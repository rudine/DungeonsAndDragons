package basic.monsters;

import static basic.monsters.specialabilities.SpecialAbility.FearOfFire;
import static basic.monsters.specialabilities.SpecialAbility.KeenSmell;
import static basic.monsters.specialabilities.SpecialAbility.SnowCamouflage;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.attacktypes.SpecialAttack;
import basic.attacktypes.SpecialAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.AbilityTypes;
import basic.ruleobjects.Alignment;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.MonsterType;
import basic.ruleobjects.SavingThrow;
import basic.ruleobjects.Size;
import basic.ruleobjects.Skill;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

public class Yeti extends AbstractEnemy {

	public Yeti() {
		setAlive(true);
		setAC(12);
		setHitpoints(DiceService.throwD10(6) + 18);
		setSpeed("40 ft. 8 vakjes. Climb 40 ft. 8 vakjes");
		setAbilityScores(new AbilityScores(18, 13, 16, 8, 12, 7));
		addToSkills(new SkillModifier(3, Skill.Perception, AbilityTypes.WIS));
		//TODO fear of fire naar vunerabilities
		addToSpecialAbilities(KeenSmell, FearOfFire, SnowCamouflage);
		setAttacks();
		setAttacksOnAttackAction(2);
		setSpecialAttacks();
		setSpecialAttacksOnAction(1);
		setSize(Size.Large);
		setMonsterType(MonsterType.monstrosity);
		setAlignment(Alignment.ChaoticEvil);
	}
	
	private void setAttacks() {
		MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
		MeleeAttack claw = meleeBuilder.setWeaponName("Claw")//
				.setBaseDamage(4)// alleen slashing damage type
				.setDamageDie(6)//
				.setTimesToThrowDamageDie(2)//
				.setDamageType(DamageType.SLASHING)//FIXME ook damagetype cold, dat is 1 van de twee dmgs
				.setDescription("including 3 COLD dmg")//
				.build();
		addToAvailableAttacks(claw);
	}
	
	private void setSpecialAttacks() {
		SpecialAttackBuilder AOEBuilder = new SpecialAttackBuilder();
		SpecialAttack chillingGaze = AOEBuilder.setAreaOfEffect("target in sight")//
				.setBaseDamage(0)//
				.setDamageDie(6)//
				.setTimesToThrowDamageDie(3)//
				.setDamageType(DamageType.COLD)//
				.setSavingThrow(new SavingThrow(13, AbilityTypes.CON))//
				.setHalfDamageWhenSaved(true)//
				.setWeaponName("Chilling Gaze")//
				.setDescription(getChillingGazeText())//
				.setRecharge(false)//
				.setAvailable(true)//
				.build();
		addToSpecialAttacks(chillingGaze);
	}
	
	private String getChillingGazeText() {
		return "The yeti targets one creature it can see within 30\r\n" + 
				"feet of it. If the target can see the yeti, the target must succeed\r\n" + 
				"on a DC 13 Constitution saving throw against this magic or\r\n" + 
				"take 10 (3d6) cold damage and then be paralyzed for 1 minute,\r\n" + 
				"unless it is immune to cold damage. The target can repeat the\r\n" + 
				"saving throw at the end of each of its turns, ending the effect\r\n" + 
				"on itself on a success. If the target's saving throw is successful,\r\n" + 
				"or if the effect ends on it, the target is immune to the Chilling\r\n" + 
				"Gaze of all yetis (but not abominable yetis) for 1 hour.";
	}
}
