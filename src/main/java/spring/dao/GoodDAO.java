package spring.dao;

import spring.entity.Good;

import java.util.List;

public interface GoodDAO {
    List<Good> getAllGoods();
    Good getGood(int id);
    void saveOrUpdateGood(Good good);
    void deleteGood(int idGood);
}
