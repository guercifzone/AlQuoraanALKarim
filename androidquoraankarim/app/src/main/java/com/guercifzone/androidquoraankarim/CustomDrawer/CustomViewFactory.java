package com.guercifzone.androidquoraankarim.CustomDrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomViewFactory implements LayoutInflater.Factory {
    private static CustomViewFactory minstance;
    public static CustomViewFactory getInstance() {
        if (minstance == null) {
            minstance = new CustomViewFactory();
        }
        return minstance;
    }
    private CustomViewFactory() {}
    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
    if (SNavigationDrawer.class.getSimpleName().equals(name)){
        return new SNavigationDrawer(context, attrs);
    }
        return null;
    }
}
