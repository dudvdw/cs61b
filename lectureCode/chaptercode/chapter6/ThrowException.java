package chaptercode.chapter6;

import syntax3.map.ArrayMap;

import java.io.IOException;

public class ThrowException {
    public static void main(String[] args) throws IOException {
        ArrayMap<String, Integer> am = new ArrayMap<String, Integer>();
        am.put("hello", 4);
        System.out.println(am.get("hello"));
    }
}