package com.demoblaze.pages;

import com.demoblaze.utulities.EncryptionUtils;

public class TestEncrypt {
    public static void main(String[] args) {


        String username = EncryptionUtils.encrypt("etsB3", System.getenv("secretKey"));
        System.out.println("username = " + username);

        //B6VlEc1zJLZ1kGn+QcIImA==
        String password = EncryptionUtils.encrypt("Test123+", System.getenv("secretKey"));
        System.out.println("password = " + password);

    }
}
