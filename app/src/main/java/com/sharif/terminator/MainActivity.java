package com.sharif.terminator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SelectListener{
    private int chosenDepartment = 0;
    private RecyclerView recyclerView;
    private ArrayList<Department> departments = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDepartments();
        addItemsFromJSON();
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        updateAdapter();
        setupSpinner();
    }

    private void updateAdapter() {
        adapter = new RecyclerAdapter(this, departments.get(chosenDepartment).getCourses(), this);
        recyclerView.setAdapter(adapter);
    }

    private void setupSpinner() {
        Spinner spinner = findViewById(R.id.spinner);
        ArrayList<String> departmentNames = Department.getDepartmentNames();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                departmentNames);
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                chosenDepartment = i;
                updateAdapter();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void initializeDepartments() {
        departments.add(new Department(R.raw.d3, "دانشکده ریاضی"));
        departments.add(new Department(R.raw.d5, "دانشکده فیزیک"));
        departments.add(new Department(R.raw.d38, "دانشکده کامپیوتر"));
    }


    private void addItemsFromJSON() {
        try {

            for (int j = 0; j < departments.size(); j++) {
                Department department = departments.get(j);
                String jsonDataString = readJSONDataFromFile(department.getFile_name());
                JSONArray jsonArray = new JSONArray(jsonDataString);

                for (int i = 0; i < jsonArray.length(); ++i) {
                    JSONObject itemObj = jsonArray.getJSONObject(i);

                    String info = itemObj.getString("info");
                    String course_id = itemObj.getString("course_id");
                    String course_number = itemObj.getString("course_number");
                    String name = itemObj.getString("name");
                    int units = itemObj.getInt("units");
                    int capacity = itemObj.getInt("capacity");
                    String instructor = itemObj.getString("instructor");
                    String class_times = itemObj.getString("class_times");
                    int id = itemObj.getInt("id");
                    String exam_time = itemObj.getString("exam_time");

                    Course course = new Course(info, course_id, course_number, name, units, capacity, instructor, class_times, id, exam_time);
                    department.addCourse(course);
                }

            }

        } catch (JSONException | IOException e) {
            Log.d("MainActivity", "addItemsFromJSON: ", e);
        }
    }


    private String readJSONDataFromFile(int resourceName) throws IOException {

        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {

            String jsonString;
            inputStream = getResources().openRawResource(resourceName);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            while ((jsonString = bufferedReader.readLine()) != null) {
                builder.append(jsonString);
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return new String(builder);
    }

    @Override
    public void onItemClicked(Course course) {
        //TODO: Convert "class_times" attribute from json format to human-readable format
        String message = String.format("%s" + '\n' +
                        "واحد: " + "%d" + '\n' +
                        "ظرفیت: " + "%d" + '\n' +
                        "زمان برگزاری: " + "%s" + '\n' +
                        "زمان امتحان: " + "%s",
                course.getInfo(), course.getUnits(), course.getCapacity(), course.getClass_times(), course.getExam_time());
        new AlertDialog.Builder(this, R.style.AlertDialogCustom)
                .setTitle(course.getName())
                .setMessage(message)
                .setPositiveButton("اضافه کن", (dialogInterface, i) -> {
                    //TODO
                })
                .setNegativeButton("لغو", null)
                .show();
    }
}