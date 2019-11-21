public class EstacionesMonterrey{

	//Linea Amarilla(1)
	static AtributosEstacion Talleres = new AtributosEstacion("Talleres","San_Bernabé",null,false,"Amarilla",25.754019569730485, -100.36527872085571);
	static AtributosEstacion San_Bernabé = new AtributosEstacion("San_Bernabé","Unidad_Modelo","Talleres",false,"Amarilla",25.74841482979281,-100.36171674728394);
	static AtributosEstacion Unidad_Modelo = new AtributosEstacion("Unidad_Modelo","Aztlán","San_Bernabé",false,"Amarilla",25.74192073145334,-100.35480737686157);
	static AtributosEstacion Aztlán = new AtributosEstacion("Aztlán","Penitenciaría","Unidad_Modelo",false,"Amarilla",25.732391545934494,-100.34738302230835);
	static AtributosEstacion Penitenciaría = new AtributosEstacion("Penitenciaría","Alfonso_Reyes","Aztlán",false,"Amarilla",25.723267553136925,-100.34257650375366);
	static AtributosEstacion Alfonso_Reyes = new AtributosEstacion("Alfonso_Reyes","Mitras","Penitenciaría",false,"Amarilla",25.716037451562844,-100.34259796142578);
	static AtributosEstacion Mitras = new AtributosEstacion("Mitras","Simón_Bolívar","Alfonso_Reyes",false,"Amarilla",25.7060035077538,-100.3425121307373);
	static AtributosEstacion Simón_Bolívar = new AtributosEstacion("Simón_Bolívar","Hospital","Mitras",false,"Amarilla",25.69906238496458,-100.3432846069336);
	static AtributosEstacion Hospital = new AtributosEstacion("Hospital","Edison","Simón_Bolívar",false,"Amarilla",25.69215953006106,-100.3441858291626);
	static AtributosEstacion Edison = new AtributosEstacion("Edison","Central","Hospital",false,"Amarilla",25.68715132605641,-100.33362865447998);
	static AtributosEstacion Central= new AtributosEstacion("Central","Cuauhtémoc","Edison",false,"Amarilla",25.687228674437396,-100.32442331314087);
	static AtributosEstacion Cuauhtémoc = new AtributosEstacion("Cuauhtémoc","Del_Golfo","Central",true,5,"Alameda","General_Anaya","Amarilla","Verde",25.68639717670977,-100.31732082366943);
	static AtributosEstacion Del_Golfo = new AtributosEstacion("Del_Golfo","Felix_U_Gómez","Cuauhtémoc",false,"Amarilla",25.68514025052232,-100.30661344528198);
	static AtributosEstacion Felix_U_Gómez = new AtributosEstacion("Felix_U_Gómez","Parque_Fundidora","Del_Golfo",true,5,"Adolfo_Prieto","Conchello","Amarilla","Rosa",25.68396066157605,-100.29680728912354);
	static AtributosEstacion Parque_Fundidora = new AtributosEstacion("Parque_Fundidora","Y_Griega","Felix_U_Gómez",false,"Amarilla",25.68378662287394,-100.28822422027588);
	static AtributosEstacion Y_Griega = new AtributosEstacion("Y_Griega","Eloy_Cavazos","Parque_Fundidora",false,"Amarilla",25.683341856146832,-100.27964115142822);
	static AtributosEstacion Eloy_Cavazos = new AtributosEstacion("Eloy_Cavazos","Lerdo_de_Tejada","Y_Griega",false,"Amarilla",25.680093074914446,-100.2642560005188);
	static AtributosEstacion Lerdo_de_Tejada = new AtributosEstacion("Lerdo_de_Tejada","Exposición","Eloy_Cavazos",false,"Amarilla",25.679822339146607,-100.25232553482056);
	static AtributosEstacion Exposición = new AtributosEstacion("Exposición",null,"Lerdo_de_Tejada",false,"Amarilla",25.679532264427028,-100.24558782577515);

	//Linea Verde (2)
	static AtributosEstacion Sendero = new AtributosEstacion("Sendero","Santiago_Tapia",null,false,"Verde",25.768629303392043,-100.29288053512573);
	static AtributosEstacion Santiago_Tapia = new AtributosEstacion("Santiago_Tapia","San_Nicolás","Sendero",false,"Verde",25.759208550046573,-100.29569149017334);
	static AtributosEstacion San_Nicolás = new AtributosEstacion("San_Nicolás","Anáhuac","Santiago_Tapia",false,"Verde",25.75272470503038,-100.29803037643433);
	static AtributosEstacion Anáhuac = new AtributosEstacion("Anáhuac","Universidad","San_Nicolás",false,"Verde",25.739775281683535,-100.30272960662842);
	static AtributosEstacion Universidad = new AtributosEstacion("Universidad","Niños_Héroes","Anáhuac",false,"Verde",25.724388759472287,-100.30824422836304);
	static AtributosEstacion Niños_Héroes = new AtributosEstacion("Niños_Héroes","Regina","Universidad",false,"Verde",25.71702340038231,-100.31090497970581);
	static AtributosEstacion Regina = new AtributosEstacion("Regina","General_Anaya","Niños_Héroes",false,"Verde",25.708284902625707,-100.3141450881958);
	static AtributosEstacion General_Anaya = new AtributosEstacion("General_Anaya","Cuauhtémoc","Regina",false,"Verde",25.697167523466092,-100.31663417816162);
	static AtributosEstacion Alameda = new AtributosEstacion("Alameda","Fundadores","Cuauhtémoc",false,"Verde",25.677056931431586,-100.31813621520996);
	static AtributosEstacion Fundadores = new AtributosEstacion("Fundadores","Padre_Mier","Alameda",false,"Verde",25.672492901433582,-100.31911253929138);
	static AtributosEstacion Padre_Mier = new AtributosEstacion("Padre_Mier","General_I_Zaragoza","Fundadores",false,"Verde",25.66860560248465,-100.31546473503113);
	static AtributosEstacion General_I_Zaragoza = new AtributosEstacion("General_I_Zaragoza",null,"Padre_Mier",true,5,null,"Santa_Lucia","Verde","Rosa",25.667744964434828,-100.31023979187012);

	//Linea Rosa(3)
	static AtributosEstacion Hospital_Metropolitano = new AtributosEstacion("Hospital_Metropolitano","Los_Ángeles",null,false,"Rosa",25.7137923,-100.2732006);
	static AtributosEstacion Los_Ángeles = new AtributosEstacion("Los_Ángeles","Ruíz_Cortines","Hospital_Metropolitano",false,"Rosa",25.708188234238758,-100.28140604496002);
	static AtributosEstacion Ruíz_Cortines = new AtributosEstacion("Ruíz_Cortines","Violeta","Los_Ángeles",false,"Rosa",25.70370273473855,-100.28787553310394);
	static AtributosEstacion Violeta = new AtributosEstacion("Violeta","Conchello","Ruíz_Cortines",false,"Rosa",25.7004216,-100.2928895);
	static AtributosEstacion Conchello= new AtributosEstacion("Conchello","Felix_U_Gómez","Violeta",false,"Rosa",25.691054939460663,-100.29584035277367);
	static AtributosEstacion Adolfo_Prieto = new AtributosEstacion("Adolfo_Prieto","Santa_Lucia","Felix_U_Gómez",false,"Rosa",25.677844982475868,-100.29763609170914);
	static AtributosEstacion Santa_Lucia = new AtributosEstacion("Santa_Lucia","General_I_Zaragoza","Adolfo_Prieto",false,"Rosa",25.672226983281032,-100.29855877161026);

	static AtributosEstacion[] Paradas = {Adolfo_Prieto,Alameda,Alfonso_Reyes,Anáhuac,Aztlán,Central,Conchello,Cuauhtémoc,Del_Golfo,Edison,Eloy_Cavazos,Exposición,Felix_U_Gómez,
		Fundadores,General_Anaya,General_I_Zaragoza,Hospital,Hospital_Metropolitano,Lerdo_de_Tejada,Los_Ángeles,Mitras,Niños_Héroes,Padre_Mier,Parque_Fundidora,Penitenciaría,
		Regina,Ruíz_Cortines,San_Bernabé,San_Nicolás,Santa_Lucia,Santiago_Tapia,Sendero,Simón_Bolívar,Talleres,Unidad_Modelo,Universidad,Violeta,Y_Griega};
	
	static String[] horario = {"5:00-7:00","7:00-9:30*","9:30-13:00","13:00-15:00*","15:00-19:00","19:00-21:30*","21:30-23:00"};
}