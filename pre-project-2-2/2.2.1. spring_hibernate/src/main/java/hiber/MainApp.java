package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("BMW 3", 805)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("BMW 5", 199)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("BMW 7", 123)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car: " + user.getCar());
            System.out.println();
        }

        Optional<User> userOp = userService.getUserByCar("model", 12);
        if (userOp.isPresent()) {
            System.out.println("user: " + userOp.get());
        } else {
            System.out.println("Нет пользователя с машиной, model: model, series: 12");
        }

        Optional<User> userOp2 = userService.getUserByCar("BMW 3", 805);
        if (userOp2.isPresent()) {
            System.out.println("user: " + userOp2.get());
        } else {
            System.out.println("Нет пользователя с машиной, model: BMW 3, series: 805");
        }

        context.close();
    }
}
