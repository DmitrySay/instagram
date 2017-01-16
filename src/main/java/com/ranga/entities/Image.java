package com.ranga.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "IMAGES")
public class Image implements Serializable {

    @Id
    @Column(name = "IMAGES_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "COMMENT", columnDefinition = "text")
    private String comment;

    @Column(name = "FILENAME")
    private String filename;


    public Image() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}
