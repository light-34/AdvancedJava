package org.adv.fasterxml;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.adv.dto.Employee;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.*;

public class ObjectMapperMethods {
    public ObjectMapperMethods() {
    }

    /**
     *
     * @param str must be entered as ["hello", "ola", ....]
     * @throws JacksonException
     */
    public List readJsonString(String str) throws Exception {
         return new ObjectMapper().readValue(str, List.class);
    }

    public void writeJsonString(Object obj) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("objmapper.json"), obj);
    }

    /**
     * Reads a json file and assign the values to TO object
     * @param path
     * @return
     * @throws IOException
     */
    public  List<Employee> readJsonObject(Path path) throws IOException {
        List<Employee> empList = new ArrayList<>();
        List emp = new ObjectMapper().readValue(path.toFile(), List.class);

        emp.forEach(e -> {
            HashMap map = (LinkedHashMap) e;
            empList.add(new Employee(String.valueOf(map.get("name")), String.valueOf(map.get("lname")), (Integer)map.get("age"), (Integer)map.get("salary")));
        });

        return empList;
    }

    /**
     * Generic list creator
     * @param path
     * @param tClass
     * @return
     * @param <T>
     * @throws IOException
     */
    public <T> List<T> readJsonObjectGeneric(Path path, Class<T> tClass) throws IOException {
        List<T> empList = new ArrayList<>();
        List emp = new ObjectMapper().readValue(path.toFile(), List.class);

        Field[] fields = tClass.getDeclaredFields();

        for(Object link : emp) {
            HashMap map = (LinkedHashMap) link;

            Arrays.stream(fields).forEach(field -> {
                field.setAccessible(true);
                try {
                    Object value = field.get(tClass);
                    if (field.getType() == Integer.class) {

                    }
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            });

            System.out.println(link);
        }

//        emp.forEach(e -> {
//
//            empList.add(new Employee(String.valueOf(map.get("name")), String.valueOf(map.get("lname")), (Integer)map.get("age"), (Integer)map.get("salary")));
//        });

        return empList;
    }
}
