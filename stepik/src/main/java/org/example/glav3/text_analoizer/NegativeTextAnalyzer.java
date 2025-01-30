package org.example.glav3.text_analoizer;

import java.awt.*;

public class NegativeTextAnalyzer extends KeywordAnalyzer {

    private final String[] keywords = new String[]{":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
