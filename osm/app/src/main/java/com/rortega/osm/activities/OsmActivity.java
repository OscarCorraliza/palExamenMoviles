package com.rortega.osm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

import com.rortega.osm.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

import static com.rortega.osm.common.Constants.DESCRIPTION_KEY;
import static com.rortega.osm.common.Constants.LATITUDE;
import static com.rortega.osm.common.Constants.LONGITUDE;
import static com.rortega.osm.common.Constants.TITLE;

public class OsmActivity extends AppCompatActivity {

    private final String TAG = getClass().getName();
    private MapView mMapView;
    private MapController mMapController;
    GeoPoint geoPointMyPosition;
    private ArrayList<OverlayItem> mOverlayItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osm);
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));

        Intent getDataIntent = getIntent();
        geoPointMyPosition = new GeoPoint(getDataIntent.getDoubleExtra(LATITUDE,0),getDataIntent.getDoubleExtra(LONGITUDE,0));
        generateOpenStreetMapViewAndMapController();

        boolean add = mOverlayItems.add(new OverlayItem(getDataIntent.getStringExtra(TITLE), getDataIntent.getStringExtra(DESCRIPTION_KEY), geoPointMyPosition));


        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(mOverlayItems, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return false;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                return false;
            }
        },getApplicationContext());

        mOverlay.setFocusItemsOnTap(true);
        mMapView.getOverlays().add(mOverlay);
    }


    public void generateOpenStreetMapViewAndMapController(){
        mMapView = (MapView) findViewById(R.id.openmapview);
        mMapView.setBuiltInZoomControls(true);
        mMapView.setMultiTouchControls(true);
        mMapController = (MapController) mMapView.getController();
        mMapController.setZoom(18);
        mMapController.setCenter(geoPointMyPosition);
    }
}