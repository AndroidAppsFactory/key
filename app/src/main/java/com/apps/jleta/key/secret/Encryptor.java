package com.apps.jleta.key.secret;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * Created by jleta on 23/07/16.
 */
public class Encryptor {
    public String encrpt(String seed, String input){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(seed);
        return encryptor.encrypt(input);
    }
}
