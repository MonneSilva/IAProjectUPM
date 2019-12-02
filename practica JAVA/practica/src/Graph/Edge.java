/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author monts
 */
public class Edge {
    private Node nodes[]= new Node[2];
   
    private double distance;
    private boolean interchange;
 
    public Edge(Node origin, Node destination, double distance) {
        this.nodes = new Node[]{origin,destination};
       
        this.distance = distance;
        this.interchange=false;
    }


    public boolean isInterchange() {
        return interchange;
    }

    public void setInterchange(boolean interchange) {
        this.interchange = interchange;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }
 
  
 
    public double getDistance() {
        return distance;
    }
 
    public void setDistance(double distance) {
        this.distance = distance;
    }
 

 
 
 
}
