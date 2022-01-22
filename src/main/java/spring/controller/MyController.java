package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.entity.Good;
import spring.service.GoodService;
import spring.service.OrderService;
import spring.service.BuyerService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MyController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;

    private List<Good> globalListOfGoods;

    @GetMapping("/")
    public String getInfoForBuyers(Model model){
        List<Good> goods = goodService.getAllGoods();
        int totalSumInCart = 0;
        model.addAttribute("totalSumInCart", totalSumInCart);
        model.addAttribute("listOfGoods", goods);
        return "view_for_buyers";
    }

    @GetMapping("/add_Cart")
    public String addSum(@RequestParam("costOfGood") int costOfGood,
                         @RequestParam("totalSumInCart") int totalSumInCart,
                         @RequestParam("idOfGood") int idOfGood,
                         Model model){

        // Добавили товар в в список для заказа
        if(globalListOfGoods == null)
            globalListOfGoods = new ArrayList<>();
        globalListOfGoods.add(goodService.getGood(idOfGood));

        List<Good> goods = goodService.getAllGoods();
        model.addAttribute("totalSumInCart", totalSumInCart + costOfGood);
        model.addAttribute("listOfGoods", goods);
        return "view_for_buyers";
    }

    @GetMapping("/update_info")
    public String getInfoForAdmin(@RequestParam("idGood") int idGood,
                                  Model model){
        Good good = goodService.getGood(idGood);
        model.addAttribute("good", good);
        return "view_for_good_info";
    }

    @PostMapping("/save_or_update_good")
    public String saveOrUpdateGood(@Valid @ModelAttribute("good") Good good,
                                   BindingResult result){
        if (result.hasErrors())
            return "view_for_good_info";
        else{
            goodService.saveOrUpdateGood(good);
            return "redirect:/";
        }
    }

    @GetMapping("/add_new_good")
    public String addNewGood(Model model){
        Good good = new Good();
        model.addAttribute("good", good);
        return "view_for_good_info";
    }
    @GetMapping("/clean_cart")
    public String cleanCart(){
        globalListOfGoods = null;
        return "redirect:/";
    }

    @GetMapping("/create_order")
    public String createOrder(@AuthenticationPrincipal User user,
                              @RequestParam("totalSum") int totalSumOfOrder){
        System.out.println(totalSumOfOrder);
        int idBuyer = buyerService.getBuyer(user.getUsername());
        orderService.createOrder(globalListOfGoods, idBuyer, totalSumOfOrder);
        globalListOfGoods = null;
        return "redirect:/";
    }

    @GetMapping("/form_order")
    public String createOrder(Model model){
        Map<Integer, List<Good>> mapGoods = globalListOfGoods.stream().collect(
                Collectors.groupingBy(Good::getIdGood));
        model.addAttribute("goodsInCart", mapGoods);
        return "view_for_info_about_cart";
    }

    @GetMapping("/delete_good")
    public String deleteGood(@RequestParam("idGood") int idGood){
        goodService.deleteGood(idGood);
        return "redirect:/";
    }
}
