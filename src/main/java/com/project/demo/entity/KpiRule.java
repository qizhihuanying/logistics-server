package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *kpi规则：(KpiRule)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "KpiRule")
public class KpiRule implements Serializable {

    //KpiRule编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kpi_rule_id")
    private Integer kpi_rule_id;
    // 规则名称
    @Basic
    private String rule_name;
    // 更新日期
    @Basic
    private Timestamp update_date;
    // 规则内容
    @Basic
    private String rule_content;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
