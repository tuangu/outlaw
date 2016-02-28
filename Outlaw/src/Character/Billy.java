package Character;

import java.util.HashMap;

public class Billy {
    
    public boolean dead;
    public boolean done;
    public int talked;
    Parser parser = new Parser();
    private HashMap<String, String> instructions = new HashMap();
    private HashMap<String, String> answers = new HashMap();
    private String[] command;
    private String[] instruction;
    private String[] answer;
    
    
    public Billy() {
        this.dead = false;
        this.done = false;
        this.talked = 0;
        this.command = new String[]{
            "name", 
            "day_stayed", 
            "where_live", 
            "last_night", 
            "witness", 
            "arm", 
            "check_gun" };
        this.instruction = new String[]{
            "name", 
            "day_stayed", 
            "where_live - where_live_1", 
            "last_night - last_night_1", 
            "witness", 
            "arm - examine_arm",
            "check_gun" };
        this.answer = new String[]{
            "Billy Ricot", 
            "I’m moved here about 2 months ago.", 
            "I still can’t rent a house so I’m living at the motel near the church.", 
            "I was at the church to pray.",
            "No, I was alone.",
            "I was injured when I clean my gun carelessly.", 
            "Of course you can." };
        
        for (int i = 0; i < this.command.length; i++) {
            instructions.put(this.command[i], this.instruction[i]);
            answers.put(this.command[i], this.answer[i]);
        }
        
    }
    
    public void startBilly() {
        if ( this.talked != 0 ) {
            System.out.println("\nYou are back in the market square.\n");
        }
        
        while (!this.dead && !this.done) {
            if (this.talked == 0) {
                System.out.println("After a few days follow, you decide to talk with a man who is in the market square.\n");
            }
            
            System.out.println(this.instruction[this.talked]);
            // Input and parse input
            String input = this.parser.getInput();
            String parsed = this.parser.parse(input);
            if ( parsed.equals("where_live_1") ) {
                parsed = "where_live";
            }
            if ( parsed.equals("examine_arm") ) {
                parsed = "arm";
            }
            if ( parsed.equals("last_night_1") ) {
                parsed = "last_night";
            }
                
            if (parsed.equals("leave")) {
                System.out.println("You've left the market square.");
                break;
            }
            if (parsed.equals("kill")) {
                this.dead = true;
                System.out.println("You've killed " + this.answer[0] + " . He is an outlaw. Congrats!");
                break;
            }
            if (parsed.equals(this.command[this.talked])) {
                System.out.println(this.answer[this.talked] + "\n");
                this.talked += 1;
            }
            
            if (this.talked == this.command.length) {
                this.done = true;
            }
        }
        
        while (!this.dead && this.done) {
            System.out.println("It's time to decide whether to kill or not.");
            System.out.println("If you want to kill " + this.answer[0] +
                    ", please type `KILL`. If you want to keep him alive, just `LEAVE` the tarven.");
            String input = this.parser.getInput();
            String parsed = this.parser.parse(input);
            if ( parsed.equals("kill") ) {
                this.dead = true;
                System.out.println("You've killed " + this.answer[0] + " . He is an outlaw. Congrats!");
            } else if ( parsed.equals("leave") ) {
                System.out.println("You've left the market square.");
                break;
            }
        }
    }
 
}

