package com.autocomplete.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by e30462 on 9/25/18.
 */
public class AutoCompleteHealthCheck extends HealthCheck{
    private final String template;

    public AutoCompleteHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected HealthCheck.Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return HealthCheck.Result.unhealthy("template doesn't include a name");
        }
        return HealthCheck.Result.healthy();
    }
}
