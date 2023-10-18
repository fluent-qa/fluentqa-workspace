package io.fluent.datafactory.core;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class User {

    private String name;

    private int age;

    private Date birthday;

    private List<String> stringList;

    //S/F 的枚举

    private Map<String, String> map;
    
    //Getter & Setter
}