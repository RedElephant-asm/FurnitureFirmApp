package org.FurnitureFirmApp.DAO.Furnitures;

import org.FurnitureFirmApp.models.Furnitures.Furniture;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс который служит для описания настроек обьекта, который ориентирован на получение из базы данных информации
 * о фурнитуре.
 * @author Red Elephant
 * @version 1.0
 * Наследует : CrudRepository&lt;{@link Furniture}, Integer&gt;.
 */
public interface FurnitureRepository extends CrudRepository<Furniture, Integer> {

}
