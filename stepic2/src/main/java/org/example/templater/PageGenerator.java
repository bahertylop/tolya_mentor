package org.example.templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PageGenerator {

    private static final String HTML_DIRECTORY = "templates";

    private static PageGenerator pageGenerator;

    private final Configuration configuration;

    public static PageGenerator instance() {
        if (pageGenerator == null) {
            pageGenerator = new PageGenerator();
        }
        return pageGenerator;
    }

    public PageGenerator() {
        this.configuration = new Configuration();
    }

    public String getPage(String fileName, Map<String, Object> data) {
        Writer writer = new StringWriter();
        try {
            Template template = configuration.getTemplate(HTML_DIRECTORY + File.separator + fileName);
            template.process(data, writer);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}
