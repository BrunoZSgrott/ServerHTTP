/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import connection.Connection;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class ServerController implements Runnable {

    private boolean isRunning;
    private ServerSocket server;

    static final int PORT = 80;

    public static final boolean verbose = true;

    public ServerController() throws IOException {
        server = new ServerSocket(PORT);
        System.out.println("Server started.\nListening for connections on port : " + PORT + " ...\n");
        isRunning = true;
        if (verbose) {
            System.out.println("Connecton opened. (" + new Date() + ")");
        }
    }

    public void run() {
        while (this.isRunning) {
            try {
                Thread conn = new Thread(new Connection(server.accept()));
                conn.start();
            } catch (Exception ex) {

            }
        }
    }
}
