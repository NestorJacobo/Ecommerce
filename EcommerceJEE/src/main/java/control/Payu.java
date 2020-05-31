/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author REDEN MUSIC
 */
public class Payu {
    public static String MD5(String firma){
        try {
            MessageDigest algo=MessageDigest.getInstance("MD5");
            algo.reset();
            algo.update(firma.getBytes());
            byte[] d=algo.digest();
            StringBuffer hash=new StringBuffer();
            String hex;
            for (int i = 0; i < d.length; i++) {
                hex=Integer.toHexString(0xFF & d[i]);
                if(hex.length()==1){
                    hex="0"+hex;
                }
                hash.append(hex);
            }
            return hash.toString();
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
        
    }
}
