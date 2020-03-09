/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public enum StringConst {

    SERVER_NAME("Servidor do Bruno");

    private String value;

    private StringConst(String str) {
        this.value = str;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
