package app.ineedyou.Visuales;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import app.ineedyou.HospitalActivity;
import app.ineedyou.R;
import app.ineedyou.Auxiliares.Adaptador;
import app.ineedyou.Auxiliares.Fila;
import app.ineedyou.Auxiliares.Peticion;

public class Emergencias {
	final Fila[] datos = new Fila[]{new Fila(R.drawable.hospital, "Hospital", "Find the nearest hospital"),
			new Fila(R.drawable.ambulance, "Ambulance", "Call an ambulance urgently"),
			new Fila(R.drawable.police, "Police", "Call the police"),
			new Fila(R.drawable.fire, "Firefighters", "Call the firemen quickly")};

	public Emergencias (final Activity actividad) {
		Adaptador adaptador = new Adaptador(actividad, datos);
		ListView lista = (ListView)actividad.findViewById(R.id.opc1);
		lista.setAdapter(adaptador);
		
		lista.setOnItemClickListener(new ListView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int posicion, long id) {
				switch(posicion) {
				case 0:
					Intent intent = new Intent(actividad, HospitalActivity.class);
					actividad.startActivity(intent);
					break;
				case 1:
					Peticion.crearDialogoConfirmacion(actividad).show();
					break;
				case 2:
					Peticion.crearDialogoConfirmacion(actividad).show();
					break;
				case 3:
					Peticion.crearDialogoConfirmacion(actividad).show();
					break;
				}
			}
		});
	}
}
