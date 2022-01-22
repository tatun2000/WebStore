package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.Good;


import java.util.List;

@Repository
public class GoodDAOImpl implements GoodDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Good> getAllGoods() {
        Session session = sessionFactory.getCurrentSession();
        List<Good> goods = session.createQuery("from Good ORDER BY id_good", Good.class)
                .getResultList();
        return goods;
    }

    @Override
    public Good getGood(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Good.class, id);
    }

    @Override
    public void saveOrUpdateGood(Good good) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(good);
    }

    @Override
    public void deleteGood(int idGood) {
        Session session = sessionFactory.getCurrentSession();
        Query<Good> query = session.createQuery("delete from Good where " +
                "id=:idGood");
        query.setParameter("idGood", idGood);
        query.executeUpdate();
    }


}
