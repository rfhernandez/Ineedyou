package app.ineedyou.Auxiliares;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;

public class Peticion {
	
	public static Dialog crearDialogoConfirmacion(Context contexto)
	{
	    AlertDialog.Builder builder = new AlertDialog.Builder(contexto);

	    builder.setTitle("Confirmation");
	    builder.setMessage("Do you want to do this action really?");
	    builder.setPositiveButton("Acept", new OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			Log.i("Dialogos", "Confirmacion Aceptada.");
			dialog.cancel();
		}
	    });
	    builder.setNegativeButton("Cancel", new OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			Log.i("Dialogos", "Confirmacion Cancelada.");
			dialog.cancel();
		}
	    });

	    return builder.create();
	}
}
