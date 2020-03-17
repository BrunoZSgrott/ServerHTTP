/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import utils.StringConst;
import utils.FileManipulator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import server.ServerController;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public abstract class ViewBase implements View {

    private FileManipulator file;

    abstract public void verbose();

    @Override
    public List<String> getHeader() {
        List<String> header = new ArrayList<>();

        header.add("HTTP/1.1 " + this.getStatusCode() + " " + this.getStatusMessage());
        header.add("Server: " + StringConst.SERVER_NAME);
        header.add("Date: " + new Date());
        header.add("Content-type: " + getContentType());
        header.add("Content-length: " + getFileLength());

        return header;
    }

    protected FileManipulator getFile() {
        if (this.file == null) {
            this.file = createFile();
            if (ServerController.verbose) {
                verbose();
            }
        }
        return this.file;
    }

    abstract public String getContentType();

    abstract public int getFileLength();

    abstract protected FileManipulator createFile();

    abstract protected String getStatusMessage();

    abstract protected int getStatusCode();

}
