package model;

import java.util.Random;

/** Roll a pair of random dice.
@author Byron Weber Becker */
public class RandomDice extends Dice
{
	/** Construct a new object. */
	public RandomDice()
	{  super();
	}

   /** Return a roll of the pair of dice.
   @return a number between 2 and 2*numSides */
   public int getRoll()
   {  
    Random random = new Random();
    int rand = 0;
    
    while (true){
        rand = random.nextInt(13);
        if(rand !=0) break;
    }
    
    return rand;
   }
   
}
