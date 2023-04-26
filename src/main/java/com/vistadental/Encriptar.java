
package com.vistadental;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {
    
    public static void main (String[] args){
    var codigo = new BCryptPasswordEncoder();
    System.out.println("sebas (123): " + codigo.encode("123"));
    System.out.println("david (456): " + codigo.encode("456"));
    System.out.println("admin (789): " + codigo.encode("789"));
    }
    
}
