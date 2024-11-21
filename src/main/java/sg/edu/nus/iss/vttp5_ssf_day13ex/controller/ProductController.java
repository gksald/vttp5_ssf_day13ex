package sg.edu.nus.iss.vttp5_ssf_day13ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp5_ssf_day13ex.model.Product;
import sg.edu.nus.iss.vttp5_ssf_day13ex.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> products = productService.loadProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/buy")
    public String buyProduct(@RequestParam("itemId") int itemId) {
        productService.buyProduct(itemId);
        return "redirect:/products"; // Refresh the page after the update
    }

    // @GetMapping("/buy/{itemId}")
    // public String buyProduct(@PathVariable("itemId") int itemId, Model model) {
    //     boolean isSuccess = productService.buyProduct(itemId);

    //     // If purchase failed (item out of stock), redirect to the error page
    //     if (!isSuccess) {
    //         // Add error message to model
    //         model.addAttribute("errorMessage", "Sorry, the item is out of stock.");
    //         return "redirect:/product-error"; // Redirect to the error page
    //     }

    //     // Otherwise, show the updated product list or success page
    //     return "redirect:/products";
    // }

    // @GetMapping("/product-error")
    // public String productError() {
    //     return "product-error"; // Display the error page
    // }
}