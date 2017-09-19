package com.example.android.jindalfresh.app_activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.app_activities.auth.LoginFragment;
import com.example.android.jindalfresh.app_activities.home.HomeFragment;
import com.example.android.jindalfresh.app_activities.share.ShareFragment;
import com.example.android.jindalfresh.app_activities.viewOrder.ViewOrderFragment;
import com.example.android.jindalfresh.database.DBHelper;
import com.example.android.jindalfresh.generic.AppData;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    private DBHelper dbHelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppData.initiateAppData(this);

        setToolBar();
        fragmentStart();
        setUpNavigation();

    }

    private void setUpNavigation() {
        navigationView = (NavigationView) findViewById(R.id.naviagation_view);

        //navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);

//View view=navigationView.inflateHeaderView(R.layout.navigation_drawer_header);
            TextView navigationHeaderTextViewEmail = (TextView)header.findViewById(R.id.navigation_header_text_view_emmail_id);

        //Log.v("ABCDE",AppData.getUserModelToken().hasToken()+dbHelper.getEmail());
        if (AppData.getUserModelToken().hasToken()) {
            navigationHeaderTextViewEmail.setText(dbHelper.getEmail());

            Log.v("ABCDE",AppData.getUserModelToken().hasToken()+dbHelper.getEmail());
        }
//





        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home");
                        item.setChecked(true);
                        getSupportActionBar().setHomeButtonEnabled(true);
                        drawerLayout.closeDrawer(navigationView);
                        break;
                    case R.id.search:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, new ViewOrderFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Search");
                        item.setChecked(true);
                        getSupportActionBar().setHomeButtonEnabled(true);
                        drawerLayout.closeDrawer(navigationView);
                        break;
                    case R.id.share:
//                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.frame_layout, new ShareFragment());
//                        fragmentTransaction.commit();

                        Intent intent = new Intent(MainActivity.this, ShareFragment.class);
                        startActivity(intent);
                        getSupportActionBar().isShowing();
                        getSupportActionBar().setTitle("Share");
                        item.setChecked(true);
                        drawerLayout.closeDrawer(navigationView);
                        break;
                    case R.id.setting:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, new LoginFragment());
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
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home");
    }

    private void setToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
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
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();
        if (res_id == R.id.action_logout) {

            dbHelper.deleteTokens();

            if (AppData.getUserModelToken().hasToken()) {
                Toast.makeText(this, "Failed to logout" , Toast.LENGTH_SHORT).show();

            }
             else {
                Toast.makeText(this, "Successfully logged out" , Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }


}
