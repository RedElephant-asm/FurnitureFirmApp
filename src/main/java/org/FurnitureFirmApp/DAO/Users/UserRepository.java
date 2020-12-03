package org.FurnitureFirmApp.DAO.Users;

import org.FurnitureFirmApp.models.Users.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Интерфейс который служит для описания настроек обьекта, который ориентирован на получение из базы данных информации
 * о пользователях.
 * @author Red Elephant
 * @version 1.0
 * Наследует : CrudRepository&lt;{@link User}, Integer&gt;.
 */
public interface UserRepository extends CrudRepository<User, Integer>{

    Optional<User> findByLogin(String login);

}
