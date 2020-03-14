package view;

import connection.Paths;
import filteutils.FileManipulator;
import java.io.IOException;
import main.Cache;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class ViewNotImplemented extends ViewBase {

    protected String method;

    public ViewNotImplemented(String method) {
        this.method = method;
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
        return new FileManipulator(Cache.getInstance().getRootFile(), Paths.METHOD_NOT_SUPPORTED.toString());
    }

    @Override
    protected String getStatusMessage() {
        return "Not Implemented";
    }

    @Override
    protected int getStatusCode() {
        return 501;
    }

    @Override
    public byte[] getFileData() throws IOException {
        return getFile().readFileData();
    }

    @Override
    public void verbose() {
        System.out.println("501 Not Implemented : " + method + " method.");
    }

}
