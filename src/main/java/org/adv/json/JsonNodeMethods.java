package org.adv.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonNodeMethods {
    public Map<String, List<String>> getJsonMapData(String jsonData) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<String>> respPeopleMap = new HashMap<>();
        try {
            JsonNode rootNode = mapper.readTree(jsonData);

            if (!rootNode.isArray()) {
                throw new IOException("Invalid JSON format");
            }

            for (JsonNode jsonNode : rootNode) {
                String empKey = null;
                String userId = null;

                for (Map.Entry<String, JsonNode> fields: jsonNode.properties()) {
                    String fieldName = fields.getKey();
                    String fieldValue = fields.getValue().asText();

                    if (fieldName.startsWith("EMP_")) {
                        empKey = fieldName;
                    } else if ("USER_ID".equals(fieldName)) {
                        userId = fieldValue;
                    }
                }

                if (StringUtils.isNotBlank(empKey) && StringUtils.isNotBlank(userId)) {
                    respPeopleMap.computeIfAbsent(empKey, k -> new ArrayList<>()).add(userId);
                }

            }

        } catch (IOException e) {
            throw new IOException(e);
        }

        return respPeopleMap;
    }

    public Map<String, String> getJsonObjectMapData(String jsonData) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> respPeopleMap;
        try {
            respPeopleMap = mapper.readValue(jsonData, new TypeReference<>(){});
        } catch (IOException e) {
            throw new IOException(e);
        }

        return respPeopleMap;
    }
}
