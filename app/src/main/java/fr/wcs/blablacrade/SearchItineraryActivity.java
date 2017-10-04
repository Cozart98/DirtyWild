package fr.wcs.blablacrade;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText editDeparture = (EditText) findViewById(R.id.editTextDeparture);
        final EditText editDestination = (EditText) findViewById(R.id.editTextDestination);
        final EditText editDate = (EditText) findViewById(R.id.editTextDate);
        Button buttonSearch = (Button) findViewById(R.id.buttonSearch);

    //an action is added to the click for change of page but if a field is empty we make toast
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textDeparture = editDeparture.getText().toString();
                String textDestination = editDestination.getText().toString();
                String textDate = editDate.getText().toString();

                if (textDeparture.isEmpty() || textDestination.isEmpty()
                        ) {
                    Toast toastChampVide = Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.form_error), Toast.LENGTH_SHORT);
                    toastChampVide.show();
                }else {
                    Intent intent =
                            new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);

                    SearchRequestModel searchRequest =
                            new SearchRequestModel(textDeparture, textDestination, textDate);
                    intent.putExtra("searchRequest", searchRequest);

                    SearchItineraryActivity.this.startActivity(intent);
                }
            }
        });

        //here a calendar is incremented
        final Calendar calendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view,int year,int month,int day){
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                UpdateLabel(editDate, calendar);
            }};
        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SearchItineraryActivity.this,
                        dateListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH))
                        .show();
            }
        });
    }


    private void UpdateLabel(EditText textDate, Calendar myCalendar) {
        String formatDate = "dd/MM/yyyy";


        SimpleDateFormat sdf = new SimpleDateFormat(formatDate, Locale.FRANCE);

        //here we retrieving the selected content
        textDate.setText(sdf.format(myCalendar.getTime()));
    }
}
