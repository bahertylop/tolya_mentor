package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.repository.UserRepository;
import org.example.service.AccountService;
import org.example.servlets.SignInServlet;
import org.example.servlets.SignUpServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService(new UserRepository());
        SignUpServlet signUpServlet = new SignUpServlet(accountService);
        SignInServlet signInServlet = new SignInServlet(accountService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(signUpServlet), "/sign_up");
        context.addServlet(new ServletHolder(signInServlet), "/sign_in");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}