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
    private Node nodes[] = new Node[2];
    private double distance;

    public Edge(Node origin, Node destination, double distance) {
        this.nodes = new Node[]{origin, destination};
        this.distance = distance;
    }
   
    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public Node getDestination( Node Node) {
        if (this.getNodes()[0].equals(Node)) {
            return this.getNodes()[1];
        }
        return this.getNodes()[0];

    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

}
