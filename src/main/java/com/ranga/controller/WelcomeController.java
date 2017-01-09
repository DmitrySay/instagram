package com.ranga.controller;

import com.ranga.entities.Image;
import com.ranga.service.ImageService;
import org.apache.commons.io.FileUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;


@Controller
public class WelcomeController {

    private static final Logger logger = Logger.getLogger(WelcomeController.class);

    @Autowired
    private ImageService imageService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printIndex(ModelMap model) {

        //3 шаг выборки, по 3 новости из БД на страницу
        List<Image> imageList = imageService.list(0, 3);
        long count = imageService.count();

        int current = 1;
        int begin = Math.max(1, current - 2);
        int result = (int) Math.ceil(count / (double) 3); //3,33 округляем до 4
        long end = Math.min(begin + 2, result);

        model.addAttribute("imageList", imageList);
        model.addAttribute("count", result);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "index";
    }

    @RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
    public String printPage(ModelMap model, @PathVariable Integer pageNumber) {

        List<Image> imageList = imageService.list((pageNumber - 1) * 3, 3);
        long count = imageService.count();

        int current = pageNumber;
        int begin = Math.max(1, current - 2);
        int result = (int) Math.ceil(count / (double) 3);

        System.out.println("count = " + count);
        System.out.println("result = " + result);
        long end = Math.min(begin + 2, result);

        model.addAttribute("imageList", imageList);
        model.addAttribute("count", result);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "index";
    }


    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String printSingin() {
        return "signin";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String printRegistration() {
        return "registration";
    }


    @RequestMapping(value = {"/fileUpLoad", "pages/fileUpLoad"}, method = RequestMethod.POST)
    public String singleImageSave(HttpServletRequest request, @RequestParam("comment") String comment,
                                  @RequestParam("image") MultipartFile image, ModelMap model) throws IOException {


        String filename = "";
        //  bindingResult.hasErrors();, BindingResult bindingResult


        if (validateImage(image) == true && comment != null && !comment.isEmpty()) {

            String rootPath = request.getSession().getServletContext().getRealPath("/");
            File dir = new File(rootPath + File.separator + "WEB-INF/images");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            filename = Calendar.getInstance().getTimeInMillis() + image.getOriginalFilename();
            String path = dir.getAbsolutePath() + File.separator + filename;
            File file = new File(path);
            FileUtils.writeByteArrayToFile(file, image.getBytes());

            Image imageT = new Image();
            imageT.setComment(comment);
            imageT.setFilename(filename);
            imageT.setBaseURL(getBaseURL(request));


            imageService.addImage(imageT);

            //model.addAttribute("message", "Message :  image uploaded");// сообщение
            return "redirect:/";

        } else {
            model.addAttribute("message", "Заполните комментарий и выберите фото");
            return "index";
        }

    }


    @RequestMapping({"/delete/{imageId}", "pages/delete/{imageId}"})
    public String deleteContact(@PathVariable("imageId") Integer imageId) {

        if (imageId != null) {
            imageService.deleteImage(imageId);
        }
        return "redirect:/";

    }


    /**
     * Метод получает baseURL (http://localhost:80/web/)
     *
     * @param request
     * @return
     */
    public String getBaseURL(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }


    /**
     * Проверка изображения на null, пусто и тип файла
     *
     * @param image
     * @return true/false
     */

    private boolean validateImage(MultipartFile image) {

        if (image == null || image.isEmpty()) {
            return false;
        }

        String contentType = image.getContentType();

        if (contentType.equals("image/jpg") || contentType.equals("image/jpeg")
                || contentType.equals("image/png") || contentType.equals("image/gif")
                || contentType.equals("image/bmp") || contentType.equals("image/x-png")) {
            return true;
        }


        return false;
    }


}


