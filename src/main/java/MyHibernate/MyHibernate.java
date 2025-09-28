/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package MyHibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author silkin
 */
public class MyHibernate {

    public static void main(String[] args) {
        // Настройка подключения к базе данных (замените параметры на свои)
        String url = "jdbc:postgresql://localhost:5432/users";
        String username = "admin";
        String password = "admin";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Создаем репозиторий
            Repository repo = new Repository(connection);

            // Создаем нового пользователя
            User newUser = new User("Иван Иванов", "ivan@example.com", 30, null);
            repo.create(newUser);
            System.out.println("Пользователь создан.");

            // Чтение пользователя по ID
            int userId = 1;
            User user = repo.readById(userId);
            if (user != null) {
                System.out.println("Прочитанный пользователь: " + user.getName() + ", " + user.getEmail());
            } else {
                System.out.println("Пользователь не найден");
            }

            // Обновление пользователя
            user.setName("Иван Иванович");
            user.setEmail("ivan.ivanovich@example.com");
            repo.update(user);
            System.out.println("Пользователь обновлен.");

            // Удаление пользователя
            repo.delete(userId);
            System.out.println("Пользователь удален.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
