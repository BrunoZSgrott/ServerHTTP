package connection.strategy;

import filteutils.FileManipulator;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import server.ServerController;
import view.ViewBase;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public abstract class ConnectionStrategy {

    private OutputStream output;
    private PrintWriter writer;
    private ViewBase file;

    public ConnectionStrategy(PrintWriter writer, OutputStream output) {
        this.writer = writer;
        this.output = output;
    }

    protected ViewBase getView() {
        if (this.file == null) {
            this.file = this.createView();
        }
        return this.file;
    }

    public void send() throws IOException {
        printHead();
        printContent();
    }

    private void printHead() {
        for (String head : getView().getHeader()) {
            writer.println(head);
        }
        writer.println();
        writer.flush();
    }

    private void printContent() throws IOException {
        output.write(getView().getFileData(), 0, getView().getFileLength());
        output.flush();
    }

    public String getContentType() {
        return getView().getContentType();
    }

    abstract protected ViewBase createView();
}
