package org.FurnitureFirmApp.appConfig;

import org.FurnitureFirmApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Класс, содержащий настройки SpringSecurity
 * @author Red Elephant
 * @version 1.0
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * Содержит экземпляр класса-сервиса, предоставляющего информацию о пользователях.
     */
    @Autowired
    private UserService userService;

    /**
     * Bean-компонент, который содержит переопределенные методы класса BCryptPasswordEncoder.
     * @return
     * Новый обьект анонимного класса, содержащий переопределенные методы класса BCryptPasswordEncoder.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(){

            /**
             * В стандартном виде метод кодирует входящее CharSequence значение в (предположительно) SHA-1 хэш-строку.
             * в данном аиде метод просто возвращает строковое представление обьекта класса CharSequence
             * @param charSequence
             * Читаемая последовательность Char значений, полученная в результате попытки авторизации неким пользователем.
             * @return
             * Строковое представление обьекта класса CharSequence.
             */
            @Override
            public String encode(CharSequence charSequence){
                return charSequence.toString();
            }

            /**
             * В стандартном виде метод сравнивает хэш-значение полученное из базы данных с хэш-значением, полученным
             * при попытке авторизации неким пользователем. В данном виде метод сравнивает строковое представление объекта
             * класса CharSequence(пароль), полученную припопытке авторизации неким пользователем со строкой(паролем),
             * полученным из базы данных.
             * @param charSequence
             * Читаемая последовательность Char значений, полученная в результате попытки авторизации неким пользователем.
             * @param s
             * Строка(пароль) полученная из базы данных.
             * @return
             */
            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return charSequence.toString().equals(s);
            }
        };
    }

    /**
     * Метод служит для конфигурации параметров работы Spring Security.
     * @param http
     * Обьект класса HttpSecurity.
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/CSS/**").permitAll()
                    .antMatchers("/images/**").permitAll()
                    .antMatchers("/Registration", "/views/application/registration").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/Login")
                    .defaultSuccessUrl("/Home", true)
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    /**
     * Метод служит для установки установки аунтефикации на основе UserDetailsService.
     * @param managerBuilder
     * Bean-компонент, который содержит метод для установки обьекта-сервиса, который будет использоваться при аутентификации.
     * @throws Exception
     */
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder.userDetailsService(userService);
    }
}
