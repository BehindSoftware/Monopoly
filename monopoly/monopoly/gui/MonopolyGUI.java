package monopoly.gui;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import monopoly.model.*;

/** Put together the top-level of the Monopoly GUI.  It is composed of
a view for each property and a view for each player.
@author Byron Weber Becker */
public class MonopolyGUI extends JPanel 
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/** A list of colours to use for the players. */
   /* package */ static final Color[] PLAYER_COLORS = new Color[]{
            Color.blue, Color.red, Color.green, Color.yellow,
            Color.darkGray, Color.orange, Color.cyan
         };

   /** Construct a new GUI for Monopoly. */
   public MonopolyGUI(Monopoly model)
   {  super();

   		//Burada controller'a gidip butona basılmayı beklemesi gerekiyor, eğer playGame basılırsa 
   //yeni oyun load game basılırsa dosyadan yükleme yapılmalı.
   boolean stub=true;
   
   if(stub) {
	   model.playGame();
   }
   else{
	   model.loadGame(this.getOptionalInputFile());
   }
  
      this.layoutView(model);

      /* The HumanPlayer class waits for the human to manipulate the
      user interface. Therefore it must run in a separate thread so it
      doesn't freeze the UI at the same time. */
      Thread mThread = new Thread(new MonopolyThread(model));
      mThread.start();
   }

   private void layoutView(Monopoly model)
   {
      JPanel propertyPanel = this.makePropertiesPanel(model);
      JPanel playerPanel = this.makePlayerPanel(model);


      this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
      this.add(propertyPanel);
      this.add(playerPanel);
   }

   private String getOptionalInputFile()
   {  JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
      while (true)
      {
         int returnVal = fc.showOpenDialog(null);
         if (returnVal == JFileChooser.APPROVE_OPTION)
         {  try
            {  File f = fc.getSelectedFile();
               return f.getCanonicalPath();
            } catch (IOException e)
            {  
            }
            return fc.getSelectedFile().getName();
         } else
         {  return null;
         }
      }
   }

   /** Make a panel with all the property views in it. */
   private JPanel makePropertiesPanel(Monopoly model)
   {  
	   JPanel p = new JPanel();

	   int numProperties = model.getNumSquares();

	   int propPerSide = (numProperties + 3) / 4 + 1;

	   p.setLayout(new PerimeterLayout(propPerSide, propPerSide,
			   propPerSide - 1, propPerSide - 1));

	   System.out.println("Geldi"+propPerSide+"model.getSquare(0):"+model.getSquare(0));
	   
	   for(int i=0; i<numProperties; i++)
	   {  
		   SquareView pv = new SquareView(model.getSquare(i));
		   p.add(pv);
		   System.out.println("Square index:"+i);
	   }

	   p.add(new JButton("CENTER"), PerimeterLayout.CENTER);
	   return p;
   }

   /** Make a panel with all the player views in it. */
   private JPanel makePlayerPanel(Monopoly model)
   {  JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      int numPlayers = model.getNumPlayers();
      for(int i=0; i<numPlayers; i++)
      {  PlayerView pv = new PlayerView(model.getPlayer(i));
         panel.add(pv);
      }
      return panel;
   }
   
}
