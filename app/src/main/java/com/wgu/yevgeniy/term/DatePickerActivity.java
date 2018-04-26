package com.wgu.yevgeniy.term;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class DatePickerActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    //private DatePickerDialog.OnDateSetListener datePickerListener;
    private DatePickerDialog datePickerDialog;
    String title;
    String dateString;
    String dateType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_date_picker);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title = extras.getString("title");
            dateType = extras.getString("dateType");

            Log.i("term", "in date picker activity" +  dateType);
            //Toast.makeText(MainActivity.this, termName, Toast.LENGTH_SHORT).show();
        }

        datePickerDialog = createDatePickerDialog();
        datePickerDialog.show();
        Log.i("term","afer date picker");

    }

    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
        String year1 = String.valueOf(selectedYear);
        String month1 = String.valueOf(selectedMonth + 1);
        String day1 = String.valueOf(selectedDay);
        //EditText tvDt = (EditText) findViewById(R.id.termStartDate);
        Log.i("term","got tvDt");
        //tvDt.setText(day1 + "/" + month1 + "/" + year1);
        dateString = day1 + "/" + month1 + "/" + year1;
        //datePickerDialog.
        backAddTermActivityOK();
    }



    DatePickerDialog createDatePickerDialog() {
        final DatePickerActivity parent = this;
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        DatePickerDialog datePicker = new DatePickerDialog(this,
                R.style.AppTheme,
                this,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));

        datePicker.setCancelable(false);
        datePicker.setTitle(title);

        datePicker.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Log.i("term","got cancel");
                parent.finish();
            }
        });

        return datePicker;
    }

    void backAddTermActivityOK() {
        //Intent i;
        //i = new Intent(this, AddTermActivity.class);

        //i.putExtra("dateString", dateString);
        //i.putExtra("termName","hello there");
        Intent returnIntent = new Intent();
        returnIntent.putExtra("dateType",dateType);
        returnIntent.putExtra("dateString",dateString);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }


}
