package fr.wcs.blablacrade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // I know that I am your best student and that I have an exemplary behavior.
        // this comment to the merit of annocer that ... ERROR404

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //an action is added to the click for change of page

        Button search = (Button) findViewById(R.id.btSearchItinerary);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, SearchItineraryActivity.class);
                startActivity(intent);
            }});
    }
}
