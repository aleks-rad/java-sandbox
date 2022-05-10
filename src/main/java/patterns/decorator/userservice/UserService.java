package patterns.decorator.userservice;

import patterns.decorator.User;

public interface UserService {

    User createUser(String login, String password);

}
