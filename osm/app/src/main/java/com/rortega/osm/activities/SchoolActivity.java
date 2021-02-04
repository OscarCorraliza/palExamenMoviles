package com.rortega.osm.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.rortega.osm.R;
import com.rortega.osm.impl.ViewAdapter;
import com.rortega.osm.common.HttpGetPettition;
import com.rortega.osm.domain.HttpLocation;

import java.util.List;

import static com.rortega.osm.common.Constants.DESCRIPTION;
import static com.rortega.osm.common.Constants.DESCRIPTION_KEY;
import static com.rortega.osm.common.Constants.LATITUDE;
import static com.rortega.osm.common.Constants.LONGITUDE;
import static com.rortega.osm.common.Constants.TITLE;

public class SchoolActivity extends AppCompatActivity {

    public final String TAG = getClass().getName();
    private ViewAdapter mViewAdapter;
    private ListView mListView = null;
    private List<HttpLocation> httpLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        mListView = findViewById(R.id.listView);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent locationSchoolIntent = new Intent(getApplicationContext(),OsmActivity.class);
                locationSchoolIntent.putExtra(TITLE,httpLocations.get(i).getTitle());
                locationSchoolIntent.putExtra(DESCRIPTION_KEY,DESCRIPTION);
                locationSchoolIntent.putExtra(LATITUDE,httpLocations.get(i).getLatitude());
                locationSchoolIntent.putExtra(LONGITUDE,httpLocations.get(i).getLongitude());
                startActivity(locationSchoolIntent);
            }
        });

        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
    }

    public class MyAsyncTask extends AsyncTask<Void,Integer,String> {

        @Override
        protected String doInBackground(Void... voids) {
            HttpGetPettition httpGetPettition = new HttpGetPettition();
            httpLocations = httpGetPettition.gethttpPettitonLocation();
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mViewAdapter = new ViewAdapter(SchoolActivity.this,R.layout.activity_school,httpLocations);
            mListView.setAdapter(mViewAdapter);
            mViewAdapter.notifyDataSetChanged();
        }
    }
}