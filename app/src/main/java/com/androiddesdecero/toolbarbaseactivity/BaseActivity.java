package com.androiddesdecero.toolbarbaseactivity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by albertopalomarrobledo on 2/11/18.
 */

public class BaseActivity extends AppCompatActivity {
    private ImageButton imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setCustomView(R.layout.toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME
                | ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar);

        Toolbar toolbar = (Toolbar) getSupportActionBar().getCustomView().getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.setPadding(0, 0, 0, 0);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        showHomeUpIcon();
        setUpHomeUpIconAndColor(R.drawable.ic_cake_black_24dp, R.color.colorWhiteApp);

        imageView = toolbar.findViewById(R.id.toobar_image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "prueba botón");

            }
        });
    }

    //Se ejecuta cuando se pulsa el boton Navigate Up
    @Override
    public boolean onSupportNavigateUp() {
        Log.d("TAG", "homeButton - onSupportNavigateUp");
        return true;
    }

    protected void hideActionBar(){
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void showActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
        }
    }

    /*
    setDisplayHomeAsUpEnabled(true) -> Este método nos muestra el icono y además que se pueda presionar.
    Pero para implementar funcionalidad hay 3 opcione
    1.- Añadir en el manifest android: parentActivityName
    2.- Implementar setNavigationOnclikcListener
    3.- @Override public boolean onSupportNavigateUp() {}
     */
    public void showHomeUpIcon() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void hideHomeUpIcon() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    //Para poner el color y el Icono de Home
    private void setUpHomeUpIconAndColor(int drawable, int color){
        if (getSupportActionBar() != null) {
            final Drawable upArrow = getResources().getDrawable(drawable);
            upArrow.setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
        }
    }

    private void customTitleToolBar(){
        if (getSupportActionBar() != null) {
            //Movemos el titulo por defecto de la Toolbar
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            //TextView textView = toolbar.findViewById(R.id.toolbar_title);
        }
    }

    protected void changeColorMenuIcon(){
        imageView.setColorFilter(getResources().getColor(R.color.colorPrimary));
    }

    protected void hideMenuIcon(){
        imageView.setVisibility(View.GONE);
    }
}
