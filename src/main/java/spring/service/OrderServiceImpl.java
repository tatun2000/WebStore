package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.OrderDAO;
import spring.entity.Good;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public void createOrder(List<Good> goods, int idBuyer, int totalSumOfOrder) {
        orderDAO.createOrder(goods, idBuyer, totalSumOfOrder);
    }
}
