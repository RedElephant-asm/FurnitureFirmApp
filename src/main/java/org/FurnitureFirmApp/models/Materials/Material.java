package org.FurnitureFirmApp.models.Materials;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Класс - модель, который является сущностью базы данных.
 * @author Red Elephant
 * @version 1.0
 */
@Entity
@Table(schema = "FurnitureFirm", name = "Materials")
public class Material {

    /**
     * Поле, которое соответствует столбцу "materialId" в таблице "Materials" базы данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "materialId")
    private Integer materialId;

    /**
     * Поле, которое соответствует столбцу "article" в таблице "Materials" базы данных.
     */
    @Column(name = "article")
    private String article;

    /**
     * Поле, которое соответствует столбцу "materialName" в таблице "Materials" базы данных.
     */
    @Column(name = "materialName")
    private String materialName;

    /**
     * Поле, которое соответствует столбцу "measureId" в таблице "Materials" базы данных.
     */
    @Column(name = "measureId")
    private Integer measureId;

    /**
     * Поле, которое соответствует столбцу "length" в таблице "Materials" базы данных.
     */
    @Column(name = "length")
    private Float length;

    /**
     * Поле, которое соответствует столбцу "count" в таблице "Materials" базы данных.
     */
    @Column(name = "count")
    private Integer count;

    /**
     * Поле, которое соответствует столбцу "price" в таблице "Materials" базы данных.
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * Поле, которое соответствует столбцу "materialTypeId" в таблице "Materials" базы данных.
     */
    @Column(name = "materialTypeId")
    private Integer materialTypeId;

    /**
     * Поле, которое соответствует столбцу "gostId" в таблице "Materials" базы данных.
     */
    @Column(name = "gostId")
    private Integer gostId;

    /**
     * Поле, которое соответствует столбцу "specializationId" в таблице "Materials" базы данных.
     */
    @Column(name = "specializationId")
    private Integer specializationId;

    /**
     * Новый объект класса {@link Material}
     * @param article
     * Значение поля {@link Material#article}
     * @param materialName
     * Значение поля {@link Material#materialName}
     * @param measureId
     * Значение поля {@link Material#measureId}
     * @param length
     * Значение поля {@link Material#length}
     * @param count
     * Значение поля {@link Material#count}
     * @param price
     * Значение поля {@link Material#price}
     * @param materialTypeId
     * Значение поля {@link Material#materialTypeId}
     * @param gostId
     * Значение поля {@link Material#gostId}
     */
    public Material(String article, String materialName,
                    Integer measureId, Float length, Integer count, BigDecimal price,
                    Integer materialTypeId, Integer gostId) {
        this.article = article;
        this.materialName = materialName;
        this.measureId = measureId;
        this.length = length;
        this.count = count;
        this.price = price;
        this.materialTypeId = materialTypeId;
        this.gostId = gostId;
    }

    /**
     * Новый объект класса {@link Material}
     */
    public Material(){}

    /**
     * Метод предоставляет значение поля {@link Material#materialId}
     * @return
     * Значение поля {@link Material#materialId}
     */
    public Integer getMaterialId() {
        return materialId;
    }

    /**
     * Метод устанавливает значение поля {@link Material#materialId}
     * @param materialId
     * Параметр содержит новое значение для поля {@link Material#materialId}
     */
    public void setMaterialId(Integer materialId){
        this.materialId = materialId;
    }

    /**
     * Метод предоставляет значение поля {@link Material#article}
     * @return
     * Значение поля {@link Material#article}
     */
    public String getArticle() {
        return article;
    }

    /**
     * Метод устанавливает значение поля {@link Material#article}
     * @param article
     * Параметр содержит новое значение для поля {@link Material#article}
     */
    public void setArticle(String article) {
        this.article = article;
    }

    /**
     * Метод предоставляет значение поля {@link Material#materialName}
     * @return
     * Значение поля {@link Material#materialName}
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * Метод устанавливает значение поля {@link Material#materialName}
     * @param materialName
     * Параметр содержит новое значение для поля {@link Material#materialName}
     */
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    /**
     * Метод предоставляет значение поля {@link Material#measureId}
     * @return
     * Значение поля {@link Material#measureId}
     */
    public Integer getMeasureId() {
        return measureId;
    }

    /**
     * Метод устанавливает значение поля {@link Material#measureId}
     * @param measureId
     * Параметр содержит новое значение для поля {@link Material#measureId}
     */
    public void setMeasureId(Integer measureId) {
        this.measureId = measureId;
    }

    /**
     * Метод предоставляет значение поля {@link Material#length}
     * @return
     * Значение поля {@link Material#length}
     */
    public Float getLength() {
        return length;
    }

    /**
     * Метод устанавливает значение поля {@link Material#length}
     * @param length
     * Параметр содержит новое значение для поля {@link Material#length}
     */
    public void setLength(Float length) {
        this.length = length;
    }

    /**
     * Метод предоставляет значение поля {@link Material#count}
     * @return
     * Значение поля {@link Material#count}
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Метод устанавливает значение поля {@link Material#count}
     * @param count
     * Параметр содержит новое значение для поля {@link Material#count}
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Метод предоставляет значение поля {@link Material#price}
     * @return
     * Значение поля {@link Material#price}
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Метод устанавливает значение поля {@link Material#price}
     * @param price
     * Параметр содержит новое значение для поля {@link Material#price}
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Метод предоставляет значение поля {@link Material#materialTypeId}
     * @return
     * Значение поля {@link Material#materialTypeId}
     */
    public Integer getMaterialTypeId() {
        return materialTypeId;
    }

    /**
     * Метод устанавливает значение поля {@link Material#materialTypeId}
     * @param materialTypeId
     * Параметр содержит новое значение для поля {@link Material#materialTypeId}
     */
    public void setMaterialTypeId(Integer materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    /**
     * Метод предоставляет значение поля {@link Material#gostId}
     * @return
     * Значение поля {@link Material#gostId}
     */
    public Integer getGostId() {
        return gostId;
    }

    /**
     * Метод устанавливает значение поля {@link Material#gostId}
     * @param gostId
     * Параметр содержит новое значение для поля {@link Material#gostId}
     */
    public void setGostId(Integer gostId) {
        this.gostId = gostId;
    }

    /**
     * Метод предоставляет значение поля {@link Material#specializationId}
     * @return
     * Значение поля {@link Material#specializationId}
     */
    public Integer getSpecializationId() {
        return specializationId;
    }

    /**
     * Метод устанавливает значение поля {@link Material#specializationId}
     * @param specializationId
     * Параметр содержит новое значение для поля {@link Material#specializationId}
     */
    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }
}
