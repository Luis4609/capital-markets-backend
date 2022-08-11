package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.core.services.IcurrencyControllerService;
import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


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

    @GetMapping("/excelList-currencies")
    public String getCurrenciesExcelList() throws IOException {

        String nombreArchivo = "CurrencieList.xlsx";
        String rutaArchivo = "capitalmarkets\\src\\main\\resources\\files\\" + nombreArchivo;
        String hoja = "Currencies";

        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);

        String[] header = new String[]{"Código", "Nombre"};


        List<CurrencyApiDTO> currencies = controllerService.getAll();
        String[][] document2 = new String[currencies.size()][2];


        for (int i = 0; i < currencies.size(); i++) {
            document2[i][0] = currencies.get(i).getCode();
            document2[i][1] = currencies.get(i).getName();
        }


        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);


        //generar los datos para el documento
        for (int i = 0; i <= currencies.size(); i++) {
            XSSFRow row = hoja1.createRow(i);//se crea las filas
            for (int j = 0; j < header.length; j++) {
                //para la cabecera
                if (i == 0) {
                    //se crea las celdas para la cabecera, junto con la posición
                    XSSFCell cell = row.createCell(j);
                    // se añade el style crea anteriormente
                    cell.setCellStyle(style);
                    //se añade el contenido
                    cell.setCellValue(header[j]);
                    //para el contenido
                } else {
                    //se crea las celdas para la contenido, junto con la posición
                    XSSFCell cell = row.createCell(j);
                    //se añade el contenido
                    cell.setCellValue(document2[i - 1][j]);
                }
            }
        }

        File file;
        file = new File(rutaArchivo);
        try (FileOutputStream fileOuS = new FileOutputStream(file)) {
            if (file.exists()) {// si el archivo existe se elimina
                file.delete();
                System.out.println("Archivo eliminado");
            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            System.out.println("Archivo Creado");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Listado creado en excel";
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
