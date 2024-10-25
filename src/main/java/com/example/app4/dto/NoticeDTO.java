package com.example.app4.dto;

import com.example.app4.entity.NoticeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {
    private Long id;
    private String noticeTitle;
    private String noticeWriter;
    private String noticeContents;
    private String noticePass;
    private int noticeHits;
    private LocalDateTime noticeCreatedTime;
    private LocalDateTime noticeUpdatedTime;

    public static  NoticeDTO toNoticeDTO(NoticeEntity noticeEntity){
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setId(noticeEntity.getId());
        noticeDTO.setNoticeContents(noticeEntity.getNoticeContents());
        noticeDTO.setNoticeHits(noticeEntity.getNoticeHits());
        noticeDTO.setNoticeTitle(noticeEntity.getNoticeTitle());
        noticeDTO.setNoticePass(noticeEntity.getNoticePass());
        noticeDTO.setNoticeWriter(noticeEntity.getNoticeWriter());
        noticeDTO.setNoticeCreatedTime(noticeEntity.getCreatedTime());
        noticeDTO.setNoticeUpdatedTime(noticeEntity.getUpdatedTime());
        return noticeDTO;
    }
}
