package com.guercifzone.androidquoraankarim;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.guercifzone.androidquoraankarim.CustomDrawer.MenuItem;
import com.guercifzone.androidquoraankarim.CustomDrawer.SNavigationDrawer;
import com.guercifzone.androidquoraankarim.UiFragment.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SNavigationDrawer SNavigationDrawer;

    Class fragmentClass;
    public static Fragment fragment;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SNavigationDrawer = findViewById(R.id.navigationDrawer);
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("سورة الفاتحة",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة البقرة",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة آل عمران",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة النساء",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة المائدة",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الأنعام",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem(" سورة الأعراف",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الأنفال",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة التوبة",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem(" سورة يونس",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة هود",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة يوسف",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الرعد",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة إبراهيم",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الحجر",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة النحل",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الإسراء",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الكهف",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة مريم",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة طه",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem(" سورة الأنبياء",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الحج",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة المؤمنون",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem(" سورة النور",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الفرقان",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem(" سورة الشعراء",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("  سورة النمل",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem(" سورة القصص",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة العنكبوت",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem(" سورة الروم",R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة لقمان", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة السجد", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الأحزاب", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة يس", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الصافات", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الزمر", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة فصلت", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الشورى", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الزخرف", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الدخان", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الجاثية", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الأحقاف", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة محمد", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الفتح", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الحجرات", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة ق", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الذاريات", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الطور", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة النجم", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة القمر", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الرحمن", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الواقعة", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الحديد", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة المجادلة", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الحشر", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الممتحنة", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الصف", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الجمعة", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة المنافقون", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة التغابن", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الطلاق", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة التحريم", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الملك", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة القلم", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الحاقة", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة المعارج", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة نوح", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الجن", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة المزمل", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة المدثر", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة القيامة", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الإنسان", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة المرسلات", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة النبأ", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة النازعات", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة عبس", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة التكوير", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الإنفطار", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة المطففين", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الإنشقاق", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة البروج", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الطارق", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الأعلى", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الغاشية", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الفجر", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة البلد", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الشمس", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الليل", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الضحى", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الشرح", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة التين", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة العلق", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة القدر", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة البينة", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الزلزلة", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة العاديات", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة القارعة", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة التكاثر", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة العصر", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الهمزة", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الفيل", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة قريش", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الماعون", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الكوثر", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الكافرون", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة النصر", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة المسد", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الإخلاص", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الفلق", R.drawable.ic_launcher_background));
        menuItems.add(new MenuItem("سورة الناس", R.drawable.ic_launcher_background));


        SNavigationDrawer.setMenuItemList(menuItems);
        fragmentClass =  Fragment1.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.framelayout, fragment).commit();
        }
        SNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position "+position);
                switch (position) {
                    case 0: {
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    /*
                    case 1: {
                        fragmentClass = Fragment2.class;
                        break;
                    }
                    case 2: {
                        fragmentClass = Fragment3.class;
                        break;
                    }
                    case 3: {
                        fragmentClass = Fragment4.class;
                        break;
                    }
                    case 4: {
                        fragmentClass = Fragment5.class;
                        break;
                    }
                    case 5: {
                        fragmentClass = Fragment6.class;
                        break;
                    }
                    case 6: {
                        fragmentClass = Fragment7.class;
                        break;
                    }
                    case 7: {
                        fragmentClass = Fragment8.class;
                        break;
                    }
                    case 8: {
                        fragmentClass = Fragment9.class;
                        break;
                    }
                    case 9: {
                        fragmentClass = Fragment10.class;
                        break;
                    }
                    case 10: {
                        fragmentClass = Fragment11.class;
                        break;
                    }
                    case 11: {
                        fragmentClass = Fragment12.class;
                        break;
                    }
                    case 12: {
                        fragmentClass = Fragment13.class;
                        break;
                    }
                    case 13: {
                        fragmentClass = Fragment14.class;
                        break;
                    }
                    case 14: {
                        fragmentClass = Fragment15.class;
                        break;
                    }
                    case 15: {
                        fragmentClass = Fragment16.class;
                        break;
                    }
                    case 16: {
                        fragmentClass = Fragment17.class;
                        break;
                    }
                    case 17: {
                        fragmentClass = Fragment18.class;
                        break;
                    }
                    case 18: {
                        fragmentClass = Fragment19.class;
                        break;
                    }
                    case 19: {
                        fragmentClass = Fragment20.class;
                        break;
                    }
                    case 20: {
                        fragmentClass = Fragment21.class;
                        break;
                    }
                    case 21: {
                        fragmentClass = Fragment22.class;
                        break;
                    }
                    case 22: {
                        fragmentClass = Fragment23.class;
                        break;
                    }
                    case 23: {
                        fragmentClass = Fragment24.class;
                        break;
                    }
                    case 24: {
                        fragmentClass = Fragment25.class;
                        break;
                    }
                    case 25: {
                        fragmentClass = Fragment26.class;
                        break;
                    }
                    case 26: {
                        fragmentClass = Fragment27.class;
                        break;
                    }
                    case 27: {
                        fragmentClass = Fragment28.class;
                        break;
                    }
                    case 28: {
                        fragmentClass = Fragment29.class;
                        break;
                    }
                    case 29: {
                        fragmentClass = Fragment30.class;
                        break;
                    }
                    case 30: {
                        fragmentClass = Fragment31.class;
                        break;
                    }
                    case 31: {
                        fragmentClass = Fragment32.class;
                        break;
                    }
                    case 32: {
                        fragmentClass = Fragment33.class;
                        break;
                    }
                    case 33: {
                        fragmentClass = Fragment34.class;
                        break;
                    }
                    case 34: {
                        fragmentClass = Fragment35.class;
                        break;
                    }
                    case 35: {
                        fragmentClass = Fragment36.class;
                        break;
                    }
                    case 36: {
                        fragmentClass = Fragment37.class;
                        break;
                    }
                    case 37: {
                        fragmentClass = Fragment38.class;
                        break;
                    }
                    case 38: {
                        fragmentClass = Fragment39.class;
                        break;
                    }
                    case 39: {
                        fragmentClass = Fragment40.class;
                        break;
                    }
                    case 40: {
                        fragmentClass = Fragment41.class;
                        break;
                    }
                    case 41: {
                        fragmentClass = Fragment42.class;
                        break;
                    }
                    case 42: {
                        fragmentClass = Fragment43.class;
                        break;
                    }
                    case 43: {
                        fragmentClass = Fragment44.class;
                        break;
                    }
                    case 44: {
                        fragmentClass = Fragment45.class;
                        break;
                    }
                    case 45: {
                        fragmentClass = Fragment46.class;
                        break;
                    }
                    case 46: {
                        fragmentClass = Fragment47.class;
                        break;
                    }
                    case 47: {
                        fragmentClass = Fragment48.class;
                        break;
                    }
                    case 48: {
                        fragmentClass = Fragment49.class;
                        break;
                    }
                    case 49: {
                        fragmentClass = Fragment50.class;
                        break;
                    }
                    case 50: {
                        fragmentClass = Fragment51.class;
                        break;
                    }
                    case 51: {
                        fragmentClass = Fragment52.class;
                        break;
                    }
                    case 52: {
                        fragmentClass = Fragment53.class;
                        break;
                    }
                    case 53: {
                        fragmentClass = Fragment54.class;
                        break;
                    }
                    case 54: {
                        fragmentClass = Fragment55.class;
                        break;
                    }
                    case 55: {
                        fragmentClass = Fragment56.class;
                        break;
                    }
                    case 56: {
                        fragmentClass = Fragment57.class;
                        break;
                    }
                    case 57: {
                        fragmentClass = Fragment58.class;
                        break;
                    }
                    case 58: {
                        fragmentClass = Fragment59.class;
                        break;
                    }
                    case 59: {
                        fragmentClass = Fragment60.class;
                        break;
                    }
                    case 60: {
                        fragmentClass = Fragment61.class;
                        break;
                    }
                    case 61: {
                        fragmentClass = Fragment62.class;
                        break;
                    }
                    case 62: {
                        fragmentClass = Fragment63.class;
                        break;
                    }
                    case 63: {
                        fragmentClass = Fragment64.class;
                        break;
                    }
                    case 64: {
                        fragmentClass = Fragment65.class;
                        break;
                    }
                    case 65: {
                        fragmentClass = Fragment66.class;
                        break;
                    }
                    case 66: {
                        fragmentClass = Fragment67.class;
                        break;
                    }
                    case 67: {
                        fragmentClass = Fragment68.class;
                        break;
                    }
                    case 68: {
                        fragmentClass = Fragment69.class;
                        break;
                    }
                    case 69: {
                        fragmentClass = Fragment70.class;
                        break;
                    }
                    case 70: {
                        fragmentClass = Fragment71.class;
                        break;
                    }
                    case 71: {
                        fragmentClass = Fragment72.class;
                        break;
                    }
                    case 72: {
                        fragmentClass = Fragment73.class;
                        break;
                    }
                    case 73: {
                        fragmentClass = Fragment74.class;
                        break;
                    }
                    case 74: {
                        fragmentClass = Fragment75.class;
                        break;
                    }
                    case 75: {
                        fragmentClass = Fragment76.class;
                        break;
                    }
                    case 76: {
                        fragmentClass = Fragment77.class;
                        break;
                    }
                    case 77: {
                        fragmentClass = Fragment78.class;
                        break;
                    }
                    case 78: {
                        fragmentClass = Fragment79.class;
                        break;
                    }
                    case 79: {
                        fragmentClass = Fragment80.class;
                        break;
                    }
                    case 80: {
                        fragmentClass = Fragment81.class;
                        break;
                    }
                    case 81: {
                        fragmentClass = Fragment82.class;
                        break;
                    }
                    case 82: {
                        fragmentClass = Fragment83.class;
                        break;
                    }
                    case 83: {
                        fragmentClass = Fragment84.class;
                        break;
                    }
                    case 84: {
                        fragmentClass = Fragment85.class;
                        break;
                    }
                    case 85: {
                        fragmentClass = Fragment86.class;
                        break;
                    }
                    case 86: {
                        fragmentClass = Fragment87.class;
                        break;
                    }
                    case 87: {
                        fragmentClass = Fragment88.class;
                        break;
                    }
                    case 88: {
                        fragmentClass = Fragment89.class;
                        break;
                    }
                    case 89: {
                        fragmentClass = Fragment90.class;
                        break;
                    }
                    case 90: {
                        fragmentClass = Fragment91.class;
                        break;
                    }
                    case 91: {
                        fragmentClass = Fragment92.class;
                        break;
                    }
                    case 92: {
                        fragmentClass = Fragment93.class;
                        break;
                    }
                    case 93: {
                        fragmentClass = Fragment94.class;
                        break;
                    }
                    case 94: {
                        fragmentClass = Fragment95.class;
                        break;
                    }
                    case 95: {
                        fragmentClass = Fragment96.class;
                        break;
                    }
                    case 96: {
                        fragmentClass = Fragment97.class;
                        break;
                    }
                    case 97: {
                        fragmentClass = Fragment98.class;
                        break;
                    }
                    case 98: {
                        fragmentClass = Fragment99.class;
                        break;
                    }
                    case 99: {
                        fragmentClass = Fragment100.class;
                        break;
                    }
                    case 100: {
                        fragmentClass = Fragment101.class;
                        break;
                    }
                    case 101: {
                        fragmentClass = Fragment102.class;
                        break;
                    }
                    case 102: {
                        fragmentClass = Fragment103.class;
                        break;
                    }
                    case 103: {
                        fragmentClass = Fragment104.class;
                        break;
                    }
                    case 104: {
                        fragmentClass = Fragment105.class;
                        break;
                    }
                    case 105: {
                        fragmentClass = Fragment106.class;
                        break;
                    }
                    case 106: {
                        fragmentClass = Fragment107.class;
                        break;
                    }
                    case 107: {
                        fragmentClass = Fragment108.class;
                        break;
                    }
                    case 108: {
                        fragmentClass = Fragment109.class;
                        break;
                    }
                    case 109: {
                        fragmentClass = Fragment110.class;
                        break;
                    }
                    case 110: {
                        fragmentClass = Fragment111.class;
                        break;
                    }
                    case 111: {
                        fragmentClass = Fragment112.class;
                        break;
                    }
                    case 112: {
                        fragmentClass = Fragment113.class;
                        break;
                    }*/
                }


                SNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

                    @Override
                    public void onDrawerOpened() {

                    }

                    @Override
                    public void onDrawerOpening(){

                    }

                    @Override
                    public void onDrawerClosing(){
                        System.out.println("Drawer closed");

                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.framelayout, fragment).commit();

                        }
                    }

                    @Override
                    public void onDrawerClosed() {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        System.out.println("State "+newState);
                    }
                });
            }
        });

    }
}