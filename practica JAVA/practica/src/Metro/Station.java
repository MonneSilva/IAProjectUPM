package Metro;



import Graph.Edge;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monts
 */
public class Station {
    private String name;
	private ArrayList<String> lines;

    @Override
    public String toString() {
        return this.getName(); //To change body of generated methods, choose Tools | Templates.
    }
	private double latitude,longitude;
	private int graphx, graphy;
                       
    //Simplex delacaration of station
    public Station(String name, double lat, double longi,ArrayList<String> line, int x, int y) {
		this.name = name;
		this.latitude=lat;
		this.longitude=longi;
		this.lines=line;
		this.graphx = x;
		this.graphy = y;
	}
    public Station(String name, double lat, double longi, String line) {
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

	public ArrayList<String> getLines() {
		return lines;
	}
        public void addLine(String line)
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

