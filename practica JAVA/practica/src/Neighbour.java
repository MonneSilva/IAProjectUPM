
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
public class Neighbour {
    private Station Station;
    private double distance;

    public Neighbour(Station Station, double distance) {
        this.Station = Station;
        this.distance = distance;
    }

       

    public Station getStation() {
        return Station;
    }

    public void setStation(Station Station) {
        this.Station = Station;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    
}
