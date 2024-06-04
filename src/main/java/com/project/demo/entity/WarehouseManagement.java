package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *仓储管理：(WarehouseManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "WarehouseManagement")
public class WarehouseManagement implements Serializable {

    //WarehouseManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_management_id")
    private Integer warehouse_management_id;
    // 货物名称
    @Basic
    private String name_of_goods;
    // 货物编号
    @Basic
    private String goods_no;
    // 货物体积
    @Basic
    private String cargo_volume;
    // 货物重量
    @Basic
    private String cargo_weight;
    // 所在货位
    @Basic
    private String location;
    // 货物库龄
    @Basic
    private String storage_age_of_goods;
    // 货物库存
    @Basic
    private Integer goods_inventory;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
