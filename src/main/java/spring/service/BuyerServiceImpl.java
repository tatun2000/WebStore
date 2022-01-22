package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.BuyerDAO;

import javax.transaction.Transactional;


@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private BuyerDAO buyerDAO;

    @Override
    @Transactional
    public int getBuyer(String username) {
        return buyerDAO.getBuyer(username);
    }
}
