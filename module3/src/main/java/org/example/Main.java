package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.repository.UserRepository;
import org.example.service.AccountService;
import org.example.servlets.SignInServlet;
import org.example.servlets.SignUpServlet;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;

import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistry builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = new Configuration().buildSessionFactory(builder);

        System.out.println(sessionFactory.getProperties());


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