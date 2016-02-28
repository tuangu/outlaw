package Character;

import java.util.HashMap;

public class Suzy {
    
    public boolean dead;
    public boolean done;
    public int talked;
    Parser parser = new Parser();
    private HashMap<String, String> instructions = new HashMap();
    private HashMap<String, String> answers = new HashMap();
    private String[] command;
    private String[] instruction;
    private String[] answer;
    
    
    public Suzy() {
        this.dead = false;
        this.done = false;
        this.talked = 0;
        this.command = new String[]{
            "name", 
            "purpose", 
            "hometown", 
            "why_come",
            "last_night", 
            "show_name",
            "why_gun",
            "check_gun" };
        this.instruction = new String[]{
            "name", 
            "purpose", 
            "hometown", 
            "why_come", 
            "last_night", 
            "show_name",
            "why_gun",
            "check_gun" };
        this.answer = new String[]{
            "Suzy Laffazet", 
            "I’m a businessman. I’m here to buy some stuff.", 
            "My hometown is about 30km away from the south.", 
            "As I mention above, I’m a businessman. I’m here to do my business. ", 
            "I was just stay at home and watch a TV show. ", 
            "I forgot the name because I fall asleep quite shortly after that. ",
            "I just bring it with me to protect myself.",
            "Sure." };
        
        for (int i = 0; i < this.command.length; i++) {
            instructions.put(this.command[i], this.instruction[i]);
            answers.put(this.command[i], this.answer[i]);
        }
        
    }
    
    public void startSuzy() {
        if ( this.talked != 0 ) {
            System.out.println("\nYou are back in the motel.");
            System.out.println("Suzy is waiting for you.\n");
        }
        
        while (!this.dead && !this.done) {
            if (this.talked == 0) {
                System.out.println("You come to a motel in town, where one of the suspect is staying");
                System.out.println("You knock on her room’s door and a women open the door. You start to question her.\n");
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
                System.out.println("You've left the motel.");
                break;
            }
            if (parsed.equals("kill")) {
                this.dead = true;
                System.out.println("You've killed " + this.answer[0] + " . She is an outlaw. Congrats!");
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
                    ", please type `KILL`. If you want to keep him alive, just `LEAVE` the motel.");
            String input = this.parser.getInput();
            String parsed = this.parser.parse(input);
            if ( parsed.equals("kill") ) {
                this.dead = true;
                System.out.println("You've killed " + this.answer[0] + " . She is an outlaw. Congrats!");
            } else if ( parsed.equals("leave") ) {
                System.out.println("You've left the motel.");
                break;
            }
        }
    }
 
}

