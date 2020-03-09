/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import connection.Connection;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

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
