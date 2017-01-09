package com.ranga.service;

import com.ranga.dao.ImageDao;
import com.ranga.entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("imageService")
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDao imageDao;

    @Override
    public int addImage(Image image) {
        return imageDao.addImage(image);
    }

    @Override
    public Image updateImage(Image image) {
        return imageDao.updateImage(image);
    }

    @Override
    public void deleteImage(int id) {
        imageDao.deleteImage(id);

    }

    @Override
    public List<Image> getAllImage() {
        return imageDao.getAllImage();
    }

    @Override
    public Image getImageById(int id) {
        return imageDao.getImageById(id);
    }

    @Override
    public List<Image> list(Integer offset, Integer maxResults){
        return imageDao.list(offset, maxResults);
    }

    @Override
    public Long count(){
        return imageDao.count();
    }


}
