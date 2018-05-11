import java.io.*;
import java.util.Scanner;


public class Creator {

    public void create(Player p){

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter your username: ");

        String user = keyboard.next();
        p.setUsername(user);
        String userName = p.getUsername();
        String password = p.getPassword();
        File f= new FileWriter(userName + ".txt");
        if(f.exists()){
            System.out.println("This name is already taken.  Please use a different name");
        }else{
            System.out.println("Your user profile is being created, creating game....");
            PrintWriter pw = new PrintWriter(new FileWriter(f));
            pw.println(userName);
            pw.println(password);

        }

    }
    public void save(Player p){
        String userName = p.getUsername();
        String password = p.getPassword();

        File f = new FileWriter(userName + ".txt");
        if(f.exists()){
            try{
                PrintWriter pw = new PrintWriter(new File(f));
                pw.println(userName);
                pw.println(password);
                pw.close();
            }catch(FileNotFoundException fnfe){
                System.out.println("File not found: " + fnfe.getLocalizedMessage());
            }catch(IOException e){
                System.out.println("IOException Error: "+ e.getLocalizedMessage());    
            }
        }

    }

    public void load(Player p){


    }
 

}