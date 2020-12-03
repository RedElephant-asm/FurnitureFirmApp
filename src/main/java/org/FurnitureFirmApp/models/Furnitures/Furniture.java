package org.FurnitureFirmApp.models.Furnitures;

import org.FurnitureFirmApp.models.Users.User;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс - модель, который является сущностью базы данных.
 * @author Red Elephant
 * @version 1.0
 */
@Entity
@Table(schema = "FurnitureFirm", name = "Furnitures")
public class Furniture {

    /**
     * Поле, которое соответствует столбцу "furnitureId" в таблице "Furnitures" базы данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "furnitureId")
    private Integer furnitureId;

    /**
     * Поле, которое соответствует столбцу "article" в таблице "Furnitures" базы данных.
     */
    @Column(name = "article")
    private String article;

    /**
     * Поле, которое соответствует столбцу "furnitureName" в таблице "Furnitures" базы данных.
     */
    @Column(name = "furnitureName")
    private String furnitureName;

    /**
     * Поле, которое соответствует столбцу "count" в таблице "Furnitures" базы данных
     */
    @Column(name = "count")
    private Integer count;

    /**
     * Поле, которое соответствует столбцу "measureId" в таблице "Furnitures" базы данных
     */
    @Column(name = "measureId")
    private Integer measureId;

    /**
     * Поле, которое соответствует столбцу "fragmentTypeId" в таблице "Furnitures" базы данных
     */
    @Column(name = "fragmentTypeId")
    private Integer fragmentTypeId;

    /**
     * Поле, которое соответствует столбцу "price" в таблице "Furnitures" базы данных
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * Новый объект класса {@link Furniture}
     * @param article
     * Значение поля {@link Furniture#article}
     * @param furnitureName
     * Значение поля {@link Furniture#furnitureName}
     * @param count
     * Значение поля {@link Furniture#count}
     * @param measureId
     * Значение поля {@link Furniture#measureId}
     * @param fragmentTypeId
     * Значение поля {@link Furniture#fragmentTypeId}
     * @param price
     * Значение поля {@link Furniture#price}
     */
    public Furniture(String article, String furnitureName,
                     Integer count, Integer measureId, Integer fragmentTypeId, BigDecimal price) {
        this.article = article;
        this.furnitureName = furnitureName;
        this.count = count;
        this.measureId = measureId;
        this.fragmentTypeId = fragmentTypeId;
        this.price = price;
    }

    /**
     * Новый объект класса {@link Furniture}
     */
    public Furniture(){}

    /**
     * Метод предоставляет значение поля {@link Furniture#furnitureId}
     * @return
     * Значение поля {@link Furniture#furnitureId}
     */
    public Integer getFurnitureId() {
        return furnitureId;
    }

    /**
     * Метод устанавливает значение поля {@link Furniture#furnitureId}
     * @param furnitureId
     * Параметр содержит новое значение для поля {@link Furniture#furnitureId}
     */
    public void setFurnitureId(Integer furnitureId) {
        this.furnitureId = furnitureId;
    }

    /**
     * Метод предоставляет значение поля {@link Furniture#article}
     * @return
     * Значение поля {@link Furniture#article}
     */
    public String getArticle() {
        return article;
    }

    /**
     * Метод устанавливает значение поля {@link Furniture#article}
     * @param article
     * Параметр содержит новое значение для поля {@link Furniture#article}
     */
    public void setArticle(String article) {
        this.article = article;
    }

    /**
     * Метод предоставляет значение поля {@link Furniture#furnitureName}
     * @return
     * Значение поля {@link Furniture#furnitureName}
     */
    public String getFurnitureName() {
        return furnitureName;
    }

    /**
     * Метод устанавливает значение поля {@link Furniture#furnitureName}
     * @param furnitureName
     * Параметр содержит новое значение для поля {@link Furniture#furnitureName}
     */
    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    /**
     * Метод предоставляет значение поля {@link Furniture#count}
     * @return
     * Значение поля {@link Furniture#count}
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Метод устанавливает значение поля {@link Furniture#count}
     * @param count
     * Параметр содержит новое значение для поля {@link Furniture#count}
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Метод предоставляет значение поля {@link Furniture#measureId}
     * @return
     * Значение поля {@link Furniture#measureId}
     */
    public Integer getMeasureId() {
        return measureId;
    }

    /**
     * Метод устанавливает значение поля {@link Furniture#measureId}
     * @param measureId
     * Параметр содержит новое значение для поля {@link Furniture#measureId}
     */
    public void setMeasureId(Integer measureId) {
        this.measureId = measureId;
    }

    /**
     * Метод предоставляет значение поля {@link Furniture#fragmentTypeId}
     * @return
     * Значение поля {@link Furniture#fragmentTypeId}
     */
    public Integer getFragmentTypeId() {
        return fragmentTypeId;
    }

    /**
     * Метод устанавливает значение поля {@link Furniture#fragmentTypeId}
     * @param fragmentTypeId
     * Параметр содержит новое значение для поля {@link Furniture#fragmentTypeId}
     */
    public void setFragmentTypeId(Integer fragmentTypeId) {
        this.fragmentTypeId = fragmentTypeId;
    }

    /**
     * Метод предоставляет значение поля {@link Furniture#price}
     * @return
     * Значение поля {@link Furniture#price}
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Метод устанавливает значение поля {@link Furniture#price}
     * @param price
     * Параметр содержит новое значение для поля {@link Furniture#price}
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
