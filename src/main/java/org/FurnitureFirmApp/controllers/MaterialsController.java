package org.FurnitureFirmApp.controllers;

import org.FurnitureFirmApp.models.CRUDControllerHandlers.MaterialControllerHandler;
import org.FurnitureFirmApp.models.Materials.MaterialView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Класс-контроллер, который управляет взаимодействием моделей типа "Материал" и представлений.
 * @author Red Elephant
 * @version 1.0
 */
@Controller
@RequestMapping("/Materials")
public class MaterialsController{

    /**
     * Содержит экземпляр класса-сервиса, который предоставляет данные о материалах.
     */
    @Autowired
    private MaterialControllerHandler controllerHandler;

    /**
     * Метод служит для передачи страницы страницы обьектов-представлений материалов в представление,
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
    public String getPageOfMaterials(Model model, @PathVariable(name = "pageNumber", required = false)Integer pageNumber){
        controllerHandler.addPageOfViewsToModelByPageNumber(model, pageNumber);
        return "materials/all";
    }

    /**
     * Метод служит для передачи информации о каком либо материале в представление, в ответ на GET-запрос пользователя.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param materialId
     * Параметр содержит id представления материала, информацию о котором требуется передать в представление.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя или страница "notFound" в том случае, если материала с полученным id не существует.
     */
    @GetMapping("/{materialId}")
    public String getById(Model model, @PathVariable("materialId")Integer materialId){
        if(controllerHandler.addViewByIdToModelIsSuccessful(model, materialId)){
            return "materials/getById";
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
    public String addMaterialForm(){
        return "materials/add";
    }

    /**
     * Метод служит для обработки POST-запроса, составленного на основе получнных при отправке формы регистрации
     * материала.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param article
     * Параметр содержит артикль нового материала.
     * @param materialName
     * Параметр содержит имя полного материала.
     * @param measureId
     * Параметр содержит id единицы измерения нового материала.
     * @param length
     * Параметр содержит длину нового материала.
     * @param count
     * Параметр содержит количество нового материала.
     * @param price
     * Параметр содержит цену нового материала.
     * @param materialTypeId
     * Параметр содержит id типа материала.
     * @param gostId
     * Параметр содержит id госта материала.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя.
     */
    @PreAuthorize("hasAuthority('ROLE_3')")
    @PostMapping("/Add")
    public String addMaterial(
            Model model,
            @RequestParam("article")String article,
            @RequestParam("materialName")String materialName,
            @RequestParam("measureId")Integer measureId,
            @RequestParam("length")Float length,
            @RequestParam("count")Integer count,
            @RequestParam("price")BigDecimal price,
            @RequestParam("materialTypeId")Integer materialTypeId,
            @RequestParam("gostId")Integer gostId
    ){
        controllerHandler.saveEntityAndAddViewByThis(model, article, materialName, measureId, length, count, price, materialTypeId, gostId);
        return "redirect:/Materials/All";
    }

    /**
     * Метод служит для передачи обьекта класса {@link MaterialView} в представление, которое содержит форму обновления
     * материала, для того, чтобы разместить поля передаваемого обьекта в форме обновления, тем самым упростив
     * процесс обновления.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param materialId
     * Параметр содержит id представления материала, информацию о котором требуется передать в представление.
     * @return
     * Полное(относительно параметров шаблонизатора) имя представления, которое контроллер вернет в ответ на запрос
     * пользователя или страница "notFound" в том случае, если пользователя с полученным id не существует.
     */
    @PreAuthorize("hasAuthority('ROLE_3')")
    @GetMapping("/Update/{materialId}")
    public String updateMaterialForm(Model model, @PathVariable("materialId")Integer materialId){
        if(controllerHandler.addViewByIdToModelIsSuccessful(model, materialId)){
            return "materials/update";
        } else {
            return "notFound";
        }
    }

    /**
     * Метод служит для обработки POST-запроса, составленного на основе полученных при отправке формы обновления данных.
     * @param materialId
     * Параметр содержит id материала.
     * @param article
     * Параметр содержит артикль нового материала.
     * @param materialName
     * Параметр содержит имя полного материала.
     * @param measureId
     * Параметр содержит id единицы измерения нового материала.
     * @param length
     * Параметр содержит длину нового материала.
     * @param count
     * Параметр содержит количество нового материала.
     * @param price
     * Параметр содержит цену нового материала.
     * @param materialTypeId
     * Параметр содержит id типа материала.
     * @param gostId
     * Параметр содержит id госта материала.
     * @return
     * Адрес страницы, на которую перенаправляется пользователь после завершения операции.
     */
    @PreAuthorize("hasAuthority('ROLE_3')")
    @PostMapping("/Update/{materialId}")
    public String updateMaterial(
            @PathVariable("materialId")Integer materialId,
            @RequestParam("article")String article,
            @RequestParam("materialName")String materialName,
            @RequestParam("measureId")Integer measureId,
            @RequestParam("length")Float length,
            @RequestParam("count")Integer count,
            @RequestParam("price")BigDecimal price,
            @RequestParam("materialTypeId")Integer materialTypeId,
            @RequestParam("gostId")Integer gostId
    ){
        controllerHandler.updateEntityById(materialId, article, materialName, measureId, length, count, price, materialTypeId, gostId);
        return "redirect:/Materials/All";
    }

    /**
     * Метод служит для обработки POST запроса, полученного при запросе пользователя на удаление материала с
     * определенным id.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param materialId
     * Параметр содержит id материала, которого требуется удалить.
     * @return
     * Адрес страницы, на которую перенаправляется пользователь после завершения операции или страница "notFound"
     * в том случае, если материала с полученным id не существует.
     */
    @PreAuthorize("hasAuthority('ROLE_3')")
    @PostMapping("/Delete/{materialId}")
    public String deleteMaterial(Model model, @PathVariable("materialId")Integer materialId){
        if(controllerHandler.deleteEntityByIdIsSuccessful(model, materialId)){
            return "redirect:/Materials/All";
        } else {
            return "notFound";
        }
    }
}
