package basic.monsters.interfaces;
/**
 * Interface to indicate that the entity can be influenced by a certain DamageType and to ensure the roundsAffected methods are implemented 
 * @author Rudine
 */
public interface DamageTypeCausesDisadvantage {
	
	public abstract void setRoundsAffected(int roundsAffected);
	
	public abstract int getRoundsAffected();
	
}
