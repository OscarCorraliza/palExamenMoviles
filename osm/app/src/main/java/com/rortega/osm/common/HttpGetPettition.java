package com.rortega.osm.common;


import com.rortega.osm.domain.HttpLocation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpGetPettition {

    public final String TAG = getClass().getName();

    public final String HEADER_URL = "https://datos.madrid.es/egob/";
    public final String END_POINT_SCHOOLS = "/catalogo/202311-0-colegios-publicos.json?distrito_nombre=MORATALAZ";

    public List<HttpLocation> gethttpPettitonLocation() {

        List<HttpLocation> httpLocations = new ArrayList<>();

        BufferedReader reader = null;
        StringBuilder stringBuilder = null;
        HttpURLConnection request = null;

        try {
            URL url = new URL(HEADER_URL + END_POINT_SCHOOLS);
            request = (HttpURLConnection) url.openConnection();
            request.setRequestMethod("GET");
            request.connect();

            switch (request.getResponseCode()) {
                case 200:
                case 201:
                    reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
                    stringBuilder = new StringBuilder();
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                request.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("@graph");
            String title = "";
            Double latitude = 0.0;
            Double longitude = 0.0;
            for (int i = 0; i < jsonArray.length(); i++) {
                title = jsonArray.getJSONObject(i).getString("title");
                latitude = Double.parseDouble(jsonArray.getJSONObject(i).getJSONObject("location").getString("latitude"));
                longitude = Double.parseDouble(jsonArray.getJSONObject(i).getJSONObject("location").getString("longitude"));
                httpLocations.add(new HttpLocation(title, latitude, longitude));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return httpLocations;
    }
}
