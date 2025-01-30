package org.example.glav3.text_analoizer;

public class Main {

    public static void main(String[] args) {
        TextAnalyzer[] analyzers = new TextAnalyzer[] {
                new TooMuchKeyWordsAnalyzer(
                        new String[] {"я", "джава"},
                        3
                )
        };

        System.out.println(checkLabels(analyzers, "я джава, я учу людей джава, джава чертовски хорош, я это куча денег, я"));
        System.out.println(checkLabels(analyzers, "я джава, я учу людей джава, джава чертовски хорош, джава это куча денег, джава"));
        System.out.println(checkLabels(analyzers, "джава это круто"));
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer textAnalyzer : analyzers) {
            Label analizRes = textAnalyzer.processText(text);
            if (!analizRes.equals(Label.OK)) {
                return analizRes;
            }
        }
        return Label.OK;
    }
}
