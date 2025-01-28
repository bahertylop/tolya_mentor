package org.example.glav3.text_analoizer;

public class SpamAnalyzer extends KeywordAnalyzer {

    private final String[] keywords;

    public SpamAnalyzer(String[] keyWords) {
        this.keywords = keyWords;
    }

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
        return Label.SPAM;
    }
}
