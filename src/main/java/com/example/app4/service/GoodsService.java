package com.example.app4.service;

import com.example.app4.dto.GoodsDTO;
import com.example.app4.entity.GoodsEntity;
import com.example.app4.entity.GoodsFileEntity;
import com.example.app4.repository.GoodsFileRepository;
import com.example.app4.repository.GoodsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoodsService {
    private final GoodsRepository goodsRepository;
    private final GoodsFileRepository goodsFileRepository;
    public void save(GoodsDTO goodsDTO) throws IOException {
        if (goodsDTO.getGoodsFile().isEmpty()){
            //첨부파일이 없을때
        GoodsEntity goodsEntity = GoodsEntity.toSaveEntity(goodsDTO);
        goodsRepository.save(goodsEntity);   
        } else {
            //첨부파일이 있을 때
            MultipartFile goodsFile = goodsDTO.getGoodsFile();
            String originalFileName= goodsFile.getOriginalFilename();
            String storedFileName = System.currentTimeMillis() + "_" + originalFileName;
            //새로운 이름 생성
            String savePath = "C:/app_img/" + storedFileName;
            goodsFile.transferTo(new File(savePath));
            GoodsEntity goodsEntity = GoodsEntity.toSaveFileEntity(goodsDTO);
            Long savedId = goodsRepository.save(goodsEntity).getId();
            GoodsEntity goods = goodsRepository.findById(savedId).get();
            GoodsFileEntity goodsFileEntity = GoodsFileEntity.toGoodsFileEntity(goods,originalFileName,storedFileName);
            goodsFileRepository.save(goodsFileEntity);
        }
        
    }
@Transactional
    public List<GoodsDTO> findAll() {
        List<GoodsEntity>  goodsEntityList = goodsRepository.findAll();
        List<GoodsDTO> goodsDTOList = new ArrayList<>();

        for(GoodsEntity goodsEntity: goodsEntityList){
            goodsDTOList.add(GoodsDTO.toGoodsDTO(goodsEntity));
        }
        return goodsDTOList;
    }

    public GoodsDTO findById(Long id) {
        Optional<GoodsEntity> optionalGoodsEntity = goodsRepository.findById(id);
        if(optionalGoodsEntity.isPresent()){
            GoodsEntity goodsEntity = optionalGoodsEntity.get();
            GoodsDTO goodsDTO = GoodsDTO.toGoodsDTO(goodsEntity);
            return goodsDTO;
        } else {
            return null;
        }
    }
}
