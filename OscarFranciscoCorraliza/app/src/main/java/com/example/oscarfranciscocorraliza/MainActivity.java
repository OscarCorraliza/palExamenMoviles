package com.example.oscarfranciscocorraliza;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.oscarfranciscocorraliza.fragments.HabitatFragment;
import com.example.oscarfranciscocorraliza.fragments.HomeFragment;
import com.example.oscarfranciscocorraliza.fragments.TipoFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private NavigationView navView;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navView = findViewById(R.id.nav_view);

        setToolbar();
        setFragment(0);
        if (navView != null) {
            navView.setNavigationItemSelectedListener(this);
        }
    }

    private void setToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_squirtle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_layout);
        if(item.getItemId() == android.R.id.home){
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
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
        FragmentManager manager = getSupportFragmentManager();

        switch(fragmentNum){
            case 0:
                fragment = new HomeFragment();
                manager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
                break;
            case 1:
                fragment = new HabitatFragment();
                manager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
                break;
            case 2:
                fragment = new TipoFragment();
                manager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
                break;
        }
    }


}