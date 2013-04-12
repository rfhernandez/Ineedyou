package app.ineedyou.Auxiliares;

import app.ineedyou.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends ArrayAdapter<Fila>{
	private Activity actividad;
	private Fila[] datos;

	public Adaptador (Activity actividad, Fila[] datos) {
		super(actividad, R.layout.item, datos);
		this.actividad = actividad;
		this.datos = datos;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = actividad.getLayoutInflater();
		View item = inflater.inflate(R.layout.item, null);
		
		ImageView imagen = (ImageView)item.findViewById(R.id.imagenitem);
		imagen.setImageResource(datos[position].getImagen());

		TextView lblTitulo = (TextView)item.findViewById(R.id.nombre);
		lblTitulo.setText(datos[position].getNombre());

		TextView lblSubtitulo = (TextView)item.findViewById(R.id.descripcion);
		lblSubtitulo.setText(datos[position].getIndicacion());

		return(item);
	}
}
