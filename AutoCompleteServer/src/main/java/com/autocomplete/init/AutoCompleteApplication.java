package com.autocomplete.init;

import com.autocomplete.models.Trie;
import com.autocomplete.config.AutoCompleteConfiguration;
import com.autocomplete.rest.AutoCompleteResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

/**
 * Created by Bernie on 9/25/18.
 */
public class AutoCompleteApplication extends Application<AutoCompleteConfiguration> {
    private static final String NAMES_CSV_DIR = "/src/main/resources/CSV_Database_of_First_Names.csv";;
    private static Trie nameTrie;
    private static AutoCompleteApplication instance = new AutoCompleteApplication();

    public static void main(String [] args) throws Exception {
        initialize();
        new AutoCompleteApplication().run(args);
    }

    private AutoCompleteApplication() {

    }

    public static void initialize() {
        nameTrie = new Trie();
        nameTrie.loadCSVFileIntoTrie(Paths.get("").toAbsolutePath().toString() + NAMES_CSV_DIR);
    }

    public static AutoCompleteApplication getInstance() {
        return instance;
    }

    public Trie getNameTrie() {
        return nameTrie;
    }

    @Override
    public String getName() {
        return "auto-complete";
    }

    @Override
    public void initialize(Bootstrap<AutoCompleteConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(AutoCompleteConfiguration configuration,
                    Environment environment) {
        final AutoCompleteResource resource = new AutoCompleteResource(
                configuration.getDefaultWord()
        );

        environment.jersey().register(resource);

        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

    }
}
