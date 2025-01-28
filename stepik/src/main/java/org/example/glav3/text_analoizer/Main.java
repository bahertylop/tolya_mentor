package org.example.glav3.text_analoizer;

public class Main {

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer textAnalyzer : analyzers) {
            Label analizRes = textAnalyzer.processText(text);
            if (!analizRes.equals(Label.OK)) {
                return analizRes;
            }
        }
        return Label.OK;
    }
}
