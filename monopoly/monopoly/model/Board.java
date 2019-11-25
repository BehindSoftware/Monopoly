package monopoly.model;
import java.util.*;

public class Board {

	private static final int SIZE = 40;
	private List squares = new ArrayList(SIZE);
	
	public Board () {
		buildSquares();
		linkSquares();
	}
	
	public Square getStartSquare() {
		return (Square) squares.get(0);
	}
	
	public Square getSquare(Square start, int dist) {
		int endIndex = (start.getIndex()+ dist) % SIZE;
		return (Square) squares.get(endIndex);
	}
	
	public void buildSquares() {
		for (int i=1;i<=SIZE;i++) {
			build(i);
		}
	}
	
	public void build(int i) {
		//There is a problem about parameter
		
		//Square s = new Square("Square "+i, i-1);
	}
	
	public void linkSquares()
	{
		for(int i=0;i<SIZE;i++)
			link(i);
	}
	
	public void link (int i) {
		Square current = (Square) squares.get(i);
		Square next = (Square) squares.get((i+1)%SIZE);
		current.setNextSquare(next);
	}
	
}
