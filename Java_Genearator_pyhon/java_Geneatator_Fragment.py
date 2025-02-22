# Loop to create Java class files from Quoraan_1.java to Quoraan_114.java
for i in range(2, 115):  # From 1 to 114 inclusive
    filename = f"Fragment{i}.java"

    # Java class template
    class_content = f"""
package com.guercifzone.androidquoraankarim.UiFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.guercifzone.androidquoraankarim.JsonParser.*;
import com.guercifzone.androidquoraankarim.R;

import java.util.List;


public class Fragment{i} extends Fragment {{
    //سورة الفاتحة
    public Fragment{i}(){{}}
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {{

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        LinearLayout linearLayout = root.findViewById(R.id.linearLayout);
        List<Quoraan_{i}.Section> sections = Quoraan_{i}.readJsonFile(requireContext());
        for (Quoraan_{i}.Section section : sections) {{
            TextView titleTextView = new TextView(requireContext());
            titleTextView.setText(section.getTitle());
            titleTextView.setTextSize(25);
            titleTextView.setTypeface(null, android.graphics.Typeface.BOLD);
            titleTextView.setTextColor(getResources().getColor(R.color.red));
            titleTextView.setTypeface(this.getResources().getFont(R.font.aalmaghribi));
            titleTextView.setPadding(16, 16, 16, 8);

            // Create a TextView for the content
            TextView contentTextView = new TextView(requireContext());
            contentTextView.setText(section.getContent());
            contentTextView.setTextSize(22  );
            contentTextView.setTextColor(getResources().getColor(R.color.black));
            contentTextView.setTypeface(this.getResources().getFont(R.font.aalmaghribi));
            contentTextView.setPadding(8, 8, 8, 8);

            // Add the TextViews to the LinearLayout
            linearLayout.addView(titleTextView);
            linearLayout.addView(contentTextView);
        }}

        return root;
    }}



}}


"""
    # Write the content to the Java file
    with open(filename, 'w') as f:
        f.write(class_content)

    print(f"File {filename} created successfully.")
