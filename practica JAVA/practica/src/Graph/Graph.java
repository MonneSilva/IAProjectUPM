package Graph;




import Metro.Station;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monts
 */
public class Graph {
   
    private ArrayList<Node> nodes=new ArrayList();
 
    public void addNode(Node node) {
                nodes.add(node);
    }
    public void addNodes(ArrayList<Node> nodes)
    {
        for(Node n:nodes)
        this.nodes.add(n);
        
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

     public Node getNode(Station station) {
         for(Node N:nodes)
         {
             if(N.getStation().equals(station))
                 return N;
             
         }
        return null;
    }
     public Node getNode(String station) {
         for(Node N:nodes)
         {
             if(N.getStation().getName().equals(station))
                 return N;
             
         }
        return null;
    }
    
 
   
}

