package connection.strategy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import strategy.MethodStrategy;
import view.ViewBase;
import view.ViewFileFound;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class ConnectionStrategyFileFound extends ConnectionStrategy {

    protected String dados;
    protected MethodStrategy strategy;

    public ConnectionStrategyFileFound(PrintWriter writer, OutputStream output, MethodStrategy strategy) throws FileNotFoundException, IOException {
        super(writer, output);
        this.strategy = strategy;
    }

    @Override
    protected ViewBase createView() {
        return new ViewFileFound(strategy);
    }

}
