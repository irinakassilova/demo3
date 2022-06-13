package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ActionRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductRepository productRepository;
    private ProductService productService;
    private ActionRepository actionRepository;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @GetMapping
    public Product getProductByDescription(@PathParam("description") String description) {
        return productRepository.findByDescription(description);
    }

    @GetMapping("/actions")
    public List<Product> getActions() {
        return actionRepository.getByBegin_dateAndEnd_date();
    }

    @GetMapping("/category")
    public List<Product> findAllProductsByCategoryId(@RequestParam int category_id) {
        return productRepository.findAllByCategoryId(category_id);
    }

    @GetMapping("/price")
    public List<Product> findAllProductsByPrice(@RequestParam int price) {
        return productRepository.findAllByPrice(price);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam(required = false) String description) {
         return productService.search(description);
        }
    }


