package com.esExampleTwo.studentDataElasticsearchEx.controller;

import com.esExampleTwo.studentDataElasticsearchEx.model.HelloInterns;
import com.esExampleTwo.studentDataElasticsearchEx.search.SearchRequestDTO;
import com.esExampleTwo.studentDataElasticsearchEx.service.BookService;
import com.esExampleTwo.studentDataElasticsearchEx.service.HelloInternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RestController
@RequestMapping("/api/internship")
public class HelloInternController {

    private final HelloInternService helloInternService;

    @Autowired
    public HelloInternController(HelloInternService helloInternService) {
        this.helloInternService = helloInternService;
    }

    @GetMapping("/location")
    public List<HelloInterns> getByLocation(@RequestBody final SearchRequestDTO dto) {
        List<String> list = new ArrayList<String>();
        list.add("location");
        dto.setFieldLocation(list);
        return helloInternService.getByLocation(dto);
    }

    @PostMapping("/search")
    public List<HelloInterns> search(@RequestBody final SearchRequestDTO dto) {
        return helloInternService.search(dto);
    }
}
