package me.kgkirilov.java.webdev.controller;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean() {
        SomeBean someBean = new SomeBean(
                "value1",
                "value2",
                "value3",
                "value4");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1", "field2");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);

        mapping.setFilters(filters);
        return mapping;
    }

//    @GetMapping("/filtering-two")
//    public SomeBean retrieveSomeBeanTwo() {
//        SomeBean someBean = new SomeBean(
//                "value1",
//                "value2",
//                "value3",
//                "value4");
//        return someBean;
//    }

//    @JsonIgnoreProperties(value={"field1"})
    @JsonFilter("SomeBeanFilter")
    private class SomeBean {
        private String field1;
        private String field2;

//        @JsonIgnore
        private String field3;

        private String field4;

        public SomeBean(String field1, String field2, String field3, String fiel4) {
            this.field1 = field1;
            this.field2 = field2;
            this.field3 = field3;
            this.field4 = field4;
        }

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

        public String getField4() {
            return field3;
        }

        public void setField4(String field3) {
            this.field3 = field3;
        }
    }

}
