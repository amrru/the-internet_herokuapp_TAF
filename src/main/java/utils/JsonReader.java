package utils;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonReader {

    static String jsonReader;
    String jsonFileName;
    private final String test_data_path = "src/test/java/test_data/";
    public JsonReader(String jsonFileName){
        this.jsonFileName = jsonFileName;
        try{
            JSONObject data = (JSONObject) new JSONParser()
                    .parse(new FileReader(test_data_path+jsonFileName+".json"));
            jsonReader = data.toJSONString();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
    //jsonPath = valid.userName
    public static String getJsonData(String jsonPath){
        return JsonPath.read(jsonReader,jsonPath);
    }

}
