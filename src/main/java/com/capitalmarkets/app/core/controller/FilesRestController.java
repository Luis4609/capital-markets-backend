package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.core.services.IcurrencyControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;


@RestController
@RequestMapping("/files")
public class FilesRestController {

    @Autowired
    private IcurrencyControllerService controllerService;


    @GetMapping("/txtList-currencies")
    public String getCurrenciesTxtList() throws IOException {

        String filePath = "capitalmarkets\\src\\main\\resources\\files\\currencies.txt";
        FileOutputStream f = new FileOutputStream(filePath, true);
        String lineToAppend = (controllerService.getAll()).toString();
        byte[] byteArr = lineToAppend.getBytes();
        f.write(byteArr);
        f.close();

        return "Listado creado en txt";
    }




    @GetMapping("/historical")
    public String getHistoricalTxt(String date, double value, String base, String conversion) throws IOException {

        String filePath = "capitalmarkets\\src\\main\\resources\\files\\historical.txt";
        FileOutputStream f = new FileOutputStream(filePath, true);
        String lineToAppend = (controllerService.getHistorical(date, value, base, conversion)).toString();
        byte[] byteArr = lineToAppend.getBytes();
        f.write(byteArr);
        f.close();

        return "Historico creado en txt";
    }
    
}
