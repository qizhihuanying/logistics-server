package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *kpi考核：(KpiAssessment)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "KpiAssessment")
public class KpiAssessment implements Serializable {

    //KpiAssessment编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kpi_assessment_id")
    private Integer kpi_assessment_id;
    // 司机员工
    @Basic
    private Integer driver_staff;
    // 员工姓名
    @Basic
    private String employee_name;
    // 员工工号
    @Basic
    private String employee_job_number;
    // 考核日期
    @Basic
    private Timestamp assessment_date;
    // 考核类型
    @Basic
    private String assessment_type;
    // kpi分数
    @Basic
    private Integer kpi_score;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
