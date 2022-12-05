package com.example.demo.controllers;

import com.example.demo.domain.Taco;
import com.example.demo.repositories.TacoRepository;
import com.example.demo.web.props.OrderProps;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/tacos",
        produces="application/json")
@CrossOrigin(origins="http://tacocloud:8080")
public class TacoController {
    private TacoRepository tacoRepo;
    private OrderProps orderProps;

    public TacoController(TacoRepository tacoRepo, OrderProps orderProps) {
        this.tacoRepo = tacoRepo;
        this.orderProps = orderProps;
    }

    @GetMapping(params="recent")
    public Iterable<Taco> recentTacos() {
        Pageable page = PageRequest.of(
                orderProps.getPage(), orderProps.getPageSize(),
                Sort.by("createdAt").descending());
        return tacoRepo.findAll(page);
    }
}