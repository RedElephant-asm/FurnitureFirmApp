package org.FurnitureFirmApp.models.Furnitures;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс - модель, который является представлением базы данных.
 * @author Red Elephant
 * @version 1.0
 */
@Entity
@Table(name = "FurnituresV", schema = "FurnitureFirm")
public class FurnitureView {

    /**
     * Поле, которое соответствует столбцу "furnitureId" в таблице "FurnituresV" базы данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "furnitureId")
    private Integer furnitureId;

    /**
     * Поле, которое соответствует столбцу "article" в таблице "FurnituresV" базы данных.
     */
    @Column(name = "article")
    private String article;

    /**
     * Поле, которое соответствует столбцу "furnitureName" в таблице "FurnituresV" базы данных.
     */
    @Column(name = "furnitureName")
    private String furnitureName;

    /**
     * Поле, которое соответствует столбцу "count" в таблице "FurnituresV" базы данных.
     */
    @Column(name = "count")
    private Integer count;

    /**
     * Поле, которое соответствует столбцу "measureName" в таблице "FurnituresV" базы данных.
     */
    @Column(name = "measureName")
    private String measureName;

    /**
     * Поле, которое соответствует столбцу "fragmentTypeName" в таблице "FurnituresV" базы данных.
     */
    @Column(name = "fragmentTypeName")
    private String fragmentTypeName;

    /**
     * Поле, которое соответствует столбцу "price" в таблице "FurnituresV" базы данных.
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * Новый объект класса {@link FurnitureView}
     */
    public FurnitureView(){}

    /**
     * Метод предоставляет значение поля {@link FurnitureView#furnitureId}
     * @return
     * Значение поля {@link FurnitureView#furnitureId}
     */
    public Integer getFurnitureId() {
        return furnitureId;
    }

    /**
     * Метод предоставляет значение поля {@link FurnitureView#article}
     * @return
     * Значение поля {@link FurnitureView#article}
     */
    public String getArticle() {
        return article;
    }

    /**
     * Метод предоставляет значение поля {@link FurnitureView#furnitureName}
     * @return
     * Значение поля {@link FurnitureView#furnitureName}
     */
    public String getFurnitureName() {
        return furnitureName;
    }

    /**
     * Метод предоставляет значение поля {@link FurnitureView#count}
     * @return
     * Значение поля {@link FurnitureView#count}
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Метод предоставляет значение поля {@link FurnitureView#measureName}
     * @return
     * Значение поля {@link FurnitureView#measureName}
     */
    public String getMeasureName() {
        return measureName;
    }

    /**
     * Метод предоставляет значение поля {@link FurnitureView#fragmentTypeName}
     * @return
     * Значение поля {@link FurnitureView#fragmentTypeName}
     */
    public String getFragmentTypeName() {
        return fragmentTypeName;
    }

    /**
     * Метод предоставляет значение поля {@link FurnitureView#price}
     * @return
     * Значение поля {@link FurnitureView#price}
     */
    public BigDecimal getPrice() {
        return price;
    }
}
