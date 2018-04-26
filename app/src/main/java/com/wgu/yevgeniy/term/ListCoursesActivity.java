package com.wgu.yevgeniy.term;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListCoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_courses);


        Bundle termData = getIntent().getExtras();
        if (termData == null) {
            return;

        }
        String termName = termData.getString("term");

        Term term = MainActivity.termArrayList.get( MainActivity.termArrayList.indexOf(new Term(termName)));



        //List<String> coursesArrayList = new ArrayList<>();
        //coursesArrayList.add(term);

        ListAdapter courseAdapter;
        courseAdapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, term.getCourses());

        ListView coursesList = findViewById(R.id.coursesListView);


        coursesList.setAdapter(courseAdapter);

        coursesList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String termName = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(ListCoursesActivity.this, termName, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
