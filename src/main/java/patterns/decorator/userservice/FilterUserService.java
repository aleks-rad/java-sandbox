package patterns.decorator.userservice;

import patterns.decorator.User;

import static utils.Utils.println;

/**
 * Класс добавляет валидацию логина
 */
public class FilterUserService implements UserService {

    private final UserService wrappedUserService;

    public FilterUserService(UserService wrappedUserService) {
        this.wrappedUserService = wrappedUserService;
    }

    @Override
    public User createUser(String login, String password) {
        boolean isValid = loginFilter(login);

        if (isValid) {
            wrappedUserService.createUser(login, password);
        }

        return null;
    }

    private boolean loginFilter(String login) {
        println("Валидация логина");

        if ("login".equals(login.toLowerCase())) {
            println("Логин не прошел валидацию");
            return false;
        }

        return true;
    }

}
