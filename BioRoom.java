import java.util.Scanner;
import java.util.Random;

public class BioRoom
{
	
	public static void main(String[] args)
	{	
		int viruses = 15;
		int xWidth = 10;
		int yWidth = 10;
		
		char[] headerCoordinates = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J','K'};
		double startTime = 0;
		int blanks = 0;
		int turnNum = 0;
		int[] showCoordinate = new int[2];
		int[] time = new int[2];
		String command = " ";
		Scanner keyboard = new Scanner(System.in);
		boolean gameOver = false;

		//Get Name from name class
		String playerName = "Thomas";

		//Start Game
		drawHeader(50, "Clear the Room!! Don't touch the Viruses!!", '#');
		int[][] location = new int[xWidth][yWidth];
		boolean[][] reveal = new boolean[xWidth][yWidth];
		boolean[][] finalBoard = new boolean[xWidth][yWidth];
		showEverySpace(xWidth, yWidth, finalBoard);
		initializeBoard(location, viruses, xWidth, yWidth);
		startTime = System.currentTimeMillis();

		while (gameOver!=true) //continue until win, lose, or user quit
		{
			blanks = checkBlanks(xWidth, yWidth, reveal);
			if (blanks==viruses)
			{
				gameOver=true;
				break;
			}

			//Draw the board again
			++turnNum;
			drawBoardHeader("*** ROUND: "+turnNum+", TIME "+getTime(startTime, time)+" ***", xWidth, yWidth);
			drawBoard(location, reveal, xWidth, yWidth, headerCoordinates);

			//Get the next action to perform
			command = optionRequest(keyboard, xWidth, yWidth, reveal, showCoordinate, headerCoordinates, startTime, time);
			
			if (command.length()<4 && command.length()>1 && Character.isLetter(command.charAt(0))==true && Character.isDigit(command.charAt(1))==true && Character.isDigit(command.charAt(command.length()-1))==true)
			{
				gameOver=uncoverCoordinate(showCoordinate[1], showCoordinate[0], location, xWidth, yWidth, reveal, gameOver);
				System.out.println();
			}
			else if (command.equalsIgnoreCase("quit"))
			{
				System.out.println("Quitting...");
				System.out.println();
				gameOver=true;
			}
			else if (command.equalsIgnoreCase("redraw"))
			{
				--turnNum;
			}
		}
		//Draw the final board
		showEverySpace(xWidth, yWidth, reveal);
		drawBoardHeader("*** GAME-OVER, TIME "+ getTime(startTime, time) +" ***", xWidth, yWidth);
		drawBoard(location, reveal, xWidth, yWidth, headerCoordinates);
		if (blanks==viruses) //check if user won
		{
			System.out.println("Congratulations you have quarantined all the viruses.");
			System.out.println("The blaring siren has been silence signaling to the school that the threat of epidemic has been nutralized.");
			System.out.println("The president of Miracosta College.  Mrs. Joan Lilyhammer grants you the Key to the school.");
			System.out.println("You hear from outside the room your fellow classmate chating your name, " + playerName +", "+ playerName +", "+ playerName +"...");
		
			//Add Key for this Room to the inventory Class

		}
		else //there were more blanks than viruses
		{
			System.out.println("You touched the deadly virus.  You feel a tighness in your throat as blood squirts out of every orifice.");
			System.out.println("The last thing you see is the world turn red from the blood in your eyes.");
			System.out.println("The last thing you hear is the gurgling of blood in your ears.  Curse you Miracosta College!!!!");
			
			//Minus 1 life from the system

			System.out.println("Would you like to respawn?");
		}
	
	}
	
	//prompt player for command

	public static String optionRequest(Scanner keyboard, int xWidth, int yWidth, boolean[][] reveal, int[] showCoordinate, char[]headerCoordinates, double startTime, int[] time)
	{
		boolean valid = false;
		String command = " ";
		int[] checkExpose = new int[2];
		while(valid == false)
		{
			System.out.print("Enter a coordinate or other command: ");
			command = keyboard.next();
            if (Character.isDigit(command.charAt(0))==true  && Character.isLetter(command.charAt(command.length()-1))==true)
			{	
				int length = command.length();
				String lastChar = command.substring(length - 1);
				command = lastChar + command.substring(0, length-1);
            }
			if (command.equals("?"))
			{
				drawLine(55, '-');
				System.out.println("To uncover a square, enter the coordinate (ex. \"A2\").");
				System.out.println("To check current game time, type \"time\".");
				System.out.println("To redraw the screen, type \"redraw\".");
				System.out.println("To quit the game, type \"quit\".");
				drawLine(55, '-');
			}
			else if (command.equalsIgnoreCase("time"))
			{
				System.out.println("Current game time is "+getTime(startTime, time)+".  You better hurry up.  The viruses are spreading!!");
			}
			else if (command.equalsIgnoreCase("quit"))
			{
                valid=true;
            }
			else if (command.length()<4 && command.length()>1 && Character.isLetter(command.charAt(0))==true && Character.isDigit(command.charAt(1))==true && Character.isDigit(command.charAt(command.length()-1))==true)
			{
				checkExpose = getCoor(command, headerCoordinates, checkExpose);
				if (checkExpose[1]<xWidth && checkExpose[0]<yWidth && reveal[checkExpose[1]][checkExpose[0]]==true)
				{
					System.out.println("You have already looked there!!  Hurry! Quit wasting time you fool!");
				}
				else if (checkExpose[1]<xWidth && checkExpose[0]<yWidth)
				{
					showCoordinate[1]=checkExpose[1];
					showCoordinate[0]=checkExpose[0];
					valid=true;
				}
				else
				{
					System.out.println("You don't know what you are doing your coordinate is out of the room.  You are endanger of dying. Try again.");
				}
			}
			else if (command.equalsIgnoreCase("redraw"))
			{
				System.out.println("Redrawing grid...");
				System.out.println();
				valid=true;
			}
			else 
			{
				System.out.println("Do you have butter on your fingers!  You typed an invalid command! Try again. God Help You!!, or type \"?\" for help.");
			}
		}
		command = command.toUpperCase();
		return command;
	}
	
	//checks how many uncovered squares are left on the grid

	public static int checkBlanks(int xmax, int ymax, boolean[][] reveal)
	{
		int blanks = 0;
		for (int y=0; y<ymax; ++y)
		{
			for (int x=0; x<xmax; ++x)
			{
				if (reveal[x][y]==false)
				{
					++blanks;
				}
			}
		}
		return blanks;
	}
	
	public static int[] getCoor(String coor, char[] headerCoordinates, int[] result)
	{
		coor = coor.toUpperCase();
		for (int i=0; i<(headerCoordinates.length)-1; ++i)
		{
			if (headerCoordinates[i]==(coor.charAt(0)))
			{
				result[1]=i;
			}
		}
		result[0]=Integer.parseInt(coor.substring(1, coor.length()))-1;
		return result;
	}
				
	//creates a header with a centered text and border
	public static void drawHeader(int length, String text, char symbol)
	{
		int textLength = text.length();
		if (textLength>length-2)
		{
			length=textLength+2;
		}
		drawLine(length, symbol);
		System.out.print(symbol);
		for (int i=0; i<(length-textLength-2)+1; ++i)
		{
			if (i==(length-textLength-2)/2)
			{
				System.out.print(text);
			}
			else
			{
				System.out.print(" ");
			}
		}
		System.out.println(symbol);
		drawLine(length, symbol);
	}
	
	//draws a line of chars of a passed length

	public static void drawLine(int length, char symbol)
	{
		for (int i=0; i<length-1; ++i)
		{
			System.out.print(symbol);
		}
		System.out.println(symbol);
	}
	
	public static void showEverySpace(int xmax, int ymax, boolean[][] toExpose)
	{
		for (int y=0; y<ymax; ++y)
		{
			for (int x=0; x<xmax; ++x)
			{
				toExpose[x][y]=true;
			}
		}
	}
	
	//sets space at coordinate to reveal
	public static boolean uncoverCoordinate(int row, int col, int[][] location, int xmax, int ymax, boolean[][] reveal, boolean gameOver)
	{
		if (location[row][col]==-1)
		{
			location[row][col]=-2;
			reveal[row][col]=true;
			gameOver=true;
		}
		else if (location[row][col]==0)
		{	
			//insert code that checks all around zero and for each check, runs this method
			reveal[row][col]=true;
			for (int b=col-1; b<=col+1; ++b)
			{
				if (b<ymax && b>=0)
				{
					for (int a=row-1; a<=row+1; ++a)
					{
						if (a<xmax && a>=0 && reveal[a][b]!=true)
						{
							gameOver=uncoverCoordinate(a, b, location, xmax, ymax, reveal, gameOver);
						}
					}
				}
			}
					
		}
		else
		{
			reveal[row][col]=true;
		}
		return gameOver;		
	}
	
	//creates the initial grid, placing viruses and changing values of squares around them

	public static void initializeBoard(int[][] location, int viruses, int xmax, int ymax)
	{
		int x = 0;
		int y = 0;
		Random r = new Random();
		for (int i=0; i<viruses; ++i)
		{
			do
			{
				x=r.nextInt(xmax);
				y=r.nextInt(ymax);
				//System.out.print("("+ x + "," + y+")");
			}
			while (location[x][y]==-1);
			location[x][y]=-1;
			for (int b = y-1; b<=y+1; ++b)
			{
				if (b < ymax && b>=0)
				{
					for (int a=x-1; a<=x+1; ++a)
					{
						if (a<xmax && a>=0)
						{
							if (location[a][b]!=-1)
							{
								location[a][b]+=1;
							}
						}
					}
				}
			}
		}
		//System.out.println("");
	}
	
	
	//prints the current grid to console, hiding covered squares from player	

	public static void drawBoard(int[][] location, boolean[][] reveal, int xmax, int ymax, char[] headerCoordinates)
	{
		System.out.print("   |");
		for (int xaxis=0; xaxis<xmax; ++xaxis)
		{
			System.out.print(" "+headerCoordinates[xaxis]+" ");
		}
		System.out.println("|");
		System.out.print(" ");
		for (int top=0; top<(xmax*3)+6; ++top)
		{
			System.out.print("-");
		}
		System.out.println();
		for (int y=0; y<ymax; ++y)
		{
			if (y+1<10)
			{
				System.out.print("  "+(y+1)+"|");
			}
			else //y+1>=10
			{
				System.out.print(" "+(y+1)+"|");
			}
			for (int x=0; x<xmax; ++x)
			{
				if (reveal[x][y]==true && location[x][y]>0)
				{
					System.out.print("["+location[x][y]+"]");
				}
				else if (reveal[x][y]==true && location[x][y]==-1)
				{
					System.out.print("{#}");
				}
				else if (reveal[x][y]==true && location[x][y]==-2)
				{
					System.out.print(" X ");
				}
				else if (reveal[x][y]==true && location[x][y]==0)
				{
					System.out.print("   ");
				}
				else //reveal[x][y]==false
				{
					System.out.print(" ? ");
				}
			}
			System.out.print("|"+(y+1));
			System.out.println();
		}
		System.out.print(" ");
		for (int bottom=0; bottom<(xmax*3)+6; ++bottom)
		{
			System.out.print("-");
		}
		System.out.println();
		System.out.print("   |");
		for (int xaxis=0; xaxis<xmax; ++xaxis)
		{
			System.out.print(" "+headerCoordinates[xaxis]+" ");
		}
		System.out.println("|");
		System.out.println();
		
	}	
	//draws a centered header over the game grid

	public static void drawBoardHeader(String text, int xWidth, int yWidth)
	{
		int textLength = text.length();
		int length = (xWidth*3)+10;
		for (int i=0; i<(length-textLength-2)+1; ++i)
		{
			if (i==(length-textLength-2)/2)
			{
				System.out.print(text);
			}
			else
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	
	//gets the current game time and creates a string for it

	public static String getTime(double startTime, int[] time)
	{
		String timeString = "0:00";
		double currentAccumTime = System.currentTimeMillis()-startTime;
		time[0]=(int)(currentAccumTime%60000)/1000;
		time[1]=(int)(currentAccumTime/60000);
		if (time[0]<10)
		{
			timeString=time[1]+":0"+time[0];
		}
		else //time>=10
		{
			timeString=time[1]+":"+time[0];
		}
		return timeString;
	}
}