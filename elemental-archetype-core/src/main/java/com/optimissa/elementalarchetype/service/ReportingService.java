package com.optimissa.elementalarchetype.service;

import com.optimissa.elementalarchetype.dto.ReportingDataDto;
import org.springframework.http.ResponseEntity;

/**
 * Interface that provides methods to get an http response with a report
 *
 * @author pedro.uceda
 */
public interface ReportingService {

    /**
     * Method that returns a ResponseEntity with a pdf.
     *
     * @param request
     * @return
     */
    ResponseEntity generateReportPDF(ReportingDataDto request);

    /**
     * Method that returns a ResponseEntity with an excel.
     *
     * @param request
     * @return
     */
    ResponseEntity generateReportExcel(ReportingDataDto request);
}
