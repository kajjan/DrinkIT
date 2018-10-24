package com.TDA367.drinkit.Services;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class CategoryStore {
    private AssetManager assets;

    public void readChallenges(Context context) throws Exception {
        assets = context.getAssets();

        for (String file : assets.list("/"))
            processCategory(file);


    }

    void processCategory(String file) throws Exception {
        String txt = readAssetFile(file);

        JSONObject categoryJSON = new JSONObject(txt);




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






}
