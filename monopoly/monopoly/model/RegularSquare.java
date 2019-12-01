package monopoly.model;

public class RegularSquare extends Square {

	protected int purPrice;
	
	public RegularSquare(String propertyDescription, int index) {
		super(propertyDescription, index);
		this.propertyDescription = propertyDescription;
		this.index = index;
	}

}
