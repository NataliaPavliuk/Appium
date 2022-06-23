package util;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;


import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class JsonReader {
JsonArray data;
    public static Logger logger = Logger.getLogger((JsonReader.class).toString());

    public JsonArray getData(){
        return data;
    }

    public void jsonReader() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/data.json"));
            JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

            data = (JsonArray) parser.get("data");
            logger.info("data read");
            reader.close();

        } catch (Exception ex) {
logger.info("data did not read");
            ex.printStackTrace();
        }
    }
}
