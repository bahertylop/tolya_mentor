package org.example.glav3.text_analoizer;

import java.awt.*;

public class NegativeTextAnalyzer extends KeywordAnalyzer {

    private final String[] keywords = {":(", "=(", ":|"};

    @Override
    public Label processText(String text) {
        for (String word : getKeywords()) {
            if (text.contains(word)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
