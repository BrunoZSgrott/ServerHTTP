package connection.strategy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import server.ServerController;
import view.ViewBase;
import view.ViewFileNotFound;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class ConnectionStrategyFileNotFound extends ConnectionStrategy {

    private String fileRequested;

    public ConnectionStrategyFileNotFound(PrintWriter writer, OutputStream output, String fileRequested) {
        super(writer, output);
        this.fileRequested = fileRequested;
    }

    @Override
    protected ViewBase createView() {
        return new ViewFileNotFound(fileRequested);
    }

}
