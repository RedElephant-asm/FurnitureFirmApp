package org.FurnitureFirmApp.models.DataHandlers.RepositoryDataHandlers;

import org.FurnitureFirmApp.DAO.Materials.MaterialRepository;
import org.FurnitureFirmApp.DAO.Materials.MaterialViewRepository;
import org.FurnitureFirmApp.models.Materials.Material;
import org.FurnitureFirmApp.models.Materials.MaterialView;
import org.springframework.ui.Model;

/**
 * Класс-обработчик репозитория базы данных, который ориентирован на предоставление информации о материалах.
 * @author Red Elephant
 * @version 1.0
 * Наследует : {@link RepositoryDataHandler}&lt;{@link Material}, {@link MaterialView}, {@link MaterialRepository}, {@link MaterialViewRepository}&gt;.
 */
public class MaterialRepositoryDataHandler extends RepositoryDataHandler<Material, MaterialView, MaterialRepository, MaterialViewRepository> {

    /**
     * Метод служит для добавления в объект-модель специфичных для материалов данных о сущности/представлении,
     * которую/которое не удалось найти в базе данных.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     */
    @Override
    public void addNotFoundPageDataToModel(Model model) {
        model.addAttribute("objectName", "Material");
    }

}
