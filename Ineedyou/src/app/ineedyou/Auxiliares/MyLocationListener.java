package app.ineedyou.Auxiliares;

import android.content.Context;
import android.location.*;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyLocationListener implements LocationListener{
	private Context contexto;
	
	public MyLocationListener(Context contexto) {
		this.contexto = contexto;
	}

	@Override
	public void onLocationChanged(Location location) {
		mostrarPosicion(location);
	}

	@Override
	public void onProviderDisabled(String provider) {
		Toast.makeText(contexto, "Provider OFF", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onProviderEnabled(String provider) {
		Toast.makeText(contexto, "Provider ON", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		Log.i("LocAndroid", "Provider Status: " + status);
		Toast.makeText(contexto, "Provider Status: " + status, Toast.LENGTH_SHORT).show();
	}
	
	private void mostrarPosicion(Location location) {
		if(location != null)
	    {
	    	Toast.makeText(contexto, 
	    			"Latitud: " + String.valueOf(location.getLatitude()) + "\n" +
	    			"Longitud: " + String.valueOf(location.getLongitude()) + "\n" +
	    			"Precision: " + String.valueOf(location.getAccuracy()),
					Toast.LENGTH_SHORT).show();
	    	Log.i("LocAndroid", String.valueOf(
					location.getLatitude() + " - " + String.valueOf(location.getLongitude())));
	    }
	    else
	    {
	    	Toast.makeText(contexto, 
	    			"Latitud: " + "vacio\n" + 
	    			"Longitud: " + "vacio\n" +
	    			"Precision: " + "vacio",
					Toast.LENGTH_SHORT).show();
	    }
	}
}
