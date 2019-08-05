package com.example.hajeri;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.hajeri.adapters.ClassesAdapter;
import com.example.hajeri.database.ClassesDBHelper;
import com.example.hajeri.database.StudentContract;
import com.example.hajeri.models.ClassesModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private List<ClassesModel> cList;
    private ClassesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.classes_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cList = new ArrayList<>();
        adapter = new ClassesAdapter(this,cList);
        recyclerView.setAdapter(adapter);

        fetchData();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CreateClass.class));
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void fetchData() {

        ClassesDBHelper classesDBHelper = new ClassesDBHelper(this);
        SQLiteDatabase db = classesDBHelper.getReadableDatabase();
        Cursor cursor = classesDBHelper.readClasses(db);

        if (cursor!=null) {

            while (cursor.moveToNext()) {
                String classname = cursor.getString(cursor.getColumnIndex(StudentContract.ClassEntry.CLASS_NAME));
                String teachername = cursor.getString(cursor.getColumnIndex(StudentContract.ClassEntry.TEACHER_NAME));
                String start_date = cursor.getString(cursor.getColumnIndex(StudentContract.ClassEntry.START_DATE));
                String end_date = cursor.getString(cursor.getColumnIndex(StudentContract.ClassEntry.END_DATE));
                String organization = cursor.getString(cursor.getColumnIndex(StudentContract.ClassEntry.ORGANIZATION));
                String number_of_students = Integer.toString(cursor.getInt(cursor.getColumnIndex(StudentContract.ClassEntry.NUMBER_OF_STUDENTS)));
                String division = cursor.getString(cursor.getColumnIndex(StudentContract.ClassEntry.DIVISION));

                ClassesModel model = new ClassesModel();

                model.setCLASS_NAME(classname);
                model.setTEACHER_NAME(teachername);
                model.setSTART_DATE(start_date);
                model.setEND_DATE(end_date);
                model.setORGANIZATION(organization);
                model.setNUMBER_OF_STUDENTS(number_of_students);
                model.setDIVISION(division);

                cList.add(model);
                adapter.notifyDataSetChanged();
            }
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
