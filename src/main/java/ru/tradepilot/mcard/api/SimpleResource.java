package ru.tradepilot.mcard.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SimpleResource {

    @RequestMapping("/api/simple")
    public Map<String, String> resource() {
        return new HashMap<String, String>() {{ put("message", "Hello. It's me. Mario"); }};
    }

}
