package com.example.android.jindalfresh;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.jindalfresh.product.movieModel;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "Testing package", Toast.LENGTH_LONG).show();
        int test = new movieModel().getI();
        Toast.makeText(getApplicationContext(), "Success packg" + test, Toast.LENGTH_LONG).show();

        setToolBar();
        fragmentStart();
        setUpNavigation();

    }

    private void setUpNavigation() {
        navigationView=(NavigationView)findViewById(R.id.naviagation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout,new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home");
                        item.setChecked(true);
                        drawerLayout.closeDrawer(navigationView);
                        break;
                    case R.id.search:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout,new SearchFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Search");
                        item.setChecked(true);
                        drawerLayout.closeDrawer(navigationView);
                        break;
                    case R.id.share:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout,new ShareFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Share");
                        item.setChecked(true);
                        drawerLayout.closeDrawer(navigationView);
                        break;
                    case R.id.setting:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout,new SettingFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Setting");
                        item.setChecked(true);
                        drawerLayout.closeDrawer(navigationView);
                        break;

                }
                return true;
            }
        });
    }

    // ======================Navigation setup  methods==============================

    private void fragmentStart() {
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_layout,new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home");
    }

    private void setToolBar() {
         toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

    }


    // ======================Tool bar methods==============================

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id=item.getItemId();
        if(res_id==R.id.action_setting)
        {
            Toast.makeText(getApplicationContext(),"You select Setting",Toast.LENGTH_LONG).show();
        }
        return true;
    }
    // ====================================================
}
