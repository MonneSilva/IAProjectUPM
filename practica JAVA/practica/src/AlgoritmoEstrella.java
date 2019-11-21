public class AlgoritmoEstrella extends EstacionesMonterrey{

	AlgoritmoEstrella()
	{

	}
	private static AtributosEstacion[] ListaAbierta= new AtributosEstacion[38];
	private static AtributosEstacion[] ListaCerrada= new AtributosEstacion[38];
	public static int posSigElemLA = 0;
	public static int posSigElemLC = 0;
	public static int posFinCamino = 0;
	private static double tiempo=0;
	private static double segundos=0;
	private static int modo;
	public static double d =0;

	public static AtributosEstacion[] AlgoritmoAEstrella(AtributosEstacion salida, AtributosEstacion meta, int modos){


		AtributosEstacion actual;
		boolean metaEnListaCerrada=false;
		AtributosEstacion antDesarrollada=salida;
		modo=modos;
		salida.setG(0);
		salida.setH(calcularDistancia(salida,meta));

		ListaAbierta[0]=salida;
		actual=ListaAbierta[posSigElemLA];
		posSigElemLA++;

		while(!metaEnListaCerrada && ListaAbierta[0]!=null){
			if(actual==Cuauhtémoc || actual==Felix_U_Gómez || actual== General_I_Zaragoza){
				desarrollarConDosLinea(actual,antDesarrollada,meta);
			}else{
				desarrollarConUnaLinea(actual,antDesarrollada,meta);
			}

			ListaCerrada[posSigElemLC]=actual;
			posSigElemLC++;
			if(ListaCerrada[posSigElemLC-1].getNombre()==meta.getNombre()){
				metaEnListaCerrada=true;
			}
			antDesarrollada=actual;
			quitarListaAbierta(actual);
			if(ListaAbierta[0]!=null)actual=siguienteEstacion();
		}

		AtributosEstacion[] trayecto=hallarTrayecto(salida,meta);
		AtributosEstacion siguiente = null;
		if(posFinCamino>1)siguiente= trayecto[posFinCamino-2];
		AtributosEstacion[] respuesta = recorrerTrayecto(salida,siguiente,trayecto);

		return respuesta;
	}

	private static double calcularDistancia (AtributosEstacion punto1,AtributosEstacion punto2){
		double R = 6378137;
		double distanciaLat = ((punto2.getLatitud()-punto1.getLatitud())*Math.PI/180);
		double distanciaLong = ((punto2.getLongitud()-punto1.getLongitud())*Math.PI/180);
		double a = Math.pow(Math.sin(distanciaLat/2),2) + Math.cos(punto1.getLatitud()*Math.PI/180) * Math.cos(punto2.getLatitud()*Math.PI/180) * Math.pow(Math.sin(distanciaLong/2),2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = R * c;
		return d;
	}

	private static double calcularG( AtributosEstacion anterior2,AtributosEstacion anterior,AtributosEstacion parada){
		int penalizacion=0;
		if(modo == 2 && anterior.isTransbordo() && anterior2.getLineas()[0]!=parada.getLineas()[0] )
			penalizacion=10000;
		return anterior.getG()+calcularDistancia(anterior,parada)+penalizacion;
	}

	private static AtributosEstacion siguienteEstacion(){
		AtributosEstacion res=ListaAbierta[0];
		double f=ListaAbierta[0].getG()+ListaAbierta[0].getH();

		for(int i=0; i<ListaAbierta.length && ListaAbierta[i]!=null;i++){
			if(f>ListaAbierta[i].getG()+ListaAbierta[i].getH()){
				f=ListaAbierta[i].getG()+ListaAbierta[i].getH();
				res=ListaAbierta[i];
			}
		}
		return res;
	}

	private static void quitarListaAbierta(AtributosEstacion actual){
		boolean encontrado=false;
		int i=0;
		while(!encontrado && i<ListaAbierta.length-1){
			if(ListaAbierta[i]==actual){
				encontrado=true;
			}
			i++;
		}

		for(int j=i-1;j<ListaAbierta.length-1 && ListaAbierta[j]!=null;j++){
			ListaAbierta[j]=ListaAbierta[j+1];
		}
		if(ListaAbierta[ListaAbierta.length-1]!=null){
			ListaAbierta[ListaAbierta.length-1]=null;
		}
		if(posSigElemLA>0)posSigElemLA--;
	}

	private static AtributosEstacion[] hallarTrayecto(AtributosEstacion salida, AtributosEstacion meta){

		AtributosEstacion predecesor = meta;
		AtributosEstacion actual=meta;
		AtributosEstacion siguiente=meta;
		int aux=1;
		int caso=1;
		int caso2=0;
		AtributosEstacion[] res = new AtributosEstacion[70];
		res[0]=meta;
		while(actual.getNombre()!=salida.getNombre()){

			if(actual.getNombre()==Cuauhtémoc.getNombre()){
				caso=3;
				caso2=0;
			}else if(actual.getNombre()==Felix_U_Gómez.getNombre()){
				caso=3;
				caso2=1;
			}else if(actual.getNombre()==General_I_Zaragoza.getNombre()){
				caso=3;
				caso2=2;
			}

			switch(caso){
			case 3://transbordos
				boolean hayPredecesor2 = false;
				AtributosEstacion auxiliar2=null;
				//Cuauhtémoc
				if(caso2==0){
					for(int i=0; i<posSigElemLC;i++){
						if(Central.getNombre()==ListaCerrada[i].getNombre() 
								&& Central.getNombre()!=predecesor.getNombre()){
							if(!hayPredecesor2){
								auxiliar2=ListaCerrada[i];
								hayPredecesor2=true;
							}else if(ListaCerrada[i].getG()<auxiliar2.getG()){
								auxiliar2=ListaCerrada[i];
							}
						}
						if(Del_Golfo.getNombre()==ListaCerrada[i].getNombre() 
								&& Del_Golfo.getNombre()!=predecesor.getNombre()){
							if(!hayPredecesor2){
								auxiliar2=ListaCerrada[i];
								hayPredecesor2=true;
							}else if(ListaCerrada[i].getG()<auxiliar2.getG()){
								auxiliar2=ListaCerrada[i];
							}
						}
						if(General_Anaya.getNombre()==ListaCerrada[i].getNombre() 
								&& General_Anaya.getNombre()!=predecesor.getNombre()){
							if(!hayPredecesor2){
								auxiliar2=ListaCerrada[i];
								hayPredecesor2=true;
							}else if(ListaCerrada[i].getG()<auxiliar2.getG()){
								auxiliar2=ListaCerrada[i];
							}
						}
						if(Alameda.getNombre()==ListaCerrada[i].getNombre() 
								&& Alameda.getNombre()!=predecesor.getNombre()){
							if(!hayPredecesor2){
								auxiliar2=ListaCerrada[i];
								hayPredecesor2=true;
							}else if(ListaCerrada[i].getG()<auxiliar2.getG()){
								auxiliar2=ListaCerrada[i];
							}
						}
					}
					res[aux]=auxiliar2;
					posFinCamino++;
					predecesor=actual;
					actual=auxiliar2;
					aux++;
				}
				//Felix_U_Gómez
				if(caso2==1){
					for(int i=0; i<posSigElemLC;i++){
						if(Del_Golfo.getNombre()==ListaCerrada[i].getNombre() 
								&& Del_Golfo.getNombre()!=predecesor.getNombre()){
							if(!hayPredecesor2){
								auxiliar2=ListaCerrada[i];
								hayPredecesor2=true;
							}else if(ListaCerrada[i].getG()<auxiliar2.getG()){
								auxiliar2=ListaCerrada[i];
							}
						}
						if(Parque_Fundidora.getNombre()==ListaCerrada[i].getNombre() 
								&& Parque_Fundidora.getNombre()!=predecesor.getNombre()){
							if(!hayPredecesor2){
								auxiliar2=ListaCerrada[i];
								hayPredecesor2=true;
							}else if(ListaCerrada[i].getG()<auxiliar2.getG()){
								auxiliar2=ListaCerrada[i];
							}
						}
						if(Conchello.getNombre()==ListaCerrada[i].getNombre() 
								&& Conchello.getNombre()!=predecesor.getNombre()){
							if(!hayPredecesor2){
								auxiliar2=ListaCerrada[i];
								hayPredecesor2=true;
							}else if(ListaCerrada[i].getG()<auxiliar2.getG()){
								auxiliar2=ListaCerrada[i];
							}
						}
						if(Adolfo_Prieto.getNombre()==ListaCerrada[i].getNombre() 
								&& Adolfo_Prieto.getNombre()!=predecesor.getNombre()){
							if(!hayPredecesor2){
								auxiliar2=ListaCerrada[i];
								hayPredecesor2=true;
							}else if(ListaCerrada[i].getG()<auxiliar2.getG()){
								auxiliar2=ListaCerrada[i];
							}
						}
					}
					res[aux]=auxiliar2;
					posFinCamino++;
					predecesor=actual;
					actual=auxiliar2;
					aux++;
				}
				//General_I_Zaragoza
				if(caso2==2){
					for(int i=0; i<posSigElemLC;i++){
						if(Padre_Mier.getNombre()==ListaCerrada[i].getNombre() 
								&& Padre_Mier.getNombre()!=predecesor.getNombre()){
							if(!hayPredecesor2){
								auxiliar2=ListaCerrada[i];
								hayPredecesor2=true;
							}else if(ListaCerrada[i].getG()<auxiliar2.getG()){
								auxiliar2=ListaCerrada[i];
							}
						}
						if(Santa_Lucia.getNombre()==ListaCerrada[i].getNombre() 
								&& Santa_Lucia.getNombre()!=predecesor.getNombre()){
							if(!hayPredecesor2){
								auxiliar2=ListaCerrada[i];
								hayPredecesor2=true;
							}else if(ListaCerrada[i].getG()<auxiliar2.getG()){
								auxiliar2=ListaCerrada[i];
							}
						}
					}
					res[aux]=auxiliar2;
					posFinCamino++;
					predecesor=actual;
					actual=auxiliar2;
					aux++;
				}
				break;
			case 1:
				for(int i=0; i<posSigElemLC;i++){
					if(actual.getSigEstacion()[0]==ListaCerrada[i].getNombre() 
							&& actual.getSigEstacion()[0]!=predecesor.getNombre()){
						res[aux]=ListaCerrada[i];
						siguiente=ListaCerrada[i];
					}

					if(actual.getAntEstacion()[0]==ListaCerrada[i].getNombre()
							&& actual.getAntEstacion()[0]!=predecesor.getNombre()){
						res[aux]=ListaCerrada[i];
						siguiente=ListaCerrada[i];
					}

				}
				posFinCamino++;
				aux++;
				predecesor=actual;
				actual=siguiente;
			}
			caso=1;
		}
		return res;
	}

	private static void desarrollarConUnaLinea(AtributosEstacion actual, AtributosEstacion antDesarrollada, AtributosEstacion meta){

		boolean encontrado=false;
		int j=0;
		while(!encontrado && actual.getSigEstacion()[0]!=null && j<Paradas.length){			
			if(actual.getSigEstacion()[0]==Paradas[j].getNombre() && !enListaCerrada(Paradas[j]) && !enListaAbierta(Paradas[j])){
				Paradas[j].setG(calcularG(antDesarrollada,actual,Paradas[j]));
				Paradas[j].setH(calcularDistancia(Paradas[j],meta));
				ListaAbierta[posSigElemLA]=Paradas[j];
				posSigElemLA++;
				encontrado=true;
			}
			j++;
		}
		encontrado=false;
		j=0;
		while(!encontrado && actual.getAntEstacion()[0]!=null && j<Paradas.length){
			if(actual.getAntEstacion()[0]==Paradas[j].getNombre() && !enListaCerrada(Paradas[j]) && !enListaAbierta(Paradas[j])){
				Paradas[j].setG(calcularG(antDesarrollada,actual,Paradas[j]));
				Paradas[j].setH(calcularDistancia(Paradas[j],meta));
				ListaAbierta[posSigElemLA]=Paradas[j];
				posSigElemLA++;
				encontrado=true;
			}
			j++;
		}
	}

	private static void desarrollarConDosLinea(AtributosEstacion actual, AtributosEstacion antDesarrollada, AtributosEstacion meta){
		int caso=0;

		if(actual.getNombre()==Cuauhtémoc.getNombre()) caso=1;
		else if(actual.getNombre()== Felix_U_Gómez.getNombre()) caso=2;
		else if(actual.getNombre()== General_I_Zaragoza.getNombre()) caso=3;

		switch(caso){
		case 1://Cuauhtémoc
			if(!enListaCerrada(Central) && !enListaAbierta(Central)){
				Central.setG(calcularG(antDesarrollada,Cuauhtémoc,Central));
				Central.setH(calcularDistancia(Central,meta));
				ListaAbierta[posSigElemLA]=Central;
				posSigElemLA++;
			}
			if(!enListaCerrada(Del_Golfo) && !enListaAbierta(Del_Golfo)){
				Del_Golfo.setG(calcularG(antDesarrollada,Cuauhtémoc,Del_Golfo));
				Del_Golfo.setH(calcularDistancia(Del_Golfo,meta));
				ListaAbierta[posSigElemLA]=Del_Golfo;
				posSigElemLA++;
			}
			if(!enListaCerrada(General_Anaya) && !enListaAbierta(General_Anaya)){
				General_Anaya.setG(calcularG(antDesarrollada,Cuauhtémoc,General_Anaya));
				General_Anaya.setH(calcularDistancia(General_Anaya,meta));
				ListaAbierta[posSigElemLA]=General_Anaya;
				posSigElemLA++;
			}
			if(!enListaCerrada(Alameda) && !enListaAbierta(Alameda)){
				Alameda.setG(calcularG(antDesarrollada,Cuauhtémoc,Alameda));
				Alameda.setH(calcularDistancia(Alameda,meta));
				ListaAbierta[posSigElemLA]=Alameda;
				posSigElemLA++;
			}
			break;
		case 2://Felix_U_Gómez
			if(!enListaCerrada(Del_Golfo) && !enListaAbierta(Del_Golfo)){
				Del_Golfo.setG(calcularG(antDesarrollada,Felix_U_Gómez,Del_Golfo));
				Del_Golfo.setH(calcularDistancia(Del_Golfo,meta));
				ListaAbierta[posSigElemLA]=Del_Golfo;
				posSigElemLA++;
			}
			if(!enListaCerrada(Parque_Fundidora) && !enListaAbierta(Parque_Fundidora)){
				Parque_Fundidora.setG(calcularG(antDesarrollada,Felix_U_Gómez,Parque_Fundidora));
				Parque_Fundidora.setH(calcularDistancia(Parque_Fundidora,meta));
				ListaAbierta[posSigElemLA]=Parque_Fundidora;
				posSigElemLA++;
			}
			if(!enListaCerrada(Conchello) && !enListaAbierta(Conchello)){
				Conchello.setG(calcularG(antDesarrollada,Felix_U_Gómez,Conchello));
				Conchello.setH(calcularDistancia(Conchello,meta));
				ListaAbierta[posSigElemLA]=Conchello;
				posSigElemLA++;
			}
			if(!enListaCerrada(Adolfo_Prieto) && !enListaAbierta(Adolfo_Prieto)){
				Adolfo_Prieto.setG(calcularG(antDesarrollada,Felix_U_Gómez,Adolfo_Prieto));
				Adolfo_Prieto.setH(calcularDistancia(Adolfo_Prieto,meta));
				ListaAbierta[posSigElemLA]=Adolfo_Prieto;
				posSigElemLA++;
			}
			break;
		case 3://General_I_Zaragoza
			if(!enListaCerrada(Padre_Mier) && !enListaAbierta(Padre_Mier)){
				Padre_Mier.setG(calcularG(antDesarrollada,General_I_Zaragoza,Padre_Mier));
				Padre_Mier.setH(calcularDistancia(Padre_Mier,meta));
				ListaAbierta[posSigElemLA]=Padre_Mier;
				posSigElemLA++;
			}
			if(!enListaCerrada(Santa_Lucia) && !enListaAbierta(Santa_Lucia)){
				Santa_Lucia.setG(calcularG(antDesarrollada,General_I_Zaragoza,Santa_Lucia));
				Santa_Lucia.setH(calcularDistancia(Santa_Lucia,meta));
				ListaAbierta[posSigElemLA]=Santa_Lucia;
				posSigElemLA++;
			}
			break;
		}

	}

	private static AtributosEstacion[] recorrerTrayecto(AtributosEstacion salida, AtributosEstacion siguiente, AtributosEstacion[] camino){
		boolean encontrado = false;
		AtributosEstacion[] respuesta =new AtributosEstacion[posFinCamino+1];

		if(!salida.isTransbordo() && (salida.getLineas()[0]=="Verde")){
			if(modo==0)tiempo=tiempo+3;
			else if(modo==1) tiempo=tiempo+5;
			encontrado=true;
		}else if(!salida.isTransbordo() && salida.getLineas()[0]=="Amarilla"){
			if(modo==0)tiempo=tiempo+3;
			else if(modo==1) tiempo=tiempo+5;
			encontrado=true;
		}else if(!salida.isTransbordo() && salida.getLineas()[0]=="Rosa"){
			if(modo==0)tiempo=tiempo+3;
			else if(modo==1) tiempo=tiempo+5;
			encontrado=true;
		}
		if(!encontrado){
			if(siguiente.getLineas()[0]=="Verde"){
				if(modo==0)tiempo=tiempo+3;
				else if(modo==1) tiempo=tiempo+5;
			}else if(siguiente.getLineas()[0]=="Amarilla"){
				if(modo==0)tiempo=tiempo+3;
				else if(modo==1) tiempo=tiempo+5;
			}else if(siguiente.getLineas()[0]=="Rosa"){
				if(modo==0)tiempo=tiempo+3;
				else if(modo==1) tiempo=tiempo+5;
			}
		}

		int j=0;
		for(int i=posFinCamino; i>=0;i--){
			respuesta[j]=camino[i];
			j++;
		}

		for(int i=0;i<=posFinCamino;i++){
			if(i!=0 && i!=posFinCamino && respuesta[i].isTransbordo()){
				if(respuesta[i-1].getLineas()[0]!=respuesta[i+1].getLineas()[0]){
					tiempo=tiempo+respuesta[i].getTiempoTransbordo();
					if(respuesta[i+1].getLineas()[0]=="Verde"){
						if(modo==0)tiempo=tiempo+3;
						else if(modo==1) tiempo=tiempo+5;
					}else if(respuesta[i+1].getLineas()[0]=="Amarilla"){
						if(modo==0)tiempo=tiempo+3;
						else if(modo==1) tiempo=tiempo+5;
					}else if(respuesta[i+1].getLineas()[0]=="Rosa"){
						if(modo==0)tiempo=tiempo+3;
						else if(modo==1) tiempo=tiempo+5;
					}
				}
			}
		}
		for(int i =0;i<respuesta.length-1;i++){
			d = d + calcularDistancia(respuesta[i], respuesta[i+1]);
		}

		if(d!=0)
			tiempo =tiempo + ((camino[0].getG())/600);
		else
			tiempo=0;

		segundos = tiempo%1;
		tiempo=tiempo-segundos;
		segundos=segundos*60;
		return respuesta;
	}

	public static double getTiempo(){
		return tiempo;
	}

	public static double getSegundos(){
		segundos=Math.round(segundos);
		return segundos;
	}
	public static double getDistancia(){
		d=d*1000;
		d=Math.round(d);
		d=d/1000;
		return d;
	}

	private static boolean enListaCerrada(AtributosEstacion parada){
		boolean res = false;
		for(int i=0; i<posSigElemLC;i++){
			if(parada.getNombre()==ListaCerrada[i].getNombre()){
				res=true;
			}
		}
		return res;
	}

	private static boolean enListaAbierta(AtributosEstacion parada){
		boolean res = false;
		for(int i=0; i<posSigElemLA;i++){
			if(parada.getNombre()==ListaAbierta[i].getNombre()){
				res=true;
			}
		}
		return res;
	}

	public static void limpiarVariables(){

		for(int i=0;i<posSigElemLA && ListaAbierta[i]!=null;i++){
			ListaAbierta[i].setG(0);
			ListaAbierta[i].setH(0);
			ListaAbierta[i]=null;
		}
		for(int i=0;i<posSigElemLC && ListaCerrada[i]!=null;i++){
			ListaCerrada[i].setG(0);
			ListaCerrada[i].setH(0);
			ListaCerrada[i]=null;
		}
		posSigElemLA=0;
		posSigElemLC=0;
		posFinCamino=0;
		tiempo=0;
		segundos=0;
		d=0;
	}
}