package outlaw;

import Character.Vice;
import Character.Suzy;
import Character.Billy;
import Character.Dorin;
import java.util.HashMap;

public class Story {
    
    private boolean dead;
    private boolean done;
    private int killed;
    HashMap<String, String> mapOutlaw = new HashMap();
    //Parser parser = new Parser();
    
    //Vice vice = new Vice();
    
    public Story(Player user) {
        this.killed = 0;
        this.dead = false;
        this.done = false;
        
        Map map = new Map();
        Vice vice = new Vice();
        Suzy suzy = new Suzy();
        Billy billy = new Billy();
        Dorin dorin = new Dorin();
        mapOutlaw();
        
        System.out.println("West End, in a small peaceful and wealthy town, there is a brace Sheriff whose name is " + user.getName() + ".");
        System.out.println("\nOne night, a robbery happened in the mansion of Kalle Blome, the richest man in the town. "
                + "\nA robber attack Mr. Blome by gun but he hasn’t died. "
                + "\nAccording to the Blomes, there were 3 of them and they take all the cash and some jewelry in the mansion. "
                + "\nThe mission of the Sheriff begins, he must find out that 3 gangsters and kill them to make sure his people still live in peace.   \n" 
                + "\nHe begins to inspect the 4 people who move to the town recently. "
                + "\nHe didn’t know that in 1 of 4 people, there is a vice Sheriff from another town. "
                + "\nThe vice is tracking the Gangster Band and he also want to kill them. "
                + "\nHowever, for his safety, he has to hide his role.");
        Delay(1000);
//        System.out.println("\nFirstly, the Sheriff thinks about what he will ask that 4 guy to make them reveal themselves. "
//                + "\nHe started to make a list of questions. He will ask each of them 8 questions as follow:");
//        Delay(2000);
//        Question();
//        Delay(2000);
        System.out.println("\nYou will play as the Sheriff. "
                + "\nYour role is to walk around the town, find out 3 outlaws."
                + "\nLet start! ");
        
        while( !this.dead && !this.done ) {
            String location = map.mapMenu();
            Conversation(location, vice, suzy, billy, dorin);
        }
        
        if ( this.dead ) {
            System.out.println("You lose.");
        }
        
        if ( this.done ) {
            System.out.println("You win.");
        }
        
    }
    
    public void Conversation(String location, Vice vice, Suzy suzy, Billy billy, Dorin dorin) {
        boolean leave = false;
        String character = mapOutlaw.get(location);
        
        while(!leave) {
            if ( character != null && character.equals("Vice") ) {
               vice.startVice();
               if ( vice.dead ) {
                   this.dead = true;
               }
               leave = true;
            } else if ( character != null && character.equals("Suzy") ) {
                suzy.startSuzy();
                if ( suzy.dead ) {
                    this.killed += 1;
                }
                leave = true;
            } else if ( character != null && character.equals("Billy") ) {
                billy.startBilly();
                if ( billy.dead ) {
                    this.killed += 1;
                }
                leave = true;
            } else if ( character != null && character.equals("Dorin") ) {
                dorin.startDorin();
                if ( dorin.dead ) {
                    this.killed += 1;
                }
                if ( dorin.escaped ) {
                    this.dead = true;
                }
                leave = true;
            } else {
                System.out.println("There isn't any outlaw in " + location);
                leave = true;
            } 
        }
        
        if ( this.killed == 3 ) {
            this.done = true;
        }
    }
    
    private void mapOutlaw(){
        mapOutlaw.put("The Tavern", "Vice");
        mapOutlaw.put("Motel", "Suzy");
        mapOutlaw.put("Market Square", "Billy");
        mapOutlaw.put("South Habour", "Dorin");
    }
    
    private void Question() {
        System.out.println("\n1. What’s your name?");
        System.out.println("\n2. What are you doing here?");
        Delay(1000);
        System.out.println("\n3.  Is this place your hometown? "
                + "\nHe pretend that he doesn’t know that guy is from another town so that if they lie, they will reveal themselves");
        System.out.println("\n4. Why do you come to this town?");
        Delay(1000);
        System.out.println("\n5. What were you doing at that time when the robbery happened?");
        System.out.println("\n6. Is there anybody who witness it?");
        Delay(1000);
        System.out.println("\n7. What do you carry that gun for? In case the suspect has a gun.");
        System.out.println("\n8. Can I check the gun?");
    }
    
    private void Delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            System.out.print(ex);
        }
    }
    
}
