package spring.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int idOrder;

    @Column(name = "id_buyer")
    private int idBuyer;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "sum_of_order")
    private int sumOfOrder;

    @ManyToMany(cascade = {CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "orders_and_goods",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_good")
    )
    private List<Good> goods;

    public void addGoodToOrder(Good good){
        if(goods == null)
            goods = new ArrayList<>();
        goods.add(good);
    }
    public Order() {
    }

    public Order(int idBuyer, LocalDate orderDate, int sumOfOrder) {
        this.idBuyer = idBuyer;
        this.orderDate = orderDate;
        this.sumOfOrder = sumOfOrder;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getSumOfOrder() {
        return sumOfOrder;
    }

    public void setSumOfOrder(int sumOfOrder) {
        this.sumOfOrder = sumOfOrder;
    }



    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idBuyer=" + idBuyer +
                ", orderDate='" + orderDate + '\'' +
                ", sumOfOrder=" + sumOfOrder +
                '}';
    }
}
