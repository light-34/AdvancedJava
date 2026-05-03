package org.adv.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class BeanFieldGet {
    public static void main(String[] args) {
        Bean bean = new Bean();
        bean.setName("John");
        bean.setAge(25);
        bean.setAddress("123 Main St");
        bean.setCity("New York");

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> map = objectMapper.convertValue(bean, Map.class);
        System.out.println(map);
    }
}

class Bean {
    private String name;
    private int age;
    private String address;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
