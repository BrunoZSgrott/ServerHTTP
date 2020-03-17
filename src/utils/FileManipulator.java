/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URI;
import java.net.URLConnection;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class FileManipulator extends File {

    private String path;

    public FileManipulator(Paths path) {
        super(path.toString());
        this.path = path.toString();
    }

    public FileManipulator(String pathname) {
        super(pathname);
        this.path = pathname;
    }

    public FileManipulator(String parent, String child) {
        super(parent, child);
    }

    public FileManipulator(File parent, String child) {
        super(parent, child);
        this.path = parent.getPath().concat(child);
    }

    public FileManipulator(URI uri) {
        super(uri);
    }

    public byte[] readFileData() throws IOException {
        FileInputStream fileIn = null;
        byte[] fileData = new byte[(int) this.length()];

        try {
            fileIn = new FileInputStream(this);
            fileIn.read(fileData);
        } finally {
            if (fileIn != null) {
                fileIn.close();
            }
        }

        return fileData;
    }

    public String getMimeType() {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        return fileNameMap.getContentTypeFor(this.getName());
    }

    public void write(String str) {
        try {
            FileWriter fw = null;
            if (!this.exists()) {
                this.createNewFile();
                fw = new FileWriter(this);
            } else {
                fw = new FileWriter(this, true);
            }
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.close();
            fw.close();
        } catch (Exception ex) {
            boolean x = true;
        }
    }
}
