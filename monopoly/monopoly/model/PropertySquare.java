package monopoly.model;

public class PropertySquare extends Square{

	protected int purPrice;
	protected int houses;
	protected int houseCost;
	
	public PropertySquare(String propertyDescription, int index) {
		super(propertyDescription, index);
		this.propertyDescription = propertyDescription;
		this.index = index;
	}

}
