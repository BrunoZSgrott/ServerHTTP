/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.Paths;
import filteutils.FileManipulator;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import main.Cache;
import server.ServerController;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class ViewFileNotFound extends ViewFileFound {

    public ViewFileNotFound(String fileRequested) {
        super(fileRequested);
    }

    @Override
    public byte[] getFileData() throws IOException {
        byte[] fileData = getFile().readFileData();
        return fileData;
    }

    protected FileManipulator createFile() {
        return new FileManipulator(Cache.getInstance().getRootFile(), Paths.FILE_NOT_FOUND.toString());
    }

    public String getContentType() {
        return "text/html";
    }

    public int getFileLength() {
        return (int) getFile().length();
    }

    @Override
    protected String getStatusMessage() {
        return "File not found";
    }

    @Override
    protected int getStatusCode() {
        return 404;
    }

    @Override
    public void verbose() {
        System.out.println("File " + fileRequested + " not found");
    }

}
