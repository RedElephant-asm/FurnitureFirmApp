package org.FurnitureFirmApp.appConfig;

import org.FurnitureFirmApp.DAO.Furnitures.FurnitureViewRepository;
import org.FurnitureFirmApp.DAO.Materials.MaterialViewRepository;
import org.FurnitureFirmApp.DAO.Users.UserViewRepository;
import org.FurnitureFirmApp.models.DataHandlers.PaginationHandler;
import org.FurnitureFirmApp.models.DataHandlers.RepositoryDataHandlers.FurnitureRepositoryDataHandler;
import org.FurnitureFirmApp.models.DataHandlers.RepositoryDataHandlers.MaterialRepositoryDataHandler;
import org.FurnitureFirmApp.models.DataHandlers.RepositoryDataHandlers.UserRepositoryDataHandler;
import org.FurnitureFirmApp.models.Factory.FurnitureFactory;
import org.FurnitureFirmApp.models.Factory.MaterialFactory;
import org.FurnitureFirmApp.models.Factory.UserFactory;
import org.FurnitureFirmApp.models.Furnitures.FurnitureView;
import org.FurnitureFirmApp.models.Materials.MaterialView;
import org.FurnitureFirmApp.models.Users.UserView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Главный класс настройки приложения. Он отвечает за реализацию и понятное представление зависимостей приложения.
 * @author Red Elephant
 * @version 1.0
 */

@Configuration
@ComponentScan("org.FurnitureFirmApp")
public class SpringBootMVCAppConfig implements WebMvcConfigurer {


    /**
     * Метод служит для добавление в проект стандартных контроллеров, в данном случае - для контроллера который
     * управляет авторизацией пользователей.
     * @param registry
     * Параметр содержит обьект, который имеет методы для добавления и настройки стандартных контроллеров.
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/Login").setViewName("application/login");
    }

    /**
     * Метод служит для добавления обработчиков ресурсов, которые обслуживают статические ресурсы.
     * @param registry
     * Параметр содержит объект, который имеет методы для добавления и настройки обработчиков ресурсов.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/JS/**").addResourceLocations("classpath:/JS/");
        registry.addResourceHandler("/CSS/**").addResourceLocations("classpath:/CSS/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
        registry.addResourceHandler("/docfiles/**").addResourceLocations("classpath:/views/documentation/");
    }

    /**
     * Bean-компонент, который содержит методы для обработки пагинации и используется классом-сервисом,
     * который предоставляет данные о пользователях.
     * @return
     * Новый параметризованный объект {@link PaginationHandler}&lt;{@link UserView}, {@link UserViewRepository}&gt;.
     */
    @Bean
    public PaginationHandler<UserView, UserViewRepository> userPaginationHandlerBean(){
        PaginationHandler<UserView, UserViewRepository> userPaginationHandler = new PaginationHandler<>(){

        };
        return userPaginationHandler;
    }

    /**
     * Bean-компонент, который содержит методы для обработки пагинации и используется классом-сервисом,
     * который предоставляет данные о материалах.
     * @return
     * Новый параметризованный объект {@link PaginationHandler}&lt;{@link MaterialView}, {@link MaterialViewRepository}&gt;.
     */
    @Bean
    public PaginationHandler<MaterialView, MaterialViewRepository> materialPaginationHandlerBean(){
        PaginationHandler<MaterialView, MaterialViewRepository> materialPaginationHandler = new PaginationHandler<>(){

        };
        return materialPaginationHandler;
    }

    /**
     * Bean-компонент, который содержит методы для обработки пагинации и используется классом-сервисом,
     * который предоставляет данные о пользователях.
     * @return
     * Новый параметризованный объект {@link PaginationHandler}&lt;{@link FurnitureView}, {@link UserViewRepository}&gt;.
     */
    @Bean
    public PaginationHandler<FurnitureView, FurnitureViewRepository> furniturePaginationHandlerBean(){
        PaginationHandler<FurnitureView, FurnitureViewRepository> furniturePaginationHandler = new PaginationHandler<>(){

        };
        return furniturePaginationHandler;
    }

    /**
     * Bean-компонент, который является классом-фабрикой для объектов-сущностей {@link org.FurnitureFirmApp.models.Users.User}.
     * @return
     * Новый объект класса {@link UserFactory}.
     */
    @Bean
    public UserFactory userFactory(){
        return new UserFactory();
    }

    /**
     * Bean-компонент, который является классом-фабрикой для объектов-сущностей {@link org.FurnitureFirmApp.models.Materials.Material}.
     * @return
     * Новый объект класса {@link MaterialFactory}.
     */
    @Bean
    public MaterialFactory materialFactory(){
        return new MaterialFactory();
    }

    /**
     * Bean-компонент, который является классом-фабрикой для объектов-сущностей {@link org.FurnitureFirmApp.models.Furnitures.Furniture}.
     * @return
     * Новый объект класса {@link FurnitureFactory}.
     */
    @Bean
    public FurnitureFactory furnitureFactory(){
        return new FurnitureFactory();
    }

    /**
     * Bean-компонент, который предоставляет данные о пользователях из базы данных и используется классом-сервисом,
     * который предоставляет данные о пользователях.
     * @return
     * Новый объект класса {@link UserRepositoryDataHandler}.
     */
    @Bean
    public UserRepositoryDataHandler userRepositoryDataHandlerBean(){
        UserRepositoryDataHandler repositoryDataHandler = new UserRepositoryDataHandler();
        repositoryDataHandler.setPaginationHandler(userPaginationHandlerBean());
        repositoryDataHandler.setEntityFactory(userFactory());
        return repositoryDataHandler;
    }

    /**
     * Bean-компонент, который предоставляет данные о материалах из базы данных и используется классом-сервисом,
     * который предоставляет данные о пользователях.
     * @return
     * Новый объект класса {@link MaterialRepositoryDataHandler}.
     */
    @Bean
    public MaterialRepositoryDataHandler materialRepositoryDataHandlerBean(){
        MaterialRepositoryDataHandler repositoryDataHandler = new MaterialRepositoryDataHandler();
        repositoryDataHandler.setPaginationHandler(materialPaginationHandlerBean());
        repositoryDataHandler.setEntityFactory(materialFactory());
        return repositoryDataHandler;
    }

    /**
     * Bean-компонент, который предоставляет данные о фурнитуре из базы данных и используется классом-сервисом,
     * который предоставляет данные о пользователях.
     * @return
     * Новый объект класса {@link FurnitureRepositoryDataHandler}.
     */
    @Bean
    public FurnitureRepositoryDataHandler furnitureRepositoryDataHandlerBean(){
        FurnitureRepositoryDataHandler repositoryDataHandler = new FurnitureRepositoryDataHandler();
        repositoryDataHandler.setPaginationHandler(furniturePaginationHandlerBean());
        repositoryDataHandler.setEntityFactory(furnitureFactory());
        return repositoryDataHandler;
    }
}
