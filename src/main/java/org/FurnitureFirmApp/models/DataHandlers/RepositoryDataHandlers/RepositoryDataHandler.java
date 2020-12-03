package org.FurnitureFirmApp.models.DataHandlers.RepositoryDataHandlers;

import org.FurnitureFirmApp.models.DataHandlers.PaginationHandler;
import org.FurnitureFirmApp.models.Factory.ModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.ui.Model;

import java.util.Optional;

/**
 * Абстрактный класс, который описывает обработчик репозитория базы данных для пары сущность-представление в
 * стандартном(обобщенном) виде.
 * @author Red Elephant
 * @version 1.0
 * @param <EntityClass>
 *     Класс, представляющий сущность базы данных(некий кортеж из самостоятельной таблицы).
 * @param <ViewClass>
 *     Класс, представляющий представление базы даннх(некий кортеж, полученный из представления, которое
 *     в свою очередь основывается на запросе к самостоятельной таблице).
 * @param <EntityRepo>
 *     Репозиторий, который служит для доступа к сущностям базы данных.
 * @param <ViewRepo>
 *     Репозиторий, который служит для доступа к представлениям базы данных.
 */
public abstract class RepositoryDataHandler<EntityClass, ViewClass,
        EntityRepo extends CrudRepository<EntityClass, Integer>,
        ViewRepo extends PagingAndSortingRepository<ViewClass, Integer>> {

    /**
     * Содержит экземпляр класса, который реализует интерфейс EntityRepository с параметрами EntityClass и Integer и
     * применяется для получения данных о сущностях из базы данных.
     */
    @Autowired
    private EntityRepo repository;

    /**
     * Содержит экземпляр класса, который реализует интерфейс PagingAndSortingRepository с параметрами ViewClass и
     * Integer и применяется для получения данных о представлениях из базы данных.
     */
    @Autowired
    private ViewRepo viewRepository;

    /**
     * Содержит экземпляр класса, который реализует интерфейс {@link ModelFactory} с параметром EntityClass.
     */
    private ModelFactory<EntityClass> entityFactory;

    /**
     * Содержит экземпляр класса, который реализует наследует астрактный класс {@link PaginationHandler} с параметрами
     * ViewClass и ViewRepo и применяется для получения и обработке данных о пагинации.
     */
    private PaginationHandler<ViewClass, ViewRepo> paginationHandler;

    /**
     * Новый экземпляр класса RepositoryDataHandler.
     */
    public RepositoryDataHandler(){}

    /**
     * Метод служит для получения применяемого объекта класса ViewRepo.
     * @return
     * Объект класса ViewRepo.
     */
    public ViewRepo getViewRepository(){return viewRepository;}

    /**
     * Устанавливает объект класса {@link PaginationHandler} для поля paginationHandler.
     * @param paginationHandler
     * Обьект класса PaginationHandler.
     */
    public void setPaginationHandler(PaginationHandler<ViewClass, ViewRepo> paginationHandler) {
        this.paginationHandler = paginationHandler;
    }

    /**
     * Устанавливает объект класса, наследующего интерфейс {@link ModelFactory}, для поля entityFactory.
     * @param entityFactory
     * Объект класса, наследующего интерфейс {@link ModelFactory}.
     */
    public void setEntityFactory(ModelFactory<EntityClass> entityFactory){
        this.entityFactory = entityFactory;
    }

    /**
     * Метод служит для получения представления из базы данных с помощью id.
     * @param id
     * Параметр содержит id представления, которое требуется получить.
     * @return
     * Новый обьект класса Optional с параметром ViewClass, наличие/отсутствие искомого представления в котором зависит
     * от наличия/присутствия такового в базе данных.
     */
    public Optional<ViewClass> getViewById(Integer id){
        return viewRepository.findById(id);
    }

    /**
     * Метод служит для получения сущности из базы данных с помощью id.
     * @param id
     * Параметр содержит id сущности, которую требуется получить.
     * @return
     * Новый обьект класса Optional с параметром ViewClass, наличие/отсутствие искомой сущности в котором зависит
     * от наличия/присутствия таковой в базе данных.
     */
    public Optional<EntityClass> getEntityById(Integer id){
        return repository.findById(id);
    }

    /**
     * Метод служит для сохранения сущности в базу данных.
     * @param entity
     * Параметр содержит сущность, которую требуется сохранить в базу данных.
     */
    public void saveEntityToRepository(EntityClass entity){
        repository.save(entity);
    }

    /**
     * Метод служит для добавления в объект-модель данных, которые призваны уведомить пользователя, что
     * сущностей/моделей, имеющих тот или иной заданный в запросе признак, в базе данных не существует.
     * @param model
     * Параметр содержит обьект-модель, который будет передан в представление.
     */
    public void addNotFoundPageDataToModel(Model model){
        model.addAttribute("objectName", "Object");
    }

    /**
     * Метод служит для удаления сущности из базы данных с помощью id.
     * @param id
     * Параметр содержит id сущности, которую требуется удалить.
     */
    public void deleteEntityById(Integer id){
        repository.deleteById(id);
    }

    /**
     * Метод служит для добавления страницы представлений в объект-модель с помощью id.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param pageNumber
     * Параметр содержит id страницы, которую требуется добавить в объект-представление.
     */
    public void addPageOfViewsToModel(Model model, Integer pageNumber){
        model.addAttribute("viewList", viewRepository.findAll(paginationHandler.getPageRequestByNumber(pageNumber)));
    }

    /**
     * Метод служит для добавления в объект-модель представления с помощью id.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param view
     * Представление, которое требуется передать в объект-модель.
     */
    public void addViewToModel(Model model, ViewClass view){
        model.addAttribute("view", view);
    }

    /**
     * Метод служит для добавления в объект-модель пустой сущности, полученной при помощи объекта-фабрики.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     */
    public void addEntityFromFactoryToModel(Model model){
        model.addAttribute("entity", entityFactory.newEntity());
    }
}
