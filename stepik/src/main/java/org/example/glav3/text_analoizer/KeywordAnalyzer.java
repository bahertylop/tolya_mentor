package org.example.glav3.text_analoizer;

public abstract class KeywordAnalyzer implements TextAnalyzer {

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        return null;
    }
}
