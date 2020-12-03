package org.FurnitureFirmApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Класс-контроллер, который управляет доступом к домашней странице
 * @author Red Elephant
 * @version 1.0
 */
@Controller
@RequestMapping("/Documentation")
public class DocumentationController {

    @GetMapping("")
    public String getDocumenttationIndexPage(){
        return "documentation/index";
    }
}
