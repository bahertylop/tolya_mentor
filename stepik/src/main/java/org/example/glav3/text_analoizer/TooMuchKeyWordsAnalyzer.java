package org.example.glav3.text_analoizer;

public class TooMuchKeyWordsAnalyzer extends KeywordAnalyzer {

    private final String[] keywords;

    private final int maxCount;

    public TooMuchKeyWordsAnalyzer(String[] keywords, int maxCount) {
        this.keywords = keywords;
        this.maxCount = maxCount;
    }

    @Override
    public Label processText(String text) {
        for (String keyword : keywords) {
            if (text.length() - text.replace(String.valueOf(keyword), "").length() > maxCount * keyword.length()) {
                return Label.TOO_MUCH_KEYWORDS;
            }
        }
        return Label.OK;
    }

    @Override
    protected String[] getKeywords() {
        return new String[0];
    }

    @Override
    protected Label getLabel() {
        return null;
    }
}
