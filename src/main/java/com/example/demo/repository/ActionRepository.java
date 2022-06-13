package com.example.demo.repository;

import com.example.demo.model.Action;
import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

    public interface ActionRepository extends JpaRepository<Action, Integer> {
        @Query("select a.product from Action a where CURRENT_DATE between a.begin_date and a.end_date")
        List<Product> getByBegin_dateAndEnd_date();
    }
