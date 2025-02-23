-- Заполняем таблицу cars
INSERT INTO cars (brand, color, model, price) VALUES
                                                  ('Toyota', 'Red', 'Corolla', 20000),
                                                  ('Honda', 'Blue', 'Civic', 22000),
                                                  ('Ford', 'Black', 'Focus', 21000),
                                                  ('BMW', 'White', 'X5', 55000),
                                                  ('Mercedes', 'Silver', 'C-Class', 48000),
                                                  ('Audi', 'Gray', 'A4', 46000),
                                                  ('Nissan', 'Green', 'Altima', 23000),
                                                  ('Hyundai', 'Yellow', 'Elantra', 20000),
                                                  ('Kia', 'Blue', 'Sportage', 25000),
                                                  ('Volkswagen', 'Black', 'Passat', 27000);

-- Заполняем таблицу users, связывая каждого пользователя с одной машиной
INSERT INTO users (email, name, last_name, car_id) VALUES
                                                       ('user1@example.com', 'John', 'Doe', 1),
                                                       ('user2@example.com', 'Alice', 'Smith', 2),
                                                       ('user3@example.com', 'Bob', 'Johnson', 3),
                                                       ('user4@example.com', 'Charlie', 'Brown', 4),
                                                       ('user5@example.com', 'David', 'White', 5),
                                                       ('user6@example.com', 'Eve', 'Black', 6),
                                                       ('user7@example.com', 'Frank', 'Miller', 7),
                                                       ('user8@example.com', 'Grace', 'Davis', 8),
                                                       ('user9@example.com', 'Hank', 'Wilson', 9),
                                                       ('user10@example.com', 'Ivy', 'Moore', 10);
