package com.project.demo.controller;

import com.project.demo.entity.WarehousingRecord;
import com.project.demo.service.WarehousingRecordService;
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
 *入库记录：(WarehousingRecord)表控制层
 *
 */
@RestController
@RequestMapping("/warehousing_record")
public class WarehousingRecordController extends BaseController<WarehousingRecord,WarehousingRecordService> {

    /**
     *入库记录对象
     */
    @Autowired
    public WarehousingRecordController(WarehousingRecordService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(warehousing_record_id) AS max FROM "+"warehousing_record";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = "UPDATE `warehouse_management` INNER JOIN `warehousing_record` ON warehouse_management.goods_no=warehousing_record.goods_no SET warehouse_management.goods_inventory = warehouse_management.goods_inventory + warehousing_record.receipt_quantity WHERE warehousing_record.warehousing_record_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
