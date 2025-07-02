
package com.senacpi.dao;

import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author Jake mk
 */
public class Env {
    private static final Dotenv dotenv = Dotenv.load();
    
    public static String get(String key) {
        return dotenv.get(key);
    }
}
