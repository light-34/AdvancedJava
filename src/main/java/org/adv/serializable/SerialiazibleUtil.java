package org.adv.serializable;

import java.io.*;

public class SerialiazibleUtil {
    public void serializeObject (Person object, File file) {
        try (
                FileOutputStream fout = new FileOutputStream(file, true);
                ObjectOutputStream outStream = new ObjectOutputStream(fout)
        ){
            outStream.writeObject(object);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String deserializeObject(File file) {
        try (
                FileInputStream finput = new FileInputStream(file);
                ObjectInputStream inputStream = new ObjectInputStream(finput)
        ){
            Person desObject = (Person) inputStream.readObject();

            return desObject.getFname() + " " + desObject.getLname() + " " + desObject.getAge();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
