package com.example.demo.repositories;

import com.example.demo.domain.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}