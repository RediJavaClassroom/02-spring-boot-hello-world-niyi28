package com.redi.demo.controller;

import com.redi.demo.domain.StatisticProcessor;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {
    Map <String, Long> greetingStats = new HashMap<>();
    JSONArray jsonArray = new JSONArray();
    @GetMapping("statistics")
    public String greet(@RequestParam(value = "statsAddress") String name) throws JSONException {
        Long count =  StatisticProcessor.processStats(name, greetingStats);
        greetingStats.put(name, count);
        jsonArray = StatisticProcessor.publishGreetingStats(greetingStats);
        return jsonArray.toString();
    }
}

