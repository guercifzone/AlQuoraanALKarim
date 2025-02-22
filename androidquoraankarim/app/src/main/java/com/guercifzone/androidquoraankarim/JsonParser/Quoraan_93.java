
package com.guercifzone.androidquoraankarim.JsonParser;

import android.content.Context;
import android.content.res.Resources;

import com.guercifzone.androidquoraankarim.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Quoraan_93 {
   
    public static List<Section> readJsonFile(Context context) {
        List<Section> sectionList = new ArrayList<>();
        try {
            Resources resources = context.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.quoraan_93);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String jsonString = new String(buffer, "UTF-8");
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray sections = jsonObject.getJSONArray("sections");
            for (int j = 0; j < sections.length(); j++) {
                JSONObject section = sections.getJSONObject(j);
                String sectionTitle = section.getString("title");
                Object content = section.get("content");

                if (content instanceof String) {
                    sectionList.add(new Section(sectionTitle, (String) content));
                } else if (content instanceof JSONArray) {
                    StringBuilder contentBuilder = new StringBuilder();
                    JSONArray contentArray = (JSONArray) content;
                    for (int k = 0; k < contentArray.length(); k++) {
                        contentBuilder.append(contentArray.getString(k)).append(" ");
                    }
                    sectionList.add(new Section(sectionTitle, contentBuilder.toString()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sectionList;
    }

    public static class Section {
        public String title;
        public String content;

        public Section(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }
    }
}
