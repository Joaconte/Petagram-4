package jcg.petagram.vista.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import jcg.petagram.adapter.PageAdapter;
import jcg.petagram.R;
import jcg.petagram.vista.fragment.*;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        setUpViewPager();

        Intent intent = new Intent(MainActivity.this, MascotasFavoritasActivity.class);

    }


    private ArrayList<Fragment> agregarFragments(){
       fragments = new ArrayList<>();

        fragments.add( 0 , new HomeFragment());
        fragments.add(new ProfileFragment());

        return  fragments;
    }

    private void setUpViewPager(){

        fragments = agregarFragments();
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.profile_icon);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;

        switch (item.getItemId()){
            case R.id.mContacto:
                intent = new Intent(this, FormularioActivity.class);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                intent = new Intent(this, BiografiaAutorActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickIrAMascotasFavoritas(View target) {

        Intent intent = new Intent(MainActivity.this, MascotasFavoritasActivity.class);
        HomeFragment homeFragment = (HomeFragment) fragments.get(0);
        intent.putExtra("mascotas", homeFragment.getMascotasFavoritas());
        startActivity(intent);
    }

}