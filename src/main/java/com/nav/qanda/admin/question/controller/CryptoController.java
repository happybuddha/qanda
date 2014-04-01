package com.nav.qanda.admin.question.controller;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

import org.springframework.stereotype.Component;

@Component
public class CryptoController
{
	  private static String algorithm = "DESede";
      private static Key key = null;
      private static Cipher cipher = null;

      static {
          try {
			key = KeyGenerator.getInstance(algorithm).generateKey();
			cipher = Cipher.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
     }
      
    byte[] encrypt(String input) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] inputBytes = input.getBytes();
            return cipher.doFinal(inputBytes);
        }

    public String decrypt(byte[] encryptionBytes) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] recoveredBytes = 
              cipher.doFinal(encryptionBytes);
            String recovered = 
              new String(recoveredBytes);
            return recovered;
          }

}