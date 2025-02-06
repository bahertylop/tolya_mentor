package org.example.glav6.part4.task4;

public abstract class MailServiceUnit<T> {

    private String from;

    private String to;

    private T content;

    public MailServiceUnit(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public T getContent() {
        return content;
    }
}
