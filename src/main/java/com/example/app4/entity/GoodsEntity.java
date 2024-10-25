package com.example.app4.entity;

import com.example.app4.dto.GoodsDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="goods")
public class GoodsEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String goodsCategory;
    @Column
    private String goodsName;
    @Column
    private String goodsBrand;
    @Column
    private String goodsMoney;
    @Column
    private String goodsCost;
    @Column
    private String goodsContents;
    @Column
    private int goodsHits;
    @Column
    private int fileAttached; //1,0

    @OneToMany(mappedBy = "goodsEntity", cascade = CascadeType.REMOVE, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<GoodsFileEntity> goodsFileEntityList = new ArrayList<>();

    public static GoodsEntity toSaveEntity(GoodsDTO goodsDTO) {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsCategory(goodsDTO.getGoodsCategory());
        goodsEntity.setGoodsBrand(goodsDTO.getGoodsBrand());
        goodsEntity.setGoodsContents(goodsDTO.getGoodsContents());
        goodsEntity.setGoodsCost(goodsDTO.getGoodsCost());
        goodsEntity.setGoodsMoney(goodsDTO.getGoodsMoney());
        goodsEntity.setGoodsName(goodsDTO.getGoodsName());
        goodsEntity.setGoodsHits(0);
        goodsEntity.setFileAttached(0);
        return goodsEntity;
    }

    public static GoodsEntity toSaveFileEntity(GoodsDTO goodsDTO) {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsCategory(goodsDTO.getGoodsCategory());
        goodsEntity.setGoodsBrand(goodsDTO.getGoodsBrand());
        goodsEntity.setGoodsContents(goodsDTO.getGoodsContents());
        goodsEntity.setGoodsCost(goodsDTO.getGoodsCost());
        goodsEntity.setGoodsMoney(goodsDTO.getGoodsMoney());
        goodsEntity.setGoodsName(goodsDTO.getGoodsName());
        goodsEntity.setGoodsHits(0);
        goodsEntity.setFileAttached(1); //파일이 있다.
        return goodsEntity;

    }
}
