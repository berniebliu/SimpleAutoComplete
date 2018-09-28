package com.autocomplete.csvreader;

import com.autocomplete.models.Trie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by e30462 on 9/26/18.
 */
public class CSVReader {

    public CSVReader() {

    }


    public Trie loadCSVFileIntoTrie(String dir) {
        //read file into stream, try-with-resources
        Trie trie = new Trie();
        try (Stream<String> stream = Files.lines(Paths.get(dir))) {
            stream.forEach(name -> trie.insert(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trie;
    }}
