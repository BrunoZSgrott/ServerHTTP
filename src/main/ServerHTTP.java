/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import server.ServerController;
import java.io.IOException;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class ServerHTTP {

    public static void main(String args[]) throws IOException {
        ServerController server = new ServerController();
        Thread thread = new Thread(server);
        while(true){
            thread.run();
        }
    }

}
