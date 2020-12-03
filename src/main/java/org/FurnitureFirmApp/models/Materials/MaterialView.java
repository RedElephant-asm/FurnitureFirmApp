package org.FurnitureFirmApp.models.Materials;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс - модель, который является представлением базы данных.
 * @author Red Elephant
 * @version 1.0
 */
@Entity
@Table(name = "MaterialsV", schema = "FurnitureFirm")
public class MaterialView {

    /**
     * Поле, которое соответствует столбцу "materialId" в таблице "MaterialsV" базы данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "materialId")
    private Integer materialId;

    /**
     * Поле, которое соответствует столбцу "article" в таблице "MaterialsV" базы данных.
     */
    @Column(name = "article")
    private String article;

    /**
     * Поле, которое соответствует столбцу "materialName" в таблице "MaterialsV" базы данных.
     */
    @Column(name = "materialName")
    private String materialName;

    /**
     * Поле, которое соответствует столбцу "measureName" в таблице "MaterialsV" базы данных.
     */
    @Column(name = "measureName")
    private String measureName;

    /**
     * Поле, которое соответствует столбцу "length" в таблице "MaterialsV" базы данных.
     */
    @Column(name = "length")
    private Float length;

    /**
     * Поле, которое соответствует столбцу "count" в таблице "MaterialsV" базы данных.
     */
    @Column(name = "count")
    private Integer count;

    /**
     * Поле, которое соответствует столбцу "price" в таблице "MaterialsV" базы данных.
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * Поле, которое соответствует столбцу "materialTypeName" в таблице "MaterialsV" базы данных.
     */
    @Column(name = "materialTypeName")
    private String materialTypeName;

    /**
     * Поле, которое соответствует столбцу "gostName" в таблице "MaterialsV" базы данных.
     */
    @Column(name = "gostName")
    private String gostName;

    /**
     * Поле, которое соответствует столбцу "specializationName" в таблице "MaterialsV" базы данных.
     */
    @Column(name = "specializationName")
    private String specializationName;

    /**
     * Новый объект класса {@link MaterialView}
     */
    public MaterialView(){}

    /**
     * Метод предоставляет значение поля {@link MaterialView#materialId}
     * @return
     * Значение поля {@link MaterialView#materialId}
     */
    public Integer getMaterialId() {
        return materialId;
    }

    /**
     * Метод предоставляет значение поля {@link MaterialView#article}
     * @return
     * Значение поля {@link MaterialView#article}
     */
    public String getArticle() {
        return article;
    }

    /**
     * Метод предоставляет значение поля {@link MaterialView#materialName}
     * @return
     * Значение поля {@link MaterialView#materialName}
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * Метод предоставляет значение поля {@link MaterialView#measureName}
     * @return
     * Значение поля {@link MaterialView#measureName}
     */
    public String getMeasureName() {
        return measureName;
    }

    /**
     * Метод предоставляет значение поля {@link MaterialView#length}
     * @return
     * Значение поля {@link MaterialView#length}
     */
    public Float getLength() {
        return length;
    }

    /**
     * Метод предоставляет значение поля {@link MaterialView#count}
     * @return
     * Значение поля {@link MaterialView#count}
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Метод предоставляет значение поля {@link MaterialView#price}
     * @return
     * Значение поля {@link MaterialView#price}
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Метод предоставляет значение поля {@link MaterialView#materialTypeName}
     * @return
     * Значение поля {@link MaterialView#materialTypeName}
     */
    public String getMaterialTypeName() {
        return materialTypeName;
    }

    /**
     * Метод предоставляет значение поля {@link MaterialView#gostName}
     * @return
     * Значение поля {@link MaterialView#gostName}
     */
    public String getGostName() {
        return gostName;
    }

    /**
     * Метод предоставляет значение поля {@link MaterialView#specializationName}
     * @return
     * Значение поля {@link MaterialView#specializationName}
     */
    public String getSpecializationName() {
        return specializationName;
    }
}
