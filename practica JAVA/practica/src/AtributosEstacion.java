public class AtributosEstacion {
	private String nombre;
	private String[] sigEstacion;
	private String[] antEstacion;
	private boolean transbordo;
	private int tiempoTransbordo;
	private String[] lineas;
	private double latitud;
	private double longitud;
	protected double g;
	protected double h;

	@Override
	public String toString() {
		return nombre;
	}

	public AtributosEstacion(String nombre,String sigEstacion1,String antEstacion1,boolean transbordo,
			String linea1,double lat,double log){

		this.nombre = nombre;
		String[] a= {sigEstacion1,null,null};
		sigEstacion = a;
		String[] a2 = {antEstacion1,null,null};
		antEstacion = a2;
		this.transbordo = transbordo;
		this.tiempoTransbordo = 0;
		String[] a3 = {linea1};
		this.lineas = a3;
		this.latitud=lat;
		this.longitud=log;
	}

	public AtributosEstacion(String nombre,String sigEstacion1,String antEstacion1,boolean transbordo,
			int tiempoTransbordo,String sigEstacion2,String antEstacion2,String linea1, String linea2,double lat,double log){

		this.nombre = nombre;
		String[] a= {sigEstacion1,sigEstacion2,null};
		sigEstacion = a;
		String[] a2 = {antEstacion1,antEstacion2,null};
		antEstacion = a2;
		this.transbordo = transbordo;
		this.tiempoTransbordo = tiempoTransbordo;
		String[] a3 = {linea1,linea2};
		this.lineas = a3;
		this.latitud=lat;
		this.longitud=log;
	}

	public String getNombre(){
		return nombre;
	}

	public String[] getSigEstacion() {
		return sigEstacion;
	}

	public String[] getAntEstacion() {
		return antEstacion;
	}

	public boolean isTransbordo() {
		return transbordo;
	}

	public int getTiempoTransbordo() {
		return tiempoTransbordo;
	}

	public String[] getLineas() {
		return lineas;
	}

	public double getLatitud(){
		return latitud;
	}

	public double getLongitud(){
		return longitud;
	}

	public double getG(){
		return g;
	}

	public double getH(){
		return h;
	}

	public void setG(double a){
		g=a;
	}

	public void setH(double a){
		h=a;
	}
}