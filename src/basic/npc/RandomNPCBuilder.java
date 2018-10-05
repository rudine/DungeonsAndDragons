package basic.npc;

import java.util.HashMap;
import java.util.Map;

import basic.services.DiceService;

public abstract class RandomNPCBuilder {
	
	private static Map<Integer, String> appearances= new HashMap<>();
	private static Map<Integer, String> highAbilities= new HashMap<>();
	private static Map<Integer, String> lowAbilities= new HashMap<>();
	private static Map<Integer, String> talents= new HashMap<>();
	private static Map<Integer, String> mannerisms= new HashMap<>();
	private static Map<Integer, String> interactionTraits= new HashMap<>();
	private static Map<Integer, String> ideals= new HashMap<>();
	private static Map<Integer, String> bonds= new HashMap<>();
	private static Map<Integer, String> flaws= new HashMap<>();
	private static Map<Integer, String> alignments= new HashMap<>();
	
	public static void main(String[] args) {
		System.out.println(getRandomNPCTraits());
	}
	
	private static void initTables() {
		initAppearance();
		initHighAbility();
		initLowAbility();
		initTalents();
		initMannerisms();
		initInteractionTraits();
		initIdeals();
		initBonds();
		initFlaws();
		initAlignment();
	}
	
	private static void initAppearance() {
		appearances.put(1, "Distinctive jewelery: earrings, necklace, circlets, bracelets");
		appearances.put(2, "Piercings");
		appearances.put(3, "Flamboyant or outlandish clothes");
		appearances.put(4, "Formal, clean clothes");
		appearances.put(5, "Ragged, dirty clothes");
		appearances.put(6, "Pronounced scar");
		appearances.put(7, "Missing teeth");
		appearances.put(8, "Missing fingers");
		appearances.put(9, "Unusual eye color (or two different colors)");
		appearances.put(10, "Tattoos");
		appearances.put(11, "Birthmark");
		appearances.put(12, "Unusual skin color");
		appearances.put(13, "Bald");
		appearances.put(14, "Braided beard or hair");
		appearances.put(15, "Unusual hair color");
		appearances.put(16, "Nervous eye twitch");
		appearances.put(17, "Distinctive nose");
		appearances.put(18, "Distinctive posture (crooked or rigid)");
		appearances.put(19, "Exceptionally beautiful");
		appearances.put(20, "Exceptionally ugly");
	}
	
	private static void initHighAbility() {
		highAbilities.put(1, "Strength - powerful, brawny, strong as an ox");
		highAbilities.put(2, "Dexterity - lithe, agile, graceful");
		highAbilities.put(3, "Constitution - hardy, hale, healthy");
		highAbilities.put(4, "Intelligence - studious, learned, inquisitive");
		highAbilities.put(5, "Wisdom - perceptive, spiritual, insightful");
		highAbilities.put(6, "Charisma - persuasive, forceful, born leader");
	}
	
	private static void initLowAbility() {
		lowAbilities.put(1, "Strength - feeble, scrawny");
		lowAbilities.put(2, "Dexterity - clumsy, fumbling");
		lowAbilities.put(3, "Constitution - sickly, pale");
		lowAbilities.put(4, "Intelligence - dim-witted, slow");
		lowAbilities.put(5, "Wisdom - oblivious, absentminded");
		lowAbilities.put(6, "Charisma - dull, boring");	
	}
	
	private static void initTalents() {
		talents.put(1, "Plays a musical instrument");
		talents.put(2, "Speaks several languages fluently");
		talents.put(3, "Unbelievably lucky");
		talents.put(4, "Perfect memory");
		talents.put(5, "Great with animals");
		talents.put(6, "Great with children");
		talents.put(7, "Great at one game");
		talents.put(8, "Great at impersonations");
		talents.put(9, "Draws beautifully");
		talents.put(10, "Paints beautifully");
		talents.put(11, "Sings beautifully");
		talents.put(12, "Drinks everyone under the table");
		talents.put(13, "Expert carpenter");
		talents.put(14, "Expert cook");
		talents.put(15, "Expert dart thrower / stone skipper");
		talents.put(16, "Great at solving puzzles");
		talents.put(17, "Expert juggler");
		talents.put(18, "Skilled actor and master of disguise");
		talents.put(19, "Skilled dancer");
		talents.put(20, "Knows thieves' cant");
	}
	
	private static void initMannerisms() {
		mannerisms.put(1, "Prone to singing, whistling or humming quietly");
		mannerisms.put(2, "Speaks in rhyme or some other peculiar way");
		mannerisms.put(3, "Particulary low or high voice");
		mannerisms.put(4, "Slurs words, lisps or stutters");
		mannerisms.put(5, "Enunciates overly clearly");
		mannerisms.put(6, "Speaks loudly");
		mannerisms.put(7, "Whispers");
		mannerisms.put(8, "Uses flowery speach or long words");
		mannerisms.put(9, "Frequently uses the wrong words");
		mannerisms.put(10, "Uses colorful oaths and exclamations");
		mannerisms.put(11, "Makes constant jokes or puns");
		mannerisms.put(12, "Prone to predications of doom");
		mannerisms.put(13, "Fidgets");
		mannerisms.put(14, "Squints");
		mannerisms.put(15, "Stares into the distance");
		mannerisms.put(16, "Chews something");
		mannerisms.put(17, "Paces");
		mannerisms.put(18, "Taps fingers");
		mannerisms.put(19, "Bites fingernails");
		mannerisms.put(20, "Twirls hair or tugs beard");
	}
	
	private static void initInteractionTraits() {
		interactionTraits.put(1, "Argumentative");
		interactionTraits.put(2, "Arrogant");
		interactionTraits.put(3, "Blustering");
		interactionTraits.put(4, "Rude");
		interactionTraits.put(5, "Curious");
		interactionTraits.put(6, "Friendly");
		interactionTraits.put(7, "Honest");
		interactionTraits.put(8, "Hot tempered");
		interactionTraits.put(9, "Irritable");
		interactionTraits.put(10, "Ponderous");
		interactionTraits.put(11, "Quiet");
		interactionTraits.put(12, "Suspicious");
	}
	
	private static void initIdeals() {
		ideals.put(1, "G: Beauty, E: Domination, L: Community, C: Change, N: Balance, O: Aspiration");
		ideals.put(2, "G: Charity, E: Greed, L: Fairness, C: Creativity, N: Knowledge, O: Discovery");
		ideals.put(3, "G: Greater good, E: Might, L: Honor, C: Freedom, N: Live and let live, O: Glory");
		ideals.put(4, "G: Life, E: Pain, L: Logic, C: Independence, N: Moderation, O: Nation");
		ideals.put(5, "G: Respect, E: Retribution, L: Responsibility, C: No limits, N: Neutrality, O: Redemption");
		ideals.put(6, "G: Self-sacrifice, E: Slaughter, L: Tradition, C: Whimsy, N: People, O: Self-knowledge");
	}
	
	private static void initBonds() {
		bonds.put(1, "Dedicated to fulfilling a personal life goal");
		bonds.put(2, "Protective of close family members");
		bonds.put(3, "Protective of collegues or compatriots");
		bonds.put(4, "Loyal to a benefactor, patron or employer");
		bonds.put(5, "Captivated by a romantic interest");
		bonds.put(6, "Drawn to a special place");
		bonds.put(7, "Protective of a sentimental keepsake");
		bonds.put(8, "Protective of a valuable possession");
		bonds.put(9, "Out for revenge");
		bonds.put(10, "Roll twice ignoring results of 10");
	}
	
	private static void initFlaws() {
		flaws.put(1, "Forbidden love or susceptibility to romance");
		flaws.put(2, "Enjoys decadent pleasures");
		flaws.put(3, "Arrogance");
		flaws.put(4, "Envies another creature's possesions or station");
		flaws.put(5, "Overpowering greed");
		flaws.put(6, "Prone to rage");
		flaws.put(7, "Has a powerful enemy");
		flaws.put(8, "Specific phobia");
		flaws.put(9, "Shameful or scandalous history");
		flaws.put(10, "Secret crime or misdeed");
		flaws.put(11, "Possesion of forbidden lore");
		flaws.put(12, "Foolhardy bravery");
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
		npcBuilder.append("Appearance: \t\t" + appearances.get(DiceService.throwD20(1)) + "\n");
		
		int rollForHighAbility = DiceService.throwD6(1);
		npcBuilder.append("High ability: \t\t" + highAbilities.get(rollForHighAbility) + "\n");
		
		int rollForLowAbility = DiceService.throwD6(1);
		while (rollForLowAbility == rollForHighAbility) {
			rollForLowAbility = DiceService.throwD6(1);
		}
		npcBuilder.append("Low ability: \t\t" + lowAbilities.get(rollForLowAbility) + "\n");
		
		npcBuilder.append("Talent: \t\t" + talents.get(DiceService.throwD20(1)) + "\n");
		npcBuilder.append("Mannerism: \t\t" + mannerisms.get(DiceService.throwD20(1)) + "\n");
		npcBuilder.append("Iteraction w. others: \t" + interactionTraits.get(DiceService.throwD12(1)) + "\n");
		npcBuilder.append("Ideal: \t\t\t" + ideals.get(DiceService.throwD6(1)) + "\n");
		getBondsText(npcBuilder);
		npcBuilder.append("Flaw or secret: \t" + flaws.get(DiceService.throwD12(1)) + "\n");
		
		return npcBuilder.toString();
	}

	private static void getBondsText(StringBuilder npcBuilder) {
		int rollForBonds = DiceService.throwD10(1);
		if(rollForBonds == 10) {
			for(int i = 0 ; i<2 ; i++) {
				rollForBonds = DiceService.throwD10(1);
				if(rollForBonds < 10) {
					npcBuilder.append("Bond: \t\t\t" + bonds.get(rollForBonds) + "\n");
				}
				else {
					i--;
					continue;
				}
			}
		}
		else {
			npcBuilder.append("Bond: \t\t\t" + bonds.get(rollForBonds) + "\n");
		}
	}
}
