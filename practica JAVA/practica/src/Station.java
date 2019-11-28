import java.util.ArrayList;

public class Station {
    
	private String name;
	private ArrayList<Station> nextStations, prevStations;
        private ArrayList<Neighbour> neighbours= new ArrayList();
	private boolean interchange;
	private int interchangeTime;
	private ArrayList<String> lines;
	private double latitude,longitude,g,h;

	@Override
	public String toString() {
		return name;
	}

	public Station(String name, ArrayList<Neighbour> neighbours,ArrayList<String> lines, double lat, double longi) {

		this.name = name;
		this.neighbours=neighbours;
		this.interchange = (nextStations.size() >= 1);
		this.interchangeTime = interchange? 5: 0;
		this.lines = lines;
		this.latitude=lat;
		this.longitude=longi;
	}
        //Simplex delacaration of station
        public Station(String name, double lat, double longi) {
		this.name = name;
		this.latitude=lat;
		this.longitude=longi;
	}
	
	public ArrayList<Station> toArray() {
	    ArrayList<Station> newArray = new ArrayList<Station>();
	    newArray.add(this);
	    return newArray;
	}

	
	public String getName(){
		return name;
	}

	public ArrayList<Station> getNextStation() {
		return nextStations;
	}

	public ArrayList<Station> getPrevStation() {
		return prevStations;
	}

	public boolean isInterchange() {
		return interchange;
	}

	public int getInterchangeTime() {
		return interchangeTime;
	}

	public ArrayList<String> getLines() {
		return lines;
	}

	public double getLatitude(){
		return latitude;
	}

	public double getLongitude(){
		return longitude;
	}

	public double getG(){
		return g;
	}

	public double getH(){
		return h;
	}

	public void setG(double G){
		g=G;
	}

	public void setH(double H){
		h=H;
	}
        
        
  
}
