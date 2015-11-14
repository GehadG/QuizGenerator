/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgen;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Gehad
 */
public class PasswordHasher {

    public PasswordHasher() {
    }
    public static String hashString(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException
        {
 
    
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));
 
        return convertByteArrayToHexString(hashedBytes);
  
}
private static String convertByteArrayToHexString(byte[] arrayBytes) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < arrayBytes.length; i++) {
        stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                .substring(1));
    }
    return stringBuffer.toString();
}

    
}
