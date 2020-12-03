package org.FurnitureFirmApp.controllers;

import org.FurnitureFirmApp.models.CRUDControllerHandlers.UserControllerHandler;
import org.FurnitureFirmApp.models.Users.User;
import org.FurnitureFirmApp.models.Users.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Класс-контроллер, который управляет взаимодействием моделей типа "Пользователь" и представлений.
 * @author Red Elephant
 * @version 1.0
 */
@Controller
@RequestMapping("/Users")
@PreAuthorize("hasAuthority('ROLE_2') OR hasAuthority('ROLE_3') OR hasAuthority('ROLE_4') OR hasAuthority('ROLE_5')")
public class UserController {

    /**
     * Содержит экземпляр класса-сервиса, который предоставляет данные о пользователях.
     */
    @Autowired
    private UserControllerHandler controllerHandler;

    /**
     * Метод служит для передачи информации о каком либо пользователе в представление, в ответ на GET-запрос пользователя.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param userId
     * Параметр содержит id представления пользователя, информацию о котором требуется передать в представление.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя или страница "notFound" в том случае, если пользователя с полученным id не существует.
     */
    @GetMapping("/{userId}")
    public String getUserById(Model model, @PathVariable("userId")Integer userId){
        if(controllerHandler.addViewByIdToModelIsSuccessful(model, userId)){
            return "users/getById";
        } else {
            return "notFound";
        }
    }

    /**
     * Метод служит для передачи страницы страницы обьектов-представлений пользователей в представление,
     * в ответ на GET-запрос пользователя.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param pageNumber
     * Номер страницы, которую требует передать представлению, и на основе которого будет сформирована таблица.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя.
     */
    @GetMapping(value = {"/All", "/All/{pageNumber}"})
    public String getPageOfUsers(Model model, @PathVariable(required = false, name = "pageNumber")Integer pageNumber){
        controllerHandler.addPageOfViewsToModelByPageNumber(model, pageNumber);
        return "users/all";
    }

    /**
     * Метод служит для передачи пустого обьекта класса {@link User}, на основе которого будет создан новый пользователь,
     * в представление, которое содержит форму регистрации, в ответ на Get-запрос пользователя.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя.
     */
    @GetMapping("/Add")
    @PreAuthorize("hasAuthority('ROLE_3')")
    public String addUserForm(Model model){
        controllerHandler.addEmptyEntityToModel(model);
        return "users/add";
    }

    /**
     * Метод служит для обработки POST-запроса, составленного на основе получнных при отправке формы регистрации
     * пользователя.
     * @param newUser
     * Параметр содержит обьект класса {@link User}, поля которого задаются на основе данных, полученных при отправке
     * формы регистрации пользователя.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя.
     */
    @PostMapping("/Add")
    @PreAuthorize("hasAuthority('ROLE_3')")
    public String AddUser(@ModelAttribute("entity") User newUser){
        controllerHandler.saveNewEntity(newUser);
        return "redirect:Users/All";
    }

    /**
     * Метод служит для передачи обьекта класса {@link UserView} в представление, которое содержит форму обновления
     * пользователя, для того, чтобы разместить поля передаваемого обьекта в форме обновления, тем самым упростив
     * процесс обновления.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param userId
     * Параметр содержит id представления пользователя, информацию о котором требуется передать в представление.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя или страница "notFound" в том случае, если пользователя с полученным id не существует.
     */
    @GetMapping("/Update/{userId}")
    @PreAuthorize("hasAuthority('ROLE_3')")
    public String updateUserForm(Model model, @PathVariable("userId")Integer userId){
        if(controllerHandler.addViewByIdToModelIsSuccessful(model, userId)){
            return "users/update";
        } else {
            return "notFound";
        }
    }

    /**
     * Метод служит для обработки POST-запроса, составленного на основе полученных при отправке формы обновления данных.
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
     * @return
     * Адрес страницы, на которую перенаправляется пользователь после завершения операции.
     */
    @PostMapping("/Update/{userId}")
    @PreAuthorize("hasAuthority('ROLE_3')")
    public String UpdateUser(
            @PathVariable("userId")Integer userId,
            @RequestParam("userSecondName")String userSecondName,
            @RequestParam("userFirstName")String userFirstName,
            @RequestParam("userMiddleName")String userMiddleName,
            @RequestParam("userRole")Integer userRole,
            @RequestParam("userLogin")String userLogin,
            @RequestParam("userPassword")String userPassword
    ){
        controllerHandler.updateEntityById(userId, userSecondName, userFirstName, userMiddleName, userRole, userLogin, userPassword);
        return "redirect:/Users/All";
    }

    /**
     * Метод служит для обработки POST запроса, полученного при запросе пользователя на удаление пользователя с
     * определенным id.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param userId
     * Параметр содержит id пользователя, которого требуется удалить.
     * @return
     * Адрес страницы, на которую перенаправляется пользователь после завершения операции или страница "notFound"
     * в том случае, если пользователя с полученным id не существует.
     */
    @PostMapping("/Delete/{userId}")
    @PreAuthorize("hasAuthority('ROLE_3')")
    public String DeleteUser(Model model, @PathVariable("userId")Integer userId){
        if(controllerHandler.deleteEntityByIdIsSuccessful(model, userId)){
            return "redirect:/Users/All";
        } else {
            return "notFound";
        }
    }
}