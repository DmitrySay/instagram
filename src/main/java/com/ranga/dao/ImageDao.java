package com.ranga.dao;

import com.ranga.entities.Image;

import java.util.List;


public interface ImageDao {

    int addImage(Image image);

    Image updateImage(Image image);

    void deleteImage(int id);

    List<Image> getAllImage();

    Image getImageById(int id);

    List<Image> list(Integer offset, Integer maxResults);

    Long count();
}
