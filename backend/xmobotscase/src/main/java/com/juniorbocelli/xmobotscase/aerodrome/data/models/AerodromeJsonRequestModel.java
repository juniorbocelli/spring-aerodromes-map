package com.juniorbocelli.xmobotscase.aerodrome.data.models;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.management.JMException;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Aerodrome;
import com.juniorbocelli.xmobotscase.runway.domain.entities.Runway;

public class AerodromeJsonRequestModel {
    private MultipartFile file;

    public static List<Aerodrome> toAerodromeList(AerodromeJsonRequestModel aerodromeJsonRequestModel)
            throws IOException, JMException {
        JSONObject jsonObject = fileToJson(aerodromeJsonRequestModel.getFile());

        JSONArray aerodromesJsonArray = jsonObject.getJSONArray("aerodromes");

        List<Aerodrome> aerodromes = new ArrayList<Aerodrome>();

        for (int i = 0; i < aerodromesJsonArray.length(); i++) {
            List<Runway> runways = new ArrayList<Runway>();
            JSONArray runwaysJson = aerodromesJsonArray.getJSONObject(i).optJSONArray("runways");
            for (int j = 0; j < runwaysJson.length(); j++) {
                Runway runway = new Runway();
                JSONObject runwayJsonObject = runwaysJson.optJSONObject(j);

                runway.setDesignation(runwayJsonObject.getString("designation"));
                runway.setWidth((long) runwayJsonObject.getInt("width"));
                runway.setLength((long) runwayJsonObject.getInt("length"));

                runways.add(runway);
            }

            Aerodrome aerodrome = new Aerodrome();
            JSONObject aerodromeJsonObject = aerodromesJsonArray.getJSONObject(i);
            aerodrome.setName(aerodromeJsonObject.getString("name"));
            aerodrome.setCity(aerodromeJsonObject.getString("city"));
            aerodrome.setDescription(aerodromeJsonObject.getString("description"));
            aerodrome.setDmsFromDescription();
            aerodrome.setRunways(runways);
            aerodrome.setCreatedAt(aerodromeJsonObject.getString("created_at"));

            aerodromes.add(aerodrome);
        }

        return aerodromes;
    }

    private static JSONObject fileToJson(MultipartFile file) throws IOException {
        // https://betterprogramming.pub/how-to-read-a-json-file-and-return-its-content-in-a-spring-boot-api-1f69e552f7af
        String staticDataString = IOUtils.toString(file.getInputStream(), StandardCharsets.UTF_8);

        return new JSONObject(staticDataString);
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
