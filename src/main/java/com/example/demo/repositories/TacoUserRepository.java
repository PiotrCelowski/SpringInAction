package com.example.demo.repositories;

import com.example.demo.domain.users.TacoUser;
import org.springframework.data.repository.CrudRepository;

public interface TacoUserRepository extends CrudRepository<TacoUser, Long> {
    TacoUser findByUsername(String username);
    TacoUser save(TacoUser tacoUser);
}
