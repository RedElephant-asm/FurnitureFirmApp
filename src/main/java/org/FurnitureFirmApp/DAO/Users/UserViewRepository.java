package org.FurnitureFirmApp.DAO.Users;

import org.FurnitureFirmApp.models.Users.UserView;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Интерфейс который служит для описания настроек обьекта, который ориентирован на получение из базы данных информации
 * о представлениях пользователей.
 * @author Red Elephant
 * @version 1.0
 * Наследует : PagingAndSortingRepository&lt;{@link UserView}, Integer&gt;.
 */
public interface UserViewRepository extends PagingAndSortingRepository<UserView, Integer> {

    /**
     * Метод служит для предостовлении информации о пользователе, поиск которого в базе данных осуществляется с
     * помощью логина.
     * @param login
     * Содержит логин пользователя.
     * @return
     * Новый объект класса Optional с параметром {@link UserView}.
     */
    Optional<UserView> findByLogin(String login);

}
