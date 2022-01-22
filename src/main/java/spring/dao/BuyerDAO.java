package spring.dao;

import spring.entity.Buyer;
import spring.entity.Good;

import java.util.List;

public interface BuyerDAO {
    int getBuyer(String username);
}
