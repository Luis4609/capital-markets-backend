package com.capitalmarkets.app.core.controller;

import com.capitalmarkets.app.core.services.IcurrencyControllerService;
import com.capitalmarkets.app.dto.integration.CurrencyApiDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
@ExtendWith(MockitoExtension.class)
class FilesRestControllerTest {
    @Mock
    private IcurrencyControllerService controllerService;
    @InjectMocks
    private FilesRestController filesRestController;
    @Mock
    private List<CurrencyApiDTO> currenciesList;

    @Test
    void getCurrenciesTxtList() throws IOException {
        currenciesList = new ArrayList<>();
        currenciesList.add(new CurrencyApiDTO("EUR", "Euro"));
        currenciesList.add(new CurrencyApiDTO("AUD", "Australian Dollar"));
        String listCurrenciesToString = currenciesList.toString();
        FileOutputStream mockFile = Mockito.mock(FileOutputStream.class);
        Mockito.when(controllerService.getAll()).thenReturn(currenciesList);
        String result = controllerService.getAll().toString();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(listCurrenciesToString, result);
        byte[] byteArr = result.getBytes();
   /*     Mockito.when(mockFile.write(Matchers.anyByte())).thenAnswer(new Answer<Void>() {
            Void answer(InvocationOnMock invocation) {
                buffer.append((String)invocation.getArguments()[0]);
                return null;);*/
/*
                Mockito.when(mockFile)).thenAnswer(
                        new Answer<Void>() {
                            Void answer(InvocationOnMock invocation) {
                                buffer.append((String)invocation.getArguments()[0]);
                                return null;
                            }*/
        /*        mockFile.write(byteArr);*/

        /*        Mockito.verify(mockFile).write(byteArr);*/

        /*        Mockito.verify(mockFile).close();*/


    }

    @Test
    void getCurrenciesExcelList() {
    }

    @Test
    void getHistoricalTxt() {
    }
}