package spring.service;

import spring.entity.Good;

import java.util.List;

public interface OrderService {
    void createOrder(List<Good> goods, int idBuyer, int totalSumOfOrder);
}
