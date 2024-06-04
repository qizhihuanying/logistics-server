package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *司机信息：(DriverInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "DriverInformation")
public class DriverInformation implements Serializable {

    //DriverInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_information_id")
    private Integer driver_information_id;
    // 司机员工
    @Basic
    private Integer driver_staff;
    // 员工姓名
    @Basic
    private String employee_name;
    // 员工工号
    @Basic
    private String employee_job_number;
    // 司机kpi
    @Basic
    private Integer driver_kpi;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
