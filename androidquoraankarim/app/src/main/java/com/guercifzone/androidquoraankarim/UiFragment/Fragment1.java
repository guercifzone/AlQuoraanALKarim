package com.guercifzone.androidquoraankarim.UiFragment;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.guercifzone.androidquoraankarim.R;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Fragment1 extends Fragment {
    private static final List<String> NUMBERS_TO_HIGHLIGHT = Arrays.asList("(1)", "(2)","(3)","(4)","(5)","(6)","(7)");
    private String title;
    private String content;
    public Fragment1() {}
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        loadJsonFromRawResource();
        TextView titleTextView = rootView.findViewById(R.id.titleTextView);
        TextView contentTextView = rootView.findViewById(R.id.contentTextView);

        titleTextView.setText(title);
        contentTextView.setText(content);
        // Loop through the list of words to highlight
        SpannableString spannableContent = new SpannableString(content);
        for (String word : NUMBERS_TO_HIGHLIGHT) {
            Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                int startIndex = matcher.start();
                int endIndex = matcher.end();
                spannableContent.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.green)),
                        startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
return rootView;
    }
        private void loadJsonFromRawResource(){
        try {
            InputStream inputStream = getContext().getResources().openRawResource(R.raw.quoraan_1);
            InputStreamReader reader = new InputStreamReader(inputStream);
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            title = jsonObject.get("title").getAsString();
            content = jsonObject.get("content").getAsString();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    }




