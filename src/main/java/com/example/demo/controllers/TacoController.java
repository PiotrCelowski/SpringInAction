package com.example.demo.controllers;

import com.example.demo.domain.Taco;
import com.example.demo.domain.TacoOrder;
import com.example.demo.repositories.TacoRepository;
import com.example.demo.web.props.OrderProps;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);
        if (optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }

}