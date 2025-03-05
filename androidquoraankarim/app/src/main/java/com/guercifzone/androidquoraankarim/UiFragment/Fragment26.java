
package com.guercifzone.androidquoraankarim.UiFragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
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
public class Fragment26 extends Fragment {
    private String title;
    private String content;
    private ScaleGestureDetector scaleGestureDetector;
    private float textSize = 20f;
    public Fragment26() {}
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

        // Loop through the list of words to highlight
        SpannableString spannableContent = new SpannableString(content);
      for (int i = 0; i < content.length(); i++) {
          if (Character.isDigit(content.charAt(i))){
              spannableContent.setSpan(new ForegroundColorSpan(Color.RED), i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
          }else if (content.charAt(i) == ')' || content.charAt(i) == '('){
              spannableContent.setSpan(new ForegroundColorSpan(Color.BLUE), i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
         }else if (content.charAt(i) == '©' || content.charAt(i) == '®' || content.charAt(i) == '¥' || content.charAt(i) == '¤'){
              spannableContent.setSpan(new ForegroundColorSpan(Color.GREEN), i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
          }
      }
      contentTextView.setText(spannableContent);
      contentTextView.setTextSize(textSize);
      scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleListener(contentTextView));
      contentTextView.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return true;
    }
});
      return rootView;
    }
        private void loadJsonFromRawResource(){
        try {
            InputStream inputStream = getContext().getResources().openRawResource(R.raw.quoraan_26);
            InputStreamReader reader = new InputStreamReader(inputStream);
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            title = jsonObject.get("title").getAsString();
            content = jsonObject.get("content").getAsString();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
        private class ScaleListener extends  ScaleGestureDetector.SimpleOnScaleGestureListener{
        private TextView textView;
        public ScaleListener(TextView textView){
            this.textView = textView;
        }
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                float scaleFactor = detector.getScaleFactor();
                textSize *= scaleFactor;
                textView.setTextSize(textSize);
                return true;
            }
        }
    }
