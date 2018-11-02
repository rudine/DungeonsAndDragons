package gui.ddex.earthspur;

import java.util.Arrays;

import basic.services.DiceService;

public enum MineCartChaseEffect {
	
	SharpTurn(1, "SHARP TURN", "Characters must succeed on a DC 10 DEX save or fall prone in their cart, missing their turn"),
	Downgrade(2, "DOWNGRADE", "The cart briefly accelerates away from the bulettes, preventing melee attacks this round. If a character uses their action to pull the brake, the bulettes close in for the remainder of the round."),
	LowCeiling(3, "LOW CEILING", "Characters must succeed on a DC 14 DEX save or receive 16 (3d10) Bludgeoning damage." ),
	HigherTracks(4, "HIGHER TRACKS", "Characters can use their action to leap onto another cart. Doing so requires a DC 15 Dexterity (Acrobatics) check: if the character fails, they fall prone in their own cart."),
	SteamVents(5, "STEAM VENTS", "Characters must succeed on a DC 10 Constitution saving throw or take 11 (2d10) fire damage and be blinded until the end of their turn."),
	SweepingBends(6, "SWEEPING BENDS", "Any chasing bulettes are forced to burrow alongside the cart to keep up. Attacks made against the bulettes this round have advantage.");
	
	private int dieResult = 0;
	
	private String title;
	
	private String effect;
	
	private MineCartChaseEffect(int dieSide, String title, String effect) {
		this.dieResult = dieSide;
		this.title = title;
		this.effect = effect;
	}
	
	public static MineCartChaseEffect getByDieResult(int dieResult) {
		return Arrays.asList(values()).stream().filter(v -> v.getDieResult() == dieResult).findFirst().get();
	}
	
	public int getDieResult() {
		return dieResult;
	}
	
	public String getTitle() {
		return title;
	}

	public String getEffect() {
		if (this.equals(MineCartChaseEffect.LowCeiling)) {
			int damage = DiceService.throwD10(3);
			return "Characters must succeed on a DC 14 DEX save or receive " + damage + " bludgeoning damage.";
		}
		else if(this.equals(MineCartChaseEffect.SteamVents)) {
			int damage = DiceService.throwD10(2);
			return "Characters must succeed on a DC 10 Constitution saving throw or take " + damage + " fire damage and be blinded until the end of their turn."; 
		}
		return effect;
	}
}
