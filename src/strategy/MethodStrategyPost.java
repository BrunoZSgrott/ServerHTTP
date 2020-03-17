package strategy;

import utils.Paths;
import utils.FileManipulator;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import utils.Cache;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class MethodStrategyPost extends MethodStrategy {

    private List<String> dataKey;
    private List<String> data;

    public MethodStrategyPost(String file, BufferedReader input) {
        super(file, input);
    }

    @Override
    public String getFileRequested() {
        String url = this.getUrl();
        if (this.getUrl().indexOf("?") != -1) {
            url = this.getUrl().substring(0, this.getUrl().indexOf("?"));
        }
        FileManipulator file = new FileManipulator(Cache.getInstance().getRootFile(), url);
        if(file.exists()){
            return url;
        }
        return Paths.BAD_REQUEST.toString();
    }

    @Override
    public void getData() {
        if (this.data == null && this.dataKey == null) {
            this.buscarData();
        }
    }

    private void buscarData() {
        this.dataKey = new ArrayList<>();
        this.data = new ArrayList<>();
        try {
            String query = getPostDataFromBuffer();
            String[] array = query.split("&");
            for (String str : array) {
                String[] dados = str.split("=");
                this.dataKey.add(dados[0]);
                this.data.add(dados[1].replace('+', ' '));
            }
            FileManipulator file = new FileManipulator(Cache.getInstance().getRootFile(), Paths.INFO_PESSOA.toString());
            file.write(this.data.get(0) + ";" + this.data.get(1) + "\n");
        } catch (Exception ex) {
        }
    }

    private String getPostDataFromBuffer() throws IOException {
        String headerLine = null;
        while ((headerLine = getInput().readLine()).length() != 0) {
        }
        StringBuilder payload = new StringBuilder();
        while (getInput().ready()) {
            payload.append((char) getInput().read());
        }
        return payload.toString();
    }

}
