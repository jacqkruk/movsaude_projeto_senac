
package com.senacpi.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe responsável por fornecer funcionalidades de criptografia.
 * 
 * @author Jake mk
 */
public class Criptografia {
    
    /**
     * Gera o hash MD5 de um texto fornecido.
     * 
     * @param texto O texto que será transformado em hash MD5.
     * @return A representação hexadecimal do hash MD5 do texto
     */
    public static String getMD5(String texto) {
        try {
            // o método estático getInstance é chamado com hash MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // o método digest() é chamado para calcular a hash da mensagem
            // temos o vetor da mensagem 
            byte[] messageDigest = md.digest(texto.getBytes());
            
            // convertemos o vetor de bytes em um bigInt
            BigInteger no = new BigInteger(1, messageDigest);
            
            // a mensagem em BigInt é convertida para hexadecimal
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }  
}
