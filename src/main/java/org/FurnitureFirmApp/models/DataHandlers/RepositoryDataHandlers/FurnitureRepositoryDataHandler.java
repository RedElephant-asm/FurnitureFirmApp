package org.FurnitureFirmApp.models.DataHandlers.RepositoryDataHandlers;

import org.FurnitureFirmApp.DAO.Furnitures.FurnitureRepository;
import org.FurnitureFirmApp.DAO.Furnitures.FurnitureViewRepository;
import org.FurnitureFirmApp.models.Furnitures.Furniture;
import org.FurnitureFirmApp.models.Furnitures.FurnitureView;
import org.springframework.ui.Model;

/**
 * Класс-обработчик репозитория базы данных, который ориентирован на предоставление информации о фурнитуре.
 * @author Red Elephant
 * @version 1.0
 * Наследует : {@link RepositoryDataHandler}&lt;{@link Furniture}, {@link FurnitureView}, {@link FurnitureRepository}, {@link FurnitureViewRepository}&gt;.
 */
public class FurnitureRepositoryDataHandler extends RepositoryDataHandler<Furniture, FurnitureView, FurnitureRepository, FurnitureViewRepository> {

    /**
     * Метод служит для добавления в объект-модель специфичных для фурнитуры данных о сущности/представлении,
     * которую/которое не удалось найти в базе данных.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     */
    @Override
    public void addNotFoundPageDataToModel(Model model) {
        model.addAttribute("objectName", "Furniture");
    }

}
