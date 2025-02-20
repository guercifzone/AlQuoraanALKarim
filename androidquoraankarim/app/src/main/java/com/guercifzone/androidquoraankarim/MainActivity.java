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
import com.guercifzone.androidquoraankarim.UiFragment.Fragment1;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SNavigationDrawer SNavigationDrawer;
    int color1 = 0;
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
        menuItems.add(new MenuItem("",R.drawable.ic_launcher_background));

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
                switch (position){
                    case 0:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 1:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 2: {
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 3:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 4:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 5:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 6:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 7:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 8:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 9:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 10:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 11:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 12:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 13:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 14:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 15:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 16:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 17:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 18:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 19:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 20:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 21:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 22:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 23:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 24:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 25:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 26:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
                    case 27:{
                        fragmentClass = Fragment1.class;
                        break;
                    }
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