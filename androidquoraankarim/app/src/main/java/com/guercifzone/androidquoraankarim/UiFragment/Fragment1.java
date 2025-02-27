package com.guercifzone.androidquoraankarim.UiFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.guercifzone.androidquoraankarim.JsonParser.Quoraan_1;
import com.guercifzone.androidquoraankarim.R;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Fragment1 extends Fragment {
    //أرقام الايات
    private static final List<String> NUMBERS_TO_HIGHLIGHT = Arrays.asList("(1)", "(2)","(3)","(4)","(5)","(6)","(7)");
    //والانصاف الاحزاب والاثمان والربع
    private static final List<String> SUMBOLS_TO_HIGHLIGHT = Arrays.asList("");
   //قواعد القراءة
    private static final List<String> ROLS_TO_HIGHLIGHT = Arrays.asList("");


    public Fragment1() {}

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        LinearLayout linearLayout = root.findViewById(R.id.linearLayout);
        List<Quoraan_1.Section> sections = Quoraan_1.readJsonFile(requireContext());

        for (Quoraan_1.Section section : sections) {
            TextView titleTextView = new TextView(requireContext());
            titleTextView.setText(section.getTitle());
            titleTextView.setTextSize(25);
            titleTextView.setTypeface(null, android.graphics.Typeface.BOLD);
            titleTextView.setTextColor(getResources().getColor(R.color.red));
            titleTextView.setTypeface(this.getResources().getFont(R.font.aalmaghribi));
            titleTextView.setPadding(16, 16, 16, 8);

            TextView contentTextView = new TextView(requireContext());

            // Create a SpannableString to style the content text
            String contentText = section.getContent();
            SpannableString spannableContent = new SpannableString(contentText);

            // Loop through the list of words to highlight
            for (String word : NUMBERS_TO_HIGHLIGHT) {
                Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(contentText);

                while (matcher.find()) {
                    int startIndex = matcher.start();
                    int endIndex = matcher.end();
                    spannableContent.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.green)),
                            startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
            for (String word : SUMBOLS_TO_HIGHLIGHT) {
                Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(contentText);
                while (matcher.find()) {
                    int startIndex = matcher.start();
                    int endIndex = matcher.end();
                    spannableContent.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.blue)),
                            startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
            for (String word : ROLS_TO_HIGHLIGHT) {
                Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(contentText);
                while (matcher.find()) {
                    int startIndex = matcher.start();
                    int endIndex = matcher.end();
                    spannableContent.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.blue)),
                            startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
            contentTextView.setText(spannableContent);
            contentTextView.setTextSize(26);
            contentTextView.setTextColor(getResources().getColor(R.color.black));
            contentTextView.setTypeface(this.getResources().getFont(R.font.aalmaghribi));
            contentTextView.setPadding(8, 8, 8, 8);

            // Add the TextViews to the LinearLayout
            linearLayout.addView(titleTextView);
            linearLayout.addView(contentTextView);
        }

        return root;
    }
}