package com.example.demo.repositories;

import com.example.demo.domain.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepository  extends PagingAndSortingRepository<Taco, Long> {
}
