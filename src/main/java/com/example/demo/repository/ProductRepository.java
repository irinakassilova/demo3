package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
   @Query("SELECT p from Product p where p.description = :description")
   Product findByDescription(@Param("description") String description);

   List<Product> findAllByCategoryId(int category_id);

   List<Product> findAllByPrice(int price);
}
