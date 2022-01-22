package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.entity.Buyer;
import spring.entity.Good;

import java.util.List;

@Repository
public class BuyerDAOImpl implements BuyerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int getBuyer(String username) {
        Session session = sessionFactory.getCurrentSession();
        return (int) session.createQuery("SELECT idBuyer from Buyer where username=:username")
                .setParameter("username", username).getSingleResult();
    }
}
