package org.FurnitureFirmApp.DAO.Materials;

import org.FurnitureFirmApp.models.Materials.MaterialView;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Интерфейс который служит для описания настроек обьекта, который ориентирован на получение из базы данных информации
 * о представлениях материалов.
 * @author Red Elephant
 * @version 1.0
 * Наследует : PagingAndSortingRepository&lt;{@link MaterialView}, Integer&gt;.
 */
public interface MaterialViewRepository extends PagingAndSortingRepository<MaterialView, Integer>{

}
