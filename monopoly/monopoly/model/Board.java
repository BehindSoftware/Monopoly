package monopoly.model;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Board {

	private static final int SIZE = 27;
	private ArrayList<Object> squares = new ArrayList<Object>(SIZE);
	
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
		//for (int i=1;i<=SIZE;i++) {
			build(0);
		//}
	}
	
	public void parseSquareFromFile(String fileName, int index) {
		System.out.println("Welcome to "+fileName);
		   String text;
		   FileInputStream fStream = null;
		   try {
			fStream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   DataInputStream dStream = new DataInputStream(fStream);
		   BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
		   
		   try {
			while((text = bReader.readLine())!=null) {
				  // System.out.println(index);
				   if(text.equals("Go")) {
					   System.out.println(index);

					   GoSquare s = new GoSquare("Go", index++);
					   s.name = bReader.readLine();
					   squares.add(s);
					   
				   }else if(text.equals("BuildingLot")) {
					   System.out.println(index);

					   PropertySquare s = new PropertySquare("BuildingLot", index++);
					   s.name = bReader.readLine();
					   s.purPrice = Integer.parseInt(bReader.readLine());
					   s.houses = Integer.parseInt(bReader.readLine());
					   s.houseCost = Integer.parseInt(bReader.readLine());
					   squares.add(s);
					   
				   }else if(text.equals("RailRoad")) {
					   System.out.println(index);

					   RegularSquare s = new RegularSquare("RailRoad", index++);
					   s.name = bReader.readLine();
					   s.purPrice = Integer.parseInt(bReader.readLine());
					   squares.add(s);
				   }else {
					   //System.out.println("Unknown Square");
				   }
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   try {
			dStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void build(int i) {
		System.out.println("BUILD");
		parseSquareFromFile("/home/vertex/eclipse-workspace-forjava/Monopoly/monopoly/monopoly/boardSquares.txt",i);
	}
	
	public void linkSquares()
	{
		for(int i=0;i<SIZE;i++) {
			link(i);
		}

	}
	
	public void link (int i) {
		System.out.println("Buraya kadar geliyor burada farklı tip squarelerin birbiriyle linklenmesi gerekiyor tabi daha önce squareler arrayliste kaydedilmeli");
		Square current = (Square) squares.get(i);
		Square next = (Square) squares.get((i+1)%SIZE);
		current.setNextSquare(next);
		System.out.println("Everything is okey ?");
	}
	
}
