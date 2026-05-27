package com.example.demo_lektion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    // Vi vill kunna köra ett snabbt test och se om appen är live efter deploy
    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}
