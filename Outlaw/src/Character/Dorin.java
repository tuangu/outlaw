package Character;

import java.util.HashMap;

public class Dorin {
    
    public boolean dead;
    public boolean escaped;
    public int talked;
    Parser parser = new Parser();
    private HashMap<String, String> instructions = new HashMap();
    private HashMap<String, String> answers = new HashMap();
    private String[] command;
    private String[] instruction;
    private String[] answer;
    
    
    public Dorin() {
        this.dead = false;
        this.escaped = false;
        this.talked = 0;
        this.command = new String[]{
            "name", 
            "why_come", 
            "last_night", 
            "check_bag" };
        this.instruction = new String[]{
            "name", 
            "why_come", 
            "last_night - last_night_1", 
            "check_bag" };
        this.answer = new String[]{
            "Dorinda Clare", 
            "I’m here to visit my friend.", 
            "I was sleeping.", 
            "Yes" };
        
        for (int i = 0; i < this.command.length; i++) {
            instructions.put(this.command[i], this.instruction[i]);
            answers.put(this.command[i], this.answer[i]);
        }
        
    }
    
    public void startDorin() {
        if ( this.talked != 0 ) {
            
        }
        
        while ( !this.dead && !this.escaped ) {
            if (this.talked == 0) {
                System.out.println("The Sheriff come to the harbour. A suspect is about to get on the boat. \n");
            }
            
            System.out.println(this.instruction[this.talked]);
            // Input and parse input
            String input = this.parser.getInput();
            String parsed = this.parser.parse(input);
            if ( parsed.equals("last_night_1") ) {
                parsed = "where_live";
            }
                
            if (parsed.equals("leave")) {
                System.out.println("\nYou've left the the harbour.");
                System.out.println("Dorinda is now on the ship. He is an outlaw. He has escaped.\n");
                this.escaped = true;
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
        }
        
    }
 
}

