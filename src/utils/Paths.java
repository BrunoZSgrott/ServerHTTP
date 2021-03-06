/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public enum Paths {

    DEFAULT_FILE("index.html"),
    WEB_ROOT("public_html/"),
    FILE_NOT_FOUND("404.html"),
    METHOD_NOT_SUPPORTED("not_supported.html"),
    BAD_REQUEST("bad_request.html"),
    INFO_PESSOA("pessoa/pessoa.txt");

    private String path;

    private Paths(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return this.path;
    }

    public String getPath(String file) {
        return WEB_ROOT.toString() + file;
    }

}
