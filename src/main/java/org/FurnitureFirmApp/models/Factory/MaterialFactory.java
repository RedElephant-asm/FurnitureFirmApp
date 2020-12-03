package org.FurnitureFirmApp.models.Factory;

import org.FurnitureFirmApp.models.Materials.Material;

/**
 * Класс, который являтся фабрикой для модели {@link Material}.
 * @author Red Elephant
 * @version 1.0
 * Имплементирует : {@link ModelFactory}&lt;{@link Material}&gt;.
 */
public class MaterialFactory implements ModelFactory<Material> {

    /**
     * Метод служит для генерации пустой модели, которая является объектом класса {@link Material}.
     * @return
     * Новый объект класса {@link Material}.
     */
    @Override
    public Material newEntity() {
        return new Material();
    }
}
