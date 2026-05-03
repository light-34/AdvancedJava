package org.adv.json;

import java.io.IOException;
import java.util.*;

public class JsonNodeDemo {
    public static void main(String[] args) throws IOException {
        JsonNodeMethods jsonNodeMethods = new JsonNodeMethods();
        String json = """
                [{"EMP_ROLE":"1", "USER_ID":"1"}, {"EMP_ROLE":"2", "USER_ID":"2"}
                , {"EMP_ORG1":"3", "USER_ID":"3"}, {"EMP_ORG2":"4", "USER_ID":"4"}
                , {"EMP_ORG3":"5", "USER_ID":"5"}, {"EMP_ORG4":"6", "USER_ID":"6"}
                , {"EMP_ORG4":"7", "USER_ID":"7"}]
                """;

        String jsonObj = """
                {"Task Instruction":"T", "Standard":"S", "Admin":"A"}
                """;
        System.out.println(jsonNodeMethods.getJsonObjectMapData(jsonObj));


        //System.out.println(jsonNodeMethods.getJsonMapData(json));
    }
}
