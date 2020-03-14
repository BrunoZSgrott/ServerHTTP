/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filteutils;

import connection.Paths;
import java.io.File;
import java.io.FileInputStream;
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

    public String getContentType() {
        if (path.endsWith(".htm") || path.endsWith(".html")) {
            return "text/html";
        } else {
            return "text/plain";
        }
    }

    public String getMimeType() {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        return fileNameMap.getContentTypeFor(this.getName());
    }
}
