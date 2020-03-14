package strategy;

import java.io.BufferedReader;

/**
 *
 * @author Bruno Zilli Sgrott
 */
abstract public class MethodStrategy {

    private String url;
    private BufferedReader input;

    public MethodStrategy(String file, BufferedReader input) {
        this.url = file;
        this.input = input;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BufferedReader getInput() {
        return input;
    }

    public void setInput(BufferedReader input) {
        this.input = input;
    }

    abstract public String getFileRequested();

    abstract public void getData();

}
