package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.core.services.IcurrencyControllerService;
import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import com.capitalmarkets.app.dto.integration.CurrencyHistoricalDTO;
import com.capitalmarkets.app.dto.integration.CurrencyRatesDTO;
import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/files")
public class FilesRestController {

    @Autowired
    private IcurrencyControllerService controllerService;


    @GetMapping("/txtList-currencies")
    public HashMap<String, Object> getCurrenciesTxtList() throws IOException {

        String filePath = "capitalmarkets\\src\\main\\resources\\files\\currencies.txt";
        HashMap<String, Object> map = new HashMap<>();

        try {
            FileOutputStream f = new FileOutputStream(filePath, true);
            String lineToAppend = (controllerService.getAll()).toString();
            byte[] byteArr = lineToAppend.getBytes();
            f.write(byteArr);
            f.close();
            map.put("message", "The txt was created");
            map.put("path", filePath);
            map.put("status", HttpStatus.OK);

        }catch (Exception e) {
            map.put("Message", "Internal error");
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return map;
    }

    @GetMapping("/excelList-currencies")
    public HashMap<String, Object> getCurrenciesExcelList() throws IOException {

        String name = "CurrencieList.xlsx";
        String path = "capitalmarkets\\src\\main\\resources\\files\\" + name;
        String sheet = "Currencies";

        HashMap<String, Object> map = new HashMap<>();
        try {
            XSSFWorkbook book = new XSSFWorkbook();
            XSSFSheet sheet1 = book.createSheet(sheet);

            String[] header = new String[]{"Código", "Nombre"};


            List<CurrencyApiDTO> currencies = controllerService.getAll();
            String[][] document = new String[currencies.size()][2];


            for (int i = 0; i < currencies.size(); i++) {
                document[i][0] = currencies.get(i).getCode();
                document[i][1] = currencies.get(i).getName();
            }


            CellStyle style = book.createCellStyle();
            Font font = book.createFont();
            font.setBold(true);
            style.setFont(font);


            for (int i = 0; i <= currencies.size(); i++) {
                XSSFRow row = sheet1.createRow(i);
                for (int j = 0; j < header.length; j++) {

                    if (i == 0) {

                        XSSFCell cell = row.createCell(j);

                        cell.setCellStyle(style);

                        cell.setCellValue(header[j]);

                    } else {

                        XSSFCell cell = row.createCell(j);

                        cell.setCellValue(document[i - 1][j]);
                    }
                }
            }

            File file;
            file = new File(path);
            try (FileOutputStream fileOuS = new FileOutputStream(file)) {
                if (file.exists()) {
                    file.delete();
                    System.out.println("Archivo eliminado");
                }
                book.write(fileOuS);
                fileOuS.flush();
                fileOuS.close();
                System.out.println("Archivo Creado");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            map.put("message", "The excel was created");
            map.put("path", path);
            map.put("status", HttpStatus.OK);

        } catch (Exception e) {
            map.put("Message", "Internal error");
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return map;
    }


    @PostMapping("/txtHistorical")
    public HashMap<String, Object> getHistoricalTxt(@RequestBody CurrencyHistoricalDTO dto) throws IOException {

        String filePath = "capitalmarkets\\src\\main\\resources\\files\\historical.txt";


        HashMap<String, Object> map = new HashMap<>();
        try {
            FileOutputStream f = new FileOutputStream(filePath, true);
            String lineToAppend = (controllerService.getHistorical(dto.getStartDate(), dto.getAmount(), dto.getBase(), dto.getConversion())).toString();
            byte[] byteArr = lineToAppend.getBytes();
            f.write(byteArr);
            f.close();
            map.put("message", "The txt was created");
            map.put("path", filePath);
            map.put("status", HttpStatus.OK);


        } catch (Exception e) {
            map.put("Message", "Internal error");
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return map;
    }


    @PostMapping("/pdfHistorical")
    public HashMap<String, Object> getHistoricalPdf(@RequestBody CurrencyHistoricalDTO dto) throws IOException {

        String path = "capitalmarkets\\src\\main\\resources\\files\\historical.pdf";
        CurrencyHistoricalDTO text = (controllerService.getInterval(dto.getStartDate(), dto.getEndDate(), dto.getAmount(), dto.getBase(), dto.getConversion()));

        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);


        headerPdf(contentStream, document, page);
        infoPdf(contentStream, text, page);
        dataPdf(contentStream, document, page, text);


        HashMap<String, Object> map = new HashMap<>();
        try {

            document.save(path);

            map.put("message", "The pdf was created");
            map.put("path", path);
            map.put("status", HttpStatus.OK);

        } catch (Exception e) {

            map.put("Message", "Internal error");
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return map;

    }


    @SneakyThrows
    private void headerPdf(PDPageContentStream contentStream, PDDocument document, PDPage page) {

        PDImageXObject pdImageTitle = PDImageXObject.createFromFile("capitalmarkets/src/main/resources/img/header.png", document);
        contentStream.drawImage(pdImageTitle, 28, 668, pdImageTitle.getWidth() / 3, pdImageTitle.getHeight() / 3);

        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER_BOLD, 30);
        contentStream.setLeading(14.5f);
        contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 52);
        contentStream.showText("DATOS DE CONVERSION");
        contentStream.newLine();
        contentStream.newLine();
        contentStream.endText();
    }

    @SneakyThrows
    private void infoPdf(PDPageContentStream contentStream, CurrencyHistoricalDTO texto, PDPage page) {

        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER_BOLD_OBLIQUE, 12);
        contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 100);
        contentStream.showText("    FECHA: ");
        contentStream.newLine();
        contentStream.setFont(PDType1Font.COURIER, 9);
        contentStream.showText("     Desde: " + texto.getStartDate() + " Hasta: " + texto.getEndDate());
        contentStream.newLine();
        contentStream.setFont(PDType1Font.COURIER_BOLD_OBLIQUE, 12);
        contentStream.showText("    DE: ");
        contentStream.setFont(PDType1Font.COURIER, 9);
        contentStream.showText(texto.getBase());
        contentStream.newLine();
        contentStream.setFont(PDType1Font.COURIER_BOLD_OBLIQUE, 12);
        contentStream.showText("    A: ");
        contentStream.setFont(PDType1Font.COURIER, 9);
        contentStream.showText(texto.getTo());
        contentStream.newLine();
        contentStream.setFont(PDType1Font.COURIER_BOLD_OBLIQUE, 12);
        contentStream.showText("    VALOR ACTUAL: ");
        contentStream.setFont(PDType1Font.COURIER, 9);
        contentStream.showText(texto.getConversion());
        contentStream.newLine();
        contentStream.newLine();
        contentStream.endText();

    }

    @SneakyThrows
    private void dataPdf(PDPageContentStream contentStream, PDDocument document, PDPage page, CurrencyHistoricalDTO texto) {

        PDImageXObject pdImage = PDImageXObject.createFromFile("capitalmarkets/src/main/resources/img/CM.png", document);
        PDImageXObject pdOptImage = PDImageXObject.createFromFile("capitalmarkets/src/main/resources/img/Optimissa.png", document);

        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER_BOLD_OBLIQUE, 12);
        contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 180);
        contentStream.showText("    HISTORICO DE VALORES: ");
        contentStream.newLine();
        contentStream.newLine();

        contentStream.setFont(PDType1Font.COURIER, 9);
        int line = 0;
        for (int i = 0; i < texto.getRates().size(); i++) {

            StringBuilder builder = new StringBuilder();
            CurrencyRatesDTO o = texto.getRates().get(i);


            for (Field field : texto.getRates().get(i).getClass().getDeclaredFields()) {
                field.setAccessible(true);
                builder.append("      ")
                        .append(field.getName())
                        .append(" = ")
                        .append(field.get(o))
                        .append("                                              ");
            }

            System.out.println("builder: " + builder);

            line++;

            if (line == 35) {

                contentStream.endText();
                contentStream.drawImage(pdImage, 410, 10, pdImage.getWidth() / 3, pdImage.getHeight() / 3);
                contentStream.drawImage(pdOptImage, 10, 10, pdOptImage.getWidth() / 2, pdOptImage.getHeight() / 2);
                contentStream.close();

                PDPage page1 = new PDPage(PDRectangle.A4);
                document.addPage(page1);
                contentStream = new PDPageContentStream(document, page1);
                contentStream.beginText();
                contentStream.setLeading(14.5f);
                contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 52);
                contentStream.setFont(PDType1Font.COURIER, 9);
                contentStream.showText(builder.toString());

                line = 0;
            }

            contentStream.showText(builder.toString());
            contentStream.newLine();


        }

        contentStream.endText();
        contentStream.drawImage(pdImage, 410, 10, pdImage.getWidth() / 3, pdImage.getHeight() / 3);
        contentStream.drawImage(pdOptImage, 10, 10, pdOptImage.getWidth() / 2, pdOptImage.getHeight() / 2);
        contentStream.close();

    }

}
