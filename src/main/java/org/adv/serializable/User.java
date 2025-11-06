package org.adv.serializable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;

    private transient String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void display() {
        System.out.printf("Username: %s, Password: %s", userName, password);
    }

    private void readObject(ObjectInputStream inStream) throws Exception {
        inStream.defaultReadObject();
        password = decrypt((String) inStream.readObject());
    }

    private void writeObject(ObjectOutputStream outStream) throws Exception {
        outStream.defaultWriteObject();
        outStream.writeObject(encrypt(password));
    }

    private String encrypt(String data) {
        return new StringBuilder(data).reverse().toString(); //Simple reverse not a real encryption
    }

    private String decrypt(String encryptedData) {
        return new StringBuilder(encryptedData).reverse().toString();
    }
}
