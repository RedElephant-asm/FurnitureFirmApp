package org.FurnitureFirmApp.models.DataHandlers;

import org.FurnitureFirmApp.models.DataHandlers.RepositoryDataHandlers.RepositoryDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.ui.Model;

import java.util.Optional;

/**
 * Абстрактный класс, который описывает обработчик запросов контроллера в стандартном(обобщенном) виде.
 * @author Red Elephant
 * @version 1.0
 * @param <EntityClass>
 *     Класс, представляющий сущность базы данных(некий кортеж из самостоятельной таблицы).
 * @param <ViewClass>
 *     Класс, представляющий представление базы даннх(некий кортеж, полученный из представления, которое
 *     в свою очередь основывается на запросе к самостоятельной таблице).
 * @param <EntityRepo>
 *     Репозиторий, который служит для доступа к сущностям базы данных. Параметр требуется для точного определения бина
 *     для поля {@link ControllerHandler#repositoryDataHandler}.
 * @param <ViewRepo>
 *     Репозиторий, который служит для доступа к представлениям базы данных. Параметр требуется для точного определения бина
 *     для поля {@link ControllerHandler#repositoryDataHandler}.
 * @param <RepoDataHandler>
 */
public abstract class ControllerHandler<
        EntityClass, ViewClass,
        EntityRepo extends CrudRepository<EntityClass, Integer>,
        ViewRepo extends PagingAndSortingRepository<ViewClass, Integer>,
        RepoDataHandler extends RepositoryDataHandler<EntityClass, ViewClass, EntityRepo, ViewRepo>>{

    /**
     * Содержит экземпляр класса, который наследует {@link RepositoryDataHandler} и является обработчикаом репозитория
     * базы данных.
     */
    @Autowired
    protected RepoDataHandler repositoryDataHandler;

    /**
     * Содержит экземплячр класса, который наследует {@link PaginationHandler} и является обработчиком пагинации.
     */
    @Autowired
    protected PaginationHandler<ViewClass, ViewRepo> paginationHandler;

    /**
     * Новый экземпляр класса {@link ControllerHandler}
     */
    public ControllerHandler(){}

    /**
     * Метод служит для добавления данных о сущности в объект-модель с помощью id.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param id
     * Параметр содержит id сущности, данные о котором требуется добавить в объект-представление.
     * @return
     * Boolean-значение, которое является результатом проверки полученного в процессе поиска представления
     * Optional&lt;ViewClass&gt; обьекта на полноту/пустоту.
     */
    public boolean addViewByIdToModelIsSuccessful(Model model, Integer id){
        Optional<ViewClass> view = repositoryDataHandler.getViewById(id);
        if(view.isPresent()){
            repositoryDataHandler.addViewToModel(model, view.get());
        } else {
            repositoryDataHandler.addNotFoundPageDataToModel(model);
        }
        return view.isPresent();
    }

    /**
     * Метод служит для добавления в обьект-модель страницы представлений.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param pageNumber
     * Параметр содержит номер страницы, которую требуется добавить в обьект-модель.
     */
    public void addPageOfViewsToModelByPageNumber(Model model, Integer pageNumber){
        this.repositoryDataHandler.addPageOfViewsToModel(model, paginationHandler.fixPageNumberIfNotCorrect(pageNumber));
        model.addAttribute("currentPageNumber", paginationHandler.fixPageNumberIfNotCorrect(pageNumber));
        model.addAttribute("lastPageNumber", paginationHandler.getLastPageNumber());
    }

    /**
     * Метод служит для удаления сущности.
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     * @param id
     * Параметр содержит id пользовате
     * @return
     * Boolean-значение, которое является результатом проверки полученного в процессе поиска представления
     * Optional&lt;ViewClass&gt; обьекта на полноту/пустоту.
     */
    public boolean deleteEntityByIdIsSuccessful(Model model, Integer id){
        Optional<EntityClass> entityToDelete = repositoryDataHandler.getEntityById(id);
        if(entityToDelete.isPresent()) {
            repositoryDataHandler.deleteEntityById(id);
        } else {
            model.addAttribute("objectName", "Object");
        }
        return entityToDelete.isPresent();
    }

    /**
     * Метод служит для добавления пустой сущности в объект-модель для ее дальнейшего заполнения
     * @param model
     * Параметр содержит обьект, который может сохранять данные в паре ключ-значение и передавать эти данные в представление.
     */
    public void addEmptyEntityToModel(Model model){
        repositoryDataHandler.addEntityFromFactoryToModel(model);
    }

    /**
     * Метод служит для сохранения новой сущности.
     * @param newEntity
     * Параметр содержит новую сущность, которую требуется сохранить.
     */
    public void saveNewEntity(EntityClass newEntity){
        repositoryDataHandler.saveEntityToRepository(newEntity);
    }
}