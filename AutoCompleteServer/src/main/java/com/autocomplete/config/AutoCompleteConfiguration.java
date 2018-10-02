package com.autocomplete.config;

/**
 * Created by e30462 on 9/25/18.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class AutoCompleteConfiguration extends Configuration {
    @NotEmpty
    private String defaultWord = "";

    @JsonProperty
    public String getDefaultWord() {
        return defaultWord;
    }

    @JsonProperty
    public void setDefaultWord(String name) {
        this.defaultWord = name;
    }
}