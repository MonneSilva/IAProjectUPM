/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monts
 */
public class AStarSearch {
    
    
    private static double calculateAirDistance (Station A,Station B){
        //Fórmula del Haversine
		double R = 6378137; //Earth's radius
		double latDistance = ((B.getLatitude()-A.getLatitude())*Math.PI/180);
		double longDistance = ((B.getLongitude()-A.getLongitude())*Math.PI/180);
		double a = Math.pow(Math.sin(latDistance/2),2) + Math.cos(A.getLatitude()*Math.PI/180) * Math.cos(B.getLatitude()*Math.PI/180) * Math.pow(Math.sin(longDistance/2),2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = R * c;
		return d;
	}
    
}
