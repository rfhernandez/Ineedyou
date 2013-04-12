package app.ineedyou.Visuales;


import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import app.ineedyou.R;
import app.ineedyou.Auxiliares.Posicion;

public class Ineedyou {
	
	public Ineedyou (final Activity actividad) {
		Button enviarboton = (Button)actividad.findViewById(R.id.enviarboton);
		enviarboton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String solicitud = ((EditText)actividad.findViewById(R.id.solicitud)).getText().toString();
				
				Posicion.get(v.getContext());
				
				Toast.makeText(v.getContext(), "Your message has been send", Toast.LENGTH_SHORT).show();
			}
		});
		
	}
}
