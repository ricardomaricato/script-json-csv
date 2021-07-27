import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class ScriptJsonCsv {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();

        try {
            FileReader fileReader = new FileReader("/home/ricardo.filho/Downloads/people_login.json");
            Object obj = jsonParser.parse(fileReader);
            JSONArray jsonArray = (JSONArray) obj;
            Collections.shuffle(jsonArray);

            FileWriter fileWriter = new FileWriter("/home/ricardo.filho/Downloads/people_login.txt");
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < jsonArray.size(); i++) {
                if ((i + 1) % 5 == 0) {
                    stringBuilder.append(jsonArray.get(i)).append(";\n");
                } else {
                    stringBuilder.append(jsonArray.get(i)).append(";");
                }
            }
            System.out.println(stringBuilder);

            fileWriter.write(String.valueOf(stringBuilder));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void converterTest(JSONObject jsonObject) {
        Class<? extends JSONObject> aClass = jsonObject.getClass();
        System.out.println(aClass.toString());
    }
}
