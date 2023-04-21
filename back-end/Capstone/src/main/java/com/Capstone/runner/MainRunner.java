package com.Capstone.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.Capstone.entity.Maglia;
import com.Capstone.entity.Squadra;
import com.Capstone.exception.ValidateException;
import com.Capstone.payload.JWTAuthResponse;
import com.Capstone.payload.LoginDto;
import com.Capstone.payload.RegisterDto;
import com.Capstone.repository.SquadraRepository;
import com.Capstone.repository.UserRepository;
import com.Capstone.service.AuthService;
import com.Capstone.service.MagliaService;

@Component
public class MainRunner implements ApplicationRunner {
	
	
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	SquadraRepository squadraRepository;
	
	@Autowired 
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthService authService;
	
	@Autowired
	MagliaService magliaService;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Running!");
		//provaLogin();
//		insertSquadraSerieA();
//        insertSquadraPremier();
//        insertSquadraBundes();
//		insertSquadraLiga();
//		insertSquadraLigue1();
//		creaTutteMaglie();

	}
	
	private void creaMaglia(String nome, Squadra squadra, String colore, Double prezzo, String immagine) {
		Maglia mom= new Maglia(nome, squadra, colore, prezzo, immagine);

		try {
			magliaService.insertMaglia(mom);
		} catch (ValidateException e) {
			e.printStackTrace();
		}
	}
	
	private void insertUtenteProva() {
		RegisterDto u = new RegisterDto("Mario", "Rossi", "Red1", "mario.rossi@gmail.com", "ciao123", "via obh");
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		authService.saveUtente(u);
	}
	
	private void provaLogin() {
		LoginDto u = new LoginDto("Red1", "ciao123");
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		String token = authService.loginUtente(u);

		JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
		jwtAuthResponse.setEmail(u.getEmail());
		jwtAuthResponse.setAccessToken(token);
		System.out.println(u.toString());
	}
	
	private void insertSquadraSerieA() {
		Squadra s = new Squadra("Atalanta", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Atalanta.png");
		Squadra s1 = new Squadra("Bologna", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Bologna.png");
		Squadra s2 = new Squadra("Cremonese", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Cremonese.png");
		Squadra s3 = new Squadra("Empoli", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Empoli.png");
		Squadra s4 = new Squadra("Fiorentina", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Fiorentina.png");
		Squadra s5 = new Squadra("Hellas Verona", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Hellas Verona.png");
		Squadra s6 = new Squadra("Inter", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Inter.png");
		Squadra s7 = new Squadra("Juventus", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Juventus.png");
		Squadra s8 = new Squadra("Lazio", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Lazio.png");
		Squadra s9 = new Squadra("Lecce", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Lecce.png");
		Squadra s10 = new Squadra("Milan", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Milan.png");
		Squadra s11 = new Squadra("Monza", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Monza.png");
		Squadra s12 = new Squadra("Napoli", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Napoli.png");
		Squadra s13 = new Squadra("Roma", "Serie A", "..\\..\\..\\assets\\img\\loghi-serie-a\\Roma.png");
		Squadra s14 = new Squadra("Salernitana", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Salernitana.png");
		Squadra s15 = new Squadra("Sampdoria", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Sampdoria.png");
		Squadra s16 = new Squadra("Sassuolo", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Sassuolo.png");
		Squadra s17 = new Squadra("Spezia", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Spezia.png");
		Squadra s18 = new Squadra("Torino", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Torino.png");
		Squadra s19 = new Squadra("Udinese", "Serie A","..\\..\\..\\assets\\img\\loghi-serie-a\\Udinese.png");
		
		squadraRepository.save(s);
		squadraRepository.save(s1);
		squadraRepository.save(s2);
		squadraRepository.save(s3);
		squadraRepository.save(s4);
		squadraRepository.save(s5);
		squadraRepository.save(s6);
		squadraRepository.save(s7);
		squadraRepository.save(s8);
		squadraRepository.save(s9);
		squadraRepository.save(s10);
		squadraRepository.save(s11);
		squadraRepository.save(s12);
		squadraRepository.save(s13);
		squadraRepository.save(s14);
		squadraRepository.save(s15);
		squadraRepository.save(s16);
		squadraRepository.save(s17);
		squadraRepository.save(s18);
		squadraRepository.save(s19);
	}

	private void insertSquadraPremier() {
		Squadra s = new Squadra("Arsenal FC", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Arsenal.png");
		Squadra s1 = new Squadra("Aston Villa", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Aston Villa.png");
		Squadra s2 = new Squadra("Bournemouth", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Bournemouth.png");
		Squadra s3 = new Squadra("Brentford", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Brentford.png");
		Squadra s4 = new Squadra("Brighton", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Brighton.png");
		Squadra s5 = new Squadra("Chelsea FC", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Chelsea.png");
		Squadra s6 = new Squadra("Crystal Palace", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Crystal Palace.png");
		Squadra s7 = new Squadra("Everton", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Everton.png");
		Squadra s8 = new Squadra("Fulham", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Fulham.png");
		Squadra s9 = new Squadra("Leeds United", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Leeds.png");
		Squadra s10 = new Squadra("Leicester City", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Leicester.png");
		Squadra s11 = new Squadra("Liverpool FC", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Liverpool.png");
		Squadra s12 = new Squadra("Manchester City", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Manchester City.png");
		Squadra s13 = new Squadra("Manchester United", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Manchester United.png");
		Squadra s14 = new Squadra("Newcastle United", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Newcastle.png");
		Squadra s15 = new Squadra("Nottingham Forest", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Nottingham.png");
		Squadra s16 = new Squadra("Southampton", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Southampton.png");
		Squadra s17 = new Squadra("Tottenham Hotspur", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Tottenham.png");
		Squadra s18 = new Squadra("West Ham", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\West Ham.png");
		Squadra s19 = new Squadra("Wolverhampton", "Premier League","..\\..\\..\\assets\\img\\loghi-premier\\Wolverhampton.png");
		
		squadraRepository.save(s);
		squadraRepository.save(s1);
		squadraRepository.save(s2);
		squadraRepository.save(s3);
		squadraRepository.save(s4);
		squadraRepository.save(s5);
		squadraRepository.save(s6);
		squadraRepository.save(s7);
		squadraRepository.save(s8);
		squadraRepository.save(s9);
		squadraRepository.save(s10);
		squadraRepository.save(s11);
		squadraRepository.save(s12);
		squadraRepository.save(s13);
		squadraRepository.save(s14);
		squadraRepository.save(s15);
		squadraRepository.save(s16);
		squadraRepository.save(s17);
		squadraRepository.save(s18);
		squadraRepository.save(s19);
	}

	private void insertSquadraBundes() {
		Squadra s = new Squadra("1.FC Köln", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\1.Koln.png");
		Squadra s1 = new Squadra("Bayer 04 Leverkusen", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\Bayer Leverkusen.png");
		Squadra s2 = new Squadra("Bayern München", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\Bayern Monaco.png");
		Squadra s3 = new Squadra("Borussia Dortmund", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\Borussia Dortmund.png");
		Squadra s4 = new Squadra("Borussia Mönchengladbach II", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\Borussia Moenchengladbach.png");
		Squadra s5 = new Squadra("Eintracht Frankfurt", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\Eintracht Francoforte.png");
		Squadra s6 = new Squadra("FC Augsburg", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\Fc Augsburg.png");
		Squadra s7 = new Squadra("Herta BSC", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\Herta BSC.png");
		Squadra s8 = new Squadra("Mainz", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\Mainz.png");
		Squadra s9 = new Squadra("RB Leipzig", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\RB Leipzig.png");
		Squadra s10 = new Squadra("SC Freiburg", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\SC Freiburg.png");
		Squadra s11 = new Squadra("Schalke 04", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\Schalke 04.png");
		Squadra s12 = new Squadra("TSG 1899 Hoffenheim", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\TSG Hoffeneim.png");
		Squadra s13 = new Squadra("Union Berlin", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\Union Berlino.png");
		Squadra s14 = new Squadra("VfB Stuttgart", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\VfB Stuttgart.png");
		Squadra s15 = new Squadra("VfL Bochum", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\VfL Bochum.png");
		Squadra s16 = new Squadra("VfL Wolfsburg", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\VfL Wolfsburg.png");
		Squadra s17 = new Squadra("Werder Bremen", "Bundesliga","..\\..\\..\\assets\\img\\loghi-bundes\\Werder Brema.png");
		
		squadraRepository.save(s);
		squadraRepository.save(s1);
		squadraRepository.save(s2);
		squadraRepository.save(s3);
		squadraRepository.save(s4);
		squadraRepository.save(s5);
		squadraRepository.save(s6);
		squadraRepository.save(s7);
		squadraRepository.save(s8);
		squadraRepository.save(s9);
		squadraRepository.save(s10);
		squadraRepository.save(s11);
		squadraRepository.save(s12);
		squadraRepository.save(s13);
		squadraRepository.save(s14);
		squadraRepository.save(s15);
		squadraRepository.save(s16);
		squadraRepository.save(s17);		
	}
	
	private void insertSquadraLiga() {
		Squadra s = new Squadra("Athletic Club", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Athletic.png");
		Squadra s1 = new Squadra("Atlético Madrid", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Atletico Madrid.png");
		Squadra s2 = new Squadra("Cádiz", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Cadice.png");
		Squadra s3 = new Squadra("Celta Vigo", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Celta Vigo.png");
		Squadra s4 = new Squadra("Elche", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Elche.png");
		Squadra s5 = new Squadra("Espanyol", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Espanyol.png");
		Squadra s6 = new Squadra("FC Barcelona", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\FC Barcelona.png");
		Squadra s7 = new Squadra("Getafe", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Getafe.png");
		Squadra s8 = new Squadra("Girona", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Girona.png");
		Squadra s9 = new Squadra("Osasuna", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Osasuna.png");
		Squadra s10 = new Squadra("Rayo Vallejano", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Rayo Vallejano.png");
		Squadra s11 = new Squadra("RCD Mallorca", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\RCD Mallorca.png");
		Squadra s12 = new Squadra("Real Betis", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Real Betis.png");
		Squadra s13 = new Squadra("Real Madrid", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Real Madrid.png");
		Squadra s14 = new Squadra("Real Sociedad", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Real Sociedad.png");
		Squadra s15 = new Squadra("Sevilla FC", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Sevilla.png");
		Squadra s16 = new Squadra("U.D. Almería", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\U.D Almeria.png");
		Squadra s17 = new Squadra("Valencia", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Valencia.png");
		Squadra s18 = new Squadra("Valladolid", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Valladolid.png");
		Squadra s19 = new Squadra("Villareal", "Liga Santander","..\\..\\..\\assets\\img\\loghi-liga\\Villareal.png");

		squadraRepository.save(s);
		squadraRepository.save(s1);
		squadraRepository.save(s2);
		squadraRepository.save(s3);
		squadraRepository.save(s4);
		squadraRepository.save(s5);
		squadraRepository.save(s6);
		squadraRepository.save(s7);
		squadraRepository.save(s8);
		squadraRepository.save(s9);
		squadraRepository.save(s10);
		squadraRepository.save(s11);
		squadraRepository.save(s12);
		squadraRepository.save(s13);
		squadraRepository.save(s14);
		squadraRepository.save(s15);
		squadraRepository.save(s16);
		squadraRepository.save(s17);
		squadraRepository.save(s18);
		squadraRepository.save(s19);		
	}
	
	private void insertSquadraLigue1() {
		Squadra s = new Squadra("AC Ajaccio", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\AC Ajaccio.png");
		Squadra s1 = new Squadra("AJ Auxerre", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\AJ Auxerre.png");
		Squadra s2 = new Squadra("Angers", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Angers.png");
		Squadra s3 = new Squadra("AS Monaco", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\AS Monaco.png");
		Squadra s4 = new Squadra("Clermont", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Clermont.png");
		Squadra s5 = new Squadra("ESTAC Troyes", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\ESTAC Troyes.png");
		Squadra s6 = new Squadra("Lille LOSC", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Lille LOSC.png");
		Squadra s7 = new Squadra("Lorient", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Lorient.png");
		Squadra s8 = new Squadra("Montpellier", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Montpellier.png");
		Squadra s9 = new Squadra("Nantes", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Nantes.png");
		Squadra s10 = new Squadra("Nice", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Nice.png");
		Squadra s11 = new Squadra("Olympique Lyonnais", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Olympique Lyonnais.png");
		Squadra s12 = new Squadra("Olympique Marseille", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Olympique Marseille.png");
		Squadra s13 = new Squadra("Paris Saint-Germain", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Paris-Saint Germain.png");
		Squadra s14 = new Squadra("RC Lens", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\RC Lens.png");
		Squadra s15 = new Squadra("Stade Brestois", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Stade Brestois.png");
		Squadra s16 = new Squadra("Stade Reims", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Stade Reims.png");
		Squadra s17 = new Squadra("Stade Rennais", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Stade Rennais.png");
		Squadra s18 = new Squadra("Strasbourg", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Strasbourg.png");
		Squadra s19 = new Squadra("Toulouse", "Ligue 1","..\\..\\..\\assets\\img\\loghi-ligue1\\Toulouse.png");
		
		squadraRepository.save(s);
		squadraRepository.save(s1);
		squadraRepository.save(s2);
		squadraRepository.save(s3);
		squadraRepository.save(s4);
		squadraRepository.save(s5);
		squadraRepository.save(s6);
		squadraRepository.save(s7);
		squadraRepository.save(s8);
		squadraRepository.save(s9);
		squadraRepository.save(s10);
		squadraRepository.save(s11);
		squadraRepository.save(s12);
		squadraRepository.save(s13);
		squadraRepository.save(s14);
		squadraRepository.save(s15);
		squadraRepository.save(s16);
		squadraRepository.save(s17);
		squadraRepository.save(s18);
		squadraRepository.save(s19);
	}
	
	private void insertSquadraNazionali() {
		
	}

	private void creaTutteMaglie() {
		//SERIE A
	    Squadra s = (Squadra) squadraRepository.findById(1).get();
		creaMaglia("Maglia Casa", s, "Nero-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Atalanta\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Atalanta\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Atalanta\\terza front.jpg");
		creaMaglia("Maglia Speciale", s, "Nero-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Atalanta\\special front.jpg");
		creaMaglia("Maglia Portiere 1", s, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Atalanta\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Atalanta\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Atalanta\\portieri 3.jpg");
		Squadra s1 = (Squadra) squadraRepository.findById(2).get();
		creaMaglia("Maglia Casa", s1, "Rosso-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Bologna\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s1, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Bologna\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s1, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Bologna\\terza front.jpg");
		creaMaglia("Maglia Speciale", s1, "Rosa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Bologna\\special front.jpg");
		creaMaglia("Maglia Portiere 1", s1, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Bologna\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s1, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Bologna\\portieri 2.jpg");
		Squadra s2 = (Squadra) squadraRepository.findById(3).get();
		creaMaglia("Maglia Casa", s2, "Grigio-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Cremonese\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s2, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Cremonese\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s2, "Rosso-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Cremonese\\terza front.jpg");
		creaMaglia("Maglia Speciale", s2, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Cremonese\\special front.jpg");
		creaMaglia("Maglia Portiere 1", s2, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Cremonese\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s2, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Cremonese\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s2, "Arancione-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Cremonese\\portieri 3.jpg");
		Squadra s3 = (Squadra) squadraRepository.findById(4).get();
		creaMaglia("Maglia Casa", s3, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Empoli\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s3, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Empoli\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s3, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Empoli\\terza front.jpg");
		creaMaglia("Maglia Portiere 1", s3, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Empoli\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s3, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Empoli\\portieri 2.jpg");
		Squadra s4 = (Squadra) squadraRepository.findById(5).get();
		creaMaglia("Maglia Casa", s4, "Viola" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Fiorentina\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s4, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Fiorentina\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s4, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Fiorentina\\terza front.jpg");
		creaMaglia("Maglia Speciale", s4, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Fiorentina\\special front.jpg");
		creaMaglia("Maglia Portiere 1", s4, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Fiorentina\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s4, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Fiorentina\\portieri 2.jpg");
		Squadra s5 = (Squadra) squadraRepository.findById(6).get();
		creaMaglia("Maglia Casa", s5, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Hellas Verona\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s5, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Hellas Verona\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s5, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Hellas Verona\\terza front.jpg");
		creaMaglia("Maglia Portiere 1", s5, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Hellas Verona\\portieri 1.png");
		Squadra s6 = (Squadra) squadraRepository.findById(7).get();
		creaMaglia("Maglia Casa", s6, "Nero-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Inter\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s6, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Inter\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s6, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Inter\\terza front.jpg");
		creaMaglia("Maglia Portiere 1", s6, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Inter\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s6, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Inter\\portieri 2.jpg");
		Squadra s7 = (Squadra) squadraRepository.findById(8).get();
		creaMaglia("Maglia Casa", s7, "Bianco-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Juventus\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s7, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Juventus\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s7, "Rosa-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Juventus\\terza front.jpg");
		creaMaglia("Maglia Portiere 1", s7, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Juventus\\portieri 1.jpg");
		Squadra s8 = (Squadra) squadraRepository.findById(9).get();
		creaMaglia("Maglia Casa", s8, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Lazio\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s8, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Lazio\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s8, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Lazio\\terza front.jpg");
		creaMaglia("Maglia Portiere 1", s8, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Lazio\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s8, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Lazio\\portieri 2.jpg");
		Squadra s9 = (Squadra) squadraRepository.findById(10).get();
		creaMaglia("Maglia Casa", s9, "Giallo-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Lecce\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s9, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Lecce\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s9, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Lecce\\terza front.jpg");
		Squadra s10 = (Squadra) squadraRepository.findById(11).get();
		creaMaglia("Maglia Casa", s10, "Rosso-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Milan\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s10, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Milan\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s10, "Marrone" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Milan\\terza front.jpg");
		creaMaglia("Maglia Speciale", s10, "Rosso-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Milan\\special front.jpg");
		creaMaglia("Maglia Portiere 1", s10, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Milan\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s10, "Viola" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Milan\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s10, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Milan\\portieri 3.jpg");
		creaMaglia("Maglia Portiere 4", s10, "Beige" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Milan\\portieri 4.jpg");
		Squadra s11 = (Squadra) squadraRepository.findById(12).get();
		creaMaglia("Maglia Casa", s11, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Monza\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s11, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Monza\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s11, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Monza\\terza front.jpg");
		creaMaglia("Maglia Portiere 1", s11, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Monza\\portieri 1.jpg");
		Squadra s12 = (Squadra) squadraRepository.findById(13).get();
		creaMaglia("Maglia Casa", s12, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Napoli\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s12, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Napoli\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s12, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Napoli\\terza front.jpg");
		creaMaglia("Maglia Speciale 1", s12, "Bianco-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Napoli\\special 1 front.jpg");
		creaMaglia("Maglia Speciale 2", s12, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Napoli\\special 2 front.jpg");
		creaMaglia("Maglia Speciale 3", s12, "Azzurro-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Napoli\\special 3 front.jpg");
		creaMaglia("Maglia Portiere 1", s12, "Rosa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Napoli\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s12, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Napoli\\portieri 2.jpg");
		Squadra s13 = (Squadra) squadraRepository.findById(14).get();
		creaMaglia("Maglia Casa", s13, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Roma\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s13, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Roma\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s13, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Roma\\terza front.jpg");
		creaMaglia("Maglia Portiere 1", s13, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Roma\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s13, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Roma\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s13, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Roma\\portieri 3.jpg");
		Squadra s14 = (Squadra) squadraRepository.findById(15).get();
		creaMaglia("Maglia Casa", s14, "Granata" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Salernitana\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s14, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Salernitana\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s14, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Salernitana\\terza front.jpg");
		creaMaglia("Quarta Maglia", s14, "Blu" , 89.90, "..\\..\\\\..\\assets\\img\\maglie\\Serie A\\Salernitana\\quarta front.jpg");
		creaMaglia("Maglia Speciale", s14, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Salernitana\\speciale front.jpg");
		creaMaglia("Maglia Portiere 1", s14, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Salernitana\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s14, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Salernitana\\portieri 2.jpg");
		Squadra s15 = (Squadra) squadraRepository.findById(16).get();
		creaMaglia("Maglia Casa", s15, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Sampdoria\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s15, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Sampdoria\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s15, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Sampdoria\\terza front.jpg");
		creaMaglia("Maglia Portiere 1", s15, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Sampdoria\\portieri 1.jpg");
		Squadra s16 = (Squadra) squadraRepository.findById(17).get();
		creaMaglia("Maglia Casa", s16, "Nero-Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Sassuolo\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s16, "Bianco-Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Sassuolo\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s16, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Sassuolo\\terza front.jpg");
		creaMaglia("Maglia Portiere 1", s16, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Sassuolo\\portieri 1.jpg");
		Squadra s17 = (Squadra) squadraRepository.findById(18).get();
		creaMaglia("Maglia Casa", s17, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Spezia\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s17, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Spezia\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s17, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Spezia\\terza front.jpg");
		creaMaglia("Maglia Portiere 1", s17, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Spezia\\portieri 1.jpg");
		Squadra s18 = (Squadra) squadraRepository.findById(19).get();
		creaMaglia("Maglia Casa", s18, "Granata" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Torino\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s18, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Torino\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s18, "Granata-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Torino\\terza front.jpg");
		creaMaglia("Maglia Portiere 1", s18, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Torino\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s18, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Torino\\portieri 2.jpg");
		Squadra s19 = (Squadra) squadraRepository.findById(20).get();
		creaMaglia("Maglia Casa", s19, "Bianco-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Udinese\\casa front.jpg");
		creaMaglia("Maglia Trasferta", s19, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Udinese\\trasferta front.jpg");
		creaMaglia("Terza Maglia", s19, "Grigio" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Udinese\\terza front.jpg");
		creaMaglia("Maglia Portiere 1", s19, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Udinese\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s19, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Serie A\\Udinese\\portieri 2.jpg");
		
		//PREMIER LEAGUE
		Squadra s20 = (Squadra) squadraRepository.findById(21).get();
		creaMaglia("Maglia Casa", s20, "Rosso-Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Arsenal\\casa.jpg");
		creaMaglia("Maglia Trasferta", s20, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Arsenal\\trasferta.jpg");
		creaMaglia("Terza Maglia", s20, "Rosa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Arsenal\\terza.jpg");
		creaMaglia("Maglia Speciale", s20, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Arsenal\\special.jpg");
		creaMaglia("Maglia Portiere 1", s20, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Arsenal\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s20, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Arsenal\\portieri 2.jpg");
		Squadra s21 = (Squadra) squadraRepository.findById(22).get();
		creaMaglia("Maglia Casa", s21, "Bordeaux-Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Aston Villa\\casa.jpg");
		creaMaglia("Maglia Trasferta", s21, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Aston Villa\\trasferta.jpg");
		creaMaglia("Terza Maglia", s21, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Aston Villa\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s21, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Aston Villa\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s21, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Aston Villa\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s21, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Aston Villa\\portieri 3.jpg");
		Squadra s22 = (Squadra) squadraRepository.findById(23).get();
		creaMaglia("Maglia Casa", s22, "Rosso-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Bournemouth\\casa.jpg");
		creaMaglia("Maglia Trasferta", s22, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Bournemouth\\trasferta.jpg");
		creaMaglia("Terza Maglia", s22, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Bournemouth\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s22, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Bournemouth\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s22, "Grigio" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Bournemouth\\portieri 2.jpg");
		Squadra s23 = (Squadra) squadraRepository.findById(24).get();
		creaMaglia("Maglia Casa", s23, "Rosso-Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Brentford\\casa.jpg");
		creaMaglia("Maglia Trasferta", s23, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Brentford\\trasferta.jpg");
		creaMaglia("Terza Maglia", s23, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Brentford\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s23, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Brentford\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s23, "Viola" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Brentford\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s23, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Brentford\\portieri 3.jpg");
		Squadra s24 = (Squadra) squadraRepository.findById(25).get();
		creaMaglia("Maglia Casa", s24, "Bianco-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Brighton\\casa.jpg");
		creaMaglia("Maglia Trasferta", s24, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Brighton\\trasferta.jpg");
		creaMaglia("Terza Maglia", s24, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Brighton\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s24, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Brighton\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s24, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Brighton\\portieri 2.jpg");
		Squadra s25 = (Squadra) squadraRepository.findById(26).get();
		creaMaglia("Maglia Casa", s25, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Chelsea\\casa.jpg");
		creaMaglia("Maglia Trasferta", s25, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Chelsea\\trasferta.jpg");
		creaMaglia("Terza Maglia", s25, "Beige" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Chelsea\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s25, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Chelsea\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s25, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Chelsea\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s25, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Chelsea\\portieri 3.jpg");
		Squadra s26 = (Squadra) squadraRepository.findById(27).get();
		creaMaglia("Maglia Casa", s26, "Rosso-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Crystal Palace\\casa.jpg");
		creaMaglia("Maglia Trasferta", s26, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Crystal Palace\\trasferta.jpg");
		creaMaglia("Terza Maglia", s26, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Crystal Palace\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s26, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Crystal Palace\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s26, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Crystal Palace\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s26, "Rosa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Crystal Palace\\portieri 3.jpg");
		Squadra s27 = (Squadra) squadraRepository.findById(28).get();
		creaMaglia("Maglia Casa", s27, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Everton\\casa.jpg");
		creaMaglia("Maglia Trasferta", s27, "Rosa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Everton\\trasferta.jpg");
		creaMaglia("Terza Maglia", s27, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Everton\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s27, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Everton\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s27, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Everton\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s27, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Everton\\portieri 3.jpg");
		Squadra s28 = (Squadra) squadraRepository.findById(29).get();
		creaMaglia("Maglia Casa", s28, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Fulham\\casa.jpg");
		creaMaglia("Maglia Trasferta", s28, "Celeste-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Fulham\\trasferta.jpg");
		creaMaglia("Terza Maglia", s28, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Fulham\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s28, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Fulham\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s28, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Fulham\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s28, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Fulham\\portieri 3.jpg");
		Squadra s29 = (Squadra) squadraRepository.findById(30).get();
		creaMaglia("Maglia Casa", s29, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Leeds United\\casa.jpg");
		creaMaglia("Maglia Trasferta", s29, "Giallo-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Leeds United\\trasferta.jpg");
		creaMaglia("Terza Maglia", s29, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Leeds United\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s29, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Leeds United\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s29, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Leeds United\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s29, "Grigio" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Leeds United\\portieri 3.jpg");
		Squadra s30 = (Squadra) squadraRepository.findById(31).get();
		creaMaglia("Maglia Casa", s30, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Leicester City\\casa.jpg");
		creaMaglia("Maglia Trasferta", s30, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Leicester City\\trasferta.jpg");
		creaMaglia("Terza Maglia", s30, "Bianco-Beige" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Leicester City\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s30, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Leicester City\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s30, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Leicester City\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s30, "Grigio" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Leicester City\\portieri 3.jpg");
		Squadra s31 = (Squadra) squadraRepository.findById(32).get();
		creaMaglia("Maglia Casa", s31, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Liverpool\\casa.jpg");
		creaMaglia("Maglia Trasferta", s31, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Liverpool\\trasferta.jpg");
		creaMaglia("Terza Maglia", s31, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Liverpool\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s31, "Lilla" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Liverpool\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s31, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Liverpool\\portieri 2.jpg");	
		Squadra s32 = (Squadra) squadraRepository.findById(33).get();
		creaMaglia("Maglia Casa", s32, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Manchester City\\casa.jpg");
		creaMaglia("Maglia Trasferta", s32, "Rosso-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Manchester City\\trasferta.jpg");
		creaMaglia("Terza Maglia", s32, "Verde-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Manchester City\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s32, "Bordeaux" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Manchester City\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s32, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Manchester City\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s32, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Manchester City\\portieri 3.jpg");
		Squadra s33 = (Squadra) squadraRepository.findById(34).get();
		creaMaglia("Maglia Casa", s33, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Manchester United\\casa.jpg");
		creaMaglia("Maglia Trasferta", s33, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Manchester United\\trasferta.jpg");
		creaMaglia("Terza Maglia", s33, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Manchester United\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s33, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Manchester United\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s33, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Manchester United\\portieri 2.jpg");
		Squadra s34 = (Squadra) squadraRepository.findById(35).get();
		creaMaglia("Maglia Casa", s34, "Bianco-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Newcastle\\casa.jpg");
		creaMaglia("Maglia Trasferta", s34, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Newcastle\\trasferta.jpg");
		creaMaglia("Terza Maglia", s34, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Newcastle\\terza.jpg");
		creaMaglia("Quarta Maglia", s34, "Celeste-Blu", 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Newcastle\\quarta.jpg");
		creaMaglia("Maglia Speciale", s34, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Newcastle\\special.jpg");
		creaMaglia("Maglia Portiere 1", s34, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Newcastle\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s34, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Newcastle\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s34, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Newcastle\\portieri 3.jpg");
		Squadra s35 = (Squadra) squadraRepository.findById(36).get();
		creaMaglia("Maglia Casa", s35, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Nottingham Forest\\casa.jpg");
		creaMaglia("Maglia Trasferta", s35, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Nottingham Forest\\trasferta.jpg");
		creaMaglia("Terza Maglia", s35, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Everton\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s35, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Everton\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s35, "Grigio" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Everton\\portieri 2.jpg");
		Squadra s36 = (Squadra) squadraRepository.findById(37).get();
		creaMaglia("Maglia Casa", s36, "Bianco-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Southampton\\casa.jpg");
		creaMaglia("Maglia Trasferta", s36, "Celeste-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Southampton\\trasferta.jpg");
		creaMaglia("Terza Maglia", s36, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Southampton\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s36, "Arancione-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Southampton\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s36, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Southampton\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s36, "Viola" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Southampton\\portieri 3.jpg");
		Squadra s37 = (Squadra) squadraRepository.findById(38).get();
		creaMaglia("Maglia Casa", s37, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Tottenham\\casa.jpg");
		creaMaglia("Maglia Trasferta", s37, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Tottenham\\trasferta.jpg");
		creaMaglia("Terza Maglia", s37, "Celeste-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Tottenham\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s37, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Tottenham\\portieri 1.jpg");
		Squadra s38 = (Squadra) squadraRepository.findById(39).get();
		creaMaglia("Maglia Casa", s38, "Bordeaux" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\West Ham\\casa.jpg");
		creaMaglia("Maglia Trasferta", s38, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\West Ham\\trasferta.jpg");
		creaMaglia("Terza Maglia", s38, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\West Ham\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s38, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\West Ham\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s38, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\West Ham\\portieri 2.jpg");
		Squadra s39 = (Squadra) squadraRepository.findById(40).get();
		creaMaglia("Maglia Casa", s39, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Wolverhampton\\casa.jpg");
		creaMaglia("Maglia Trasferta", s39, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Wolverhampton\\trasferta.jpg");
		creaMaglia("Terza Maglia", s39, "Grigio" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Wolverhampton\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s39, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Wolverhampton\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s39, "Lilla" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Wolverhampton\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s39, "Rosa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Premier League\\Wolverhampton\\portieri 3.jpg");
		
		//BUNDESLIGA
		Squadra s40 = (Squadra) squadraRepository.findById(41).get();
		creaMaglia("Maglia Casa", s40, "Bianco-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\1.FC Koln\\casa.jpg");
		creaMaglia("Maglia Trasferta", s40, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\1.FC Koln\\trasferta.jpg");
		creaMaglia("Terza Maglia", s40, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\1.FC Koln\\terza.jpg");
		creaMaglia("Maglia Speciale 1", s40, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\1.FC Koln\\special 1.jpg");
		creaMaglia("Maglia Speciale 2", s40, "Bianco-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\1.FC Koln\\special 2.jpg");
		creaMaglia("Maglia Portiere 1", s40, "Giallo-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\1.FC Koln\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s40, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\1.FC Koln\\portieri 2.jpg");
		Squadra s41 = (Squadra) squadraRepository.findById(42).get();
		creaMaglia("Maglia Casa", s41, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Bayer 04 Leverkusen\\casa.jpg");
		creaMaglia("Maglia Trasferta", s41, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Bayer 04 Leverkusen\\trasferta.jpg");
		creaMaglia("Terza Maglia", s41, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Bayer 04 Leverkusen\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s41, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Bayer 04 Leverkusen\\portieri 1.jpg");
		Squadra s42 = (Squadra) squadraRepository.findById(43).get();
		creaMaglia("Maglia Casa", s42, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Bayern Monaco\\casa.jpg");
		creaMaglia("Maglia Trasferta", s42, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Bayern Monaco\\trasferta.jpg");
		creaMaglia("Terza Maglia", s42, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Bayern Monaco\\terza.jpg");
		creaMaglia("Maglia Speciale 1", s42, "Bordeaux" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Bayern Monaco\\special 1.jpg");
		creaMaglia("Maglia Speciale 2", s42, "Bianco-Arancione-Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Bayern Monaco\\special 2.jpg");
		creaMaglia("Maglia Portiere 1", s42, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Bayern Monaco\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s42, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Bayern Monaco\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s42, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Bayern Monaco\\portieri 3.jpg");
		Squadra s43 = (Squadra) squadraRepository.findById(44).get();
		creaMaglia("Maglia Casa", s43, "Giallo-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Borussia Dortmund\\casa.jpg");
		creaMaglia("Maglia Trasferta", s43, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Borussia Dortmund\\trasferta.jpg");
		creaMaglia("Maglia Speciale 1", s43, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Borussia Dortmund\\special 1.jpg");
		creaMaglia("Maglia Speciale 2", s43, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Borussia Dortmund\\special 2.jpg");
		creaMaglia("Maglia Portiere 1", s43, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Borussia Dortmund\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s43, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Borussia Dortmund\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s43, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Borussia Dortmund\\portieri 3.jpg");
		Squadra s44 = (Squadra) squadraRepository.findById(45).get();
		creaMaglia("Maglia Casa", s44, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Borussia M\\casa.jpg");
		creaMaglia("Maglia Trasferta", s44, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Borussia M\\trasferta.jpg");
		creaMaglia("Terza Maglia", s44, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Borussia M\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s44, "Bordeaux" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Borussia M\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s44, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Borussia M\\portieri 2.jpg");
		Squadra s45 = (Squadra) squadraRepository.findById(46).get();
		creaMaglia("Maglia Casa", s45, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Eintracht Francoforte\\casa.jpg");
		creaMaglia("Maglia Trasferta", s45, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Eintracht Francoforte\\trasferta.jpg");
		creaMaglia("Terza Maglia", s45, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Eintracht Francoforte\\terza.jpg");
		creaMaglia("Maglia Speciale", s45, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Eintracht Francoforte\\special.jpg");
		creaMaglia("Maglia Portiere 1", s45, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Eintracht Francoforte\\portieri 1.jpg");
		Squadra s46 = (Squadra) squadraRepository.findById(47).get();
		creaMaglia("Maglia Casa", s46, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\FC Asburgo\\casa.jpg");
		creaMaglia("Maglia Trasferta", s46, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\FC Asburgo\\trasferta.jpg");
		creaMaglia("Terza Maglia", s46, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\FC Asburgo\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s46, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\FC Asburgo\\portieri 1.jpg");
		Squadra s47 = (Squadra) squadraRepository.findById(48).get();
		creaMaglia("Maglia Casa", s47, "Bianco-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Herta\\casa.jpg");
		creaMaglia("Maglia Trasferta", s47, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Herta\\trasferta.jpg");
		creaMaglia("Terza Maglia", s47, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Herta\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s47, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Herta\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s47, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Herta\\portieri 2.jpg");
		Squadra s48 = (Squadra) squadraRepository.findById(49).get();
		creaMaglia("Maglia Casa", s48, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Mainz\\casa.jpg");
		creaMaglia("Maglia Trasferta", s48, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Mainz\\trasferta.jpg");
		creaMaglia("Terza Maglia", s48, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Mainz\\terza.jpg");
		creaMaglia("Maglia Speciale", s48, "Multicolore" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Mainz\\special.jpg");
		Squadra s49 = (Squadra) squadraRepository.findById(50).get();
		creaMaglia("Maglia Casa", s49, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\RB Lipsia\\casa.jpg");
		creaMaglia("Maglia Trasferta", s49, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\RB Lipsia\\trasferta.jpg");
		creaMaglia("Terza Maglia", s49, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\RB Lipsia\\terza.jpg");
		creaMaglia("Maglia Speciale", s49, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\RB Lipsia\\special.jpg");
		Squadra s50 = (Squadra) squadraRepository.findById(51).get();
		creaMaglia("Maglia Casa", s50, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\SC Friburgo\\casa.jpg");
		creaMaglia("Maglia Trasferta", s50, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\SC Friburgo\\trasferta.jpg");
		creaMaglia("Terza Maglia", s50, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\SC Friburgo\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s50, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\SC Friburgo\\portieri 1.jpg");
		Squadra s51 = (Squadra) squadraRepository.findById(52).get();
		creaMaglia("Maglia Casa", s51, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Schalke 04\\casa.jpg");
		creaMaglia("Maglia Trasferta", s51, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Schalke 04\\trasferta.jpg");
		creaMaglia("Terza Maglia", s51, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Schalke 04\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s51, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Schalke 04\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s51, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Schalke 04\\portieri 2.jpg");
		Squadra s52 = (Squadra) squadraRepository.findById(53).get();
		creaMaglia("Maglia Casa", s52, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\TSG Hoffenheim\\casa.jpg");
		creaMaglia("Maglia Trasferta", s52, "Beige" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\TSG Hoffenheim\\trasferta.jpg");
		creaMaglia("Terza Maglia", s52, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\TSG Hoffenheim\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s52, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\TSG Hoffenheim\\portieri 1.jpg");
		Squadra s53 = (Squadra) squadraRepository.findById(54).get();
		creaMaglia("Maglia Casa", s53, "Rosso-Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Union Berlino\\casa.jpg");
		creaMaglia("Maglia Trasferta", s53, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Union Berlino\\trasferta.jpg");
		creaMaglia("Terza Maglia", s53, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Union Berlino\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s53, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Union Berlino\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s53, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Union Berlino\\portieri 2.jpg");
		Squadra s54 = (Squadra) squadraRepository.findById(55).get();
		creaMaglia("Maglia Casa", s54, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFB Stoccarda\\casa.jpg");
		creaMaglia("Maglia Trasferta", s54, "Rosso-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFB Stoccarda\\trasferta.jpg");
		creaMaglia("Terza Maglia", s54, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFB Stoccarda\\terza.jpg");
		creaMaglia("Maglia Speciale", s54, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFB Stoccarda\\special.jpg");
		creaMaglia("Maglia Portiere 1", s54, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFB Stoccarda\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s54, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFB Stoccarda\\portieri 2.jpg");
		Squadra s55 = (Squadra) squadraRepository.findById(56).get();
		creaMaglia("Maglia Casa", s55, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFL Bochum\\casa.jpg");
		creaMaglia("Maglia Trasferta", s55, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFL Bochum\\trasferta.jpg");
		creaMaglia("Terza Maglia", s55, "Grigio" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFL Bochum\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s55, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFL Bochum\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s55, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFL Bochum\\portieri 2.jpg");
		Squadra s56 = (Squadra) squadraRepository.findById(57).get();
		creaMaglia("Maglia Casa", s56, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFL Wolfsburg\\casa.jpg");
		creaMaglia("Maglia Trasferta", s56, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFL Wolfsburg\\trasferta.jpg");
		creaMaglia("Terza Maglia", s56, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFL Wolfsburg\\terza.jpg");
		creaMaglia("Maglia Speciale", s56, "Verde-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFL Wolfsburg\\special.jpg");
		creaMaglia("Maglia Portiere 1", s56, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\VFL Wolfsburg\\portieri 1.jpg");
		Squadra s57 = (Squadra) squadraRepository.findById(58).get();
		creaMaglia("Maglia Casa", s57, "Bianco-Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Werder Brema\\casa.jpg");
		creaMaglia("Maglia Trasferta", s57, "Rosa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Werder Brema\\trasferta.jpg");
		creaMaglia("Terza Maglia", s57, "Nero-Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Werder Brema\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s57, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Werder Brema\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s57, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Bundesliga\\Werder Brema\\portieri 2.jpg");
		
		//LIGA SANTANDER
		Squadra s58 = (Squadra) squadraRepository.findById(59).get();
		creaMaglia("Maglia Casa", s58, "Bianco-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Atletic\\casa.jpg");
		creaMaglia("Maglia Trasferta", s58, "Nero-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Atletic\\trasferta.jpg");
		creaMaglia("Maglia Portiere 1", s58, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Atletic\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s58, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Atletic\\portieri 2.jpg");
		Squadra s59 = (Squadra) squadraRepository.findById(60).get();
		creaMaglia("Maglia Casa", s59, "Bianco-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Atletico\\casa.jpg");
		creaMaglia("Maglia Trasferta", s59, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Atletico\\trasferta.jpg");
		creaMaglia("Terza Maglia", s59, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Atletico\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s59, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Atletico\\portieri 1.jpg");
		Squadra s60 = (Squadra) squadraRepository.findById(61).get();
		creaMaglia("Maglia Casa", s60, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Cadiz\\casa.jpg");
		creaMaglia("Maglia Trasferta", s60, "Blu-Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Cadiz\\trasferta.jpg");
		creaMaglia("Maglia Speciale", s60, "Arancione-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Cadiz\\special.jpg");
		creaMaglia("Maglia Portiere 1", s60, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Cadiz\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s60, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Cadiz\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s60, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Cadiz\\portieri 3.jpg");
		Squadra s61 = (Squadra) squadraRepository.findById(62).get();
		creaMaglia("Maglia Casa", s61, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Celta\\casa.jpg");
		creaMaglia("Maglia Trasferta", s61, "Nero-Marrone" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Celta\\trasferta.jpg");
		creaMaglia("Terza Maglia", s61, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Celta\\terza.jpg");
		creaMaglia("Maglia Speciale", s61, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Celta\\speciale.jpg");
		creaMaglia("Maglia Portiere 1", s61, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Celta\\portieri 1.jpg");
		Squadra s62 = (Squadra) squadraRepository.findById(63).get();
		creaMaglia("Maglia Casa", s62, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Elche\\casa.jpg");
		creaMaglia("Maglia Trasferta", s62, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Elche\\trasferta.jpg");
		creaMaglia("Terza Maglia", s62, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Elche\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s62, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Elche\\portieri 1.jpg");
		Squadra s63 = (Squadra) squadraRepository.findById(64).get();
		creaMaglia("Maglia Casa", s63, "Bianco-Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Espanyol\\casa.jpg");
		creaMaglia("Maglia Trasferta", s63, "Rosa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Espanyol\\trasferta.jpg");
		creaMaglia("Terza Maglia", s63, "Bianco-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Espanyol\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s63, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Espanyol\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s63, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Espanyol\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s63, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Espanyol\\portieri 3.jpg");
		Squadra s64 = (Squadra) squadraRepository.findById(65).get();
		creaMaglia("Maglia Casa", s64, "Rosso-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\FC Barcelona\\casa.jpg");
		creaMaglia("Maglia Trasferta", s64, "Beige" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\FC Barcelona\\trasferta.jpg");
		creaMaglia("Terza Maglia", s64, "Grigio-Rosso-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\FC Barcelona\\terza.jpg");
		creaMaglia("Quarta Maglia", s64, "Giallo-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\FC Barcelona\\quarta.jpg");
		creaMaglia("Maglia Speciale 1", s64, "Rosso-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\FC Barcelona\\special 1.jpg");
		creaMaglia("Maglia Speciale 2", s64, "Rosso-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\FC Barcelona\\special 2.jpg");
		creaMaglia("Maglia Portiere 1", s64, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\FC Barcelona\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s64, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\FC Barcelona\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s64, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\FC Barcelona\\portieri 3.jpg");
		Squadra s65 = (Squadra) squadraRepository.findById(66).get();
		creaMaglia("Maglia Casa", s65, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Getafe\\casa.jpg");
		creaMaglia("Maglia Trasferta", s65, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Getafe\\trasferta.jpg");
		creaMaglia("Terza Maglia", s65, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Getafe\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s65, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Getafe\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s65, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Getafe\\portieri 2.jpg");
		Squadra s66 = (Squadra) squadraRepository.findById(67).get();
		creaMaglia("Maglia Casa", s66, "Bianco-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Girona\\casa.jpg");
		creaMaglia("Maglia Trasferta", s66, "Giallo-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Girona\\trasferta.jpg");
		creaMaglia("Terza Maglia", s66, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Girona\\terza.jpg");	
		creaMaglia("Maglia Portiere 1", s66, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Girona\\portieri 1.jpg");
		Squadra s67 = (Squadra) squadraRepository.findById(68).get();
		creaMaglia("Maglia Casa", s67, "Rosso-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Osasuna\\casa.jpg");
		creaMaglia("Maglia Trasferta", s67, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Osasuna\\trasferta.jpg");
		creaMaglia("Terza Maglia", s67, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Osasuna\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s67, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Osasuna\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s67, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Osasuna\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s67, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Osasuna\\portieri 3.jpg");
		Squadra s68 = (Squadra) squadraRepository.findById(69).get();
		creaMaglia("Maglia Casa", s68, "Bianco-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Rayo\\casa.jpg");
		creaMaglia("Maglia Trasferta", s68, "Rosso-Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Rayo\\trasferta.jpg");
		creaMaglia("Terza Maglia", s68, "Nero-Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Rayo\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s68, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Rayo\\portieri 1.jpg");
		Squadra s69 = (Squadra) squadraRepository.findById(70).get();
		creaMaglia("Maglia Casa", s69, "Rosso-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\RCD Mallorca\\casa.jpg");
		creaMaglia("Maglia Trasferta", s69, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\RCD Mallorca\\trasferta.jpg");
		creaMaglia("Terza Maglia", s69, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\RCD Mallorca\\terza.jpg");
		Squadra s70 = (Squadra) squadraRepository.findById(71).get();
		creaMaglia("Maglia Casa", s70, "Bianco-Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Betis\\casa.jpg");
		creaMaglia("Maglia Trasferta", s70, "Azzurro-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Betis\\trasferta.jpg");
		creaMaglia("Terza Maglia", s70, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Betis\\terza.jpg");
		creaMaglia("Maglia Speciale 1", s70, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Betis\\special 1.jpg");
		creaMaglia("Maglia Speciale 2", s70, "Bianco-Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Betis\\special 2.jpg");
		creaMaglia("Maglia Portiere 1", s70, "Giallo-Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Betis\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s70, "Celeste-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Betis\\portieri 2.jpg");
		Squadra s71 = (Squadra) squadraRepository.findById(72).get();
		creaMaglia("Maglia Casa", s71, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Madrid\\casa.jpg");
		creaMaglia("Maglia Trasferta", s71, "Lilla" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Madrid\\trasferta.jpg");
		creaMaglia("Terza Maglia", s71, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Madrid\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s71, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Madrid\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s71, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Madrid\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s71, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Madrid\\portieri 3.jpg");
		Squadra s72 = (Squadra) squadraRepository.findById(73).get();
		creaMaglia("Maglia Casa", s72, "Bianco-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Sociedad\\casa.jpg");
		creaMaglia("Maglia Trasferta", s72, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Sociedad\\trasferta.jpg");
		creaMaglia("Terza Maglia", s72, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Sociedad\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s72, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Sociedad\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s72, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Real Sociedad\\portieri 2.jpg");
		Squadra s73 = (Squadra) squadraRepository.findById(74).get();
		creaMaglia("Maglia Casa", s73, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Siviglia\\casa.jpg");
		creaMaglia("Maglia Trasferta", s73, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Siviglia\\trasferta.jpg");
		creaMaglia("Terza Maglia", s73, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Siviglia\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s73, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Siviglia\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s73, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Siviglia\\portieri 2.jpg");
		Squadra s74 = (Squadra) squadraRepository.findById(75).get();
		creaMaglia("Maglia Casa", s74, "Rosso-Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\UD Almeria\\casa.jpg");
		creaMaglia("Maglia Trasferta", s74, "Blu-Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\UD Almeria\\trasferta.jpg");
		creaMaglia("Terza Maglia", s74, "Beige" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\UD Almeria\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s74, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\UD Almeria\\portieri 1.jpg");
		Squadra s75 = (Squadra) squadraRepository.findById(76).get();
		creaMaglia("Maglia Casa", s75, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Valencia\\casa.jpg");
		creaMaglia("Maglia Trasferta", s75, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Valencia\\trasferta.jpg");
		creaMaglia("Terza Maglia", s75, "Giallo-Rosso-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Valencia\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s75, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Valencia\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s75, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Valencia\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s75, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Valencia\\portieri 3.jpg");
		creaMaglia("Maglia Portiere 4", s75, "Arancione", 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Valencia\\portieri4.jpg");
		Squadra s76 = (Squadra) squadraRepository.findById(77).get();
		creaMaglia("Maglia Casa", s76, "Viola-Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Valladolid\\casa.jpg");
		creaMaglia("Maglia Trasferta", s76, "Viola" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Valladolid\\trasferta.jpg");
		creaMaglia("Terza Maglia", s76, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Valladolid\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s76, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Valladolid\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s76, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Valladolid\\portieri 2.jpg");
		Squadra s77 = (Squadra) squadraRepository.findById(78).get();
		creaMaglia("Maglia Casa", s77, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Villareal\\casa.jpg");
		creaMaglia("Maglia Trasferta", s77, "Viola" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Villareal\\trasferta.jpg");
		creaMaglia("Terza Maglia", s77, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Villareal\\terza.jpg");
		creaMaglia("Maglia Speciale", s77, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Villareal\\special.jpg");
		creaMaglia("Maglia Portiere 1", s77, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\La Liga\\Villareal\\portieri 1.jpg");
		Squadra s78 = (Squadra) squadraRepository.findById(79).get();
		creaMaglia("Maglia Casa", s78, "Bianco-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AC Ajaccio\\casa.jpg");
		creaMaglia("Maglia Trasferta", s78, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AC Ajaccio\\trasferta.jpg");
		creaMaglia("Terza Maglia", s78, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AC Ajaccio\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s78, "Rosa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AC Ajaccio\\portieri 1.jpg");
		Squadra s79 = (Squadra) squadraRepository.findById(80).get();
		creaMaglia("Maglia Casa", s79, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AJ Auxerre\\casa.jpg");
		creaMaglia("Maglia Trasferta", s79, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AJ Auxerre\\trasferta.jpg");
		Squadra s80 = (Squadra) squadraRepository.findById(81).get();
		creaMaglia("Maglia Casa", s80, "Bianco-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Angers\\casa.jpg");
		creaMaglia("Maglia Trasferta", s80, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Angers\\trasferta.jpg");
		creaMaglia("Terza Maglia", s80, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Angers\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s80, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Angers\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s80, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Angers\\portieri 2.jpg");
		Squadra s81 = (Squadra) squadraRepository.findById(82).get();
		creaMaglia("Maglia Casa", s81, "Bianco-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AS Monaco\\casa.jpg");
		creaMaglia("Maglia Trasferta", s81, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AS Monaco\\trasferta.jpg");
		creaMaglia("Terza Maglia", s81, "Lilla" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AS Monaco\\terza.jpg");
		creaMaglia("Maglia Speciale", s81, "Beige-Marrone-Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AS Monaco\\special.jpg");
		creaMaglia("Maglia Portiere 1", s81, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AS Monaco\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s81, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AS Monaco\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s81, "Marrone" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\AS Monaco\\portieri 3.jpg");
		Squadra s82 = (Squadra) squadraRepository.findById(83).get();
		creaMaglia("Maglia Casa", s82, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Clermont\\casa.jpg");
		creaMaglia("Maglia Trasferta", s82, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Clermont\\trasferta.jpg");
		creaMaglia("Terza Maglia", s82, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Clermont\\terza.jpg");
		Squadra s83 = (Squadra) squadraRepository.findById(84).get();
		creaMaglia("Maglia Casa", s83, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\ESTAC Troyes\\casa.jpg");
		creaMaglia("Maglia Trasferta", s83, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\ESTAC Troyes\\trasferta.jpg");
		creaMaglia("Terza Maglia", s83, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\ESTAC Troyes\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s83, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\ESTAC Troyes\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s83, "Rosa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\ESTAC Troyes\\portieri 2.jpg");
		Squadra s84 = (Squadra) squadraRepository.findById(85).get();
		creaMaglia("Maglia Casa", s84, "Rosso-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Lille LOSC\\casa.jpg");
		creaMaglia("Maglia Trasferta", s84, "Bianca" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Lille LOSC\\trasferta.jpg");
		creaMaglia("Terza Maglia", s84, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Lille LOSC\\terza.jpg");
		creaMaglia("Quarta Maglia", s84, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Lille LOSC\\quarta.jpg");
		creaMaglia("Maglia Portiere 1", s84, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Lille LOSC\\portieri 1.jpg");
		Squadra s85 = (Squadra) squadraRepository.findById(86).get();
		creaMaglia("Maglia Casa", s85, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Lorient\\casa.jpg");
		creaMaglia("Maglia Trasferta", s85, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Lorient\\trasferta.jpg");
		creaMaglia("Terza Maglia", s85, "Grigio" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Lorient\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s85, "Multicolore" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Lorient\\AS Monaco\\portieri 1.jpg");
		Squadra s86 = (Squadra) squadraRepository.findById(87).get();
		creaMaglia("Maglia Casa", s86, "Blu-Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Montpellier\\casa.jpg");
		creaMaglia("Maglia Trasferta", s86, "Bianco-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Montpellier\\trasferta.jpg");
		creaMaglia("Terza Maglia", s86, "Grigio-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Montpellier\\terza.jpg");
		creaMaglia("Maglia Speciale", s86, "Rosa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Montpellier\\special.jpg");
		Squadra s87 = (Squadra) squadraRepository.findById(88).get();
		creaMaglia("Maglia Casa", s87, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Nantes\\casa.jpg");
		creaMaglia("Maglia Trasferta", s87, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Nantes\\trasferta.jpg");
		creaMaglia("Terza Maglia", s87, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Nantes\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s87, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Nantes\\portieri 1.jpg");
		Squadra s88 = (Squadra) squadraRepository.findById(89).get();
		creaMaglia("Maglia Casa", s88, "Rosso-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Nice\\casa.jpg");
		creaMaglia("Maglia Trasferta", s88, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Nice\\trasferta.jpg");
		creaMaglia("Terza Maglia", s88, "Viola-Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Nice\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s88, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Nice\\portieri 1.jpg");
		Squadra s89 = (Squadra) squadraRepository.findById(90).get();
		creaMaglia("Maglia Casa", s89, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OL\\casa.jpg");
		creaMaglia("Maglia Trasferta", s89, "Rosso-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OL\\trasferta.jpg");
		creaMaglia("Terza Maglia", s89, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OL\\terza.jpg");
		creaMaglia("Quarta Maglia", s89, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OL\\quarta.jpg");
		creaMaglia("Maglia Portiere 1", s89, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OL\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s89, "Giallo" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OL\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s89, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OL\\portieri 3.jpg");
		Squadra s90 = (Squadra) squadraRepository.findById(91).get();
		creaMaglia("Maglia Casa", s90, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OM\\casa.jpg");
		creaMaglia("Maglia Trasferta", s90, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OM\\trasferta.jpg");
		creaMaglia("Terza Maglia", s90, "Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OM\\terza.jpg");
		creaMaglia("Maglia Speciale", s90, "Bianco-Azzurro" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OM\\special.jpg");
		creaMaglia("Maglia Portiere 1", s90, "Arancione" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OM\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s90, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\OM\\portieri 2.jpg");
		Squadra s91 = (Squadra) squadraRepository.findById(92).get();
		creaMaglia("Maglia Casa", s91, "Blu-Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\PSG\\casa.jpg");
		creaMaglia("Maglia Trasferta", s91, "Grigio" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\PSG\\trasferta.jpg");
		creaMaglia("Terza Maglia", s91, "Bianco-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\PSG\\terza.jpg");
		creaMaglia("Quarta Maglia", s91, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\PSG\\quarta.jpg");
		creaMaglia("Maglia Portiere 1", s91, "Verde" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\PSG\\portieri 1.jpg");
		Squadra s92 = (Squadra) squadraRepository.findById(93).get();
		creaMaglia("Maglia Casa", s92, "Giallo-Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\RC Lens\\casa.jpg");
		creaMaglia("Maglia Trasferta", s92, "Verde-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\RC Lens\\trasferta.jpg");
		creaMaglia("Terza Maglia", s92, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\RC Lens\\terza.jpg");
		creaMaglia("Maglia Speciale", s92, "Beige" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Rc Lens\\special.jpg");
		Squadra s93 = (Squadra) squadraRepository.findById(94).get();
		creaMaglia("Maglia Casa", s93, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Stade Brestois\\casa.jpg");
		creaMaglia("Maglia Trasferta", s93, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Stade Brestois\\trasferta.jpg");
		creaMaglia("Terza Maglia", s93, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Stade Brestois\\terza.jpg");
		Squadra s94 = (Squadra) squadraRepository.findById(95).get();
		creaMaglia("Maglia Casa", s94, "Rosso-Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Stade Reims\\casa.jpg");
		creaMaglia("Maglia Trasferta", s94, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Stade Reims\\trasferta.jpg");
		creaMaglia("Terza Maglia", s94, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Stade Reims\\terza.jpg");
		Squadra s95 = (Squadra) squadraRepository.findById(96).get();
		creaMaglia("Maglia Casa", s95, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Stade Rennais\\casa.jpg");
		creaMaglia("Maglia Trasferta", s95, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Stade Rennais\\trasferta.jpg");
		creaMaglia("Terza Maglia", s95, "Azzurro-Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Stade Rennais\\terza.jpg");
		Squadra s96 = (Squadra) squadraRepository.findById(97).get();
		creaMaglia("Maglia Casa", s96, "Blu" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Strasbourg\\casa.jpg");
		creaMaglia("Maglia Trasferta", s96, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Strasbourg\\trasferta.jpg");
		creaMaglia("Terza Maglia", s96, "Blu-Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Strasbourg\\terza.jpg");
		creaMaglia("Maglia Portiere 1", s96, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Strasbourg\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s96, "Celeste" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Strasbourg\\portieri 2.jpg");
		creaMaglia("Maglia Portiere 3", s96, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Strasbourg\\portieri 3.jpg");
		Squadra s97 = (Squadra) squadraRepository.findById(98).get();
		creaMaglia("Maglia Casa", s97, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Toulouse\\casa.jpg");
		creaMaglia("Maglia Trasferta", s97, "Nero" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Toulouse\\trasferta.jpg");
		creaMaglia("Terza Maglia", s97, "Viola" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Toulouse\\terza.jpg");
		creaMaglia("Quarta Maglia", s97, "Rossa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Toulouse\\quarta.jpg");
		creaMaglia("Maglia Speciale", s97, "Rosa" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Toulouse\\special.jpg");
		creaMaglia("Maglia Portiere 1", s97, "Rosso" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Toulouse\\portieri 1.jpg");
		creaMaglia("Maglia Portiere 2", s97, "Bianco" , 89.90, "..\\..\\..\\assets\\img\\maglie\\Ligue 1\\Toulouse\\portieri 2.jpg");


		

		

		;









		
		
		
		
		
		
		
		
		
		
	}

}
