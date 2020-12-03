package org.FurnitureFirmApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main class. Application will start here.
 * @author Red Elephant
 * @version 1.0
 */

@SpringBootApplication
public class FurnitureFirmSpringBootApplication {

    /**
     * @param args
     * Принимает параметры командной строки и передает их статшческому методу run класса Spring application
     */
    public static void main(String[] args) {
        SpringApplication.run(FurnitureFirmSpringBootApplication.class, args);
    }
}
