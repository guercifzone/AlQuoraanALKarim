package com.guercifzone.androidquoraankarim.UiFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
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
private EditText searchEditText;
private Button searchButton;
private LinearLayout dynamicContentLayout;
private ScaleGestureDetector scaleGestureDetector;
    private List<Quoraan_1.Section> sections;
private int currentFontSize = 26;
private float scaleFactor = 1.0f;

    public Fragment1() {}

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        LinearLayout linearLayout = root.findViewById(R.id.linearLayout);
        dynamicContentLayout = root.findViewById(R.id.dynamicContentLayout);
        searchEditText = root.findViewById(R.id.searchEditText);
        searchButton = root.findViewById(R.id.searchButton);
        sections = Quoraan_1.readJsonFile(requireContext());

        List<Quoraan_1.Section> sections = Quoraan_1.readJsonFile(requireContext());
        loadContent(sections);
        searchButton.setOnClickListener(v->{
            String searchQuery = searchEditText.getText().toString().trim();
if (!searchQuery.isEmpty()) {
    searchContent(searchQuery);
}
        });
        SeekBar seekBar = root.findViewById(R.id.fontSizeSeekBar);
        TextView fontSizeTextView = root.findViewById(R.id.fontSizeTextView);
        fontSizeTextView.setText("Font size : " + currentFontSize);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentFontSize = progress + 10;
                fontSizeTextView.setText("Font size : " + currentFontSize);
 for (int i = 0; i < linearLayout.getChildCount(); i++) {
     View child = linearLayout.getChildAt(i);
     if (child instanceof TextView) {
         TextView textView = (TextView) child;
         textView.setTextSize(currentFontSize);
     }
   }
 }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        scaleGestureDetector = new ScaleGestureDetector(getContext(),new ScaleListener());
        root.setOnTouchListener(new View.OnTouchListener() {
     @Override
     public boolean onTouch(View v, MotionEvent event) {
         scaleGestureDetector.onTouchEvent(event);
         return true;
     }
 });
        return root;
    }

    private void searchContent(String searchQuery) {
        dynamicContentLayout.removeAllViews();
        for (Quoraan_1.Section section : sections) {
            if (section.getTitle().toLowerCase().contains(searchQuery.toLowerCase()) ||
                    section.getContent().toLowerCase().contains(searchQuery.toLowerCase())) {

                // Display matching section
                TextView titleTextView = new TextView(requireContext());
                titleTextView.setText(section.getTitle());
                titleTextView.setTextSize(20);
                titleTextView.setTypeface(null, android.graphics.Typeface.BOLD);
                titleTextView.setTextColor(getResources().getColor(R.color.red));

                TextView contentTextView = new TextView(requireContext());
                String contentText = section.getContent();
                SpannableString spannableContent = new SpannableString(contentText);

                // Highlight search results
                Pattern pattern = Pattern.compile(searchQuery, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(contentText);
                while (matcher.find()) {
                    int startIndex = matcher.start();
                    int endIndex = matcher.end();
                    spannableContent.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.blue)),
                            startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }

                contentTextView.setText(spannableContent);
                contentTextView.setTextSize(18);
                contentTextView.setTextColor(getResources().getColor(R.color.black));

                dynamicContentLayout.addView(titleTextView);
                dynamicContentLayout.addView(contentTextView);
            }
        }
    }
    private void loadContent(List<Quoraan_1.Section> sections) {
    dynamicContentLayout.removeAllViews();
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
            contentTextView.setTextSize(currentFontSize);
            contentTextView.setTextColor(getResources().getColor(R.color.black));
            contentTextView.setTypeface(this.getResources().getFont(R.font.aalmaghribi));
            contentTextView.setPadding(8, 8, 8, 8);

            // Add the TextViews to the LinearLayout
            dynamicContentLayout.addView(titleTextView);
            dynamicContentLayout.addView(contentTextView);
        }
    }
    @Override
    public void onResume() {
        super.onResume();
    }
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scaleFactor *= detector.getScaleFactor();
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));


            LinearLayout linearLayout = getView().findViewById(R.id.linearLayout);
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                View child = linearLayout.getChildAt(i);
                if (child instanceof TextView) {
                    TextView textView = (TextView) child;
                    textView.setTextSize(26 * scaleFactor);
                }
            }
            return true;
        }
    }
}