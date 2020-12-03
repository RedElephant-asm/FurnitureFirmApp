package org.FurnitureFirmApp.models.Users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс - модель, который является сущностью базы данных.
 * @author Red Elephant
 * @version 1.0
 */
@Entity
@Table(schema = "FurnitureFirm", name = "Users")
public class User implements UserDetails {

    /**
     * Поле, которое соответствует столбцу "userId" в таблице "Users" базы данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;

    /**
     * Поле, которое соответствует столбцу "secondName" в таблице "Users" базы данных.
     */
    @Column(name = "secondName")
    private String secondName;

    /**
     * Поле, которое соответствует столбцу "firstName" в таблице "Users" базы данных.
     */
    @Column(name = "firstName")
    private String firstName;

    /**
     * Поле, которое соответствует столбцу "middleName" в таблице "Users" базы данных.
     */
    @Column(name = "middleName")
    private String middleName;

    /**
     * Поле, которое соответствует столбцу "roleId" в таблице "Users" базы данных.
     */
    @Column(name = "roleId")
    private Integer roleId = 1;

    /**
     * Поле, которое соответствует столбцу "login" в таблице "Users" базы данных.
     */
    @Column(name = "login")
    private String login;

    /**
     * Поле, которое соответствует столбцу "userpassword" в таблице "Users" базы данных.
     */
    @Column(name = "userpassword")
    private String userpassword;

    @Transient
    private String passwordConfirm;

    /**
     * Новый объект класса {@link User}.
     * @param secondName
     * Значение поля {@link User#secondName}
     * @param firstName
     * Значение поля {@link User#firstName}
     * @param middleName
     * Значение поля {@link User#middleName}
     * @param roleId
     * Значение поля {@link User#roleId}
     * @param login
     * Значение поля {@link User#login}
     * @param userpassword
     * Значение поля {@link User#userpassword}
     */
    public User(String secondName, String firstName, String middleName,
                Integer roleId, String login, String userpassword) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.roleId = roleId;
        this.userpassword = userpassword;
        this.login = login;
    }

    /**
     * Новый объект класса {@link User}.
     */
    public User(){}

    /**
     * Метод предоставляет значение поля {@link User#userId}
     * @return
     * Значение поля {@link User#userId}
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Метод устанавливает значение поля {@link User#userId}
     * @param userId
     * Параметр содержит новое значение для поля {@link User#userId}
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Метод предоставляет значение поля {@link User#secondName}
     * @return
     * Значение поля {@link User#secondName}
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Метод устанавливает значение поля {@link User#secondName}
     * @param secondName
     * Параметр содержит новое значение для поля {@link User#secondName}
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * Метод предоставляет значение поля {@link User#firstName}
     * @return
     * Значение поля {@link User#firstName}
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Метод устанавливает значение поля {@link User#firstName}
     * @param firstName
     * Параметр содержит новое значение для поля {@link User#firstName}
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Метод предоставляет значение поля {@link User#middleName}
     * @return
     * Значение поля {@link User#middleName}
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Метод устанавливает значение поля {@link User#middleName}
     * @param middleName
     * Параметр содержит новое значение для поля {@link User#middleName}
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Метод предоставляет значение поля {@link User#roleId}
     * @return
     * Значение поля {@link User#roleId}
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * Метод устанавливает значение поля {@link User#roleId}
     * @param roleId
     * Параметр содержит новое значение для поля {@link User#roleId}
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * Метод предоставляет значение поля {@link User#login}
     * @return
     * Значение поля {@link User#login}
     */
    public String getLogin() {
        return login;
    }

    /**
     * Метод устанавливает значение поля {@link User#login}
     * @param login
     * Параметр содержит новое значение для поля {@link User#login}
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Метод предоставляет значение поля {@link User#userpassword}
     * @return
     * Значение поля {@link User#userpassword}
     */
    public String getUserpassword() {
        return userpassword;
    }

    /**
     * Метод устанавливает значение поля {@link User#userpassword}
     * @param userpassword
     * Параметр содержит новое значение для поля {@link User#userpassword}
     */
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    /**
     * Метод предоставляет значение поля {@link User#passwordConfirm}
     * @return
     * Значение поля {@link User#passwordConfirm}
     */
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    /**
     * Метод устанавливает значение поля {@link User#passwordConfirm}
     * @param passwordConfirm
     * Параметр содержит новое значение для поля {@link User#passwordConfirm}
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    //------------[ UserDetails ]

    /**
     * Метод предоставляет права пользователя
     * @return
     * Строка, содержащая права пользователя
     */
    @Override
    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthority = new HashSet<>();
        grantedAuthority.add(new SimpleGrantedAuthority(String.format("ROLE_%d", this.getRoleId())));
        return grantedAuthority;
    }

    /**
     * Метод, кторый используется Spring Security и возвращает пароль пользователя.
     * @return
     * Строка, содержащая пароль пользователя.
     */
    @Override
    public String getPassword() {
        return this.userpassword;
    }

    /**
     * Метод, кторый используется Spring Security и возвращает пароль логин.
     * @return
     * Строка, содержащая логин пользователя.
     */
    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
