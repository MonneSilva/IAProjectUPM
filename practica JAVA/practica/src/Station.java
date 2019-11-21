import java.util.ArrayList;

public class Station {
    
	private String name;
	private ArrayList<Station> nextStations;
	private ArrayList<Station> prevStations;
	private boolean interchange;
	private int interchangeTime;
	private ArrayList<String> lines;
	private double latitude;
	private double longitude;
	protected double g;
	protected double h;

	@Override
	public String toString() {
		return name;
	}

	public Station(String name, ArrayList<Station> nextStations, ArrayList<Station> prevStations, 
			ArrayList<String> lines, double lat, double longi) {

		this.name = name;
		this.nextStations = nextStations;
		this.prevStations = prevStations;
		this.interchange = (nextStations.size() >= 1);
		this.interchangeTime = interchange? 5: 0;
		this.lines = lines;
		this.latitude=lat;
		this.longitude=longi;
	}
	
	public ArrayList<Station> toArray() {
	    ArrayList<Station> newArray = new ArrayList<Station>();
	    newArray.add(this);
	    return newArray;
	}

	
	public String getname(){
		return name;
	}

	public ArrayList<Station> getnextStation() {
		return nextStations;
	}

	public ArrayList<Station> getprevStation() {
		return prevStations;
	}

	public boolean isinterchange() {
		return interchange;
	}

	public int getinterchangeTime() {
		return interchangeTime;
	}

	public ArrayList<String> getlines() {
		return lines;
	}

	public double getlatitude(){
		return latitude;
	}

	public double getlongitude(){
		return longitude;
	}

	public double getG(){
		return g;
	}

	public double getH(){
		return h;
	}

	public void setG(double newG){
		g=newG;
	}

	public void setH(double newH){
		h=newH;
	}
}