package com.example.app4.repository;

import com.example.app4.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminEntity,Long> {
    Optional<AdminEntity> findByAdmId(String admId);
}
