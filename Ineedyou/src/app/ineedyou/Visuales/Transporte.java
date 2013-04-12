package app.ineedyou.Visuales;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import app.ineedyou.R;
import app.ineedyou.RentCarActivity;
import app.ineedyou.TurBusActivity;
import app.ineedyou.Auxiliares.Adaptador;
import app.ineedyou.Auxiliares.Fila;
import app.ineedyou.Auxiliares.Peticion;

public class Transporte {
	final Fila[] datos = new Fila[]{new Fila(R.drawable.taxi, "Taxi", "Call a Taxi now"),
			new Fila(R.drawable.renta, "Rent car", "Nearby car rentals"),
			new Fila(R.drawable.tur, "Tur Bus", "Take a stroll around the city"),
			new Fila(R.drawable.grua, "Tow", "Exit the issue quickly")};
	
	public Transporte(final Activity actividad) {
		Adaptador adaptador = new Adaptador(actividad, datos);
		ListView lista = (ListView)actividad.findViewById(R.id.opc2);
		lista.setAdapter(adaptador);
		
		lista.setOnItemClickListener(new ListView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int posicion, long id) {
				Intent intent;
				switch(posicion) {
				case 0:
					Peticion.crearDialogoConfirmacion(actividad).show();
					break;
				case 1:
					intent = new Intent(actividad, RentCarActivity.class);
					actividad.startActivity(intent);
					break;
				case 2:
					intent = new Intent(actividad, TurBusActivity.class);
					actividad.startActivity(intent);
					break;
				case 3:
					Peticion.crearDialogoConfirmacion(actividad).show();
					break;
				}
			}
		});
	}
}
