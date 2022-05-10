package patterns.decorator.userservice;

import org.apache.commons.codec.digest.DigestUtils;
import patterns.decorator.User;

import static utils.Utils.println;

/**
 * Класс добавляет шифрование пароля
 */
public class EncryptUserService implements UserService {

    private final UserService wrappedUserService;

    public EncryptUserService(UserService wrappedUserService){
        this.wrappedUserService = wrappedUserService;
    }

    @Override
    public User createUser(String login, String password) {
        password = encryptPassword(password);
        User user = wrappedUserService.createUser(login, password);

        return user;
    }

    private String encryptPassword(String password){
        println("Зашифровали пароль");
        return DigestUtils
                .md5Hex(password);
    }

}
