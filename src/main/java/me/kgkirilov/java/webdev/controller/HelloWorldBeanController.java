package me.kgkirilov.java.webdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldBeanController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world-bean")
    private HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World! This is a bean");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    private HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World! %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
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


