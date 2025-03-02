
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

import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.guercifzone.androidquoraankarim.JsonParser.*;
import com.guercifzone.androidquoraankarim.R;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Fragment85 extends Fragment {
    //سورة 
        private static final List<String> NUMBERS_TO_HIGHLIGHT = Arrays.asList("(1)","(2)","(3)","(4)","(5)","(6)","(7)","(8)","(9)","(10)","(11)","(12)","(13)","(14)","(15)","(16)","(17)","(18)","(19)","(20)","(21)","(22)","(23)","(24)","(25)","(26)","(27)","(28)","(29)","(30)","(31)","(32)","(33)","(34)","(35)","(36)","(37)","(38)","(39)","(40)","(41)","(42)","(43)","(44)","(45)","(46)","(47)","(48)","(49)","(50)","(51)","(52)","(53)","(54)","(55)","(56)","(57)","(58)","(59)","(60)","(61)","(62)","(63)","(64)","(65)","(66)","(67)","(68)","(69)","(70)","(71)","(72)","(73)","(74)","(75)","(76)","(77)","(78)","(79)","(80)","(81)","(82)","(83)","(84)","(85)","(86)","(87)","(88)","(89)","(90)","(91)","(92)","(93)","(94)","(95)","(96)","(97)","(98)","(99)","(100)","(101)","(102)","(103)","(104)","(105)","(106)","(107)","(108)","(109)","(110)","(111)","(112)","(113)","(114)","(115)","(116)","(117)","(118)","(119)","(120)","(121)","(122)","(123)","(124)","(125)","(126)","(127)","(128)","(129)","(130)","(131)","(132)","(133)","(134)","(135)","(136)","(137)","(138)","(139)","(140)","(141)","(142)","(143)","(144)","(145)","(146)","(147)","(148)","(149)","(150)","(151)","(152)","(153)","(154)","(155)","(156)","(157)","(158)","(159)","(160)","(161)","(162)","(163)","(164)","(165)","(166)","(167)","(168)","(169)","(170)","(171)","(172)","(173)","(174)","(175)","(176)","(177)","(178)","(179)","(180)","(181)","(182)","(183)","(184)","(185)","(186)","(187)","(188)","(189)","(190)","(191)","(192)","(193)","(194)","(195)","(196)","(197)","(198)","(199)","(200)","(201)","(202)","(203)","(204)","(205)","(206)","(207)","(208)","(209)","(210)","(211)","(212)","(213)","(214)","(215)","(216)","(217)","(218)","(219)","(220)","(221)","(222)","(223)","(224)","(225)","(226)","(227)","(228)","(229)","(230)","(231)","(232)","(233)","(234)","(235)","(236)","(237)","(238)","(239)","(240)","(241)","(242)","(243)","(244)","(245)","(246)","(247)","(248)","(249)","(250)","(251)","(252)","(253)","(254)","(255)","(256)","(257)","(258)","(259)","(260)","(261)","(262)","(263)","(264)","(265)","(266)","(267)","(268)","(269)","(270)","(271)","(272)","(273)","(274)","(275)","(276)","(277)","(278)","(279)","(280)","(281)","(282)","(283)","(284)","(285)","(286)");
    //والانصاف الاحزاب والاثمان والربع
    private static final List<String> SUMBOLS_TO_HIGHLIGHT = Arrays.asList("¤","®","©","¥");
   //قواعد القراءة
    private static final List<String> ROLS_TO_HIGHLIGHT = Arrays.asList("؋ّٓؐ","");

private ScaleGestureDetector scaleGestureDetector;

private int currentFontSize = 26;
private float scaleFactor = 1.0f;
    public Fragment85(){}
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        LinearLayout linearLayout = root.findViewById(R.id.linearLayout);
        List<Quoraan_85.Section> sections = Quoraan_85.readJsonFile(requireContext());
        for (Quoraan_85.Section section : sections) {
            TextView titleTextView = new TextView(requireContext());
            titleTextView.setText(section.getTitle());
            titleTextView.setTextSize(25);
            titleTextView.setTypeface(null, android.graphics.Typeface.BOLD);
            titleTextView.setTextColor(getResources().getColor(R.color.red));
            titleTextView.setTypeface(this.getResources().getFont(R.font.aalmaghribi));
            titleTextView.setPadding(16, 16, 16, 8);
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
                    spannableContent.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.orange)),
                            startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
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
        }
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
            public void onStartTrackingTouch(SeekBar seekBar){}
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


