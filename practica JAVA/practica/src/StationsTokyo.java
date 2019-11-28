import java.awt.EventQueue;
import java.util.*;

public class StationsTokyo{

    ArrayList<String> metroLines = new ArrayList<String>();
    ArrayList<Station> next = new ArrayList<Station>();
    ArrayList<Station> prev = new ArrayList<Station>();
    String green = "Green";
    String yellow = "Yellow";
    String red = "Red";
    Station shinOkubo, takadanobaba, mejiro, ikebukuro, otsuka, sugamo, komagome, tabata, nishiNippori, nippori;
    Station uguisudani, ueno, okachimachi, akihabara, kanda, tokyo, yurakucho, shimbashi, hamamatsucho, tamachi;
    Station shinagawa, osaki, gotanda, merugo, ebisu, shibuya, harajuku, yoyogi, shinjuku, ochanomizu;
    Station sendagaya, shinanomachi, yotsuya, lichigaya, lidabashi, suidobashi;
    
    Station[] stations = {shinOkubo, takadanobaba, mejiro, ikebukuro, otsuka, sugamo, komagome, tabata, nishiNippori, nippori, 
            uguisudani, ueno, okachimachi, akihabara, kanda, tokyo, yurakucho, shimbashi, hamamatsucho, tamachi, shinagawa, osaki, 
            gotanda, merugo, ebisu, shibuya, harajuku, yoyogi, shinjuku, ochanomizu, sendagaya, shinanomachi, yotsuya,lichigaya,
            lidabashi, suidobashi};
    
    
    static String[] schedule = {"5:00-7:00","7:00-9:30*","9:30-13:00","13:00-15:00*","15:00-19:00","19:00-21:30*","21:30-23:00"};
    
	
    public void createStations() {
        //WHY WE USE ARRAY TO THE NEXT STATIONS?
        
    //Green line (1)
    metroLines.add(green);
    //ADD DISTANCE TO NEIGHBOUR STATIONS
	takadanobaba = new Station("Takadanobaba",new ArrayList<Neighbour>(){{add(new Neighbour(mejiro,0));add(new Neighbour(shinOkubo,0));}}, metroLines, 35.712932, 139.704455);
        mejiro = new Station("Mejiro",new ArrayList<Neighbour>(){{add(new Neighbour(ikebukuro,0));add(new Neighbour(takadanobaba,0));}}, metroLines, 35.7211714, 139.7065603);
        ikebukuro = new Station("Mejiro",new ArrayList<Neighbour>(){{add(new Neighbour(ikebukuro,0));add(new Neighbour(takadanobaba,0));}}, metroLines, 35.7211714, 139.7065603);
        
 
	ikebukuro = new Station("Ikebukuro", otsuka.toArray(), mejiro.toArray(), metroLines, 35.7295028, 139.7109001);
	otsuka = new Station("Otsuka", sugamo.toArray(), ikebukuro.toArray(), metroLines, 35.7318309,139.7281112);
	sugamo = new Station("Sugamo", komagome.toArray(), otsuka.toArray(), metroLines,35.7334192,139.7392848);
	komagome = new Station("Komagome", tabata.toArray(), sugamo.toArray(), metroLines, 35.7365665, 139.7470098);
	tabata = new Station("Tabata", nishiNippori.toArray(), komagome.toArray(), metroLines, 35.7381581,139.7608154);
	nishiNippori = new Station("Nishi-Nippori", nippori.toArray(), tabata.toArray(), metroLines, 35.7320057, 139.7668856);
	nippori = new Station("Nippori", uguisudani.toArray(), nishiNippori.toArray(), metroLines, 35.7281578, 139.7706414);
	uguisudani = new Station("Uguisudani", ueno.toArray(), nippori.toArray(), metroLines, 35.7214573, 139.7780133);
	ueno = new Station("Ueno", okachimachi.toArray(), uguisudani.toArray(), metroLines, 35.7141672, 139.7774091);
	okachimachi = new Station("Okachimachi", akihabara.toArray(), ueno.toArray(), metroLines, 35.7075185, 139.7748564);
	metroLines.add(yellow);
	changeNext(kanda, ochanomizu);
	akihabara = new Station("Akihabara", next, okachimachi.toArray(), metroLines, 35.698383,139.7730717);
	metroLines.remove(yellow);
	kanda = new Station("Kanda", tokyo.toArray(), okachimachi.toArray(), metroLines, 35.6918216,139.7709318);
	metroLines.add(red);
	changeNext(yurakucho, ochanomizu);
	tokyo = new Station("Tokyo", next, kanda.toArray(), metroLines,35.6812362,139.7649308);
	metroLines.remove(red);
	yurakucho = new Station("Yurakucho", shimbashi.toArray(), tokyo.toArray(), metroLines, 35.6749187,139.7628199);
	shimbashi = new Station("Shimbashi", hamamatsucho.toArray(), tokyo.toArray(), metroLines, 35.666379,139.7583398);
	hamamatsucho = new Station("Hamamatsucho", tamachi.toArray(), shimbashi.toArray(), metroLines, 35.6553809,139.7571289);
    tamachi = new Station("Tamachi", shinagawa.toArray(), hamamatsucho.toArray(), metroLines, 35.6457361,139.7475624);
    shinagawa = new Station("Shinagawa", osaki.toArray(), tamachi.toArray(), metroLines, 35.6284713,139.7387597);
    osaki = new Station("Osaki", gotanda.toArray(), shinagawa.toArray(), metroLines, 35.6198513,139.7281892);
    gotanda = new Station("Gotanda", merugo.toArray(), osaki.toArray(), metroLines, 35.6261591,139.7236022);
    merugo = new Station("Meguro", ebisu.toArray(), gotanda.toArray(), metroLines, 35.6340929,139.7158331);
    ebisu = new Station("Ebisu", shibuya.toArray(), merugo.toArray(), metroLines, 35.6467139,139.7100777);
    shibuya = new Station("Shibuya", harajuku.toArray(), ebisu.toArray(), metroLines, 35.6580339,139.7016358);
    harajuku = new Station("Harajuku", yoyogi.toArray(), shibuya.toArray(), metroLines, 35.6702285,139.7026976);
    metroLines.add(yellow);
    changePrev(harajuku, sendagaya);
    yoyogi = new Station("Yoyogi", shinjuku.toArray(), prev, metroLines, 35.683033,139.7020555);
    metroLines.add(red);
    changePrev(yoyogi, ochanomizu);
    shinjuku = new Station("Shinjuku", shinOkubo.toArray(), prev , metroLines, 35.6896067,139.7005713);
    metroLines.remove(yellow);
    metroLines.remove(red);
    shinOkubo = new Station("Shin-Okubo", takadanobaba.toArray(), shinjuku.toArray(), metroLines, 35.7012459,139.7002258);
    
    metroLines.clear();
    
    //Yellow Line (2)
    metroLines.add(yellow);
    sendagaya = new Station("Sendagaya", yoyogi.toArray(), shinanomachi.toArray(), metroLines, 35.6811956,139.7112808);
    shinanomachi = new Station("Shinanomachi", sendagaya.toArray(), yotsuya.toArray(), metroLines, 35.6800602,139.7203199);
    yotsuya = new Station("Yotsuya", shinanomachi.toArray(), lichigaya.toArray(), metroLines, 35.6861525,139.7302183);
    lichigaya = new Station("Ichigaya", yotsuya.toArray(), lidabashi.toArray(), metroLines, 35.6910121,139.7355674);
    lidabashi = new Station("Lidabashi", lichigaya.toArray(), suidobashi.toArray(), metroLines, 35.7020837,139.7450232);
    suidobashi = new Station("Suidobashi", lidabashi.toArray(), ochanomizu.toArray(), metroLines, 35.7020484,139.7535016);
    metroLines.add(red);
    changeNext(suidobashi, shinjuku);
    changePrev(tokyo, akihabara);
    ochanomizu = new Station("Ochanomizu", next, prev, metroLines, 35.6993854,139.7652479);
	
	
    } 
    
    public void changePrev(Station prev1, Station prev2) {
        prev.clear();
        prev.add(prev1);
        prev.add(prev2);
    }
    
    public void changeNext(Station next1, Station next2) {
        next.clear();
        next.add(next1);
        next.add(next2);
    }
    
    public static void main(String[] args) {
		StationsTokyo T=new StationsTokyo();
                T.createStations();
	}
	
}