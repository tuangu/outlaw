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
            "As always, I need to know WHAT his NAME is.", 
            "I knew that he has just move here. However I have to ask HOW LONG he has been here, he might be put in my trap…", 
            "It will be more convenient to follow him if I know WHERE he is LIVING now?", 
            "I wonder WHAT she was doing last NIGHT when the robbery happened?", 
            "If he can provide some evidence of his innocence, I can eliminated him from the suspect list. Maybe there is someone to be his WITNESS ", 
            "Wait, his ARM, it’s bleeding, I can see it although he try to hide it. WHAT is wrong with his ARM?",
            "I have to check that GUN, it might help me somehow." };
        this.answer = new String[]{
            "Billy Ricot", 
            "I’m moved here about 2 months ago.", 
            "I still can’t rent a house so I’m living at the motel near the church.", 
            "I was at the church to pray.",
            "No, I was alone.",
            "I was injured when I clean my gun carelessly.", 
            "Of course you can. \nThe Sheriff thought: “This gun only has only 5 bullets, he said that he cleaned his gun but I’m not so sure about that. How could he be that careless.”" };
        
        for (int i = 0; i < this.command.length; i++) {
            instructions.put(this.command[i], this.instruction[i]);
            answers.put(this.command[i], this.answer[i]);
        }
        
    }
    
    public void startBilly() {
        if ( this.talked != 0 ) {
            System.out.println("\nYou are back in the market square. Let's continue asking him.\n");
        }
        
        if ( this.dead ) {
            System.out.println("You've killed Billy. He is an outlaw.");
            System.out.println("Let's go and check another place.");
        }
        
        while (!this.dead && !this.done) {
            if (this.talked == 0) {
                System.out.println("\nAfter a few days follow, you decide to talk with a man who is in the market square.\n");
                System.out.println("“Hello, can I ask you some questions about the robbery few days ago”");
                System.out.println("“How can I help you?” – He answer\n");
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
                System.out.println("\nYou've left the market square.");
                break;
            }
            if (parsed.equals("kill")) {
                this.dead = true;
                System.out.println("\nYou've killed " + this.answer[0] + " . He is an outlaw. Congrats!");
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
                    ", please type `KILL`. If you want to keep him alive, just `LEAVE` the market square.\n");
            String input = this.parser.getInput();
            String parsed = this.parser.parse(input);
            if ( parsed.equals("kill") ) {
                this.dead = true;
                System.out.println("\nYou've killed " + this.answer[0] + " . He is an outlaw. Congrats!");
            } else if ( parsed.equals("leave") ) {
                System.out.println("\nYou've left the market square.");
                break;
            }
        }
    }
 
}

