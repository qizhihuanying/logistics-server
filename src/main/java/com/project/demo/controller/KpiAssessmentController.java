package com.project.demo.controller;

import com.project.demo.entity.KpiAssessment;
import com.project.demo.service.KpiAssessmentService;
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
 *kpi考核：(KpiAssessment)表控制层
 *
 */
@RestController
@RequestMapping("/kpi_assessment")
public class KpiAssessmentController extends BaseController<KpiAssessment,KpiAssessmentService> {

    /**
     *kpi考核对象
     */
    @Autowired
    public KpiAssessmentController(KpiAssessmentService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(kpi_assessment_id) AS max FROM "+"kpi_assessment";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = "UPDATE `driver_information` INNER JOIN `kpi_assessment` ON driver_information.employee_job_number=kpi_assessment.employee_job_number SET driver_information.driver_kpi = driver_information.driver_kpi + kpi_assessment.kpi_score WHERE kpi_assessment.kpi_assessment_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
