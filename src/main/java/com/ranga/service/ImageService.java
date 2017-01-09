package com.ranga.service;

import com.ranga.entities.Image;

import java.util.List;


public interface ImageService {


    int addImage(Image image);

    Image updateImage(Image image);

    void deleteImage(int id);

    List getAllImage();

    Image getImageById(int id);

    List<Image> list(Integer offset, Integer maxResults);

    Long count();
}
