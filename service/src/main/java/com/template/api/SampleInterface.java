package com.template.api;

import com.template.entity.Sample;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SampleInterface {

    @PostMapping(value="/sample/add", produces="application/json")
    ResponseEntity<Integer> addSample(@RequestParam String name, @RequestParam String description);

    @GetMapping(value="/sample/get/{id}", produces="application/json")
    ResponseEntity<Sample> getSample(@PathVariable int id);

    @GetMapping(value="/sample/list", produces="application/json")
    ResponseEntity<List<Sample>> listSamples();

}
