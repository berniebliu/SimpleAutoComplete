package com.autocomplete.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by e30462 on 9/25/18.
 */
public class AutoComplete {

    private long id;
    private List<String> autoCompleteContent;

    public AutoComplete() {
        // Jackson deserialization
    }

    public AutoComplete(long id, List<String> autoCompleteContent) {
        this.id = id;
        this.autoCompleteContent = autoCompleteContent;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public List<String> getAutoCompleteContent() {
        return autoCompleteContent;
    }
}
