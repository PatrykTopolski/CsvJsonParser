package com.patryk.controller;

import org.springframework.stereotype.Controller;


@Controller
public class AppController {
    private CsvSalarySumController csvSalarySumController;
    private JsonSalarySumController jsonSalarySumController;

    public AppController(CsvSalarySumController csvSalarySumController, JsonSalarySumController jsonSalarySumController) {
        this.csvSalarySumController = csvSalarySumController;
        this.jsonSalarySumController = jsonSalarySumController;
    }

    public void readAndPrint(){
        csvSalarySumController.ReturnCalculatedDataToConsole();
        jsonSalarySumController.ReturnCalculatedDataToConsole();
    }

}
