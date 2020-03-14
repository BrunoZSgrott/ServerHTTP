package connection.strategy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import server.ServerController;
import strategy.MethodStrategy;
import view.ViewBase;
import view.ViewFileNotFound;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class ConnectionStrategyFileNotFound extends ConnectionStrategy {

    private MethodStrategy methodStrategy;

    public ConnectionStrategyFileNotFound(PrintWriter writer, OutputStream output, MethodStrategy methodStrategy) {
        super(writer, output);
        this.methodStrategy = methodStrategy;
    }

    @Override
    protected ViewBase createView() {
        return new ViewFileNotFound(methodStrategy);
    }

}
