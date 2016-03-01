package Character;

import java.util.HashMap;

public class Vice {
    
    public boolean dead;
    public boolean done;
    public int talked;
    Parser parser = new Parser();
    private HashMap<String, String> instructions = new HashMap();
    private HashMap<String, String> answers = new HashMap();
    private String[] command;
    private String[] instruction;
    private String[] answer;
    
    
    public Vice() {
        this.dead = false;
        this.done = false;
        this.talked = 0;
        this.command = new String[]{
            "name", 
            "purpose", 
            "hometown", 
            "why_come",
            "last_night", 
            "check_gun", 
            "why_gun", 
            "bullets"};
        this.instruction = new String[]{
            "I should find a way to approach him, maybe I should ask “WHAT is his NAME”?", 
            "What is his purpose? WHAT is he DOING HERE?", 
            "I need to have more clues to find out who are the gangsters. Maybe I should ask WHERE his HOMETOWN is?", 
            "WHY does he MOVE to this town?", 
            "I wonder WHAT he was doing last NIGHT when the robbery happened?", 
            "I have to check that GUN, it might help me somehow.", 
            "The Sheriff looks down, he notices that Marvin is carrying a GUN. “Nice GUN.” – the Sheriff said, “I think you don’t need that here.”. WHY does he carry that GUN?",
            "Oh, it’s so strange, this gun is missing 1 BULLET, why ???"};
        this.answer = new String[]{
            "Marvin Catalon", 
            "Just sitting and having a drink.", 
            "My hometown is quite far from here, about 160km away from the north.", 
            "I'm on vacation.", 
            "I was wandering around the town, enjoyed the silent of the night. Suddenly, I saw somebody rushing, then I followed them.", 
            "Of course.",
            "I need it. It’s for my job.", 
            "I have used 1. That’s it."};
        
        for (int i = 0; i < this.command.length; i++) {
            instructions.put(this.command[i], this.instruction[i]);
            answers.put(this.command[i], this.answer[i]);
        }
        
    }
    
    public void startVice() {
        if ( this.talked != 0 ) {
            System.out.println("\nYou are back in the tarven. Let's continue asking him.\n");
        }
        
        while (!this.dead && !this.done) {
            if (this.talked == 0) {
                System.out.println("\nYou are in the TARVEN. It's very crowded. There is a man in your suspect list here.");
                System.out.println("You decide to talk with that man and ask him some questions in your question list.\n");
            }
            
            System.out.println(this.instruction[this.talked]);
            // Input and parse input
            String input = this.parser.getInput();
            String parsed = this.parser.parse(input);
            if ( parsed.equals("purpose_1") ) {
                parsed = "purpose";
            }
            if ( parsed.equals("last_night_1") ) {
                parsed = "last_night";
            }
                
            if (parsed.equals("leave")) {
                System.out.println("\nYou've left the tarven.");
                break;
            }
            if (parsed.equals("kill")) {
                this.dead = true;
                System.out.println("\nYou've killed " + this.answer[0] + " . He is a vice Sheriff.");
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
        
        while (!this.dead && this.done) {
            System.out.println("\nIt's time to decide whether to kill or not.");
            System.out.println("If you want to kill " + this.answer[0] +
                    ", please type `KILL`. If you want to keep him alive, just `LEAVE` the tarven.\n");
            String input = this.parser.getInput();
            String parsed = this.parser.parse(input);
            if ( parsed.equals("kill") ) {
                this.dead = true;
                System.out.println("\nYou've killed " + this.answer[0] + " . He is a vice Sheriff.");
            } else if ( parsed.equals("leave") ) {
                System.out.println("\nYou've left the tarven.");
                break;
            }
        }
    }
 
}

