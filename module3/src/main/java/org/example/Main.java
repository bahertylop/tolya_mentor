package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.AccountService;
import org.example.servlets.SignInServlet;
import org.example.servlets.SignUpServlet;
import org.example.util.ServletUtils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();

        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(User.class)
                .buildMetadata();

        SessionFactory sessionFactory = metadata.buildSessionFactory();

//        for (Map.Entry<String, Object> prop : sessionFactory.getProperties().entrySet()) {
//            System.out.println(prop.getKey() + " : " + prop.getValue());
//        }

        ServletUtils servletUtils = new ServletUtils();
        AccountService accountService = new AccountService(new UserRepository(sessionFactory));
        SignUpServlet signUpServlet = new SignUpServlet(accountService, servletUtils);
        SignInServlet signInServlet = new SignInServlet(accountService, servletUtils);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(signUpServlet), "/signup");
        context.addServlet(new ServletHolder(signInServlet), "/signin");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}