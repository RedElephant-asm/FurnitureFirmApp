package org.FurnitureFirmApp.models.Factory;

import org.FurnitureFirmApp.models.Furnitures.Furniture;

/**
 * Класс, который являтся фабрикой для модели {@link Furniture}.
 * @author Red Elephant
 * @version 1.0
 * Имплементирует : {@link ModelFactory}&lt;{@link Furniture}&gt;.
 */
public class FurnitureFactory implements ModelFactory<Furniture> {

    /**
     * Метод служит для генерации пустой модели, которая является объектом класса {@link Furniture}.
     * @return
     * Новый объект класса {@link Furniture}.
     */
    @Override
    public Furniture newEntity() {
        return new Furniture();
    }
}
