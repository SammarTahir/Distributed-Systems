package com.user;

import com.codahale.metrics.health.HealthCheck;

public class ExampleHealthCheck extends HealthCheck {
	
	@Override
	protected Result check() throws Exception {
        return Result.healthy();
	}
}