package org.example.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import lombok.AllArgsConstructor;
import org.eclipse.jetty.http.HttpStatus;
import org.example.dto.UserDto;
import org.example.model.User;
import org.example.service.AccountService;
import org.example.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SignUpServlet extends HttpServlet {

    private final AccountService accountService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = ServletUtils.parseRequestBody(req, resp, UserDto.class);

        HttpStatus.Code code = accountService.signUp(userDto);
        resp.setStatus(code.getCode());
        if (code.equals(HttpStatus.OK_200)) {
            resp.getWriter().println("OK! You signed up");
        }
    }
}
