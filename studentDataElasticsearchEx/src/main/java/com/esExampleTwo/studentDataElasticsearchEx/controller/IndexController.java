package com.esExampleTwo.studentDataElasticsearchEx.controller;

import com.esExampleTwo.studentDataElasticsearchEx.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api/index")
public class IndexController {

    private final IndexService service;

    @Autowired
    public IndexController(IndexService service) {
        this.service = service;
    }


    @PostMapping("/recreate")
    public void recreateAllIndices() {
        service.recreateIndices(true);
    }
}
