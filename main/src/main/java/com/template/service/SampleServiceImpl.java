package com.template.service;

import com.template.api.SampleInterface;
import com.template.entity.Sample;
import com.template.util.exceptions.InvalidInputException;
import com.template.util.exceptions.NotFoundException;
import com.template.util.http.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class SampleServiceImpl implements SampleInterface {

    private final ServiceUtil util;

    @Autowired
    public SampleServiceImpl(ServiceUtil util){
        this.util = util;
    }

    @Override
    public ResponseEntity<Integer> addSample(String name, String description) {
        log.debug("/add add sample ", name);

        Sample val = Sample.builder().id(1).name(name).description(description).build();

        if (val.getName().equalsIgnoreCase("invalid")) throw new InvalidInputException("Invalid productId: " + val.getId());

        return ResponseEntity.status(HttpStatus.OK).body(val.getId());
    }

    @Override
    public ResponseEntity<Sample> getSample(int id) {
        log.debug("/get return the found sample for id={}", id);

        if (id < 1) throw new InvalidInputException("Invalid productId: " + id);

        if (id == 13) throw new NotFoundException("No product found for productId: " + id);

        return ResponseEntity.status(HttpStatus.OK).body(new Sample(id, "name-" + id,  util.getServiceAddress()));
    }

    @Override
    public ResponseEntity<List<Sample>> listSamples() {
        log.debug("/list return list of samples");
        List<Sample> list = new ArrayList<>();
        list.add(Sample.builder().id(1).name("hello").description("greeting").build());
        list.add(Sample.builder().id(2).name("there").description("adverb").build());
        list.add(Sample.builder().id(3).name("world").description("subject").build());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
