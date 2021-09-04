package session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import session.model.Cart;
@Controller
public class CartController {
    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
}

