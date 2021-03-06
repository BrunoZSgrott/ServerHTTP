package connection;

import utils.Paths;
import connection.strategy.ConnectionStrategy;
import connection.strategy.ConnectionStrategyFileFound;
import connection.strategy.ConnectionStrategyFileNotFound;
import connection.strategy.ConnectionStrategyNotImplemented;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;
import server.ServerController;
import strategy.MethodStrategy;
import strategy.MethodStrategyGet;
import strategy.MethodStrategyPost;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class Connection implements Runnable {

    private Socket connection;
    private BufferedReader in;
    private PrintWriter out;
    private BufferedOutputStream dataOut;
    private String fileRequested;

    public Connection(Socket socket) {
        this.connection = socket;
    }

    @Override
    public void run() {
        ConnectionStrategy strategy = null;
        String method = null;
        MethodStrategy methodStrategy = null;
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new PrintWriter(connection.getOutputStream());
            dataOut = new BufferedOutputStream(connection.getOutputStream());
            in.mark(1);
            String input = in.readLine();
            StringTokenizer parse = new StringTokenizer(input);
            method = parse.nextToken().toUpperCase();
            strategy = new ConnectionStrategyNotImplemented(out, dataOut, method);
            fileRequested = parse.nextToken().toLowerCase();

            if (fileRequested.equals("index.html") || fileRequested.equals("") || fileRequested.equals("/")) {
                fileRequested += Paths.DEFAULT_FILE.toString();
            }
            if (method.equals("GET") || method.equals("HEAD")) {
                methodStrategy = new MethodStrategyGet(fileRequested, in);
            } else if (method.equals("POST")) {
                methodStrategy = new MethodStrategyPost(fileRequested, in);
            }
            strategy = new ConnectionStrategyFileFound(out, dataOut, methodStrategy);
            methodStrategy.getData();

        } catch (FileNotFoundException fnfe) {
            strategy = new ConnectionStrategyFileNotFound(out, dataOut, methodStrategy);
        } catch (IOException ioe) {
            System.err.println("Server error : " + ioe);
        } finally {
            try {
                strategy.send();
                in.close();
                out.close();
                dataOut.close();
                connection.close();
            } catch (Exception e) {
                System.err.println("Error closing stream : " + e.getMessage());
            }

            if (ServerController.verbose) {
                System.out.println("Connection closed.\n");
            }
        }
    }

}
