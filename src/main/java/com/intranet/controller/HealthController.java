package com.intranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthController {

	@Autowired
	private HealthEndpoint healthEndpoint;

	@GetMapping("/api/health")
	public HealthComponent health() {
		return healthEndpoint.health();
	}

}
