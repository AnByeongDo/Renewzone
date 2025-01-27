package com.example.app4.repository;

import com.example.app4.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NoticeRepository extends JpaRepository<NoticeEntity,Long> {
    @Modifying
    @Query(value = "update NoticeEntity b set b.noticeHits=b.noticeHits + 1 where b.id=:id")
    void updateHits(@Param("id") Long id);
}
