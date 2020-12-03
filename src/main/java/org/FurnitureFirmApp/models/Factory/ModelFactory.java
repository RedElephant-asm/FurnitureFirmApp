package org.FurnitureFirmApp.models.Factory;

/**
 * Интерфейс, который служит для описания и настройки классов-фабрик для моделей.
 * @author Red Elephant
 * @version 1.0
 * @param <Model>
 *     Класс, представляющий модель.
 */
public interface ModelFactory<Model> {
    Model newEntity();
}
