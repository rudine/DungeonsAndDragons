package basic.npc;

import java.util.HashMap;
import java.util.Map;

import basic.services.DiceService;

public abstract class RandomNPCBuilderNL {
	
	private static Map<Integer, String> uiterlijk= new HashMap<>();
	private static Map<Integer, String> hogeAbilities= new HashMap<>();
	private static Map<Integer, String> lageAbilities= new HashMap<>();
	private static Map<Integer, String> talenten= new HashMap<>();
	private static Map<Integer, String> maniertjes= new HashMap<>();
	private static Map<Integer, String> omgangsVormen = new HashMap<>();
	private static Map<Integer, String> idealen= new HashMap<>();
	private static Map<Integer, String> obligaties= new HashMap<>();
	private static Map<Integer, String> gebreken= new HashMap<>();
	private static Map<Integer, String> alignments= new HashMap<>();
	
	public static void main(String[] args) {
		System.out.println(getRandomNPCTraits());
	}
	
	private static void initTables() {
		initUiterlijk();
		initHoogsteAbility();
		initLaagsteAbility();
		initTalenten();
		initManiertjes();
		initOmgangsvormen();
		initIdealen();
		initObligaties();
		initGebreken();
		initAlignment();
	}
	
	private static void initUiterlijk() {
		uiterlijk.put(1, "Opvallende juwelen: oorbellen, ketting, tiara's, armbanden");
		uiterlijk.put(2, "Piercings");
		uiterlijk.put(3, "Flamboyante kleding of kleding uit een andere cultuur");
		uiterlijk.put(4, "Een schoon uniform");
		uiterlijk.put(5, "Afgedragen vieze kleding");
		uiterlijk.put(6, "Duidelijk litteken");
		uiterlijk.put(7, "Missende tanden");
		uiterlijk.put(8, "Missende vinger(s)");
		uiterlijk.put(9, "Ongebruikelijke kleur ogen (of twee verschillende kleuren)");
		uiterlijk.put(10, "Tattoos");
		uiterlijk.put(11, "Moedervlek");
		uiterlijk.put(12, "Ongebruikelijke huidskleur");
		uiterlijk.put(13, "Kaal");
		uiterlijk.put(14, "Gevlochten baard of haar");
		uiterlijk.put(15, "Ongebruikelijke haarkleur");
		uiterlijk.put(16, "Trekkend oog / mondhoek / hoofd");
		uiterlijk.put(17, "Opvallende neus");
		uiterlijk.put(18, "Opvallende houding (stijf of krom bijv.)");
		uiterlijk.put(19, "Een schoonheid / adonis");
		uiterlijk.put(20, "Erg lelijk");
	}
	
	private static void initHoogsteAbility() {
		hogeAbilities.put(1, "Strength - machtig, vol bravoure, beresterk");
		hogeAbilities.put(2, "Dexterity - lichtvoetig, lenig, gracieus");
		hogeAbilities.put(3, "Constitution - taai, energiek, gezond"); 
		hogeAbilities.put(4, "Intelligence - leergierig, geleerd, onderzoekend");
		hogeAbilities.put(5, "Wisdom - opmerkzaam, spiritueel, wijs");
		hogeAbilities.put(6, "Charisma - overtuigend, assertief, geboren leider");
	}
	
	private static void initLaagsteAbility() { 
		lageAbilities.put(1, "Strength - zwak, mager");
		lageAbilities.put(2, "Dexterity - onhandig, klungelig");
		lageAbilities.put(3, "Constitution - ziekelijk, bleek");
		lageAbilities.put(4, "Intelligence - dom, langzaam");
		lageAbilities.put(5, "Wisdom - vergeetachtig, verstrooid");
		lageAbilities.put(6, "Charisma - simpel, saai");	
	}
	
	private static void initTalenten() {
		talenten.put(1, "Speelt een muziekinstrument");
		talenten.put(2, "Kan verschillende talen vloeiend spreken");
		talenten.put(3, "Guus geluk");
		talenten.put(4, "Perfect geheugen");
		talenten.put(5, "Goed met dieren");
		talenten.put(6, "Goed met kinderen");
		talenten.put(7, "Goed in één spel");
		talenten.put(8, "Goed in mensen nadoen");
		talenten.put(9, "Tekent mooi");
		talenten.put(10, "Schildert mooi");
		talenten.put(11, "Zingt mooi");
		talenten.put(12, "Drinkt iedereen onder de tafel");
		talenten.put(13, "Timmerexpert");
		talenten.put(14, "Kan goed koken");
		talenten.put(15, "Goed in het gooien van darts / gooien van steentjes op water");
		talenten.put(16, "Kan goed puzzels oplossen");
		talenten.put(17, "Jongleur");
		talenten.put(18, "Goede acteur en goed in vermommingen");
		talenten.put(19, "Danst goed");
		talenten.put(20, "Kent thieves' cant");
	}
	
	private static void initManiertjes() {
		maniertjes.put(1, "Neuriet, fluit of zingt vaak zomaar");
		maniertjes.put(2, "Heeft een aparte manier van spreken, (rijmen bijv.)");
		maniertjes.put(3, "Bijzonder hoge of lage stem");
		maniertjes.put(4, "Verbasterd woorden, slist of stottert");
		maniertjes.put(5, "Articuleert uitzonderlijk duidelijk");
		maniertjes.put(6, "Spreekt erg luid");
		maniertjes.put(7, "Fluistert");
		maniertjes.put(8, "Gebruikt archaïsche taal en moeilijke woorden");
		maniertjes.put(9, "Gebruikt vaak de verkeerde woorden");
		maniertjes.put(10, "Heeft bijzondere uitroepen en vloekt kleurrijk");
		maniertjes.put(11, "Grappenmaker");
		maniertjes.put(12, "Doemdenker");
		maniertjes.put(13, "Frunnikt");
		maniertjes.put(14, "Knijpt ogen samen");
		maniertjes.put(15, "Staart in de verte");
		maniertjes.put(16, "Kauwt op iets");
		maniertjes.put(17, "Ijsbeert");
		maniertjes.put(18, "Trommelt met de vingers");
		maniertjes.put(19, "Nagelbijter");
		maniertjes.put(20, "Draait aan haar of plukt in baard");
	}
	
	private static void initOmgangsvormen() {
		omgangsVormen .put(1, "Betogend");
		omgangsVormen .put(2, "Arrogant");
		omgangsVormen .put(3, "Opschepper");
		omgangsVormen .put(4, "Onbeleefd");
		omgangsVormen .put(5, "Nieuwsgierig");
		omgangsVormen .put(6, "Vriendelijk");
		omgangsVormen .put(7, "Eerlijk");
		omgangsVormen .put(8, "Temperamentvol");
		omgangsVormen .put(9, "Prikkelbaar");
		omgangsVormen .put(10, "Zwaarwichtig");
		omgangsVormen .put(11, "Stil");
		omgangsVormen .put(12, "Wantrouwig");
	}
	
	private static void initIdealen() {
		idealen.put(1, "G: Schoonheid, E: Overheersing, L: Harmonie, C: Verandering, N: Balans, O: Ambitie");
		idealen.put(2, "G: Vrijgevigheid, E: Hebzucht, L: Eerlijkheid, C: Creativiteit, N: Kennis, O: Vindingrijkheid");
		idealen.put(3, "G: Grotere goed, E: Macht, L: Eer, C: Vrijheid, N: Leef en laat leven, O: Glorie");
		idealen.put(4, "G: Leven, E: Pijn, L: Logica, C: Onafhankelijkheid, N: Matigheid, O: Voor het volk");
		idealen.put(5, "G: Respect, E: Vergelding, L: Verantwoordelijkheid, C: Geen grenzen, N: Onpartijdigheid, O: Verlossing");
		idealen.put(6, "G: Zelfopoffering, E: Afslachting, L: Traditie, C: Originaliteit, N: Mensen, O: Zelf-kennis");
	}
	
	private static void initObligaties() {
		obligaties.put(1, "Toegewijd aan het vervullen van een levensdoel");
		obligaties.put(2, "Beschermt haar / zijn gezin");
		obligaties.put(3, "Beschermt haar / zijn collega's of compagnons");
		obligaties.put(4, "Loyaal aan een beschermheer/dame, weldoener of werkgever");
		obligaties.put(5, "Verliefd");
		obligaties.put(6, "Hang naar een bepaalde speciale plek");
		obligaties.put(7, "Beschermt een sentimenteel aandenken");
		obligaties.put(8, "Beschermt een kostbaar bezit");
		obligaties.put(9, "Uit op wraak");
		obligaties.put(10, "Rol twee keer, negeer 10 daarbij");
	}
	
	private static void initGebreken() {
		gebreken.put(1, "Minnaar en / of snel verliefd");
		gebreken.put(2, "Heeft dure hobbies");
		gebreken.put(3, "Arrogantie");
		gebreken.put(4, "Jaloers op iemands bezit of status");
		gebreken.put(5, "Ontzettend hebzuchtig");
		gebreken.put(6, "Wordt snel kwaad");
		gebreken.put(7, "Heeft een machtige vijand");
		gebreken.put(8, "Heeft last van een bepaalde angst");
		gebreken.put(9, "Schandelijk verleden");
		gebreken.put(10, "Verbergt een misdaad");
		gebreken.put(11, "Bezit verloren kennis");
		gebreken.put(12, "Nietsonziende heldhaftigheid");
	}
	
	private static void initAlignment() {
		alignments.put(1, "LG");
		alignments.put(2, "LE");
		alignments.put(3, "LN");
		alignments.put(4, "CG");
		alignments.put(5, "CE");
		alignments.put(6, "CN");
		alignments.put(7, "NN");
		alignments.put(8, "NE");
		alignments.put(9, "NG");
		alignments.put(10, "NG");
	}
	
	public static String getRandomNPCTraits() {
		initTables();
		StringBuilder npcBuilder = new StringBuilder();
		npcBuilder.append("Alignment: \t\t" + alignments.get(DiceService.throwD6(1)) + "\n");
		npcBuilder.append("Uiterlijk: \t\t" + uiterlijk.get(DiceService.throwD20(1)) + "\n");
		
		int rollForHighAbility = DiceService.throwD6(1);
		npcBuilder.append("Hoge ability: \t\t" + hogeAbilities.get(rollForHighAbility) + "\n");
		
		int rollForLowAbility = DiceService.throwD6(1);
		while (rollForLowAbility == rollForHighAbility) {
			rollForLowAbility = DiceService.throwD6(1);
		}
		npcBuilder.append("Lage ability: \t\t" + lageAbilities.get(rollForLowAbility) + "\n");
		
		npcBuilder.append("Talent: \t\t" + talenten.get(DiceService.throwD20(1)) + "\n");
		npcBuilder.append("Maniertje(s): \t\t" + maniertjes.get(DiceService.throwD20(1)) + "\n");
		npcBuilder.append("Omgang met anderen: \t" + omgangsVormen .get(DiceService.throwD12(1)) + "\n");
		npcBuilder.append("Ideaal: \t\t" + idealen.get(DiceService.throwD6(1)) + "\n");
		getBondsText(npcBuilder);
		npcBuilder.append("Geheim of gebrek: \t" + gebreken.get(DiceService.throwD12(1)) + "\n");
		
		return npcBuilder.toString();
	}

	private static void getBondsText(StringBuilder npcBuilder) {
		int rollForBonds = DiceService.throwD10(1);
		if(rollForBonds == 10) {
			for(int i = 0 ; i<2 ; i++) {
				rollForBonds = DiceService.throwD10(1);
				if(rollForBonds < 10) {
					npcBuilder.append("Obligatie: \t\t" + obligaties.get(rollForBonds) + "\n");
				}
				else {
					i--;
					continue;
				}
			}
		}
		else {
			npcBuilder.append("Obligatie: \t\t" + obligaties.get(rollForBonds) + "\n");
		}
	}
}
