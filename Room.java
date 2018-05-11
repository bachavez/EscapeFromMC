import java.util.*;

public class Room{
    
    public static String [] possibleInventory = {};
    public static int inventoryLocation = 0;
    public static ArrayList<String> inventory = new ArrayList<String>(20);//This will be attached to the inventory object in the User class
    public static ArrayList<Integer> keys = new ArrayList<Integer>(5);
    public static long startTime = System.currentTimeMillis();
    public static long endTime = 0;
    public static int currentPosition = -1;
    public static String command1 = "";
    public static String command2 = "";
    public static int loc=-1; //location in the map

    public static void main(String[] args){
        printLogo();
        start();
    }

    public static void viewsFrom(int loc){
        switch(loc){
            case 0:
            case 1: System.out.println("You are in the middle of main quad at the MiraCosta Campus");
                    System.out.println("The Biology Room is on at the end of a path directly in front of you.");
                    System.out.println("The Administrative Building is on a winding path to your left.");
                    System.out.println("The Math Room is at the end of a path directly behind you.");
                    System.out.println("The English Room is on a path to your right");
                    System.out.println("There is a clock tower directly above you");
                    System.out.println("There is a shiny key at your feet.  On it is inscribed the words 'engl-101'");
                    //command();
                    break;
            case 2: System.out.println("Your are at the front of the Biology Building.  The main door seems to be locked");
                    System.out.println("The Clock Tower is at the end of the path directly behind you.");
                    System.out.println("The Math Room is on the path to your right");
                    System.out.println("The Administrative Building is on a path to your left");
                    //command();
                    break;
        }
    }

    public static void start(){
        boolean askAgain = true;
        currentPosition = 0;
        System.out.println("A ray of sunlight hits you in eye just as you feel the water from the sprinkler hits you in the face.");
        System.out.println("You are lying on your back in the middle of Miracosta College.  You have a splitting headache and you feel like throwing up.");
        System.out.println("A sinister fellow walks up to you.  He introduces himself as Mr. Gradely the college president.  He explains that");
        System.out.println("the school has been monitoring your use of the school network to play video games.  We know that you are failing just about all of your classes");
        System.out.println("because of it.  The only way to graduate is to find 4 keys hidden in 4 rooms at the college.  These will unlock your diploma.");
        System.out.println("You must do so by the time the school opens at 7:00am or you will DIE!");
        System.out.println("Only then can you ESCAPE FROM MIRACOSTA COLLEGE");
        do{
            switch(commands()){
                case "init"     :   break;
                case "lookaround":  viewsFrom(currentPosition);
                                    break;
                case "lookclock":   endTime = System.currentTimeMillis();
                                    System.out.println("The hands on the clock say the time is " + timeCalc(startTime, endTime));
                                    break;
                case "takekey"  :   addKey(1); 
                                    System.out.println(addInventory("key to English Room"));      
                                    break;
                case "gobiology":currentPosition = 2;
                                    askAgain = false;
                                    break;

                default: System.out.println("That is not possible right now try something else!");
            }
        }while(askAgain);

        changeRoom(currentPosition);
    }

    public static void clockTower(){
        boolean askAgain = true;
        currentPosition = 1;
        System.out.println("You are at the clock tower in the middle of the campus");
        do{
            switch(commands()){
                case "init"     :   break;
                case "lookaround":  viewsFrom(currentPosition);
                                    break;
                case "lookclock":   endTime = System.currentTimeMillis();
                                    System.out.println("The hands on the clock say the time is " + timeCalc(startTime, endTime));
                                    break;
                case "takekey"  :   addKey(1); 
                                    System.out.println(addInventory("key to English Room"));      
                                    break;
                case "gobiology":currentPosition = 2;
                                    askAgain = false;
                                    break;

                default: System.out.println("That is not possible right now try something else!");
            }
        }while(askAgain);

        changeRoom(currentPosition);
    }

    public static void bioRoom(){
        boolean askAgain = true;
        currentPosition = 2;
        System.out.println("You stagger wearily to the biology room");
        System.out.println("Your head is throbbing");
        System.out.println("Upon reaching the biology room you notice that the door is locked and you hear a loud siren comming from inside");
        do{
            switch(commands()){
                case "init"     :   break;
                case "lookaround":  viewsFrom(currentPosition);
                                    break;
                case "lookclock":   endTime = System.currentTimeMillis();
                                    System.out.println("The hands on the clock say the time is " + timeCalc(startTime, endTime));
                                    break;
                case "unlockdoor"  : 
                                    System.out.println("you can't unlock the door.  You don't have a key for this door");      
                                    break;
                case "gotower":currentPosition = 1;
                                    askAgain = false;
                                    break;

                default: System.out.println("That is not possible right now try something else!");
            }
        }while(askAgain);

        changeRoom(currentPosition);
    }

    public static void englishRoom(){


    }

    public static void mathRoom(){


    }

    public static void adminRoom(){


    }
    
    public static void changeRoom(int position){
        switch (position){
            case 1 : start();
            case 2 : bioRoom();
            case 3 : englishRoom();
            case 4 : mathRoom();
            case 5 : adminRoom();
        }
    }

    public static String commands(){
        Scanner input = new Scanner(System.in);
        boolean askAgain = false;
        do{
            System.out.print("\n What do you want to do? -> ");
            command1 = input.next();
            command1 = command1.toLowerCase();
            switch (command1){
                case "take" : System.out.print("What?->");
                              command2 = input.next();
                              command2 = command2.toLowerCase();
                              return "take" + command2;
                case "look" : System.out.print("Where?->");
                              command2 = input.next();
                              command2 = command2.toLowerCase();
                              return "look" + command2;
                case "go"   : System.out.print("Where?->");
                              command2 = input.next();
                              command2 = command2.toLowerCase();
                              return "go" + command2; 
                case "drop" : System.out.print("What?->");
                              command2 = input.next();
                              command2 = command2.toLowerCase();
                              return "drop" + command2;  
                case "unlock" : System.out.print("What?->");
                              command2 = input.next();
                              command2 = command2.toLowerCase();
                              return "unlock" + command2; 
                case "help" : return "help";
                case "?"    : printCommands();
                              return "init";
                case "inventory": System.out.println(showInventory());
                                  return "init";
                case "quit": quitGame();
                              break;
                default: System.out.println("\n What you say homey? \n This isn't possible. \n Type (?) for all the possible commands");
                            askAgain = true;
            }
        }while(askAgain);
        return "end";
    }

    public static void printCommands(){
        System.out.println("\n*************");
        System.out.println("take -> to pick something up and put it into your inventory for future use.");
        System.out.println("look -> needs to be followed by a secondary command e.g(look tower, look door)");
        System.out.println("go -> walk to a particular location");
        System.out.println("drop ->  drop an item in your inventory");
        System.out.println("unlock -> tries to use one of your keys to unlock object");
        System.out.println("help -> get a hint...but not always");
        System.out.println("inventory -> lists everything in your inventory");
        System.out.println("quit -> stops game and saves progress");
        System.out.println("*************\n");
    }

    public static String timeCalc(long start, long end){

        //in milliseconds
        long diff = end - start;

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        String seconds = (diffSeconds<10) ? ("0" + diffSeconds) : ("" + diffSeconds);

        //start time for the story is 6:30am
        return ((diffHours + 6) + ":" + (diffMinutes + 30) + ":"+ seconds + " am");
    }

    public static String addInventory(String invent){

        inventory.add(invent);

        return ("Ok! "+ invent + " was added to your inventory");

    }

    public static String addKey(int key){
        keys.add(key);
        return "";
    }

    public static String showInventory(){
        String items="";
        if (inventory.size() == 0){
            System.out.println("You don't have anything in your inventory!");
        }else{
            for (int x = 0; x < inventory.size(); x++){
                String item = inventory.get(x);
                items = (x+1) + ". " + item + "\n";
            }
        }
        return items;
    }

    public static void stockItems(){
        String[] allItems = {"key1","key2","key3","key4","flashlight", "dryEraseMarker"};
        Random rndm = new Random(); // Ideally just create one instance globally
        // Note: use LinkedHashSet to maintain insertion order
        Set<Integer> generated = new LinkedHashSet<Integer>();
        while (generated.size() < allItems.length)
        {
            Integer next = rndm.nextInt(allItems.length);
            // As we're adding to a set, this will automatically do a containment check
            generated.add(next);
        }

            Iterator<Integer> setIterator = generated.iterator();
		        while(setIterator.hasNext()){
		        int index = setIterator.next();
		        System.out.println(allItems[index]);
        }
    }
    public static String quitGame(){
        Scanner input = new Scanner(System.in);
        boolean askAgain = false;
        do {
            System.out.print("Would you really like to quit (y/n) ? ");
            char yesNo = input.next().charAt(0);
            if(yesNo == 'y'){
                //try{
                    //call process for saving game here in the player class??
                    System.out.println("Thank you for playing.  We have saved your progress");
                    System.exit(0);//temporary
                //}
                //catch{ print error message

            // }
            }else if(yesNo == 'n'){
                System.out.println("Let's get you back in the game");
                return "";
            }else{
                System.out.println("I don't understand your response.  Please only type y for yes or n for no");
                askAgain = true;
            }
        }while(askAgain);
        return "";
    }

    public static void printLogo(){
        System.out.println("                               ...----....");
        System.out.println("                         ..-:\"''         ''\"-..");
        System.out.println("                      .-'                      '-.");
        System.out.println("                    .'              .     .       '.");
        System.out.println("                  .'   .          .    .      .    .''.");
        System.out.println("                .'  .    .       .   .   .     .   . ..:.");
        System.out.println("              .' .   . .  .       .   .   ..  .   . ....::.");
        System.out.println("             ..   .   .      .  .    .     .  ..  . ....:IA.");
        System.out.println("            .:  .   .    .    .  .  .    .. .  .. .. ....:IA.");
        System.out.println("           .: .   .   ..   .    .     . . .. . ... ....:.:VHA.");
        System.out.println("           '..  .  .. .   .       .  . .. . .. . .....:.::IHHB.");
        System.out.println("          .:. .  . .  . .   .  .  . . . ...:.:... .......:HIHMM.");
        System.out.println("         .:.... .   . .\"::\"'.. .   .  . .:.:.:II;,. .. ..:IHIMMA");
        System.out.println("         ':.:..  ..::IHHHHHI::. . .  ...:.::::.,,,. . ....VIMMHM");
        System.out.println("        .:::I. .AHHHHHHHHHHAI::. .:...,:IIHHHHHHMMMHHL:. . VMMMM");
        System.out.println("       .:.:V.:IVHHHHHHHMHMHHH::..:\" .:HIHHHHHHHHHHHHHMHHA. .VMMM.");
        System.out.println("       :..V.:IVHHHHHMMHHHHHHHB... . .:VPHHMHHHMMHHHHHHHHHAI.:VMMI");
        System.out.println("       ::V..:VIHHHHHHMMMHHHHHH. .   .I\":IIMHHMMHHHHHHHHHHHAPI:WMM");
        System.out.println("       ::\". .:.HHHHHHHHMMHHHHHI.  . .:..I:MHMMHHHHHHHHHMHV:':H:WM");
        System.out.println("       :: . :.::IIHHHHHHMMHHHHV  .ABA.:.:IMHMHMMMHMHHHHV:'. .IHWW");
        System.out.println("       '.  ..:..:.:IHHHHHMMHV\" .AVMHMA.:.'VHMMMMHHHHHV:' .  :IHWV");
        System.out.println("        :.  .:...:\".:.:TPP\"   .AVMMHMMA.:. \"VMMHHHP.:... .. :IVAI");
        System.out.println("       .:.   '... .:\"'   .   ..HMMMHMMMA::. .\"VHHI:::....  .:IHW'");
        System.out.println("       ...  .  . ..:IIPPIH: ..HMMMI.MMMV:I:.  .:ILLH:.. ...:I:IM");
        System.out.println("     : .   .'\"' .:.V\". .. .  :HMMM:IMMMI::I. ..:HHIIPPHI::'.P:HM.");
        System.out.println("     :.  .  .  .. ..:.. .    :AMMM IMMMM..:...:IV\":T::I::.\".:IHIMA");
        System.out.println("     'V:.. .. . .. .  .  .   'VMMV..VMMV :....:V:.:..:....::IHHHMH");
        System.out.println("       \"IHH:.II:.. .:. .  . . . \" :HB\"\" . . ..PI:.::.:::..:IHHMMV\"");
        System.out.println("        :IP\"\"HHII:.  .  .    . . .'V:. . . ..:IH:.:.::IHIHHMMMMM\"");
        System.out.println("        :V:. VIMA:I..  .     .  . .. . .  .:.I:I:..:IHHHHMMHHMMM");
        System.out.println("        :\"VI:.VWMA::. .:      .   .. .:. ..:.I::.:IVHHHMMMHMMMMI");
        System.out.println("        :.\"VIIHHMMA:.  .   .   .:  .:.. . .:.II:I:AMMMMMMHMMMMMI");
        System.out.println("        :..VIHIHMMMI...::.,:.,:!\"I:!\"I!\"I!\"V:AI:VAMMMMMMHMMMMMM'");
        System.out.println("        ':.:HIHIMHHA:\"!!\"I.:AXXXVVXXXXXXXA:.\"HPHIMMMMHHMHMMMMMV");
        System.out.println("          V:H:I:MA:W'I :AXXXIXII:IIIISSSSSSXXA.I.VMMMHMHMMMMMM");
        System.out.println("            'I::IVA ASSSSXSSSSBBSBMBSSSSSSBBMMMBS.VVMMHIMM'\"'");
        System.out.println("             I:: VPAIMSSSSSSSSSBSSSMMBSSSBBMMMMXXI:MMHIMMI");
        System.out.println("            .I::. \"H:XIIXBBMMMMMMMMMMMMMMMMMBXIXXMMPHIIMM'");
        System.out.println("            :::I.  ':XSSXXIIIIXSSBMBSSXXXIIIXXSMMAMI:.IMM");
        System.out.println("            :::I:.  .VSSSSSISISISSSBII:ISSSSBMMB:MI:..:MM");
        System.out.println("            ::.I:.  ':\"SSSSSSSISISSXIIXSSSSBMMB:AHI:..MMM.");
        System.out.println("            ::.I:. . ..:\"BBSSSSSSSSSSSSBBBMMMB:AHHI::.HMMI");
        System.out.println("            :..::.  . ..::\":BBBBBSSBBBMMMB:MMMMHHII::IHHMI");
        System.out.println("            ':.I:... ....:IHHHHHMMMMMMMMMMMMMMMHHIIIIHMMV\"");
        System.out.println("              \"V:. ..:...:.IHHHMMMMMMMMMMMMMMMMHHHMHHMHP'");
        System.out.println("               ':. .:::.:.::III::IHHHHMMMMMHMHMMHHHHM\"");
        System.out.println("                 \"::....::.:::..:..::IIIIIHHHHMMMHHMV\"");
        System.out.println("                   \"::.::.. .. .  ...:::IIHHMMMMHMV\"");
        System.out.println("                     \"V::... . .I::IHHMMV\"'");
        System.out.println("                       '\"VHVHHHAHHHHMMV:\"'");
    }



}


/*



*/