package org.FurnitureFirmApp.controllers;

import org.FurnitureFirmApp.models.CRUDControllerHandlers.FurnitureControllerHandler;
import org.FurnitureFirmApp.models.Furnitures.FurnitureView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Класс-контроллер, который управляет взаимодействием моделей типа "Фурнитура" и представлений.
 * @author Red Elephant
 * @version 1.0
 */

@Controller
@RequestMapping("/Furnitures")
public class FurnitureController {

    /**
     * Содержит экземпляр класса-сервиса, который предоставляет данные о фурнитуре.
     */
    @Autowired
    private FurnitureControllerHandler controllerHandler;

    /**
     * Метод служит для передачи страницы страницы обьектов-представлений фурнитуры в представление,
     * в ответ на GET-запрос пользователя.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param pageNumber
     * Номер страницы, которую требует передать представлению, и на основе которого будет сформирована таблица.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя.
     */
    @GetMapping({"/All", "/All/{pageNumber}"})
    public String allFurnitures(Model model, @PathVariable(name = "pageNumber", required = false) Integer pageNumber){
        controllerHandler.addPageOfViewsToModelByPageNumber(model, pageNumber);
        return "furnitures/all";
    }

    /**
     * Метод служит для передачи информации о какой либо фурнитуре в представление, в ответ на GET-запрос пользователя.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param furnitureId
     * Параметр содержит id представления фурнитуры, информацию о котором требуется передать в представление.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя или страница "notFound" в том случае, если материала с полученным id не существует.
     */
    @GetMapping("/{furnitureId}")
    public String getById(Model model, @PathVariable("furnitureId")int furnitureId){
        if(controllerHandler.addViewByIdToModelIsSuccessful(model, furnitureId)){
            return "furnitures/getById";
        } else {
            return "notFound";
        }
    }

    /**
     * Метод служит получения пользователем представления, содержащего форму регистрации нового материала, в ответ на
     * GET-запрос
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя.
     */
    @GetMapping("/Add")
    @PreAuthorize("hasAuthority('ROLE_3')")
    public String addFurnitureForm(){
        return "furnitures/add";
    }

    /**
     * Метод служит для обработки POST-запроса, составленного на основе получнных при отправке формы регистрации
     * Фурнитуры.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param article
     * Параметр содержит артикль новой фурнитуры.
     * @param furnitureName
     * Параметр содержит имя новой фурнитуры.
     * @param count
     * Параметр содержит количество нового материала.
     * @param measureId
     * Параметр содержит id единицы измерения нового материала.
     * @param fragmentTypeId
     * Параметр содержит id фрагмента, входящего в состав материала.
     * @param price
     * Параметр содержит цену нового материала.
     * @return
     * Адрес страницы, на которую перенаправляется пользователь после завершения операции.
     */
    @PostMapping("/Add")
    @PreAuthorize("hasAuthority('ROLE_3')")
    public String addFurniture(Model model,
            @RequestParam("article")String article,
            @RequestParam("furnitureName")String furnitureName,
            @RequestParam("count")Integer count,
            @RequestParam("measureId")Integer measureId,
            @RequestParam("fragmentTypeId")Integer fragmentTypeId,
            @RequestParam("price")BigDecimal price
    ){
        controllerHandler.saveEntityAndAddViewByThis(model, article, furnitureName, count, measureId, fragmentTypeId, price);
        return "redirect:/Furnitures/All";
    }

    /**
     * Метод служит для передачи обьекта класса {@link FurnitureView} в представление, которое содержит форму обновления
     * фурнитуры, для того, чтобы разместить поля передаваемого обьекта в форме обновления, тем самым упростив
     * процесс обновления.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param furnitureId
     * Параметр содержит id представления фурнитуры, информацию о которой требуется передать в представление.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя или страница "notFound" в том случае, если пользователя с полученным id не существует.
     */
    @GetMapping("/Update/{furnitureId}")
    @PreAuthorize("hasAuthority('ROLE_3')")
    public String updateFurnitureForm(Model model, @PathVariable("furnitureId")Integer furnitureId){
        if(controllerHandler.addViewByIdToModelIsSuccessful(model, furnitureId)){
            return "furnitures/update";
        } else {
            return "notFound";
        }
    }

    /**
     * Метод служит для обработки POST-запроса, составленного на основе полученных при отправке формы обновления данных.
     * @param furnitureId
     * Параметр содержит id фурнитуры.
     * @param article
     * Параметр содержит артикль фурнитуры.
     * @param furnitureName
     * Параметр содержит имя фурнитуры.
     * @param count
     * Параметр содержит количество фурнитуры.
     * @param measureId
     * Параметр содержит id единицы измерения материала.
     * @param fragmentTypeId
     * Параметр содержит id типа фрагмента, который входит в состав фурнитуры.
     * @param price
     * Параметр содержит цену фурнитуры.
     * @return
     * Адрес страницы, на которую перенаправляется пользователь после завершения операции.
     */
    @PostMapping("/Update/{furnitureId}")
    @PreAuthorize("hasAuthority('ROLE_3')")
    public String updateFurniture(
            @PathVariable("furnitureId")Integer furnitureId,
            @RequestParam("article")String article,
            @RequestParam("furnitureName")String furnitureName,
            @RequestParam("count")Integer count,
            @RequestParam("measureId")Integer measureId,
            @RequestParam("fragmentTypeId")Integer fragmentTypeId,
            @RequestParam("price")BigDecimal price
    ){
        controllerHandler.updateEntityById(furnitureId, article, furnitureName, count, measureId, fragmentTypeId, price);
        return "redirect:/Furnitures/All";
    }

    /**
     * Метод служит для обработки POST запроса, полученного при запросе пользователя на удаление фурнитуры с
     * определенным id.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param furnitureId
     * Параметр содержит id фурнитуры, котороую требуется удалить.
     * @return
     * Адрес страницы, на которую перенаправляется пользователь после завершения операции или страница "notFound"
     * в том случае, если фурнитуры с полученным id не существует.
     */
    @PostMapping("/Delete/{furnitureId}")
    @PreAuthorize("hasAuthority('ROLE_3')")
    public String deleteFurniture(Model model, @PathVariable("furnitureId")Integer furnitureId){
        if(controllerHandler.deleteEntityByIdIsSuccessful(model, furnitureId)){
            return "redirect:/Furnitures/All";
        } else {
            return "notFound";
        }
    }
}
