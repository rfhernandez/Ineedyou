package app.ineedyou.Auxiliares;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import app.ineedyou.R;

public class MapActivity extends Activity{
	private MapView mapView;
    private MapController mapController;

    private LinearLayout searchPanel;
    private Button searchButton;
    private EditText searchText;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		//Habilitamos los controles de zoom
        mapView = (MapView)findViewById(R.id.mapView);
        mapView.setBuiltInZoomControls(true);
        
        searchPanel = (LinearLayout)findViewById(R.id.searchPanel);
        searchButton = (Button)findViewById(R.id.searchButton);
        searchText = (EditText)findViewById(R.id.searchText);
        
        mapController = mapView.getController();
        mapController.setZoom(2);
        
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String searchFor = searchText.getText().toString();
                JSONArray results = searchLocation(searchFor);

                if (results.length() > 0) {
                    try {
                        JSONObject firstResult = (JSONObject)results.get(0);
                        Double lat = firstResult.getDouble("lat");
                        Double lon = firstResult.getDouble("lon");

                        GeoPoint point = new GeoPoint((int) (lat * 1E6),
                                                      (int) (lon * 1E6));
                        mapController.setZoom(15);
                        mapController.setCenter(point);

                        mapView.invalidate();

                    } catch (JSONException e) {
                        Log.e("OnClickListener", e.getMessage());
                    }
                } else {
                    Toast.makeText(view.getContext(), 
                                   "No results found", 
                                   Toast.LENGTH_SHORT).show();
                }
            }
        });
	}
	
	/*
     * Encargado de buscar la localización de una consulta
     * 
     * Retorna un JSONArray, clase encargada del tratamiento del fichero JSON que 
     * devuelve openstreetmap
     * 
     */
    public JSONArray searchLocation(String query) {
        JSONArray results = new JSONArray();

        try {
            query = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return results;
        }
        String url = "http://nominatim.openstreetmap.org/search?";
        url += "q=" + query;
        url += "&format=json";

        HttpGet httpGet = new HttpGet(url);
        Log.i("httpget", httpGet.getURI().getPath());
        DefaultHttpClient httpClient = new DefaultHttpClient();

        try {
            HttpResponse response = httpClient.execute(httpGet);
            Log.i("response", response.toString());
            String content = EntityUtils.toString(response.getEntity(), "utf-8");
            results = new JSONArray(content);

        } catch (Exception e) {
            Log.e("searchLocation", 
                  "Error executing url: " + url + "; " + e.getMessage());
        }

        return results;
    }
}
