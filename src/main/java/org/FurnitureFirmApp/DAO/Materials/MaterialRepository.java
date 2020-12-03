package org.FurnitureFirmApp.DAO.Materials;

import org.FurnitureFirmApp.models.Materials.Material;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс который служит для описания настроек обьекта, который ориентирован на получение из базы данных информации
 * о материалах.
 * @author Red Elephant
 * @version 1.0
 * Наследует : CrudRepository&lt;{@link Material}, Integer&gt;.
 */
public interface MaterialRepository extends CrudRepository<Material, Integer> {

}
