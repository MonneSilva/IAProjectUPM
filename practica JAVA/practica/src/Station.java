import java.util.ArrayList;

public class Station {
    
	private String name;
	private ArrayList<Station> nextStations;
	private ArrayList<Station> prevStations;
	private boolean interchange;
	private int interchangeTime;
	private ArrayList<String> lines;
	private double latitude,longitude,g,h,grapx,grapy;

    public ArrayList<Station> getPrevStations() {
        return prevStations;
    }

    public void setPrevStations(ArrayList<Station> prevStations) {
        this.prevStations = prevStations;
    }

    public ArrayList<Neighbour> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<Neighbour> neighbours) {
        this.neighbours = neighbours;
    }

    public double getGrapx() {
        return grapx;
    }

    public void setGrapx(double grapx) {
        this.grapx = grapx;
    }

    public double getGrapy() {
        return grapy;
    }

    public void setGrapy(double grapy) {
        this.grapy = grapy;
    }

	@Override
	public String toString() {
		return name;
	}
        
        public void relations(ArrayList<Neighbour> neighbours,ArrayList<String> lines)
        {
            this.neighbours=neighbours;
            this.lines=lines; 
        }
        
	public Station(String name, ArrayList<Neighbour> neighbours,ArrayList<String> lines, double lat, double longi) {

		this.name = name;
		this.neighbours=neighbours;
		this.interchange = (neighbours.size() >= 1);
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