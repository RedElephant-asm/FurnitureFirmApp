package org.FurnitureFirmApp.models.DataHandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Objects;

/**
 * Абстрактный класс, который описывает обработчик запросов контроллера в стандартном(обобщенном) виде.
 * @author Red Elephant
 * @version 1.0
 * @param <ViewClass>
 *     Класс, представляющий сущность базы данных(некий кортеж из самостоятельной таблицы).
 * @param <ViewRepo>
 *     Класс, представляющий представление базы даннх(некий кортеж, полученный из представления, которое
 *     в свою очередь основывается на запросе к самостоятельной таблице).
 */
public abstract class PaginationHandler<ViewClass, ViewRepo extends PagingAndSortingRepository<ViewClass, Integer>> {

    /**
     * Содержит экземпляр класса, который реализует интерфейс PagingAndSortingRepository с параметрами ViewClass и
     * Integer и применяется для получения данных о представлениях из базы данных.
     */
    @Autowired
    private ViewRepo viewRepo;

    /**
     * Содержит значение максимально возможной длины страницы, получинное из файла конфигурации.
     */
    @Value("${pagination.maxPageLength}")
    private Integer maxPageLength;

    /**
     * Содержит значение номера страницы по умолчанию, которую получит пользователь при переходе по адресу с тем или
     * иным ресурсом, представляющим из себя перечень представлений, оформленный в виде таблицы.
     */
    @Value("${pagination.defaultPageNumber}")
    private Integer defaultPageNumber;

    /**
     * Новый экземпляр класса {@link PaginationHandler}.
     */
    public PaginationHandler(){}

    /**
     * Метод предоставляет значение маскимально возможной длины страницы.
     * @return
     * Значение маскимально возможной длины страницы.
     */
    public Integer getMaxPageLength(){
        return maxPageLength;
    }

    /**
     * Метод предоставляет значение номера страницы по умолчанию.
     * @return
     * Значение номера страницы по умолчанию.
     */
    public Integer getDefaultPageNumber(){
        return defaultPageNumber;
    }

    /**
     * Метод предоставляет значение количества странииц.
     * @return
     * Значение количества страниц.
     */
    public Integer getPageCount() {
        return viewRepo.findAll(PageRequest.of(0, getMaxPageLength())).getTotalPages();
    }

    /**
     * Метод предоставляет номер последней стрницы.
     * @return
     * Значение номера последней страницы
     */
    public Integer getLastPageNumber(){
        return this.getPageCount() - 1;
    }

    /**
     * Метод предоставляет обьект класса PageRequest, полученный с помощью номера страницы.
     * @param pageNumber
     * Параметр содержит номер страницы.
     * @return
     * Новый объект класса PageRequest.
     */
    public  PageRequest getPageRequestByNumber(Integer pageNumber){
        return PageRequest.of(pageNumber, getMaxPageLength());
    }

    /**
     * Метод предназначен для корректировки номера страницы.
     * @param pageNumber
     * Параметр содержит номер страницы.
     * @return
     * Номер страницы в том случае, если он не больше маскимального номера страницы, не меньше 0 или не равен null.
     * В противном случае возвращается исправленное значение.
     */
    public Integer fixPageNumberIfNotCorrect(Integer pageNumber){
        if(Objects.isNull(pageNumber)){
            return this.getDefaultPageNumber();
        } else if(pageNumber < 0){
            return 0;
        } else if(pageNumber > this.getLastPageNumber()){
            return this.getLastPageNumber();
        } else {
            return pageNumber;
        }
    }
}
