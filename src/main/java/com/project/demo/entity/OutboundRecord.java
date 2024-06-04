package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *出库记录：(OutboundRecord)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "OutboundRecord")
public class OutboundRecord implements Serializable {

    //OutboundRecord编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "outbound_record_id")
    private Integer outbound_record_id;
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
    // 出库日期
    @Basic
    private Timestamp delivery_date;
    // 出库数量
    @Basic
    private Integer outbound_quantity;
    // 出库发票
    @Basic
    private String delivery_invoice;
    // 货运车辆
    @Basic
    private String freight_vehicle;
    // 货运司机
    @Basic
    private String freight_driver;
    // 预计时间
    @Basic
    private Timestamp estimated_time;
    // 实际时间
    @Basic
    private Timestamp actual_time;
    // 费用结算
    @Basic
    private String expense_settlement;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
