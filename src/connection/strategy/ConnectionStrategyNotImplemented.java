package connection.strategy;

import java.io.OutputStream;
import java.io.PrintWriter;
import view.ViewBase;
import view.ViewNotImplemented;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class ConnectionStrategyNotImplemented extends ConnectionStrategy {

    private String method;

    public ConnectionStrategyNotImplemented(PrintWriter writer, OutputStream output, String method) {
        super(writer, output);
        this.method = method;
    }

    @Override
    protected ViewBase createView() {
        return new ViewNotImplemented(method);
    }

}
