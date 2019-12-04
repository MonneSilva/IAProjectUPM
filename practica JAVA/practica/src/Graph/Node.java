/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;



import Metro.Station;
import java.util.ArrayList;

/**
 *
 * @author monts
 */
public class Node {
    private Station station;
    private ArrayList<Edge> edges;
    public Edge currentE;
    double g,h;
    int x,y;

    public double getCost() {
        return g+h;
    }
    
    public Node(Station station, ArrayList<Edge> edges) {
        this.station = station;
        this.edges = edges;
        this.x = this.station.getX();
        this.y = this.station.getY();
    }
    public Node(Station station) {
        this.station = station;
        this.edges = new ArrayList();
        this.x = this.station.getX();
        this.y = this.station.getY();
    }
    public void setPixels(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
    
    public void addEdge(Edge edge) {
        if (edges == null) {
            edges = new ArrayList();
        }
        edges.add(edge);
    }
    public void addEdges(ArrayList<Edge> edge) {
        for(Edge e:edge)
        edges.add(e);
    }

    public int getXFromNode(){
        return x;
    }
    public int getYFromNode(){
        return y;
    }
    
}

