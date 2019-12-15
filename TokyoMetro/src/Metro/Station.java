package Metro;
import java.awt.Color;
import java.util.ArrayList;
/**
 *
 * @author monts
 */
public class Station {
    private String name;
	private ArrayList<Color> lines;

    @Override
    public String toString() {
        return this.getName(); //To change body of generated methods, choose Tools | Templates.
    }
	private double latitude,longitude;
	private int graphx, graphy;
                       
    //Simplex delacaration of station
    public Station(String name, double lat, double longi,ArrayList<Color> line, int x, int y) {
		this.name = name;
		this.latitude=lat;
		this.longitude=longi;
		this.lines=line;
		this.graphx = x;
		this.graphy = y;
	}
    public Station(String name, double lat, double longi, Color line) {
		this.name = name;
		this.latitude=lat;
		this.longitude=longi;
        this.lines=new ArrayList();
        this.lines.add(line);

	}
       
	
	public ArrayList<Station> toArray() {
	    ArrayList<Station> newArray = new ArrayList<Station>();
	    newArray.add(this);
	    return newArray;
	}
	
	public String getName(){
		return name;
	}

	public ArrayList<Color> getLines() {
		return lines;
	}
        public void addLine(Color line)
        {
            this.lines.add(line);
        }

	public double getLatitude(){
		return latitude;
	}

	public double getLongitude(){
		return longitude;
	}
     
    public int getX(){
		return graphx;
	}    

	public int getY(){
		return graphy;
	}
  
}

