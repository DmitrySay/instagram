package com.ranga.dao;

import com.ranga.entities.Image;
import com.ranga.entities.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration("classpath:/testConfig.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class ImageDaoTest{

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private RoleDao roleDao;


    @Test
    public void getAllImage() {

        List<Image> list = imageDao.getAllImage();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }


    @Test
    public void getRoleById() {

        Role role = new Role();
        role = roleDao.getRoleById(1);
        assertEquals("ROLE_USER", role.getName());
    }

}
