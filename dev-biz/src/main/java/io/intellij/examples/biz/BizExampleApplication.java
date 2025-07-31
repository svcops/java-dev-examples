package io.intellij.examples.biz;

import io.intellij.examples.commons.ExampleBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * BizExampleApplication
 *
 * @author tech@intellij.io
 */
@SpringBootApplication
public class BizExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizExampleApplication.class, args);
    }

    @RequestMapping("/")
    @RestController
    public static class ExampleController {

        @GetMapping("/")
        public String hello() {
            return "Hello from BizExampleApplication!";
        }

        @GetMapping("/exception")
        public void exception() {
            throw new RuntimeException("This is an example exception from ExampleService");
        }

        @GetMapping("/exampleBean")
        public ExampleBean exampleBean() {
            return ExampleBean.of().id(1L).name("example").ts(new Date()).build();
        }

    }

}
