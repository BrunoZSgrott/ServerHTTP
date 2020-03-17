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
public class ViewFileFound extends ViewBase {

    protected String fileRequested;
    protected int statusCode;
    protected String statusMessage;

    public ViewFileFound(MethodStrategy strat) {
        String fr = strat.getFileRequested();
        if(fr.equals(Paths.BAD_REQUEST.toString())){
            this.fileRequested = Paths.BAD_REQUEST.toString();
            this.statusCode = 400;
            this.statusMessage = "Bad Request";
        } else {
            this.fileRequested = fr;
            this.statusCode = 200;
            this.statusMessage = "Ok";
        }
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
        return this.statusMessage;
    }

    @Override
    protected int getStatusCode() {
        return this.statusCode;
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
