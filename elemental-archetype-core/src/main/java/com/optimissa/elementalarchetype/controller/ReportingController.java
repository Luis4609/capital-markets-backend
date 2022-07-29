package com.optimissa.elementalarchetype.controller;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.optimissa.elementalarchetype.dto.ReportingDataDto;
import com.optimissa.elementalarchetype.service.ReportingService;

/**
 * Controller to generate reports.
 *
 * @author pedro.uceda
 */
@RestController
public class ReportingController {

    @Autowired
    private ReportingService reportingService;

    @RequestMapping(value = "/reporting/pdf", method = RequestMethod.POST)
    @Consumes("application/json")
    public ResponseEntity generatePDF(@RequestBody ReportingDataDto request) {
        return this.reportingService.generateReportPDF(request);
    }

    @RequestMapping(value = "/reporting/excel", method = RequestMethod.POST)
    @Consumes("application/json")
    public ResponseEntity generateExcel(@RequestBody ReportingDataDto request) {
        return this.reportingService.generateReportExcel(request);
    }

}
