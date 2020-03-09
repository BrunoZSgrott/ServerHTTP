/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public interface View {

    List<String> getHeader();

    byte[] getFileData() throws IOException;
}
