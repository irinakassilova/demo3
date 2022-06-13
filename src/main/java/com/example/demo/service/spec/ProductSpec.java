package com.example.demo.service.spec;

import com.example.demo.model.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpec {
    public static Specification<Product> getSpec(String description) {
        Specification<Product> spec = null;
        Specification<Product> temp = null;

        if(description != null) {
            spec = getProductByDescription(description);
            temp = Specification.where(spec).and(temp);
        }
        return spec;
    }

    private static Specification<Product> getProductByDescription(String description) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + description.toLowerCase() + "%");
    }
}
