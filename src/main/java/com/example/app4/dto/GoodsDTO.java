package com.example.app4.dto;

import com.example.app4.entity.GoodsEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDTO {
    private Long id;
    private String goodsCategory;
    private String goodsName;
    private String goodsBrand;
    private String goodsMoney;
    private String goodsCost;
    private String goodsContents;
    private int goodsHits;

    private LocalDateTime goodsCreatedTime;
    private LocalDateTime goodsUpdatedTime;

    private MultipartFile goodsFile;
    private String originalFileName; //원본이름
    private String storedFileName; //저장이름 (임의의이름)
    private int fileAttached; //첨부유무

    public static GoodsDTO toGoodsDTO(GoodsEntity goodsEntity){
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setId(goodsEntity.getId());
        goodsDTO.setGoodsName(goodsEntity.getGoodsName());
        goodsDTO.setGoodsCategory(goodsEntity.getGoodsCategory());
        goodsDTO.setGoodsCost(goodsEntity.getGoodsCost());
        goodsDTO.setGoodsBrand(goodsEntity.getGoodsBrand());
        goodsDTO.setGoodsContents(goodsEntity.getGoodsContents());
        goodsDTO.setGoodsMoney(goodsEntity.getGoodsMoney());
        goodsDTO.setGoodsHits(goodsEntity.getGoodsHits());
        goodsDTO.setGoodsCreatedTime(goodsEntity.getCreatedTime());
        goodsDTO.setGoodsUpdatedTime(goodsEntity.getUpdatedTime());

        if(goodsEntity.getFileAttached() ==0){
            goodsDTO.setFileAttached(goodsEntity.getFileAttached());
        } else {
            goodsDTO.setFileAttached(goodsEntity.getFileAttached());
            goodsDTO.setOriginalFileName(goodsEntity.getGoodsFileEntityList().get(0).getOrginalFileName());
            goodsDTO.setStoredFileName(goodsEntity.getGoodsFileEntityList().get(0).getStoredFileName());
        }
        return goodsDTO;
    }
}
