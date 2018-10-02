package com.autocomplete.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Bernie on 9/26/18.
 */
public class Trie {

    public TrieNode root;

    public Trie () {
        root = new TrieNode(' ', new HashMap<>(), new ArrayList<>());
    }

    public void loadCSVFileIntoTrie(String dir) {
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(dir))) {
            stream.forEach(name -> insert(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insert(String s) {
        TrieNode currentTrieNode = root;
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (!currentTrieNode.getMap().containsKey(c)) {
                currentTrieNode.updateMap(c, new TrieNode(c, new HashMap<>(), new ArrayList<>()));
            }
            currentTrieNode = currentTrieNode.getMap().get(c);
            currentTrieNode.updateList(s);
        }
    }

    public List<String> startsWith(String s) {
        TrieNode currentTrieNode = root;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!currentTrieNode.getMap().containsKey(c)) {
                return new ArrayList<>();
            }
            currentTrieNode = currentTrieNode.getMap().get(c);
        }
        return currentTrieNode.getList();
    }
}
