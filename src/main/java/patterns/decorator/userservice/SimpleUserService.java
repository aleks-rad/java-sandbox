package patterns.decorator.userservice;

import patterns.decorator.User;

import static utils.Utils.println;

public class SimpleUserService implements UserService {

    @Override
    public User createUser(String login, String password) {
        User user = new User(login, password);
        println("Пользователь создан в БД:\n" + user);

        return user;
    }

}
