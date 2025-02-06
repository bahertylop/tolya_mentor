package org.example.glav6.part4.task4;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MailService<T> implements Consumer<MailServiceUnit<T>> {

    private final Map<String, List<T>> map = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            return getOrDefault(key, new ArrayList<>());
        }
    };

    @Override
    public void accept(MailServiceUnit<T> unit) {
        map.computeIfAbsent(unit.getTo(), x -> new ArrayList<>()).add(unit.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return map;
    }
}
