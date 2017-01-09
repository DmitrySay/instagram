package com.ranga.dao;

import com.ranga.entities.Image;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ImageDaoImpl implements ImageDao {

    private SessionFactory sessionFactory;


    @Autowired
    public ImageDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public int addImage(Image image) {
        return (int) getSession().save(image);
    }

    @Override
    public Image updateImage(Image image) {
        Session session = getSession();
        session.update(image);
        return image;
    }

    @Override
    public void deleteImage(int id) {
        Session session = getSession();
        Image image = (Image) session.get(Image.class, id);
        session.delete(image);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Image> getAllImage() {
        Session session = getSession();
        Query query = session.createQuery("from Image");
        return query.list();
    }

    @Override
    public Image getImageById(int id) {
        Session session = getSession();
        Image image = (Image) session.get(Image.class, id);
        return image;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Image> list(Integer offset, Integer maxResults) {

        return getSession()
                .createCriteria(Image.class)
                .setFirstResult(offset != null ? offset : 0)
                .setMaxResults(maxResults != null ? maxResults : 10)
                .list();
    }

    @Override
    public Long count() {
        return (Long) getSession()
                .createCriteria(Image.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }


}


