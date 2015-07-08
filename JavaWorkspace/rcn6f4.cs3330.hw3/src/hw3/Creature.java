/**
 * Name: Ryan Neff
 * Pawprint: rcn6f4
 * HW 3
 */
package hw3;

public interface Creature {

	public boolean attack(GameCreature creature, Item item);
	public boolean heal(Item item);
	public boolean pickup(Item item);
	public boolean drop(Item item);
	public void dropAll();
	public boolean injured(Item item);
}
