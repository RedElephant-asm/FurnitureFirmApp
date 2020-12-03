package org.FurnitureFirmApp.DAO.Furnitures;

import org.FurnitureFirmApp.models.Furnitures.FurnitureView;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Интерфейс который служит для описания настроек обьекта, который ориентирован на получение из базы данных информации
 * о представлениях фурнитуры.
 * @author Red Elephant
 * @version 1.0
 * Наследует : PagingAndSortingRepository&lt;{@link FurnitureView}, Integer&gt;.
 */
public interface FurnitureViewRepository extends PagingAndSortingRepository<FurnitureView, Integer>{

}
