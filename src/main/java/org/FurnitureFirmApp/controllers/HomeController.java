package org.FurnitureFirmApp.controllers;

import org.FurnitureFirmApp.models.DataHandlers.RepositoryDataHandlers.UserRepositoryDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Класс-контроллер, который управляет доступом к домашней странице
 * @author Red Elephant
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * Содержит экземпляр класса-сервиса, который предоставляет данные о пользователях.
     */
    @Autowired
    private UserRepositoryDataHandler repositoryDataHandler;

    /**
     * Метод служит для предоставления пользователю представления, которое является домашней страницей
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя.
     */
    @GetMapping("/Home")
    public String home(Model model){
        repositoryDataHandler.addViewToModel(model, repositoryDataHandler.getViewByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "application/home";
    }
}
