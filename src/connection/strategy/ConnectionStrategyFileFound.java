package connection.strategy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import server.ServerController;
import view.ViewBase;
import view.ViewFileFound;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class ConnectionStrategyFileFound extends ConnectionStrategy {

    protected String fileRequested;

    public ConnectionStrategyFileFound(PrintWriter writer, OutputStream output, String fileRequested) throws FileNotFoundException, IOException {
        super(writer, output);
        this.fileRequested = fileRequested;
        getView().getFileData();
    }

    @Override
    protected ViewBase createView() {
        return new ViewFileFound(fileRequested);
    }

}
