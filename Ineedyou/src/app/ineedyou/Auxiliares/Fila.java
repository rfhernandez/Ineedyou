package app.ineedyou.Auxiliares;

public class Fila {
	private int imagen;
	private String nombre;
	private String indicacion;
	
	public Fila (int imagen, String nombre, String indicacion) {
		this.imagen = imagen;
		this.nombre = nombre;
		this.indicacion = indicacion;
	}
	
	public int getImagen () {
		return this.imagen;
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public String getIndicacion () {
		return this.indicacion;
	}
}
