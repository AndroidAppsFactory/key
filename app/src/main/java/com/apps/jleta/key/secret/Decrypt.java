package com.apps.jleta.key.secret;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * Created by jleta on 23/07/16.
 */
public class Decrypt {
    public String decrypt(String seed, String encrypted){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(seed);
        return encryptor.decrypt(encrypted);
    }
}
