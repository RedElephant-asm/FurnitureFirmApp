package org.FurnitureFirmApp.models.Users;

import javax.persistence.*;

/**
 * Класс - модель, который является представлением базы данных.
 * @author Red Elephant
 * @version 1.0
 */
@Entity
@Table(name = "UsersV", schema = "FurnitureFirm")
public class UserView {

    /**
     * Поле, которое соответствует столбцу "userId" в таблице "UsersV" базы данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;

    /**
     * Поле, которое соответствует столбцу "secondName" в таблице "UsersV" базы данных.
     */
    @Column(name = "secondName")
    private String secondName;

    /**
     * Поле, которое соответствует столбцу "firstName" в таблице "UsersV" базы данных.
     */
    @Column(name = "firstName")
    private String firstName;

    /**
     * Поле, которое соответствует столбцу "middleName" в таблице "UsersV" базы данных.
     */
    @Column(name = "middleName")
    private String middleName;

    /**
     * Поле, которое соответствует столбцу "roleName" в таблице "UsersV" базы данных.
     */
    @Column(name = "roleName")
    private String roleName;

    /**
     * Поле, которое соответствует столбцу "login" в таблице "UsersV" базы данных.
     */
    @Column(name = "login")
    private String login;

    /**
     * Поле, которое соответствует столбцу "userpassword" в таблице "UsersV" базы данных.
     */
    @Column(name = "userpassword")
    private String userpassword;

    /**
     * Новый объект {@link UserView}
     */
    public UserView(){}

    /**
     * Метод предоставляет значение поля {@link UserView#userId}
     * @return
     * Значение поля {@link UserView#userId}
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Метод предоставляет значение поля {@link UserView#secondName}
     * @return
     * Значение поля {@link UserView#secondName}
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Метод предоставляет значение поля {@link UserView#firstName}
     * @return
     * Значение поля {@link UserView#firstName}
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Метод предоставляет значение поля {@link UserView#middleName}
     * @return
     * Значение поля {@link UserView#middleName}
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Метод предоставляет значение поля {@link UserView#roleName}
     * @return
     * Значение поля {@link UserView#roleName}
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Метод предоставляет значение поля {@link UserView#login}
     * @return
     * Значение поля {@link UserView#login}
     */
    public String getLogin() {
        return login;
    }

    /**
     * Метод предоставляет значение поля {@link UserView#userpassword}
     * @return
     * Значение поля {@link UserView#userpassword}
     */
    public String getUserpassword() {
        return userpassword;
    }
}
