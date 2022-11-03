package Framework.Util;

import Entity.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadJson {
    private static JSONObject jsonConfig;
    private static JSONObject jsonTesting;
    public static JSONObject getJsonConfig() {
        return jsonConfig;
    }
    public static JSONObject getJsonTesting() {
        return jsonTesting;
    }



    static {
        try {
            JSONParser parser = new JSONParser();
            try {
                FileReader fileReaderConfig = new FileReader("./src/main/resources/config/config.json");
                jsonConfig = (JSONObject) parser.parse(fileReaderConfig);
                FileReader fileReaderTesting = new FileReader("./src/main/resources/config/testing.json");
                jsonTesting = (JSONObject) parser.parse(fileReaderTesting);
            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getConfigData(String key){
        return ReadJson.getJsonConfig().get(key);
    }

    public static Object getTestingData(String key){
        return ReadJson.getJsonTesting().get(key);
    }

    public static JSONArray usersJson = (JSONArray)jsonTesting.get("users");

    public static List<User> getUsers(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < usersJson.size(); i++) {
            User user = new User();
            JSONObject userJson = (JSONObject) usersJson.get(i);
            user.setId(((long)(userJson.get("userId"))));
            user.setFirstName (userJson.get("firstName").toString());
            user.setLastName (userJson.get("lastName").toString());
            user.setEmail (userJson.get("email").toString());
            user.setAge ((long) userJson.get("age"));
            user.setSalary ((long) userJson.get("salary"));
            user.setDepartment (userJson.get("department").toString());
            users.add(user);
        }
        return users;
    }
}