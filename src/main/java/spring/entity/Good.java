package spring.entity;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "goods")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_good")
    private int idGood;

    @Column(name = "name_of_goods")
    @NotBlank(message = "The field should not be empty")
    @Pattern(regexp = "^.{1,30}$",
            message = "The name must not be less than 1 and not exceed 30 characters")
    private String nameOfGoods;

    @Column(name = "cost")
    @NotNull(message = "The field should not be empty")
    @Min(value = 100, message = "Cost must be greater than 99")
    @Max(value = 100000, message = "Cost must be less than 100001")
    private int cost;

    @Column(name = "path_to_image")
    @NotBlank(message = "The field should not be empty")
    @Pattern(regexp = "^resources\\/images\\/goods\\/[a-zA-Z0-9]{1,30}\\.[ji][pm][g]$",
            message = "The string must match the pattern: (resources/images/goods/xxx.jpg(img)")
    private String pathToImage;

    @ManyToMany(cascade = {CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "orders_and_goods",
            joinColumns = @JoinColumn(name = "id_good"),
            inverseJoinColumns = @JoinColumn(name = "id_order")
    )
    private List<Order> orders;


    public Good() {
    }

    public Good(String nameOfGoods, int cost, String pathToImage) {
        this.nameOfGoods = nameOfGoods;
        this.cost = cost;
        this.pathToImage = pathToImage;
    }

    public int getIdGood() {
        return idGood;
    }

    public void setIdGood(int idGood) {
        this.idGood = idGood;
    }

    public String getNameOfGoods() {
        return nameOfGoods;
    }

    public void setNameOfGoods(String nameOfGoods) {
        this.nameOfGoods = nameOfGoods;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Good{" +
                "idGood=" + idGood +
                ", nameOfGoods='" + nameOfGoods + '\'' +
                ", cost=" + cost +
                ", pathToImage='" + pathToImage + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Good good = (Good) obj;
        return this.idGood == good.getIdGood();
    }
}
