package com.TDA367.drinkit.Services;

import android.content.Context;
import android.content.res.AssetManager;
import com.TDA367.drinkit.Controller.Controller;
import com.TDA367.drinkit.Model.Category;
import com.TDA367.drinkit.Model.Challenge;
import com.TDA367.drinkit.Model.DrinkIT;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class CategoryStore {

    Controller ctrl;

    public CategoryStore(Controller ctrl) {
        this.ctrl = ctrl;
    }

    private AssetManager assets;
    private List<Category> categories = new ArrayList<>();


    public void readChallenges(Context context) throws Exception {
        assets = context.getAssets();
        String[] fileList = assets.list("");

        for (String file : fileList)
            if (hasJsonExtention(file))
                processCategory(file);

    }

    private boolean hasJsonExtention(String file){
        return file.endsWith(".json");
    }

    void processCategory(String file) throws Exception {
        String txt = readAssetFile(file);
        List<Challenge> challengeList;

        JSONObject categoryJSON = new JSONObject(txt);
        String name = categoryJSON.getString("name");
        String description = categoryJSON.getString("description");
        JSONArray challengeArray = categoryJSON.getJSONArray("challenges");

        challengeList = createChallengeList(challengeArray);

        addNewCategoryToList(name, description, challengeList);

    }

    void addNewCategoryToList(String name, String description, List<Challenge> challengeList) {
        categories.add(ctrl.createCategory(name, description, challengeList));
        System.out.println(name);
    }

    List<Challenge> createChallengeList(JSONArray challengeArray) throws Exception {
        List<Challenge> challengeList = new ArrayList<>();

        for (int i=0; i<challengeArray.length(); i++) {
            JSONObject row = challengeArray.getJSONObject(i);
            String challenge = row.getString("challenge");
            String answer = getAnswer(row);
            int point = row.getInt("point");

            challengeList.add(ctrl.createChallenge(challenge, answer, point));
        }
        return challengeList;
    }

    private String getAnswer(JSONObject object) {
        String answer = null; // "No answer available. :-(";

        try {
            answer = object.getString("answer");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return answer;
    }

    String readAssetFile(String file) throws Exception {
        InputStream stream = assets.open(file);
        String txt = readStream(stream);
        stream.close();
        return txt;
    }

    String readStream(InputStream stream) throws Exception {
        byte[] buffer = new byte[stream.available()];
        stream.read(buffer, 0, stream.available());
        return new String(buffer);
    }


    public List<Category> getCategories() {
        return categories;
    }
}
