package Character;

import java.util.HashMap;

public class Dorin {
    
    public boolean dead;
    public boolean done;
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
        this.done = false;
        this.escaped = false;
        this.talked = 0;
        this.command = new String[]{
            "name", 
            "purpose", 
            "last_night", 
            "check_bag" };
        this.instruction = new String[]{
            "As always, I need to know WHAT her NAME is.", 
            "What is her purpose? WHAT is she DOING HERE? Let ask her.", 
            "“Did you hear about the ROBBERY occurred LAST NIGHT? I want to know WHAT you were DOING at 10 PM?” – I think.", 
            "I’m having only a few clues, this woman is carrying a huge bag, if she is a gangster and on her way of running….I must CHECK the BAG first.." };
        this.answer = new String[]{
            "Dorinda Clare", 
            "I’m here to visit my friend.", 
            "I was sleeping.", 
            "Yes. \nA gun’s in the bag. \nThe ship is about to run. Now, you must decide to kill or let him go. If he is an outlaw, you lose the game. Be careful." };
        
        for (int i = 0; i < this.command.length; i++) {
            instructions.put(this.command[i], this.instruction[i]);
            answers.put(this.command[i], this.answer[i]);
        }
        
    }
    
    public void startDorin() {
        
        while ( !this.dead && !this.escaped && !this.done ) {
            if (this.talked == 0) {
                System.out.println("\nThe Sheriff come to the harbour. A suspect is about to get on the boat. \n");
            }
            
            System.out.println(this.instruction[this.talked]);
            // Input and parse input
            String input = this.parser.getInput();
            String parsed = this.parser.parse(input);
            if ( parsed.equals("last_night_1") ) {
                parsed = "where_live";
            }
            if ( parsed.equals("purpose_1") ) {
                parsed = "purpose";
            }
                
            if (parsed.equals("leave")) {
                System.out.println("\nYou've left the the harbour.");
                System.out.println("Dorinda is now on the ship. She is an outlaw. She has escaped.\n");
                this.escaped = true;
                break;
            }
            if (parsed.equals("kill")) {
                this.dead = true;
                System.out.println("\nYou've killed " + this.answer[0] + " . She is an outlaw. Congrats!");
                break;
            }
            if (parsed.equals(this.command[this.talked])) {
                System.out.print("a: ");
                System.out.println(this.answer[this.talked] + "\n");
                this.talked += 1;
            }
            if (this.talked == this.command.length) {
                this.done = true;
            }
        }
        
        while (this.done && !this.dead && !this.escaped ) {
            System.out.println("\nIt's time to decide whether to kill or not.");
            System.out.println("If you want to kill " + this.answer[0] +
                    ", please type `KILL`. If you want to keep her alive, just `LEAVE` the harbour.\n");
            String input = this.parser.getInput();
            String parsed = this.parser.parse(input);
            if ( parsed.equals("kill") ) {
                this.dead = true;
                System.out.println("\nYou've killed " + this.answer[0] + " . She is an outlaw. Congrats!");
            } else if ( parsed.equals("leave") ) {
                System.out.println("\nYou've left the the harbour.");
                System.out.println("Dorinda is now on the ship. She is an outlaw. She has escaped.\n");
                this.escaped = true;
                break;
            }
        }
        
    }
 
}

