package com.example.demo.repositories;

import com.example.demo.domain.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TacoRepository  extends PagingAndSortingRepository<Taco, Long> {
    Taco save(Taco taco);

    Optional<Taco> findById(Long id);
}
