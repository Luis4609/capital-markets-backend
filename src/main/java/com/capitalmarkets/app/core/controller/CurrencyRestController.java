package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.core.services.IcurrencyControllerService;
import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyConverterDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyRestController {

    @Autowired
    private  IcurrencyControllerService controllerService;

    @GetMapping("/list-currencies")
    public List<CurrencyApiDTO> getCurrenciesList() {

        return controllerService.getAll();
    }

    @GetMapping("/converter")
    public CurrencyConverterDTO getConversion( int value,String base, String conversion){

        return controllerService.getConversion(value,base,conversion);
    }

    @GetMapping("/historical")
    public CurrencyHistoricalDTO getHistorical(String date, double value, String base, String conversion) throws IOException {

        String filePath = "capitalmarkets\\src\\main\\resources\\copy\\historical.txt";
        FileOutputStream f = new FileOutputStream(filePath, true);
        String lineToAppend =  (controllerService.getHistorical(date, value, base, conversion)).toString();
        byte[] byteArr = lineToAppend.getBytes();
        f.write(byteArr);
        f.close();

        return controllerService.getHistorical(date, value, base, conversion);
    }

}
