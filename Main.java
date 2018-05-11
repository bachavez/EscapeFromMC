import java.util.Scanner;

//Main class will present user options throughout the game

public class Main{

    public static void main (String args[]){

        Scanner keyboard = new Scanner(System.in);

        Creator c = new Creator();
        Player p = new Player();

        System.out.println("**************************");
        System.out.println("Please Select:");
        System.out.println("(1) Create -> Create a new game");
        System.out.println("(2) Load -> Load a saved game");
        System.out.println("(3) Exit -> Exit the game");
        System.out.println("-->");

        int options = keyboard.nextInt();
        try {
            switch(options){
            
                case 1 : 
                    c.create(p);
                    break;
                case 2 :
                    c.load(p);
                    break;
                case 3 :
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter (1) to start a new game, (2) to load a saved game or (3) to exit");
                    options = keyboard.netInt();
            }
        }catch(Exception e){
            System.out.println("Exception error in the Main Class: " +e.getLocalizedMessage());
        }

    }

}

