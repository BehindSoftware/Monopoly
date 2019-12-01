package monopoly.model;


/** An class to be inherited from to create various kinds of dice.
@author Byron Weber Becker */
public class Dice extends Object
{
	protected int faceValue;

	public Dice()
	{  super();
	}

	/** Get a roll of the "dice"
   @return a random number */
	public void roll()
	{  return ;
	}
	
	/** Get a roll of the "dice"
	   @return a random number */
	public int getFaceValue( ) { 
		return faceValue; 
	} 

}
