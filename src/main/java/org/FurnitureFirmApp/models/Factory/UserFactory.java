package org.FurnitureFirmApp.models.Factory;

import org.FurnitureFirmApp.models.Users.User;

/**
 * Класс, который являтся фабрикой для модели {@link User}.
 * @author Red Elephant
 * @version 1.0
 * Имплементирует : {@link ModelFactory}&lt;{@link User}&gt;.
 */
public class UserFactory implements ModelFactory<User> {

    /**
     * Метод служит для генерации пустой модели, которая является объектом класса {@link User}.
     * @return
     * Новый объект класса {@link User}.
     */
    @Override
    public User newEntity() {
        return new User();
    }
}
