/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import utils.Paths;
import utils.FileManipulator;
import java.io.IOException;
import utils.Cache;
import strategy.MethodStrategy;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class ViewFileNotFound extends ViewFileFound {

    public ViewFileNotFound(MethodStrategy strat) {
        super(strat);
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
        return getFile().getMimeType();
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
