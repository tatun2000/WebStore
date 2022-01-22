package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.GoodDAO;
import spring.entity.Good;

import javax.transaction.Transactional;
import java.util.List;



@Service
public class GoodServiceImpl implements GoodService{
    @Autowired
    private GoodDAO goodDAO;

    @Override
    @Transactional
    public List<Good> getAllGoods() {
        return goodDAO.getAllGoods();
    }

    @Override
    @Transactional
    public Good getGood(int id) {
        return goodDAO.getGood(id);
    }

    @Override
    @Transactional
    public void saveOrUpdateGood(Good good) {
        goodDAO.saveOrUpdateGood(good);
    }

    @Override
    @Transactional
    public void deleteGood(int idGood) {
        goodDAO.deleteGood(idGood);
    }
}
