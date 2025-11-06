package org.adv.yaml;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Map;

public class ReadYamlDemo {

    /**
     * YAML vs. JSON: A Comparison
     *
     * Both YAML (YAML Ain't Markup Language) and JSON (JavaScript Object Notation) are popular data serialization formats
     * used to store and exchange data. While they serve a similar purpose, there are key differences in their syntax and features.
     *
     * Syntax
     *
     * JSON: Uses curly braces {} for objects, square brackets [] for arrays, and colon : to separate keys from values.
     * YAML: Offers a more flexible syntax, using indentation to define structures and allowing for more concise representation.
     *
     * Features
     *
     * YAML:
     * Supports comments
     * Can represent complex data structures like maps, sequences, and scalars.
     * Offers features like anchors and aliases for referencing values within the document.
     * JSON:
     * Primarily used for representing simple data structures like objects and arrays.
     * Does not support comments.
     *
     * Use Cases
     *
     * JSON: Widely used for data interchange between systems, especially in web APIs and JavaScript applications.
     * YAML: Often preferred for configuration files, where human readability and ease of editing are important.
     *
     * @param args
     */
    public static void main(String[] args) {
        //try (FileReader fileReader = new FileReader("test_yaml.yml")){
        try (FileInputStream fileReader = new FileInputStream("test_yaml.yml")){ //example file structure
            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.loadAs(fileReader, Map.class);
            map.values().forEach(System.out::println);

            Map<String, Object> variables = (Map<String, Object>) map.get("variables");
            variables.values().forEach(System.out::println);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
