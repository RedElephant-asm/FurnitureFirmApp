package org.FurnitureFirmApp.services;

import org.FurnitureFirmApp.DAO.Users.UserRepository;
import org.FurnitureFirmApp.models.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Класс - сервис, который используется Spring Security для получения и побработки данных о пользователях.
 * @author Red Elephant
 * @version 1.0
 */
@Service
public class UserService implements UserDetailsService {

    /**
     * Содержит экземпляр класса, который реализует интерфейс CrudRepository и применяется для получения данных о
     * представлениях из базы данных.
     */
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Метод используется Spring Security для организации авторизации.
     * @param login
     * Параметр содержит логин пользователя.
     * @return
     * Новый обьект org.springframework.security.core.userdetails.User, содержащий информацию об авторизованном пользователе.
     */
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(login);
        if(user.isEmpty()){
            throw new UsernameNotFoundException(login);
        }
        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(),
                user.get().getAuthorities());
    }
}
