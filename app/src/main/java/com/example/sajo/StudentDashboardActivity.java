package com.example.sajo;

import android.content.Intent;
import android.os.Bundle;

import com.example.sajo.adapter.organisation_post_adap;
import com.example.sajo.data.model.organisation_post;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class StudentDashboardActivity extends AppCompatActivity {
    private TextView mTextMessage;
    ArrayList<organisation_post> organisationPostArrayList ;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_about:
                  startActivity(new Intent(getApplicationContext(),AboutActivity.class));
                    return true;
            }
            return false;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_student_dashboard);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        RecyclerView recyclerView = findViewById(R.id.posts_recycler);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        organisationPostArrayList =new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        organisation_post organisation_post1 = new organisation_post(R.drawable.display_img,"helping hands","helping hand international a one time biz for enriching young minds base on networking");
        organisation_post organisation_post2 = new organisation_post(R.drawable.display_img,"world bank","helping hand international a one time biz for enriching young minds base on networking");
        organisation_post organisation_post3 = new organisation_post(R.drawable.display_img,"diamond bank","helping hand international a one time biz for enriching young minds base on networking");
        organisation_post organisation_post4 = new organisation_post(R.drawable.display_img,"hotel ng","helping hand international a one time biz for enriching young minds base on networking");
        organisation_post organisation_post5 = new organisation_post(R.drawable.display_img,"start.ng ","helping hand international a one time biz for enriching young minds base on networking");
        organisation_post organisation_post6 = new organisation_post(R.drawable.display_img,"helping hands","helping hand international a one time biz for enriching young minds base on networking");

        organisationPostArrayList.add(organisation_post1);
        organisationPostArrayList.add(organisation_post2);
        organisationPostArrayList.add(organisation_post3);
        organisationPostArrayList.add(organisation_post4);
        organisationPostArrayList.add(organisation_post5);
        organisationPostArrayList.add(organisation_post6);


        organisation_post_adap  organisation_post_adap = new organisation_post_adap(getApplicationContext(),organisationPostArrayList);
        recyclerView.setAdapter(organisation_post_adap);
    }


}

