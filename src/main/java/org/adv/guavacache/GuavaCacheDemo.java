package org.adv.guavacache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.adv.dto.Employee;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class GuavaCacheDemo {
    public static void main(String[] args) throws ExecutionException {

        LoadingCache<String, Employee> cache = CacheBuilder
                .newBuilder()
                .expireAfterAccess(Duration.of(3000, ChronoUnit.SECONDS))
                .build(new CacheLoader<String, Employee>() {
                    @Override
                    public Employee load(String key) throws Exception {
                        return getEmployee(key);
                    }
                });

        System.out.println(cache.get("two").getName());

    }

    static Employee getEmployee(String key) {

        Employee e1 = new Employee("Cezmi", "Aktepe", 40, 500);
        Employee e2 =new Employee("Ferid", "Fer", 35, 300);

        Map<String, Employee> map = new HashMap<>();
        map.put("one", e1);
        map.put("two", e2);


        return map.get(key);
    }

}
