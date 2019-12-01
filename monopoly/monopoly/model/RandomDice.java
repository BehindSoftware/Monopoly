package monopoly.model;


/** Roll a pair of random dice.
@author Byron Weber Becker */
public class RandomDice extends Dice
{

	public static final int MAX = 6;

	/** Construct a new object. */
	public RandomDice()
	{  
		super();
		roll();
	}

	//bad design : roll and getFaceValue will be seperated. (Principle of Separation of Command and Query)

	/** Return a roll of the pair of dice.
   @return a number between 2 and 2*numSides */
	public void roll()
	{  
		faceValue = (int) ( (Math.random( ) * MAX) + 1);
	}


}
