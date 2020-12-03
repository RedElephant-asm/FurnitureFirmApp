package org.FurnitureFirmApp.models.DataHandlers.RepositoryDataHandlers;

import org.FurnitureFirmApp.DAO.Users.UserRepository;
import org.FurnitureFirmApp.DAO.Users.UserViewRepository;
import org.FurnitureFirmApp.models.Users.User;
import org.FurnitureFirmApp.models.Users.UserView;
import org.springframework.ui.Model;

/**
 * Класс-обработчик репозитория базы данных, который ориентирован на предоставление информации о ользователях.
 * @author Red Elephant
 * @version 1.0
 * Наследует : {@link RepositoryDataHandler}&lt;{@link User}, {@link UserView}, {@link UserRepository}, {@link UserViewRepository}&gt;.
 */
public class UserRepositoryDataHandler extends RepositoryDataHandler<User, UserView, UserRepository, UserViewRepository> {

    /**
     * Метод служит для получения сущности пользователя из репозитория базы данных с помощью логина.
     * @param login
     * Параметр содержит логин пользователя, которого требуется получить.
     * @return
     * Объект класса UserView.
     */
    public UserView getViewByLogin(String login){
        return super.getViewRepository().findByLogin(login).get();
    }

    /**
     * Метод служит для добавления в объект-модель специфичных для пользователей данных о сущности/представлении,
     * которую/которое не удалось найти в базе данных.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     */
    @Override
    public void addNotFoundPageDataToModel(Model model){
        model.addAttribute("objectName", "User");
    }
}
