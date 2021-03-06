package strategy;

import utils.Paths;
import utils.FileManipulator;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import utils.Cache;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class MethodStrategyGet extends MethodStrategy {

    private List<String> dataKey;
    private List<String> data;

    public MethodStrategyGet(String file, BufferedReader input) {
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
        return Paths.FILE_NOT_FOUND.toString();
    }

    public void getData() {
        if (this.data == null && this.dataKey == null) {
            this.buscarData();
        }
    }

    private void buscarData() {
        this.dataKey = new ArrayList<>();
        this.data = new ArrayList<>();
        if (this.getUrl().indexOf("?") != -1) {
            String query = this.getUrl().substring(this.getUrl().indexOf("?") + 1);
            String[] array = query.split("&");
            for (String str : array) {
                String[] dados = str.split("=");
                this.dataKey.add(dados[0]);
                this.data.add(dados[1]);
            }
        }
    }
}
