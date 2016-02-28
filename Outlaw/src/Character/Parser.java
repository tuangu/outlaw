package Character;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    private final Scanner reader = new Scanner(System.in);
    private String input;
    private String[] commands;
    ArrayList key = new ArrayList();
    
    public Parser() {
        this.commands = new String[]{
            "name", 
            "purpose", 
            "purpose_1", 
            "hometown", 
            "why_come", 
            "why_gun", 
            "bullets", 
            "last_night", 
            "robbery",
            "last_night_1", 
            "show_name", 
            "check_gun", 
            "day_stayed", 
            "where_live", 
            "where_live_1", 
            "witness", 
            "arm", 
            "examine_arm", 
            "leave", 
            "kill",
            "check_bag" };
        
        String[] name = {"what", "name"};
        key.add(name);
        String[] purpose = {"what", "doing", "here"};
        key.add(purpose);
        String[] purpose_1 = {"what", "do", "here"};
        key.add(purpose_1);
        String[] hometown = {"home", "town"};
        key.add(hometown);
        String[] why_come = {"why", "come"};
        key.add(why_come);
        String[] why_gun = {"why", "gun"};
        key.add(why_gun);
        String[] bullets = {"bullet"};
        key.add(bullets);
        String[] last_night = {"what", "night"};
        key.add(last_night);
        String[] robbery = {"robbery"};
        key.add(robbery);
        String[] last_night_1 = {"what", "time"};
        key.add(last_night_1);
        String[] show_name = {"what", "name", "show"};
        key.add(show_name);
        String[] check_gun = {"gun"};
        key.add(check_gun);
        String[] day_stayed = {"how", "long"};
        key.add(day_stayed);
        String[] where_live = {"where", "living"};
        key.add(where_live);
        String[] where_live_1 = {"where", "live"};
        key.add(where_live_1);
        String[] witness = {"witness"};
        key.add(witness);
        String[] arm = {"arm"};
        key.add(arm);
        String[] examine_arm = {"examine", "arm"};
        key.add(examine_arm);
        String[] leave = {"leave"};
        key.add(leave);
        String[] kill = {"kill"};
        key.add(kill);
        String[] check_bag = {"bag"};
        key.add(check_bag);
    }
    
    public String parse(String input) {
        String command = "Something went wrong. Try another input.";
        input = input.toLowerCase();
        
        for (int i = 0; i < key.size(); i++) {
            if (parseInput(input, (String[]) key.get(i))) {
                command = this.commands[i];
                break;
            }
        }
        
        return command;
    }
    
    private boolean parseInput(String input, String[] key) {
        boolean contained = false;
        int j = 0;
        
        for(int i = 0; i < key.length; i++) {
            if (input.contains(key[i])) {
                j++;
            }
        }
        
        if (j == key.length) {
            contained = true;
        }
        
        return contained;
    }
    
    public String getInput() {
        String getInput;
        System.out.print("- ");
        getInput = reader.nextLine();
        
        return getInput;
    }
}
