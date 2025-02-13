package org.example.servlet;

import org.example.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MirrorServlet extends HttpServlet {

    private static final String KEY_PARAMETER_NAME = "key";

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Map<String, Object> parameters = createPageVariablesMap(req);
//
//        if (parameters.get(KEY_PARAMETER_NAME) == null) {
//            parameters.put(KEY_PARAMETER_NAME, "пришедший параметр равен null");
//            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//        } else {
//            resp.setStatus(HttpServletResponse.SC_OK);
//        }
//
//        resp.setContentType("text/html;charset=utf-8");
//        resp.getWriter().println(PageGenerator.instance().getPage("page.html", parameters));
//    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put(KEY_PARAMETER_NAME, request.getParameter(KEY_PARAMETER_NAME));
        return pageVariables;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter(KEY_PARAMETER_NAME);

        String resultString = "пришедший параметр равен null";
        if (key != null) {
            resultString = KEY_PARAMETER_NAME + ":" + key;
        }

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(resultString);
    }
}
