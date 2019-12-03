package Metro;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;
import Search.StarA;
import java.util.*;

public class Metro {

    Graph metro = new Graph();
    ArrayList<Station> stations;
    public ArrayList<Station> getStations() {
        return stations;
    }
    public ArrayList<String> getStationsN() {
        ArrayList S=new ArrayList();
        for(Station s:this.stations)
        {
            S.add(s.getName());
        }
        return S;
    }

    public Graph getMetro() {
        return metro;
    }

    public void setMetro(Graph metro) {
        this.metro = metro;
    }

    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }
    Station shinOkubo, takadanobaba, mejiro, ikebukuro, otsuka, sugamo, komagome, tabata, nishiNippori, nippori,
            uguisudani, ueno, okachimachi, akihabara, kanda, tokyo, yurakucho, shimbashi, hamamatsucho, tamachi,
            shinagawa, osaki, gotanda, merugo, ebisu, shibuya, harajuku, yoyogi, shinjuku, ochanomizu,
            sendagaya, shinanomachi, yotsuya, iichigaya, iidabashi, suidobashi;

    static String[] schedule = {"5:00-7:00", "7:00-9:30*", "9:30-13:00", "13:00-15:00*", "15:00-19:00", "19:00-21:30*", "21:30-23:00"};

    public void createStations() {

        //FIRST CREATE EACH STATION WHIT COORDANADES AND GRAPH COORDANADES*    *Optional
        String line = "green";
        //GREEN LINE
        takadanobaba = new Station("Takadanobaba", 35.712932, 139.704455, line);
        mejiro = new Station("Mejiro", 35.7211714, 139.7065603, line);
        ikebukuro = new Station("Ikebukuro", 35.7295028, 139.7109001, line);
        otsuka = new Station("Otsuka", 35.7318309, 139.7281112, line);
        sugamo = new Station("Sugamo", 35.7334192, 139.7392848, line);
        komagome = new Station("Komagome", 35.7365665, 139.7470098, line);
        tabata = new Station("Tabata", 35.7381581, 139.7608154, line);
        nishiNippori = new Station("Nishi-Nippori", 35.7320057, 139.7668856, line);
        nippori = new Station("Nippori", 35.7281578, 139.7706414, line);
        uguisudani = new Station("Uguisudani", 35.7214573, 139.7780133, line);
        ueno = new Station("Ueno", 35.7141672, 139.7774091, line);
        okachimachi = new Station("Okachimachi", 35.7075185, 139.7748564, line);
        akihabara = new Station("Akihabara", 35.698383, 139.7730717, line);
        kanda = new Station("Kanda", 35.6918216, 139.7709318, line);
        tokyo = new Station("Tokyo", 35.6812362, 139.7649308, line);
        yurakucho = new Station("Yurakucho", 35.6749187, 139.7628199, line);
        shimbashi = new Station("Shimbashi", 35.666379, 139.7583398, line);
        hamamatsucho = new Station("Hamamatsucho", 35.6553809, 139.7571289, line);
        tamachi = new Station("Tamachi", 35.6457361, 139.7475624, line);
        shinagawa = new Station("Shinagawa", 35.6284713, 139.7387597, line);
        osaki = new Station("Osaki", 35.6198513, 139.7281892, line);
        gotanda = new Station("Gotanda", 35.6261591, 139.7236022, line);
        merugo = new Station("Meguro", 35.6340929, 139.7158331, line);
        ebisu = new Station("Ebisu", 35.6467139, 139.7100777, line);
        shibuya = new Station("Shibuya", 35.6580339, 139.7016358, line);
        harajuku = new Station("Harajuku", 35.6702285, 139.7026976, line);
        yoyogi = new Station("Yoyogi", 35.683033, 139.7020555, line);
        shinjuku = new Station("Shinjuku", 35.6896067, 139.7005713, line);
        shinOkubo = new Station("Shin-Okubo", 35.7012459, 139.7002258, line);
//YELLOW LINE
        shinjuku.addLine(line = "yellow");
        yoyogi.addLine(line);
        sendagaya = new Station("Sendagaya", 35.6811956, 139.7112808, line);
        shinanomachi = new Station("Shinanomachi", 35.6800602, 139.7203199, line);
        yotsuya = new Station("Yotsuya", 35.6861525, 139.7302183, line);
        iichigaya = new Station("Ichigaya", 35.6910121, 139.7355674, line);
        iidabashi = new Station("Lidabashi", 35.7020837, 139.7450232, line);
        suidobashi = new Station("Suidobashi", 35.7020484, 139.7535016, line);
        akihabara.addLine(line);

//RED LINE         
        tokyo.addLine(line = "red");
        ochanomizu = new Station("Ochanomizu", 35.6993854, 139.7652479, line);
        yoyogi.addLine(line);
        shinjuku.addLine(line);

        Station[] stations = {shinOkubo, takadanobaba, mejiro, ikebukuro, otsuka, sugamo, komagome, tabata, nishiNippori, nippori,
            uguisudani, ueno, okachimachi, akihabara, kanda, tokyo, yurakucho, shimbashi, hamamatsucho, tamachi, shinagawa, osaki,
            gotanda, merugo, ebisu, shibuya, harajuku, yoyogi, shinjuku, ochanomizu, sendagaya, shinanomachi, yotsuya, iichigaya,
            iidabashi, suidobashi};
        this.stations = new ArrayList<Station>(Arrays.asList(stations));

    }

    public void createGraph() {
        //TO CALCULATE PENALTY WE CHOOSE AVERAGE TIME THAT IS LESS OF 4MINS BETWEEN STATIONS
        final double penalty = 3;
        //WE CREATE A NODE FOR EACH STATION
        for (Station s : this.stations) {
            metro.addNode(new Node(s));
        }

        //WE CREATE ALL THE CONNECTIONS
        //change 5 for real distances (h)
        ArrayList<Edge> eAux = new ArrayList() {
            {

                //GREEN LINE
                add(new Edge(metro.getNode(shinOkubo), metro.getNode(takadanobaba), 1.4));
                add(new Edge(metro.getNode(takadanobaba), metro.getNode(mejiro), 0.9));
                add(new Edge(metro.getNode(mejiro), metro.getNode(ikebukuro), 1.2));
                add(new Edge(metro.getNode(ikebukuro), metro.getNode(otsuka), 1.8));
                add(new Edge(metro.getNode(otsuka), metro.getNode(sugamo), 1.1));
                add(new Edge(metro.getNode(sugamo), metro.getNode(komagome), 0.7));
                add(new Edge(metro.getNode(komagome), metro.getNode(tabata), 1.6));
                add(new Edge(metro.getNode(tabata), metro.getNode(nishiNippori), 0.8));
                add(new Edge(metro.getNode(nishiNippori), metro.getNode(nippori), 0.5));
                add(new Edge(metro.getNode(nippori), metro.getNode(uguisudani), 1.1));
                add(new Edge(metro.getNode(uguisudani), metro.getNode(ueno), 1.1));
                add(new Edge(metro.getNode(ueno), metro.getNode(okachimachi), 0.6));
                add(new Edge(metro.getNode(okachimachi), metro.getNode(akihabara), 1));
                add(new Edge(metro.getNode(akihabara), metro.getNode(kanda), 0.7));
                add(new Edge(metro.getNode(kanda), metro.getNode(tokyo), 1.3));
                add(new Edge(metro.getNode(tokyo), metro.getNode(yurakucho), 0.8));
                add(new Edge(metro.getNode(yurakucho), metro.getNode(shimbashi), 1.1));
                add(new Edge(metro.getNode(shimbashi), metro.getNode(hamamatsucho), 1.2));
                add(new Edge(metro.getNode(hamamatsucho), metro.getNode(tamachi), 1.5));
                add(new Edge(metro.getNode(tamachi), metro.getNode(shinagawa), 2.2));
                add(new Edge(metro.getNode(shinagawa), metro.getNode(osaki), 2));
                add(new Edge(metro.getNode(osaki), metro.getNode(gotanda), 0.9));
                add(new Edge(metro.getNode(gotanda), metro.getNode(merugo), 1.2));
                add(new Edge(metro.getNode(merugo), metro.getNode(ebisu), 1.5));
                add(new Edge(metro.getNode(ebisu), metro.getNode(shibuya), 1.6));
                add(new Edge(metro.getNode(shibuya), metro.getNode(harajuku), 1.2));
                add(new Edge(metro.getNode(harajuku), metro.getNode(yoyogi), 1.5));
                add(new Edge(metro.getNode(yoyogi), metro.getNode(shinjuku), 0.7));
                add(new Edge(metro.getNode(shinjuku), metro.getNode(shinOkubo), 1.3));

                //Yellow
                add(new Edge(metro.getNode(suidobashi), metro.getNode(iidabashi), 0.9));
                add(new Edge(metro.getNode(iidabashi), metro.getNode(iichigaya), 1.5));
                add(new Edge(metro.getNode(iichigaya), metro.getNode(shinanomachi), 2.1));
                add(new Edge(metro.getNode(shinanomachi), metro.getNode(sendagaya), 0.7));
                add(new Edge(metro.getNode(suidobashi), metro.getNode(ochanomizu), 0.8));
                
                
                
                
                

            }
        };

        //EACH STATION ITS GOING TO ADD EACH EDGE WHERE IT´S CONCIDERED AS POINT
        for (Node N : metro.getNodes()) {
            for (Edge E : eAux) {
                if ((E.getNodes()[0] == N) || E.getNodes()[1] == N) {
                    N.addEdge(E);
                } else {
                }
            }
        }

//INTERCHANGE STATIONS
        Node f1, f2, f3, auxN, auxN1; //FICTICIUS AND AUXILIAR NODES

        //TOKYO STATION ON GREEN LINE
        //CAMBIO DE LINEA GREEN TO RED
        Edge aux = new Edge(f1 = new Node(tokyo), auxN = metro.getNode(tokyo), penalty);
        //ADD EDGE TO TOKYO- FICTICIUS 1(TOKYO)
        f1.addEdge(aux);
        auxN.addEdge(aux);

        //ADD EDGE TO  FICTICIUS 1(TOKYO)-OCHANOMIZU WITH REAL DISTANCE
        aux = new Edge(f1, auxN = metro.getNode(ochanomizu), 2.6);

        f1.addEdge(aux);
        auxN.addEdge(aux);
        metro.addNode(f1);

        //SHINJUKU STATION ON GREEN LINE
        //CAMBIO DE LINEA GREEN TO RED
        aux = new Edge(f1 = new Node(shinjuku), auxN = metro.getNode(shinjuku), penalty);
        //ADD EDGE TO SHINJUKU- FICTICIUS 1 
        f1.addEdge(aux);
        auxN.addEdge(aux);
        //ADD EDGE TO SHINJUKU- FICTICIUS 1-OCHANOMIZU WITH REAL DISTANCE
        aux = new Edge(f1, auxN1 = metro.getNode(ochanomizu), 1.5);
        f1.addEdge(aux);
        auxN1.addEdge(aux);

        metro.addNode(f1);

        //CAMBIO DE LINEA GREEN TO YELLOW
        aux = new Edge(f2 = new Node(shinjuku), auxN, penalty);
        //ADD EDGE TO SHINJUKU- FICTICIUS 2 
        f2.addEdge(aux);
        auxN.addEdge(aux);
        metro.addNode(f2);

        //YOYOGY STATION ON GREEN LINE
        //CAMBIO DE LINEA GREEN TO YELLOW
        aux = new Edge(f3 = new Node(yoyogi), auxN = metro.getNode(yoyogi), penalty);
        //ADD EDGE TO SHINJUKU- FICTICIUS 3 
        f3.addEdge(aux);
        auxN.addEdge(aux);

        aux = new Edge(f1, f2, penalty);
        f2.addEdge(aux);
        f1.addEdge(aux);

        //ADD EDGE YOYOGY- FICTICIUS 3 - FICTICIUS 2 - SHINJUKU
        aux = new Edge(f3, f2, 0.7); //REAL DISTANCE YOYOGY-SHINJUKU YELLOE LINE
        f3.addEdge(aux);
        f2.addEdge(aux);
        //metro.addNode(f1);
        // metro.addNode(f2);
        //ADD EDGE YOYOGY- FICTICIUS 3 - sendagaya
        aux = new Edge(f3, auxN = metro.getNode(sendagaya), 1);//REAL DISTANCE YOYOGY-SENDAGAYA YELLOE LINE
        f3.addEdge(aux);
        auxN.addEdge(aux);
        metro.addNode(f3);
        
        ////OCHANOMIZU STATION ON RED LINE
        //CAMBIO DE LINEA RED TO YELLOW
        Edge aux2 = new Edge(f2 = new Node(ochanomizu), auxN1 = metro.getNode(ochanomizu), penalty);
        
        //ADD EDGE TO OCHANOMIZU - FICTICIUS 2 
        f2.addEdge(aux2);
        auxN1.addEdge(aux2);
                

        //AKIHABARA STATION ON GREEN LINE
        //CAMBIO DE LINEA GREEN TO YELLOW
        aux = new Edge(f1 = new Node(akihabara), auxN = metro.getNode(akihabara), penalty);
        //ADD EDGE TO AKIHABARA - FICTICIUS 1 
        f1.addEdge(aux);
        auxN.addEdge(aux);
        
        //ADD EDGE TO AKIHABARA - FICTICIUS 1-FICTICIUS 2 -OCHANOMIZU WITH REAL DISTANCE
        Edge aux1 = new Edge(f1, f2, 0.9);
        f1.addEdge(aux1);
        f2.addEdge(aux1);
        
        aux = new Edge(f1, auxN = metro.getNode(suidobashi), 0.8);
        //ADD EDGE TO AKIHABARA - FICTICIUS 1 
        f1.addEdge(aux);
        auxN.addEdge(aux);
        
        metro.addNode(f1);
        metro.addNode(f2);

        for (Node N : metro.getNodes()) {
            System.out.println(N.getStation().getName() + ":");
            for (Edge E : N.getEdges()) {
                if (E.getNodes()[0].equals(N)) {
                    System.out.println("    -" + (E.getNodes()[1]).getStation().getName() + ": " + E.getDistance());
                } else {
                    System.out.println("    -" + (E.getNodes()[0]).getStation().getName() + ": " + E.getDistance());
                }
            }

        }
        System.out.println();

    }


}
