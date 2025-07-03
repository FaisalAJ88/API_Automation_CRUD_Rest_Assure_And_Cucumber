package helper;

import java.io.File;

public class Utility {
    public static File GetJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchemaData/" +JSONFile);
    }
}