package session.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import session.model.Cart;
import session.model.Product;
import session.service.IproductService;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IproductService iproductService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", iproductService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> product = iproductService.findById(id);
        if (!product.isPresent()) {
            return "/error";
        }
        if (action.equals("show")) {
            cart.addProduct(product.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product.get());
        return "redirect:/shop";
    }

    @GetMapping("/sub/{id}")
    public String subFromCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> product = iproductService.findById(id);
        if (!product.isPresent()) {
            return "/error";
        }
        if (action.equals("show")) {
            cart.subProduct(product.get());
            return "redirect:/shopping-cart";
        }
        cart.subProduct(product.get());
        return "redirect:/shop";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        Optional<Product> product = iproductService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/detail");
            modelAndView.addObject("product", product.get());
            return modelAndView;
        } else {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/create");
    }

    @PostMapping("/create")
    public ModelAndView saveProduct(Product product, @RequestParam MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File("C:\\Users\\DELL\\IdeaProjects\\Session\\src\\main\\webapp\\WEB-INF\\file\\" + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        product.setImage(fileName);
        iproductService.save(product);
        return new ModelAndView("redirect:/shop");
    }
}
