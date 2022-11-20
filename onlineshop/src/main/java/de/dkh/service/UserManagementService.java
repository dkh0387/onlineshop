package de.dkh.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import de.dkh.db.bo.User;
import lombok.Getter;

/**
 * Collect, sort and hold all the {@linkplain User}.
 * 
 * @author dkh
 *
 */
public class UserManagementService {
	@Getter
	private Set<User> userSet = new HashSet<>();

	public UserManagementService() {
		initUserSet();
		sort();
	}

	public void sort() {
		userSet.stream().sorted(User.getComparator());
	}

	private void initUserSet() {
		userSet.add(new User(1, "Gerheide Hertweck", "Auenstraße 94, 14089 Spandau",
				"gerheide-hertweck@goggle-mail.none", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(2, "Rudolph Hirtreiter", "Rönneburger Straße 71, 89607 Emerkingen",
				"r_hirtreiter@retromail.none", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(3, "Adelbert Brand", "Holbeinstraße 26, 45525 Hattingen an der Ruhr",
				"a.brand@trashmail.none", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(4, "Andy Nietsch", "Mohlenweg 44, 56589 Datzeroth", "a.nietsch@web.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(5, "Irmentraud Siems", "Königsheide 199, 49828 Esche", "irmentraud-siems@trashmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(6, "Carl Lenze", "Brachtendorfer Weg 87, 29456 Hitzacker", "carl-1909@email.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(7, "Uto Townsend", "Jakobistraße 172, 37581 Bad Gandersheim", "u.townsend@trashmail.none",
				LocalDate.of(1909, 7, 23)));
		userSet.add(new User(8, "Marhild Hornig", "Lötzener Straße 44, 75210 Keltern", "marhild.hornig@private.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(9, "Ferhard Spohr", "Brabantstraße 94, 54518 Heidweiler", "ferhard.spohr@company.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(10, "Friedwin Sattler", "Orsoyer Straße 153, 24238 Martensrade",
				"friedwin.1948@validmail.none", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(11, "Reimo Lehwald", "Hinter dem Dorf 121 c, 69121 Heidelberg", "",
				LocalDate.of(1989, 4, 23)));
		userSet.add(
				new User(12, "Renata Deimel", "Lahn-Eder-Straße 117, 61137 Schöneck", "", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(13, "Desiree Johanning", "Deutschherrenstraße 11, 36251 Ludwigsau",
				"desiree.1966@spam-mail.none", LocalDate.of(1966, 6, 10)));
		userSet.add(new User(14, "Constance Erl", "Molziger Straße 116, 55758 Hellertshausen", "c.erl@inter-mail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(15, "Jolantha Schmuck", "Am Krahstück 167, 56598 Rheinbrohl", "j-schmuck@validmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(16, "Ehrentrud Neumaier", "Sewanstraße 52, 73550 Hummelshalden", "e_neumaier@funmail.none",
				LocalDate.of(1992, 8, 17)));
		userSet.add(new User(17, "Notburg Donner", "Oleftal 61, 94142 Fürsteneck", "n_donner@bestmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(18, "Daniela Gräbner", "Borkener Damm 161, 58089 Hagen", "d-graebner@validmail.none",
				LocalDate.of(2011, 6, 2)));
		userSet.add(new User(19, "Karsten Duffner", "Altendorf 27, 46045 Oberhausen", "karsten.duffner@hoster.none",
				LocalDate.of(2015, 1, 21)));
		userSet.add(new User(20, "Klaas Dreisbach", "Spitzackerring 132, 32105 Bad Salzuflen",
				"klaas_dreisbach@private.none", LocalDate.of(1972, 7, 3)));
		userSet.add(new User(21, "Heimfrid Kegel", "Salon-de-Provence-Ring 27, 45276 Essen",
				"heimfrid.kegel@justmail.none", LocalDate.of(1914, 8, 3)));
		userSet.add(new User(22, "Barnabas Vagt", "Thüringer Weg 131, 93491 Stamsried", "barnabas.vagt@trashmail.none",
				LocalDate.of(1973, 12, 1)));
		userSet.add(new User(23, "Marion Stiel", "Lenaustraße 45, 56357 Niederbachheim", "marion_61@mymail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(24, "Berni Rubel", "Bischof-Ketteler-Straße 152, 35719 Angelburg", "b-rubel@funmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(25, "Joelle Scheffer", "Hochgasse 25, 82395 Obersöchering", "joellescheffer@xyz.none",
				LocalDate.of(1927, 5, 19)));
		userSet.add(new User(26, "Wolfgard Senn", "Taunusstraße 185, 47877 Anrath", "w.senn@quickmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(27, "Katy Heidt", "Zillertal 63, 65185 Wiesbaden", "", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(28, "Chantalle Sauerborn", "Bahndamm 27, 67575 Eich", "chantalle_sauerborn@validmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(29, "Gertrude Bergs", "Daruper Straße 123, 79736 Rickenbach", "g_bergs@justmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(30, "Nils Pollmann", "Kaiserstraße 168, 27578 Bremerhaven", "nils_pollmann@hoster.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(31, "Katrein Kleinfeld", "Mühlenstraße 63, 63456 Hanau", "", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(32, "Marhild Bargmann", "Hubertushöhe 22, 47445 Moers", "", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(33, "Barnabas Lenk", "Hagelkreuzstraße 152, 56370 Bremberg", "barnabas1919@open-mail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(34, "Heike Doppelpunkt", "Merseburger Straße 105, 54597 Balesfeld",
				"hdoppelpunkt@hoster.none", LocalDate.of(1996, 7, 17)));
		userSet.add(new User(35, "Kimberley Kulke", "Nelkenstraße 115, 57648 Unnau", "k.kulke@anymail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(36, "Jessica Rey", "Auf den Weiden 151, 25551 Silzen", "jessica.36@company.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(
				new User(37, "Marlis Habig", "Schweidnitzer Straße 145, 56743 Mendig", "", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(38, "Burgunde Stanzel", "Im Hohlgarten 99 c, 9122 Chemnitz",
				"burgunde_stanzel@spam-mail.none", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(39, "Dietrich Stober", "Hasendell 3, 29699 Bomlitz", "dietrich.stober@xyz.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(40, "Dietlinde Schwind", "Hofkoppel 179, 21717 Fredenbeck",
				"dietlinde.schwind@goggle-mail.none", LocalDate.of(1940, 5, 24)));
		userSet.add(new User(41, "Evi Loges", "Nassauer Straße 48, 6408 Gröna", "", LocalDate.of(1988, 6, 29)));
		userSet.add(new User(42, "Hildegunde Graßhoff", "Nettesheimstraße 116, 67280 Ebertsheim",
				"hildegunde.76@goggle-mail.none", LocalDate.of(1976, 7, 1)));
		userSet.add(new User(43, "Luitgart Gehrig", "Grenzbachstraße 66, 56355 Oberbachheim",
				"luitgart_gehrig@ultramail.none", LocalDate.of(2008, 7, 12)));
		userSet.add(new User(44, "Till Doose", "Helfensteinstraße 200, 17089 Grapzow", "till-doose@ultramail.none",
				LocalDate.of(1979, 8, 24)));
		userSet.add(new User(45, "Katarina Benson", "Im Gässchen 174, 54673 Koxhausen", "k_benson@company.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(46, "Reni Dirkes", "Erpeler Straße 69, 91187 Röttenbach", "reni.dirkes@net-mail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(47, "Annika Hoheisel", "Zum Kalkofen 114, 24796 Bovenau", "annika_hoheisel@justmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(48, "Bertram Norden", "Warschauer Straße 48, 24395 Rabenholz", "bnorden@mymail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(49, "Lea Schaffner", "Kalksbecker Weg 81, 17091 Wolde", "lea99@spam-mail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(50, "Wiegand Behrens", "Kiwittweg 118, 42899 Remscheid", "wiegand-behrens@web.none",
				LocalDate.of(1906, 9, 15)));
		userSet.add(new User(51, "Bartosch Lange", "Auf der Konn 185, 57339 Erndtebrück", "b.lange@email.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(52, "Mattis Grüger", "Neumühle 58, 79872 Bernau", "mattis-66@live-mail.none",
				LocalDate.of(1966, 4, 26)));
		userSet.add(new User(53, "Janine Boschert", "In den Forstwiesen 81, 54346 Mehring", "jboschert@company.none",
				LocalDate.of(2016, 12, 4)));
		userSet.add(new User(54, "Annelinde Rogg", "Scharnhorststraße 195, 33611 Bielefeld",
				"annelinde20@justmail.none", LocalDate.of(1920, 12, 3)));
		userSet.add(new User(55, "Berna Staudinger", "Am Stromberg 13, 72070 Tübingen", "", LocalDate.of(1944, 2, 12)));
		userSet.add(new User(56, "Lily Evertz", "Saffiger Straße 186, 24869 Dörpstedt", "", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(57, "Hannspeter Kerl", "Geranienweg 109, 57641 Oberlahr", "hannspeter.kerl@email.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(58, "Dorchen Knierim", "Gabelsbergerstraße 3, 56370 Oberfischbach", "d_19@private.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(59, "Theobalda Raithel", "Bertolt-Brecht-Straße 91, 86703 Rögling",
				"t.raithel@company.none", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(60, "Rosetraut Eichstädt", "Mörikeweg 21, 37308 Steinbach", "r_05@anymail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(61, "Ronny Wuttig", "Barmer Straße 161, 44894 Bochum", "r1988@retromail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(62, "Ermenfried Higgins", "Boerholzer Straße 12, 57612 Giesenhausen",
				"ermenfriedhiggins@hoster.none", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(63, "Birkhild Still", "Zum Limes 41, 55413 Oberdiebach", "birkhild-still@justmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(64, "Gero Elze", "Brühler Straße 162, 24640 Hasenmoor", "gero.1972@kitty.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(
				new User(65, "Hanspeter Sieg", "Heedfelder Straße 35, 33607 Bielefeld", "", LocalDate.of(1929, 2, 3)));
		userSet.add(new User(66, "Sahra Brady", "Im Lag 155, 27404 Elsdorf", "sahrabrady@mymail.none",
				LocalDate.of(2014, 7, 16)));
		userSet.add(new User(67, "Klotilde Schwarzfischer", "Silscheder Straße 142, 66851 Bann",
				"klotilde73@anymail.none", LocalDate.of(1973, 12, 7)));
		userSet.add(new User(68, "Helene Mehler", "Römerstraße 156, 75389 Neuweiler", "helene_mehler@quickmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(69, "Lily Hertrich", "Blütenweg 84, 24806 Bargstall", "", LocalDate.of(1934, 4, 16)));
		userSet.add(new User(70, "Thielo Becke", "Burghofstraße 51, 25436 Groß Nordende", "t_becke@funmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(71, "Evchen Kluge", "In der Staar 19, 27404 Ostereistedt", "", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(72, "Arnold Bischof", "Steinbergen 160, 21035 Hamburg", "arnold_bischof@live-mail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(73, "Lieselore Kallweit", "Erdinger Straße 46, 80807 München",
				"lieselore_kallweit@xyz.none", LocalDate.of(2008, 7, 13)));
		userSet.add(new User(74, "Ela Henseleit", "Schieferstraße 165, 48683 Ahaus", "e.henseleit@web.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(75, "Gusti Daubner", "Giebelwaldstraße 105, 70372 Stuttgart", "gusti-69@ultramail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(76, "Gertwin Ruck", "Kurtstraße 122, 48153 Münster", "gruck@domain.none",
				LocalDate.of(1903, 6, 30)));
		userSet.add(new User(77, "Jörgfried Bechtel", "Härtlinger Straße 139, 30169 Hannover", "",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(78, "Bertold Hillers", "Lindlarer Straße 161, 72622 Nürtingen",
				"bertold_hillers@net-mail.none", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(79, "Godo Willemsen", "Haunerbusch 173, 39638 Kloster Neuendorf", "",
				LocalDate.of(1991, 11, 8)));
		userSet.add(new User(80, "Katrina Riegel", "Orsoyer Straße 124, 77793 Gutach", "k-riegel@ultramail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(81, "Dietburg Kaluza", "Großstraße 178, 82398 Polling", "dietburg_kaluza@retromail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(82, "Sabrina Niermann", "Hardtbergweg 75, 92445 Neukirchen-Balbini", "s-1964@hoster.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(83, "Katrin Gauer", "Habichtshöhe 196, 79595 Rümmingen", "katrin_93@mymail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(84, "Ellen Gruner", "Medardusstraße 150, 48480 Spelle", "ellen_gruner@xyz.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(85, "Jeanett Knüppel", "Krejuhl 5, 56459 Stockum-Püschen",
				"jeanett.knueppel@ultramail.none", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(86, "Boris Mai", "Daruper Straße 97, 66894 Käshofen", "bmai@justmail.none",
				LocalDate.of(1973, 3, 10)));
		userSet.add(new User(87, "Elvire Lippert", "Leckingser Straße 39, 71065 Sindelfingen", "",
				LocalDate.of(2002, 10, 21)));
		userSet.add(new User(88, "Franka Götz", "Urftseestraße 5, 35510 Butzbach", "f.goetz@private.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(89, "Golo Hose", "Milchstraße 71, 45968 Gladbeck", "golo.1903@bestmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(90, "Annalene Helfer", "Lürriper Straße 72, 24306 Wittmoldt", "annalene.helfer@web.none",
				LocalDate.of(2015, 5, 3)));
		userSet.add(new User(91, "Anouk Hilker", "Merler Ring 11, 78132 Hornberg", "anoukhilker@inter-mail.none",
				LocalDate.of(1999, 2, 11)));
		userSet.add(new User(92, "Dennis Klingel", "Bahndamm 167, 85462 Eitting", "d_klingel@justmail.none",
				LocalDate.of(1989, 4, 23)));
		userSet.add(new User(93, "Ringo Düsing", "Bilker Allee 133, 60329 Frankfurt am Main", "",
				LocalDate.of(1960, 10, 5)));
		userSet.add(
				new User(94, "Sybill Wittke", "An der Kolonnade 22, 23619 Rehhorst", "", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(95, "Elsemarie Rascher", "Windthorststraße 3, 86707 Westendorf",
				"elsemarierascher@mymail.none", LocalDate.of(1908, 10, 11)));
		userSet.add(new User(96, "Isedore Rappold", "Weidweg 60, 26556 Utarp", "isedore_rappold@goggle-mail.none",
				LocalDate.of(1961, 3, 16)));
		userSet.add(new User(97, "Gerheide Markowski", "Lippweg 159, 54413 Damflos",
				"gerheide.markowski@inter-mail.none", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(98, "Giselher Roggenbuck", "St.-Nikolaus-Straße 98, 97833 Frammersbach",
				"giselher.roggenbuck@quickmail.none", LocalDate.of(1905, 4, 1)));
		userSet.add(new User(99, "Cordelia Budde", "Weitefelder Garten 146, 56370 Reckenroth",
				"cordeliabudde@quickmail.none", LocalDate.of(1989, 4, 23)));
		userSet.add(new User(100, "Gerdi Brinker", "Wittlicher Straße 39, 27412 Wilstedt", "g-brinker@funmail.none",
				LocalDate.of(1993, 9, 12)));
	}

}
