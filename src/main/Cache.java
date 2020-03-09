/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import connection.Paths;
import filteutils.FileManipulator;
import java.io.File;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class Cache {

    private File root;

    private Cache() {
    }

    public static Cache getInstance() {
        return CacheHolder.INSTANCE;
    }

    private static class CacheHolder {

        private static final Cache INSTANCE = new Cache();
    }

    public File getRootFile() {
        if (root == null) {
            this.root = new FileManipulator(Paths.WEB_ROOT);
        }
        return this.root;
    }
}
