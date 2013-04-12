package app.ineedyou;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.TabHost;
import app.ineedyou.Visuales.Emergencias;
import app.ineedyou.Visuales.Ineedyou;
import app.ineedyou.Visuales.Transporte;

public class MainActivity extends Activity {
    public static final int SEARCH_ID = Menu.FIRST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Resources res = getResources();
        
        //Se obtiene una referencia del control principal
        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        //Se prepara para su configuración
        tabs.setup();
        
        //Se crean cada una de las pestañas
        CrearPestanna (tabs, "mitab1", R.id.tab1, "", res.getDrawable(R.drawable.emergency));
        new Emergencias(this);
        CrearPestanna (tabs, "mitab2", R.id.tab2, "", res.getDrawable(R.drawable.rueda));
        new Transporte(this);
        CrearPestanna (tabs, "mitab3", R.id.tab3, "", res.getDrawable(R.drawable.help_wanted));
        new Ineedyou(this);

        tabs.setCurrentTab(0);
    }
    
    /*
     * Permite crear una pestaña
     * Se le pasa por parametros el contenedor de las tabs
     * El nombre de la tab que se va a crear
     * El id del layout del contenido que le corresponde
     * El texto de la tab que se va a crear
     * La imagen que se le va a poner a la tab
     */
    private void CrearPestanna (TabHost tabs, String nombre, int contenido, String texto, Drawable imagen) {
    	//Se crear la nueva pestaña con el nombre correspondiente
    	TabHost.TabSpec spec = tabs.newTabSpec(nombre);
    	//Se le define a la nueva pestaña cuál será su contenido
    	spec.setContent(contenido);
    	//Se le define a la nueva pestaña cual es su texto y la imagen
        spec.setIndicator("", imagen);
        //Se agrega la nueva pestaña al contenedor de pestañas pasado por parámetros
        tabs.addTab(spec);
    }
    
}
