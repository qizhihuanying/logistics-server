package com.project.demo.controller;

import com.project.demo.entity.OutboundRecord;
import com.project.demo.service.OutboundRecordService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *出库记录：(OutboundRecord)表控制层
 *
 */
@RestController
@RequestMapping("/outbound_record")
public class OutboundRecordController extends BaseController<OutboundRecord,OutboundRecordService> {

    /**
     *出库记录对象
     */
    @Autowired
    public OutboundRecordController(OutboundRecordService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(outbound_record_id) AS max FROM "+"outbound_record";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = ("SELECT count(*) count FROM `warehouse_management` INNER JOIN `outbound_record` ON warehouse_management.goods_no=outbound_record.goods_no WHERE warehouse_management.goods_inventory &#60; outbound_record.outbound_quantity AND outbound_record.outbound_record_id="+max).replaceAll("&#60;","<");
        select = service.runCountSql(sql);
        Integer count = Integer.valueOf(String.valueOf(select.getSingleResult()));
        if(count>0){
            sql = "delete from "+"outbound_record"+" WHERE "+"outbound_record_id"+" ="+max;
            select = service.runCountSql(sql);
            select.executeUpdate();
            return error(30000,"库存不足!");
        }
        sql = "UPDATE `warehouse_management` INNER JOIN `outbound_record` ON warehouse_management.goods_no=outbound_record.goods_no SET warehouse_management.goods_inventory = warehouse_management.goods_inventory - outbound_record.outbound_quantity WHERE outbound_record.outbound_record_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
