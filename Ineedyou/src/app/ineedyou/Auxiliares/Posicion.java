package app.ineedyou.Auxiliares;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.util.Log;

public class Posicion {
	static public double[] get(Context contexto) {
		double[] coordenadas = new double[2];
		
		//Se obtiene el gestor de localizaciones
		LocationManager manager = (LocationManager)contexto.getSystemService(Context.LOCATION_SERVICE);
				
		//Se determinan los requisitos de selección del mejor proveedor
		Criteria requisitos = new Criteria();
		//La precisión tiene que ser buena
		requisitos.setAccuracy(Criteria.ACCURACY_FINE);
		//Tiene que proporcionar altitud
		requisitos.setAltitudeRequired(true);
		
		//Mejor proveedor según los criterios especificados
		String mejorProveedor = manager.getBestProvider(requisitos, false);
		
		Log.i("GPS", mejorProveedor);
		
		//Permite "subscribirse" a los eventos del proveedor
		manager.requestLocationUpdates(mejorProveedor, 15000, 0, new MyLocationListener(contexto));
		
		return coordenadas;
	}
}
