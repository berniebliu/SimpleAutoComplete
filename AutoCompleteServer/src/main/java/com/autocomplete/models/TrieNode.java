package com.autocomplete.models;

import java.util.*;

/**
 * Created by Bernie on 9/26/18.
 */
public class TrieNode {
    private Map<Character, TrieNode> map;
    private Character c;
    private List<String> list;

    public TrieNode(Character c, HashMap<Character, TrieNode> map, ArrayList<String> list) {
        this.c = c;
        this.map = map;
        this.list = list;
    }

    public Character getCharacter() {
        return c;
    }

    public Map<Character, TrieNode> getMap() {
        return map;
    }

    public List<String> getList() {
        return list;
    }

    public void updateCharacter(Character c) {
        this.c = c;
    }

    public void updateMap(Character c, TrieNode t) {
        map.put(c, t);
    }

    public void updateList(String s) {
        list.add(s);
    }
}
