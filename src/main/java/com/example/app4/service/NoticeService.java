package com.example.app4.service;

import com.example.app4.dto.NoticeDTO;
import com.example.app4.entity.NoticeEntity;
import com.example.app4.repository.NoticeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;
    public void save(NoticeDTO boardDTO) {
        NoticeEntity noticeEntity = NoticeEntity.toSaveEntity(boardDTO);
        noticeRepository.save(noticeEntity);
    }

    public List<NoticeDTO> findAll() {
        List<NoticeEntity> noticeEntityList = noticeRepository.findAll();
        List<NoticeDTO> noticeDTOList = new ArrayList<>();

        for (NoticeEntity noticeEntity: noticeEntityList){
            noticeDTOList.add(NoticeDTO.toNoticeDTO(noticeEntity));
        }
        return noticeDTOList;
    }
    @Transactional
    public void updateHits(Long id) {
        noticeRepository.updateHits(id);
    }

    public NoticeDTO findById(Long id) {
        Optional<NoticeEntity> optionalNoticeEntity = noticeRepository.findById(id);
        if (optionalNoticeEntity.isPresent()){
            NoticeEntity noticeEntity = optionalNoticeEntity.get();
            NoticeDTO noticeDTO = NoticeDTO.toNoticeDTO(noticeEntity);
            return noticeDTO;
        } else {
            return null;
        }
    }

    public NoticeDTO update(NoticeDTO noticeDTO) {
        NoticeEntity noticeEntity = NoticeEntity.toUpdateEntity(noticeDTO);
        noticeRepository.save(noticeEntity);
        return findById(noticeDTO.getId());
    }

    public void delete(Long id) {
        noticeRepository.deleteById(id);
    }
}
