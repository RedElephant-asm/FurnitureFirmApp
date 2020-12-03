package org.FurnitureFirmApp.models.CRUDControllerHandlers;

import org.FurnitureFirmApp.DAO.Users.UserRepository;
import org.FurnitureFirmApp.DAO.Users.UserViewRepository;
import org.FurnitureFirmApp.models.DataHandlers.ControllerHandler;
import org.FurnitureFirmApp.models.DataHandlers.RepositoryDataHandlers.UserRepositoryDataHandler;
import org.FurnitureFirmApp.models.Users.User;
import org.FurnitureFirmApp.models.Users.UserView;
import org.springframework.stereotype.Service;

/**
 * Класс-сервис, который предоставляет информацию о пользователях.
 * @author Red Elephant
 * @version 1.0
 * Наследует : {@link ControllerHandler}&lt;{@link User}, {@link UserView}, {@link UserRepository}, {@link UserViewRepository}, {@link UserRepositoryDataHandler}&gt;.
 */
@Service
public class UserControllerHandler extends ControllerHandler<User, UserView, UserRepository, UserViewRepository, UserRepositoryDataHandler>{

    /**
     * Метод служит для обновления пользователя.
     * @param userId
     * Параметр содержит id пользователя.
     * @param userSecondName
     * Параметр содержит фамилию пользователя.
     * @param userFirstName
     * Параметр содержит имя пользователя.
     * @param userMiddleName
     * Параметр содержит отчество пользователя.
     * @param userRole
     * Пааметр содержит id роли пользователя.
     * @param userLogin
     * Параметр содержит логин пользователя.
     * @param userPassword
     * Параметр содержит пароль пользователя.
     */
    public void updateEntityById(Integer userId, String userSecondName, String userFirstName, String userMiddleName,
                                             Integer userRole, String userLogin, String userPassword){
        User modifiedEntity = new User(userSecondName, userFirstName, userMiddleName, userRole, userLogin, userPassword);
        modifiedEntity.setUserId(userId);
        repositoryDataHandler.saveEntityToRepository(modifiedEntity);
    }


    public void updateEntity(User entity){
        repositoryDataHandler.saveEntityToRepository(entity);
    }
}