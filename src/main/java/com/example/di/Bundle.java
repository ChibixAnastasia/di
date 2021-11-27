package com.example.di;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Bundle {
    private Map<String, Object> map;

    public void putLong(String key, Long a){
        map.put(key, a);
    }

    public Bundle() {
        map = new HashMap<>();
    }
}
