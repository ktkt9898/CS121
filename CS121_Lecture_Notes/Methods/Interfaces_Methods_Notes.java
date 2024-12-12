package Methods;
/*
 * Interface defines the methods that can be used within a class
 * An interface just declares methods and what to expect from objects
 * 
 * public interface DeckOfCardsInterface {
 *  public void shuffle();
 *  public Card draw();
 *  // possibly other methods
 * }
 * 
 * Class and inteface references are different...
 * If an array list of an interface, any object can be stored that 
 * uses that interface
 * 
 * public class DeckOfCards implements DeckOfCardsInteface {
 *  private ArrayList<Card> cards;
 *  public DeckOfCards() {
 * }
 * 
 * A static prefix means an object does not need be created in
 * order to for a method to be used.
 * 
 * Static variables are special fields that are shared by every object
 * that is created, instead of receiving their own copies.
 * To access the variable, the object can be passed onto or the class
 * as long as the method is public
 * itself: die1.numDice() or Dice.numDice()
 * 
 * Static methods can ONLY call other static methods.
 * If you want to call from main, the methods must be static
 * 
 * Method overloading is giving a single method name multiple definitions
 * Overloading allows a method that works for different type parameters
 * println() is overloaded for multiply types (char, string, int)
 * 
 * Methods can take objects as parameters.
 * 
 * Objects are stored as references addresses because storing copies takes up
 * alot of memory
 * Careful, a method is able to permanently modify an object
 * This is called Pass-by-reference
 * 
 * To avoid breaking incapsulation with arraylists, new arraylists
 * can be created by taking the elements of the original
 * arraylist. This ensures nothing could be modified from the original
 * arraylist by main.
 * 
 * Very important for private instance variables that should
 * only be modified within the class
 */