package com.emard.limits.limits.controller;

import com.emard.limits.limits.bean.LimitsConfiguration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LimitsConfigurationController {

    private final LimitsConfiguration limits;
    
    @GetMapping("/limits")
    public LimitsConfiguration returnLimits() {
        return new LimitsConfiguration(limits.getMaximum(), limits.getMinimum());
    }
}
