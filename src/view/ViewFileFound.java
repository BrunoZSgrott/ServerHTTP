package view;

import filteutils.FileManipulator;
import java.io.IOException;
import main.Cache;
import strategy.MethodStrategy;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class ViewFileFound extends ViewBase {

    protected String fileRequested;

    public ViewFileFound(MethodStrategy strat) {
        this.fileRequested = strat.getFileRequested();
    }

    @Override
    public String getContentType() {
        return getFile().getMimeType();
    }

    @Override
    public int getFileLength() {
        return (int) getFile().length();
    }

    @Override
    protected FileManipulator createFile() {
        return new FileManipulator(Cache.getInstance().getRootFile(), fileRequested);
    }

    @Override
    protected String getStatusMessage() {
        return "OK";
    }

    @Override
    protected int getStatusCode() {
        return 200;
    }

    @Override
    public byte[] getFileData() throws IOException {
        return getFile().readFileData();
    }

    @Override
    public void verbose() {
        System.out.println("File " + fileRequested + " of type " + getContentType() + " returned");
    }

}
