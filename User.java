/**************************************************
 *
 *  File Name:	
 *  Author: 	Yoshiko Imura
 *  Date:			
 *  Problem:		
 *	Pre:		
 *	Post:		
 *
 *
 **************************************************/
 		 //System.out.println("Template");

          import java.util.Scanner;
          import java.io.FileInputStream;
          import java.io.FileNotFoundException;
          
          public class User2
          {
              private static final int MAX_PLAYERS = 5;		// maximum # of players 
              private static final int NUMBER_OF_STRINGS = 2;	// ID and password
              private static final int NUMBER_OF_DATA = 7;	// identifire, location, 5 keys
              private static final int MAX_KEYS = 5;			// # of keys to collect
              private static final int MAX_ITEMS = 8;
              
              
         //// 	private TestData1[] wholeData1;
              private String userID;
              private String userPassword;
              private String userName;			// use userID
              private int userLocation;
             private int[] userKeys = new int[MAX_KEYS];
             private int numberOfLives;
             
             private int[] userItems;					// items in array
             
             private int foundMiniGame;
             private int wonMiniGame;
             private int totalScore;
             private int totalTime;
             private int bestScore;
             private int bestTime;
             private int numberPlayed;
             private int numberWon;
             
             private int playerLastIndex = 0;
             
              
              public User2()
              {
                  this.userID = null;
                  this.userPassword = null;
                  this.userName = null;
                  this.userLocation = 0;
                  for (int index = 0; index < MAX_KEYS; index++ )
                  {
                     this.userKeys[index] = 0;
                 }
                 
                 /**		The following variables will be added later.
                 this.numberOfLives = 0;
                 for (int index = 0; index < MAX_ITEMS; index++)
                 {
                     this.userItems[index] = 0;
                 }
                 this.foundMiniGame = 0;
                 this.wonMiniGame = 0;
                 this.totalScore = 0;
                 this.totalTime = 0;
                 this.bestScore = 0;
                 this.bestTime = 0;
                 this.numberPlayed = 0;
                 this.numberWon = 0;
                 */
              }
              
             
              public int checkLogin(String loginID, String loginPassword)
              {
                  return 1;	// check ID and password in Data
                              // return player's number (0-9) when the login was successful
              }
              
              
              public int accountIDCheck (String loginID)
              {
                  // when max player number has reached, return -2
                  // when the loginID has been already taken, return -1
                  // otherwise, return the new playerNumber (playerIndex)
                  return 4;
              }
              
         
              public int createAccount(String loginID, String loginPassword)
              {
                 // create a new account using loginID and loginPassword
                 // reset all his data to default
                 // return his new account index
                 return 8;
             }
              
              
              
          /**	
              public int checkNextIDExists(String accountID)
              {
                  return -1;	// -1... maximum number of players has been reached, 1-10
                              // 0... the ID was taken
              }
         */ 	
         
         
         /**
              
              public void setData (int playerNumber)
              {
                  int index;
                  index = playerNumber;
                  
                  // set account data using playerNumber (index) to play
                  
                  System.out.println ("player's number is " + index);
                  System.out.println ("Account Data has been set." + "\n");
              }
          */
              
              
              public void outputFileData (int playerNumber)
              {
         
                  // save account data on text file to exit this game
                  
                  System.out.println ("player's number is " + playerNumber);
                  System.out.println ("Account Data has been saved." + "\n");
              }
              
              public void printData ()
              {
                  System.out.println (userID + " " + userPassword + " " + userName + "  location= " + userLocation + "  Keys= " + userKeys[0] + " " + userKeys[1] + " " + userKeys[2] + " " + userKeys[3] + " " + userKeys[4]);
          //		System.out.println ("Lives left= " + numberOfLives + "Mini Game found= " + foundMiniGame + "Mini Game won= " + wonMiniGame );
          //		System.out.println ("Total Score= " + totalScore + "Total Time= " + totalTime + "Best Score= " + bestScore + "Best Time= " + bestTime + " # of Plays= " + numberPlayed + "# of Wins= " + numberWon);
              }
              
         
         
         
         
         
              
              //------------------------------------------------------------------------
              
          
              //private void setUserID(String userID)
              public void setUserID(String userID)			// THIS METHOD SHOULD BE PRIVATE. changed to public to be called from UserDriver.java
              {
                  this.userID = userID;
              }
              
              //private void setUserPassword(String userPassword)
              public void setUserPassword(String userPassword)	// THIS METHOD SHOULD BE PRIVATE. changed to public to be called from UserDriver.java
              {
                  this.userPassword = userPassword;
              }
         
              //private void setUserName(String userID)
              public void setUserName(String userName)			// THIS METHOD SHOULD BE PRIVATE. changed to public to be called from UserDriver.java
              {
                  this.userName = userName;
              }
         
              public void setUserLocation(int userLocation)
              {
                  this.userLocation = userLocation;
              }
         
              public void setKeys(int keyNumber)
              {
                  switch(keyNumber)
                  {
                      default:
                      System.out.println ("Wrong key number");
                      break;
                      
                      case 1:
                      userKeys[0] = 1;
                      break;
                      
                      case 2:
                      userKeys[1] = 1;
                      break;
                      
                      case 3:
                      userKeys[2] = 1;
                      break;
                      
                      case 4:
                      userKeys[3] = 1;
                      break;
                      
                      case 5:
                      userKeys[4] = 1;
                      break;
                  }
              }
         
              public void setItems()
              {
              }
         
              public void setNumberLives(int lives)
              {
                  this.numberOfLives = lives;
              }
         
              public void setFoundMiniGame(int foundMiniGame)
              {
                  this.foundMiniGame = 1;
              }
         
              public void setWonMiniGame(int wonMiniGame)
              {
                  this.wonMiniGame = 1;
              }
         
              public void setTotalScore(int totalScore)
              {
                  this.totalScore = totalScore;
              }
         
              public void setTotalTime(int totalTime)
              {
                  this.totalTime = totalTime;
              }
         
              public void setBestScore(int bestScore)
              {
                  this.bestScore = bestScore;
              }
         
              public void setBestTime(int bestTime)
              {
                  this.bestTime = bestTime;
              }
         
              public void setNumberPlayed(int numberPlayed)
              {
                  this.numberPlayed = numberPlayed;
              }
         
              public void setNumberWon(int numberWon)
              {
                  this.numberWon = numberWon;
              }
              
              
              //---------------------------------------------------------
         
         
              public String getUserID()
              {
                  return userID;
              }
              
              public String getUserPassword()
              {
                  return userPassword;
              }
         
              public String getUserName()
              {
                  return userName;
              }
         
              public int getUserLocation()
              {
                  return userLocation;
              }
         
              public int[] getKeys()
              {
                  return userKeys;
              }
         
              public int[] getItems()
              {
                  return userItems;
              }
         
              public int getNumberLives()
              {
                  return numberOfLives;
              }
         
              public int getFoundMiniGame()
              {
                  return foundMiniGame;
              }
         
              public int getWonMiniGame()
              {
                  return wonMiniGame;
              }
         
              public int getTotalScore()
              {
                  return totalScore;
              }
         
              public int getTotalTime()
              {
                  return totalTime;
              }
         
              public int getBestScore()
              {
                  return bestScore;
              }
         
              public int getBestTime()
              {
                  return bestTime;
              }
         
              public int getNumberPlayed()
              {
                  return numberPlayed;
              }
         
              public int getNumberWon()
              {
                  return numberWon;
              }
         
         
         //-------------------------------------------------------------------
         
             public void resetItems()			// when player leaves the room
             {
                 int index;
                 for (index = 0; index < MAX_ITEMS; index ++)
                 {
                     userItems [index] = 0;
                 }
             }
             
             
             public void resetGameData()			// when player completed the game
             {
             }
             
             
             public void initialData()			// when user creates an account
             {
             }
             
             
         
         
                  
          /**
                  
                  TestData[] wholeData = new TestData[MAX_PLAYERS];
                 for (index = 0; index < MAX_PLAYERS; index ++)
                     wholeData[index] = new TestData();
                     
                  for (int index1 = 0; index1 < maxPlayers; index1 ++)
                  {
         
                      wholeData1[index1].playerID = fileIn.next();
                      wholeData1[index1].playerPassword = fileIn.next();
                      wholeData1[index1].location = fileIn.nextInt();
                      for (int index2 = 0; index2 < maxKeys; index2 ++)
                      {
          //				wholeData1[index1].key[index2] = fileIn.nextboolean();
                          wholeData1[index1].key[index2] = fileIn.nextInt();
                      }
          //			fileIn.nextLine();
                  }
                  
                  for (int index = 0; index < maxPlayers; index++)
                  {
                      System.out.println ("Player " + index+1);
                      System.out.println ("wholeData1[index].ID = " + playerID);
                       System.out.println ("wholeData1[index].Password = " + playerPassword);
                      System.out.println ("wholeData1[index].his location = Room #" + location);
                      System.out.println ("wholeData1[index].his keys = " + key[0] + " " + key[1] + " " + key[2] + " " + key[3] + " " + key[4] );
                  }
                  
                  */
                  
          
              
              
          
         }