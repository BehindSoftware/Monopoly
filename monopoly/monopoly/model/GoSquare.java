package monopoly.model;

public class GoSquare extends Square{

	public GoSquare(String propertyDescription, int index) {
		super(propertyDescription, index);
		this.propertyDescription = propertyDescription;
		this.index = index;
	}

}
