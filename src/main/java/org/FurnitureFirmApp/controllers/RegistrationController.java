package org.FurnitureFirmApp.controllers;

import org.FurnitureFirmApp.models.CRUDControllerHandlers.UserControllerHandler;
import org.FurnitureFirmApp.models.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Класс-контроллер, который управляет доступом к странице регистрации
 * @author Red Elephant
 * @version 1.0
 */

@Controller
@RequestMapping("/Registration")
public class RegistrationController {

    /**
     * Содержит экземпляр класса-сервиса, который предоставляет данные о пользователях.
     */
    @Autowired
    private UserControllerHandler controllerHandler;

    /**
     * Метод служит для предоставления пользователю представления, которое является страницей регистрации
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя.
     */
    @GetMapping("")
    public String getRegistrationForm(Model model){
        controllerHandler.addEmptyEntityToModel(model);
        return "application/registration";
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
    @PostMapping("")
    public String addUser(@ModelAttribute("entity") User newUser){
        controllerHandler.saveNewEntity(newUser);
        return "redirect:/Login";
    }
}
