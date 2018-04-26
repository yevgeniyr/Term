package com.wgu.yevgeniy.term;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.TextView;

public class AddTermActivity extends AppCompatActivity {
    TextView termStartDate;
    TextView termEndDate;
    EditText termName;
    final int REQUEST_CODE = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //startActivityF
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_term);

        termName = (EditText) findViewById(R.id.termName);
        termStartDate = (TextView) findViewById(R.id.termStartDate);
        termEndDate = (TextView) findViewById(R.id.termEndDate);

        termStartDate.setOnClickListener(createOnClickListener("Pick term's start date", "startDate"));
        termEndDate.setOnClickListener(createOnClickListener("Pick term's end date", "endDate"));

    }

    View.OnClickListener createOnClickListener(final String title, final String dateType) {
        final AddTermActivity athis = this;
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(athis, DatePickerActivity.class);

                i.putExtra("title", title);
                i.putExtra("dateType", dateType);

                athis.startActivityForResult(i, REQUEST_CODE);

            }
        };
    }

    public void onClickAddNewTerm(View view) {
        Log.i("term","addNewTerm in AddTermctivity");
        Intent returnIntent = new Intent();
        returnIntent.putExtra("termName", termName.getText().toString());
        returnIntent.putExtra("startDate", termStartDate.getText().toString());
        returnIntent.putExtra("endDate", termEndDate.getText().toString());
        setResult(Activity.RESULT_OK, returnIntent);
        Log.i("term","about to finish onclickaddnewterm");
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if ((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)) {
            // Make sure the request was successful

            String dateString = data.getStringExtra("dateString");
            Log.i("term", "in madd term activity" + dateString);
            //Toast.makeText(AddTermActivity.this, dateString, Toast.LENGTH_SHORT).show();
            if (data.getStringExtra("dateType").equals("startDate")) {
                termStartDate.setText(dateString);
            }

            if (data.getStringExtra("dateType").equals("endDate")) {
                termEndDate.setText(dateString);
            }

        }
    }
}
