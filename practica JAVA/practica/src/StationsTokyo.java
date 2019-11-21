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
            gotanda, merugo, ebisu, shibuya, harajuku, yoyogi, shinjuku, ochanomizu, sendagaya, shinanomachi, yotsuya, lichigaya,
            lidabashi, suidobashi};
    
    
    static String[] schedule = {"5:00-7:00","7:00-9:30*","9:30-13:00","13:00-15:00*","15:00-19:00","19:00-21:30*","21:30-23:00"};
    
	
    public void createStations() {
        
    //Green line (1)
    metroLines.add(green);
	takadanobaba = new Station("Takadanobaba", mejiro.toArray(), shinOkubo.toArray(), metroLines, 35.712932, 139.704455);
	mejiro = new Station("Mejiro", ikebukuro.toArray(), takadanobaba.toArray(), metroLines, 35.712932, 139.704455);
	ikebukuro = new Station("Ikebukuro", otsuka.toArray(), mejiro.toArray(), metroLines, 35.712932, 139.704455);
	otsuka = new Station("Otsuka", sugamo.toArray(), ikebukuro.toArray(), metroLines, 35.712932, 139.704455);
	sugamo = new Station("Sugamo", komagome.toArray(), otsuka.toArray(), metroLines, 35.712932, 139.704455);
	komagome = new Station("Komagome", tabata.toArray(), sugamo.toArray(), metroLines, 35.712932, 139.704455);
	tabata = new Station("Tabata", nishiNippori.toArray(), komagome.toArray(), metroLines, 35.712932, 139.704455);
	nishiNippori = new Station("Nishi-Nippori", nippori.toArray(), tabata.toArray(), metroLines, 35.712932, 139.704455);
	nippori = new Station("Nippori", uguisudani.toArray(), nishiNippori.toArray(), metroLines, 35.712932, 139.704455);
	uguisudani = new Station("Uguisudani", ueno.toArray(), nippori.toArray(), metroLines, 35.712932, 139.704455);
	ueno = new Station("Ueno", okachimachi.toArray(), uguisudani.toArray(), metroLines, 35.712932, 139.704455);
	okachimachi = new Station("Okachimachi", akihabara.toArray(), ueno.toArray(), metroLines, 35.712932, 139.704455);
	metroLines.add(yellow);
	changeNext(kanda, ochanomizu);
	akihabara = new Station("Akihabara", next, okachimachi.toArray(), metroLines, 35.712932, 139.704455);
	metroLines.remove(yellow);
	kanda = new Station("Kanda", tokyo.toArray(), okachimachi.toArray(), metroLines, 35.712932, 139.704455);
	metroLines.add(red);
	changeNext(yurakucho, ochanomizu);
	tokyo = new Station("Tokyo", next, kanda.toArray(), metroLines, 35.712932, 139.704455);
	metroLines.remove(red);
	yurakucho = new Station("Yurakucho", shimbashi.toArray(), tokyo.toArray(), metroLines, 35.712932, 139.704455);
	shimbashi = new Station("Shimbashi", hamamatsucho.toArray(), tokyo.toArray(), metroLines, 35.712932, 139.704455);
	hamamatsucho = new Station("Hamamatsucho", tamachi.toArray(), shimbashi.toArray(), metroLines, 35.712932, 139.704455);
    tamachi = new Station("Tamachi", shinagawa.toArray(), hamamatsucho.toArray(), metroLines, 35.712932, 139.704455);
    shinagawa = new Station("Shinagawa", osaki.toArray(), tamachi.toArray(), metroLines, 35.712932, 139.704455);
    osaki = new Station("Osaki", gotanda.toArray(), shinagawa.toArray(), metroLines, 35.712932, 139.704455);
    gotanda = new Station("Gotanda", merugo.toArray(), osaki.toArray(), metroLines, 35.712932, 139.704455);
    merugo = new Station("Merugo", ebisu.toArray(), gotanda.toArray(), metroLines, 35.712932, 139.704455);
    ebisu = new Station("Ebisu", shibuya.toArray(), merugo.toArray(), metroLines, 35.712932, 139.704455);
    shibuya = new Station("Shibuya", harajuku.toArray(), ebisu.toArray(), metroLines, 35.712932, 139.704455);
    harajuku = new Station("Harajuku", yoyogi.toArray(), shibuya.toArray(), metroLines, 35.712932, 139.704455);
    metroLines.add(yellow);
    changePrev(harajuku, sendagaya);
    yoyogi = new Station("Yoyogi", shinjuku.toArray(), prev, metroLines, 35.712932, 139.704455);
    metroLines.add(red);
    changePrev(yoyogi, ochanomizu);
    shinjuku = new Station("Shinjuku", shinOkubo.toArray(), prev , metroLines, 35.712932, 139.704455);
    metroLines.remove(yellow);
    metroLines.remove(red);
    shinOkubo = new Station("Shin-Okubo", takadanobaba.toArray(), shinjuku.toArray(), metroLines, 35.712932, 139.704455);
    
    metroLines.clear();
    
    //Yellow Line (2)
    metroLines.add(yellow);
    sendagaya = new Station("Sendagaya", yoyogi.toArray(), shinanomachi.toArray(), metroLines, 35.712932, 139.704455);
    shinanomachi = new Station("Shinanomachi", sendagaya.toArray(), yotsuya.toArray(), metroLines, 35.712932, 139.704455);
    yotsuya = new Station("Yotsuya", shinanomachi.toArray(), lichigaya.toArray(), metroLines, 35.712932, 139.704455);
    lichigaya = new Station("Lichigaya", yotsuya.toArray(), lidabashi.toArray(), metroLines, 35.712932, 139.704455);
    lidabashi = new Station("Lidabashi", lichigaya.toArray(), suidobashi.toArray(), metroLines, 35.712932, 139.704455);
    suidobashi = new Station("Suidobashi", lidabashi.toArray(), ochanomizu.toArray(), metroLines, 35.712932, 139.704455);
    metroLines.add(red);
    changeNext(suidobashi, shinjuku);
    changePrev(tokyo, akihabara);
    ochanomizu = new Station("Ochanomizu", next, prev, metroLines, 35.712932, 139.704455);
	
	
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
	
}