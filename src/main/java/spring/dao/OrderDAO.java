package spring.dao;

import spring.entity.Good;

import java.util.List;

public interface OrderDAO {
    void createOrder(List<Good> goods, int idBuyer, int totalSumOfOrder);
}
