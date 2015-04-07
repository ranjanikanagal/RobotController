
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	import javax.swing.BorderFactory;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;

	public class RobotGame extends JFrame {
		private static final int N = 10;// grid Size 
		   private final List<JButton> list = new ArrayList<JButton>();
	JButton button;
	JButton button2;
	JPanel[] p = new JPanel[100];
	int k = 0;

	public RobotGame() {
	    super();
	    button = new JButton("Robot");//Robot 
	    button.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	                    requestFocusInWindow();
	        }
	    });
	    JPanel panel = new JPanel(new GridLayout(N,N));
	    for (int i = 0; i <  N * N; i++) {
	        p[i] = new JPanel(new BorderLayout());
	        p[i].setBorder(BorderFactory.createLineBorder(Color.RED));
	        panel.add(p[i]);
	       
	    
	    }
	  
	    p[15].setBackground(Color.BLACK); //Represents Rock
	    p[90].setBackground(Color.BLACK); //Represents Rock
	    p[55].setBackground(Color.CYAN); //Represents Connecting cell only one way or Hole which connects to other cell
	    p[77].setBackground(Color.CYAN); ///  Represents Connecting cell 
	    p[0].add(button);  //intial Robot position

	    setFocusable(true);
	    panel.requestFocusInWindow();
	  
	    setSize(600, 600);
	    add(panel);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	   
	    

	}
	/* Function to Rmove robot one cell at a time*/
	public int MoveRobot(String c){

		 if (k <= 99 && k >= 0) {
		switch(c){
		case "F":
			 if (k + 10 <= 99 && k!=5 && k!=80) {
				 p[k += 10].add(button);
	          }
	              System .out.print(c);
			 repaint();
			 break;
			 
		case "L":
			 if (k - 1 >= 0 && k!=16 && k!=91) {
				 p[--k].add(button);
	         }System .out.print(c);
			 repaint();
			 break;
		case "R":
			  if (k + 1 <= 99 && k!=14 && k!=89) {
				  p[++k].add(button);
	          }System .out.print(c);
			 repaint();
			 break;
		 }
		 if(k==55){
	     	k=77;
	         p[k].add(button);
	     }
	     repaint();
		}
		 return k;
	}
	public static void main(String[] args) {
		RobotGame test= new RobotGame();
	   
	   for(;;){
		Scanner reader = new Scanner(System.in);
	    
	    System.out.println("Enter your Command To move  L-LEFT, R-RIGHT, F-FORWARD");
	    String c =reader.nextLine();
	    int k=test.MoveRobot(c);
	    System.out.println(k);
	    int row = k / N;
	    int col = k % N;
	    System.out.println("Path***"+"(" +row+','+ col+")");
	    if(k==(N*N-1)){   //if(Robot reach last cell in the grid Game Ends 
	    	
	    	 System.out.println("Game End");
	    	break;
	    
	    }
	   }
	}
	}

