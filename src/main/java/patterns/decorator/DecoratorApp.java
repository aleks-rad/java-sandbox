package patterns.decorator;

import patterns.decorator.userservice.EncryptUserService;
import patterns.decorator.userservice.FilterUserService;
import patterns.decorator.userservice.SimpleUserService;
import patterns.decorator.userservice.UserService;

/**
 * Паттерн "Декоратор"
 * Динамически наделяет объект новыми возможностями и яляется гибкой альтрернативой субклассированию
 * в области расширения функциональности.
 */
public class DecoratorApp {

    public static void main(String[] args) {
        UserService userService = new SimpleUserService();
        userService = new EncryptUserService(userService);
        userService = new FilterUserService(userService);

        userService.createUser("ivanov92", "qwe123");
        //userService.createUser("login", "qwe123"); // пользователь с логином login не пройдет валидацию
    }

}
