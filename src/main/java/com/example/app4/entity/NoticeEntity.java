package com.example.app4.entity;

import com.example.app4.dto.NoticeDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="notice")
public class NoticeEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String noticeTitle;
    @Column
    private String noticeWriter;
    @Column
    private String noticePass;
    @Column(length = 500)
    private String noticeContents;
    @Column
    private int noticeHits;

    public static NoticeEntity toSaveEntity(NoticeDTO noticeDTO){
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setNoticeTitle(noticeDTO.getNoticeTitle());
        noticeEntity.setNoticeWriter(noticeDTO.getNoticeWriter());
        noticeEntity.setNoticeContents(noticeDTO.getNoticeContents());
        noticeEntity.setNoticeHits(0);
        noticeEntity.setNoticePass(noticeDTO.getNoticePass());
        return noticeEntity;
    }

    public static NoticeEntity toUpdateEntity(NoticeDTO noticeDTO) {
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setId(noticeDTO.getId());
        noticeEntity.setNoticeTitle(noticeDTO.getNoticeTitle());
        noticeEntity.setNoticeWriter(noticeDTO.getNoticeWriter());
        noticeEntity.setNoticeContents(noticeDTO.getNoticeContents());
        noticeEntity.setNoticeHits(0);
        noticeEntity.setNoticePass(noticeDTO.getNoticePass());
        return noticeEntity;
    }
}

