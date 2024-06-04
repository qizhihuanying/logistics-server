package com.project.demo.controller;

import com.project.demo.entity.OrdinaryStaff;
import com.project.demo.service.OrdinaryStaffService;
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
 *普通员工：(OrdinaryStaff)表控制层
 *
 */
@RestController
@RequestMapping("/ordinary_staff")
public class OrdinaryStaffController extends BaseController<OrdinaryStaff,OrdinaryStaffService> {

    /**
     *普通员工对象
     */
    @Autowired
    public OrdinaryStaffController(OrdinaryStaffService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapemployee_job_number = new HashMap<>();
        mapemployee_job_number.put("employee_job_number",String.valueOf(paramMap.get("employee_job_number")));
        List listemployee_job_number = service.select(mapemployee_job_number, new HashMap<>()).getResultList();
        if (listemployee_job_number.size()>0){
            return error(30000, "字段员工工号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
