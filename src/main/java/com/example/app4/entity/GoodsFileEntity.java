package com.example.app4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "goods_file")
public class GoodsFileEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String orginalFileName;

    @Column
    private String storedFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private GoodsEntity goodsEntity;

    public static GoodsFileEntity toGoodsFileEntity(GoodsEntity goodsEntity,String orginalFileName,String storedFileName){
        GoodsFileEntity goodsFileEntity = new GoodsFileEntity();
        goodsFileEntity.setOrginalFileName(orginalFileName);
        goodsFileEntity.setStoredFileName(storedFileName);
        goodsFileEntity.setGoodsEntity(goodsEntity);
        return goodsFileEntity;
    }
}
