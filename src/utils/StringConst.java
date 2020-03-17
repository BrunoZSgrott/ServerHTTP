package utils;

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
