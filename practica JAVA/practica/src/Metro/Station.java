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
                       
	public Station(String name,ArrayList<String> lines, double lat, double longi) {

		this.name = name;
		this.lines = lines;
		this.latitude=lat;
		this.longitude=longi;
	}
        //Simplex delacaration of station
        public Station(String name, double lat, double longi,ArrayList<String> lines) {
		this.name = name;
		this.latitude=lat;
		this.longitude=longi;
                this.lines=lines;
	}
         public Station(String name, double lat, double longi,String line) {
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
     
        
  
}

