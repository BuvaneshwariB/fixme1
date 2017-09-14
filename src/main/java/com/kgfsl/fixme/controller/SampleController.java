/*package com.kgfsl.fixme.controller;
import com.kgfsl.fixme.model.Sample;
import com.kgfsl.fixme.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @RequestMapping("/sample")
    public Sample sample(String sampleName) {
        return sampleService.createSample(sampleName);
    }

    @RequestMapping("/sample1")
    public Sample sample1(String sampleName) {
        return sampleService.updateSample(sampleName);
    }
}
*/