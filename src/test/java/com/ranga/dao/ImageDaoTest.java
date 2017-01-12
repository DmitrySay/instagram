package com.ranga.dao;

import com.ranga.entities.Image;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration("/testConfig.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class ImageDaoTest {

    @Autowired
    private ImageDao imageDao;


    @Test
    public void getAllImage() {

        List<Image> list = imageDao.getAllImage();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

}
