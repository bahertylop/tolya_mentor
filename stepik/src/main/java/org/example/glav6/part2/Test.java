package org.example.glav6.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.*;

public class Test {
    public static void main(String[] args) {

        Collection<?> collection = new ArrayList<>();
        Object o = new Object();

//        collection.add(o);
//        collection.addAll(Arrays.asList(o));
        collection.toArray();
        collection.contains(o);
        collection.iterator();
        collection.size();
        collection.remove(o);
        collection.clear();
    }
}
