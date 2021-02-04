package com.example.examen;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.examen.Fragements.HabitatFragment;
import com.example.examen.Fragements.HomeFragment;
import com.example.examen.Fragements.TipoFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView navigationView;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_view);

        setToolbar();

        setFragment(0);

        if(navigationView != null){
            navigationView.setNavigationItemSelectedListener(this);
        }

    }

    private void setToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_layout);
        if(item.getItemId() == android.R.id.home){
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.habitat:
                setFragment(1);
                break;
            case R.id.tipo:
                setFragment(2);
                break;
        }
        return false;
    }

    public void setFragment(int fragmentNum){
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch(fragmentNum){
            case 0:
                fragment = new HomeFragment();
                fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
                break;
            case 1:
                Log.d("entra", "entra");
                fragment = new HabitatFragment();
                fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
                break;
            case 2:
                fragment = new TipoFragment();
                fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
                break;
        }
    }
}