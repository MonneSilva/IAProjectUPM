/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

import Graph.Edge;
import Graph.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.ToDoubleFunction;

/**
 *
 * @author monts
 */
public class StarA {

    /**
     *
     * @param start
     * @param goal
     * @return
     */
    public static LinkedList <Node> Search(Node start, Node goal) {

        ArrayList<Node> openList = new ArrayList();
        // Map<Node,double> openList= new Map()<Node,>;
        List<Node> closeList = new ArrayList();
        Node current = start;
        current.setG(0);
        current.setH(calculateH(current, goal));

        //first Node is always in close list
        closeList.add(start);

        // while current node is not the goal node.
        while (!current.getStation().equals(goal.getStation())) {
            // iterate through the neighbors of the current node.
            for (Edge e : current.getEdges()) {
                Node neighbor;
                if (e.getNodes()[0].equals(current)) {
                    neighbor = e.getNodes()[1];
                } else {
                    neighbor = e.getNodes()[0];
                }
                // if this neighbor is already on closeList, ignore it.
                if (!closeList.contains(neighbor)) {
                    // if this neighbor is already on openList, check if could have a better cost.
                    if (openList.contains(neighbor)) {
                        double g;
                        if (((g = current.getG() + e.getDistance()) + current.getH()) < current.getCost()) {
                            current.setG(g);
                            neighbor.currentE = e;
                        }
                        
                    } else {
                        neighbor.setH(calculateH(current, goal));
                        int i;
                        ////
                        neighbor.setG(current.getG() + e.getDistance());//LAST DISTANCE ROUTED + DISTANCE OF LAST NODE TO CURRENT
                      
                        neighbor.currentE = e;
                        openList.add(neighbor);

                    }
                }

            }

         
           order(openList);
           closeList.add(current = openList.get(0));
           openList.remove(0);

        }
        LinkedList <Node> CL=new LinkedList();
        Node N = closeList.get(closeList.size() - 1);

        while(N.currentE!=null){
            CL.add(N);
            System.out.println(N.getStation().getName() + " : " + N.getCost());
            if (N.currentE.getNodes()[0].equals(N)) {
                N = N.currentE.getNodes()[1];
            } else {
                N = N.currentE.getNodes()[0];
            }
        }
            CL.add(N);
        System.out.println(N.getStation().getName() + " : " + N.getCost());
         return CL;               
    }
    public static void order(ArrayList<Node> List)
    {
        Collections.sort(List, new Comparator<Node>() {
    
            @Override
            public int compare(Node N1, Node N2) {
            return Double.compare(N1.getCost(), N2.getCost());
    }
        });}
        
    
    public static double calculateH(Node Actual, Node Goal) {
        double R = 6378137;
        double distanciaLat = ((Goal.getStation().getLatitude() - Actual.getStation().getLatitude()) * Math.PI / 180);
        double distanciaLong = ((Goal.getStation().getLongitude() - Actual.getStation().getLongitude()) * Math.PI / 180);
        double a = Math.pow(Math.sin(distanciaLat / 2), 2) + Math.cos(Actual.getStation().getLatitude() * Math.PI / 180) * Math.cos(Goal.getStation().getLatitude() * Math.PI / 180) * Math.pow(Math.sin(distanciaLong / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;
        return d/1000;
    }
}
