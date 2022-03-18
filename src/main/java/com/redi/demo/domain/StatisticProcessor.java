package com.redi.demo.domain;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class StatisticProcessor {
    public static Long processStats(String name, Map<String, Long> greetingStats){
        long count = new AtomicLong().incrementAndGet();
        if (greetingStats.containsKey(name)) {
            count = count + greetingStats.get(name);
        }
        return count;
    }

    public static JSONArray publishGreetingStats(Map <String, Long> greetingStats) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (Map.Entry<String, Long> entry : greetingStats.entrySet()){
            JSONObject forEveryEntry = new JSONObject();
            forEveryEntry.put("name", entry.getKey());
            forEveryEntry.put("greeting", entry.getValue());
            jsonArray.put(forEveryEntry);

        }
        return jsonArray;
    }
}

