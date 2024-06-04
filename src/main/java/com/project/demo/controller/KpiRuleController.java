package com.project.demo.controller;

import com.project.demo.entity.KpiRule;
import com.project.demo.service.KpiRuleService;
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
 *kpi规则：(KpiRule)表控制层
 *
 */
@RestController
@RequestMapping("/kpi_rule")
public class KpiRuleController extends BaseController<KpiRule,KpiRuleService> {

    /**
     *kpi规则对象
     */
    @Autowired
    public KpiRuleController(KpiRuleService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
