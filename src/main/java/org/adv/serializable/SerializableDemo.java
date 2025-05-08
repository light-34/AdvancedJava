package org.adv.serializable;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Cezmi", "Aktepe", 35);


        SerialiazibleUtil util = new SerialiazibleUtil();
        util.serializeObject(p1, new File("person.ser"));
        System.out.println(util.deserializeObject(new File("person.ser")));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"))){
            User user = new User("John Doe", "mySecretPassword");
            out.writeObject(user);
            System.out.println("User object serialized successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"))){
            User deserializedOne = (User) in.readObject();
            System.out.println("User object deserialized successfully");
            deserializedOne.display();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("workers.ser"))){
            out.writeObject(new Workers("John Doe", 45, "123-123-456"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("workers.ser"))){
            Workers desObj = (Workers )input.readObject();
            desObj.display();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
