package me.kgkirilov.java.webdev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldBeanController {



    @GetMapping(path = "/hello-world-bean")
    private HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World! This is a bean");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    private HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World! %s", name));
    }

    private class HelloWorldBean
    {
        private String message;

        public HelloWorldBean(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "HelloWorldBean{" +
                    "message='" + message + '\'' +
                    '}';
        }
    }

}


