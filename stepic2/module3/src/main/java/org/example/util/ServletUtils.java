package org.example.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class ServletUtils {

    private static final Gson GSON = new Gson();

    public <T> T parseRequestBody(HttpServletRequest req, HttpServletResponse resp, Class<T> clazz) throws IOException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        try {
            return GSON.fromJson(body, clazz);
        } catch (JsonSyntaxException e) {
            resp.setStatus(HttpStatus.BAD_REQUEST_400);
            return null;
        }
    }
}
