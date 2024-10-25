package com.example.app4.repository;

import com.example.app4.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<GoodsEntity,Long> {
}
