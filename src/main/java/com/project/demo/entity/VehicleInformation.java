package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *车辆信息：(VehicleInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "VehicleInformation")
public class VehicleInformation implements Serializable {

    //VehicleInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_information_id")
    private Integer vehicle_information_id;
    // 车辆名称
    @Basic
    private String vehicle_name;
    // 车牌号码
    @Basic
    private String license_plate;
    // 所在位置
    @Basic
    private String location;
    // 车辆状态
    @Basic
    private String vehicle_status;
    // 车辆备注
    @Basic
    private String vehicle_remarks;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
