package org.FurnitureFirmApp.models.CRUDControllerHandlers;

import org.FurnitureFirmApp.DAO.Furnitures.FurnitureRepository;
import org.FurnitureFirmApp.DAO.Furnitures.FurnitureViewRepository;
import org.FurnitureFirmApp.models.DataHandlers.ControllerHandler;
import org.FurnitureFirmApp.models.DataHandlers.RepositoryDataHandlers.FurnitureRepositoryDataHandler;
import org.FurnitureFirmApp.models.Furnitures.Furniture;
import org.FurnitureFirmApp.models.Furnitures.FurnitureView;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.math.BigDecimal;

/**
 * Класс-сервис, который предоставляет информацию о фурнитуре.
 * @author Red Elephant
 * @version 1.0
 * Наследует : {@link ControllerHandler}&lt;{@link Furniture}, {@link FurnitureView}, {@link FurnitureRepository}, {@link FurnitureViewRepository}, {@link FurnitureRepositoryDataHandler}&gt;.
 */
@Service
public class FurnitureControllerHandler extends ControllerHandler<Furniture, FurnitureView, FurnitureRepository, FurnitureViewRepository, FurnitureRepositoryDataHandler> {

    /**
     * Метод служит для сохранения новой фурнитуры и добавления представления данной фурнитуры в обьект-модель,
     * для передачи представлению информации о ней.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
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
     */
    public void saveEntityAndAddViewByThis(Model model, String article, String furnitureName, Integer count,
                                         Integer measureId, Integer fragmentTypeId, BigDecimal price){
        Furniture newFurniture = new Furniture(article, furnitureName, count, measureId, fragmentTypeId, price);
        repositoryDataHandler.saveEntityToRepository(newFurniture);
        repositoryDataHandler.addViewToModel(model, repositoryDataHandler.getViewById(newFurniture.getFurnitureId()).get());
    }

    /**
     * Метод служит для обновления фурнитуры с помощью ее id
     * @param furnitureId
     * Параметр содержит id фурнитуры
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
     */
    public void updateEntityById(Integer furnitureId, String article, String furnitureName, Integer count,
                                              Integer measureId, Integer fragmentTypeId, BigDecimal price){
        Furniture modifiedFurniture = new Furniture(article, furnitureName, count, measureId, fragmentTypeId, price);
        modifiedFurniture.setFurnitureId(furnitureId);
        repositoryDataHandler.saveEntityToRepository(modifiedFurniture);
    }

}
