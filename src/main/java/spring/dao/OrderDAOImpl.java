package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.entity.Good;
import spring.entity.Order;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createOrder(List<Good> goods, int idBuyer, int totalSumOfOrder) {
        LocalDate localDate = LocalDate.now();
        Order order = new Order(idBuyer, localDate, totalSumOfOrder);
        for (Good good : goods) {
            order.addGoodToOrder(good);
        }
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);

        /*Session session = sessionFactory.getCurrentSession();
       Order order = session.get(Order.class, 48);
       session.delete(order);*/
    }
}
