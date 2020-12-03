package org.FurnitureFirmApp.models.CRUDControllerHandlers;

import org.FurnitureFirmApp.DAO.Materials.MaterialRepository;
import org.FurnitureFirmApp.DAO.Materials.MaterialViewRepository;
import org.FurnitureFirmApp.models.DataHandlers.ControllerHandler;
import org.FurnitureFirmApp.models.DataHandlers.RepositoryDataHandlers.MaterialRepositoryDataHandler;
import org.FurnitureFirmApp.models.Materials.Material;
import org.FurnitureFirmApp.models.Materials.MaterialView;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.math.BigDecimal;

/**
 * Класс-сервис, который предоставляет информацию о материалах.
 * @author Red Elephant
 * @version 1.0
 * Наследует : {@link ControllerHandler}&lt;{@link Material}, {@link MaterialView}, {@link MaterialRepository}, {@link MaterialViewRepository}, {@link MaterialRepositoryDataHandler}&gt;.
 */
@Service
public class MaterialControllerHandler extends ControllerHandler<Material, MaterialView, MaterialRepository, MaterialViewRepository, MaterialRepositoryDataHandler> {

    /**
     * Метод служит для сохранения нового материала и добавления представления данного материала в обьект-модель,
     * для передачи представлению информации о нем.
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
     */
    public void saveEntityAndAddViewByThis(Model model, String article, String materialName, Integer measureId, Float length,
                                         Integer count, BigDecimal price, Integer materialTypeId, Integer gostId){
        Material newMaterial = new Material(article, materialName, measureId, length, count, price, materialTypeId, gostId);
        repositoryDataHandler.saveEntityToRepository(newMaterial);
        repositoryDataHandler.addViewToModel(model, repositoryDataHandler.getViewById(newMaterial.getMaterialId()).get());
    }

    /**
     * Метод служит для обновления материала.
     * @param materialId
     * Параметр содержит id материала, который требуется обновить
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
    */
    public void updateEntityById(Integer materialId, String article, String materialName, Integer measureId, Float length,
                                   Integer count, BigDecimal price, Integer materialTypeId, Integer gostId){
        Material modifiedEntity = new Material(article, materialName, measureId, length, count, price, materialTypeId, gostId);
        modifiedEntity.setMaterialId(materialId);
        repositoryDataHandler.saveEntityToRepository(modifiedEntity);
    }
}