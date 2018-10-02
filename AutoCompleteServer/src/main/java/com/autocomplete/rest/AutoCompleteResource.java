package com.autocomplete.rest;

/**
 * Created by Bernie on 9/25/18.
 */
/**
 * Created by Bernie on 9/25/18.
 */

import com.autocomplete.models.Trie;
import com.autocomplete.init.AutoCompleteApplication;
import com.autocomplete.models.AutoComplete;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/autocomplete")
@Produces(MediaType.APPLICATION_JSON)
public class AutoCompleteResource {
    private final String defaultWord;
    private final AtomicLong counter;
    private AutoCompleteApplication autoCompleteApplication = AutoCompleteApplication.getInstance();

    public AutoCompleteResource(String defaultWord) {
        this.defaultWord = defaultWord;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public AutoComplete getAutoComplete(@QueryParam("search") Optional<String> word) {
        final String value = String.format(word.orElse(defaultWord));
        Trie nameTrie = autoCompleteApplication.getNameTrie();
        return new AutoComplete(counter.incrementAndGet(), nameTrie.startsWith(value));
    }
}