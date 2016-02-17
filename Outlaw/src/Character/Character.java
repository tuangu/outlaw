package Character;

import java.util.ArrayList;

public class Character {

    public boolean dead;
    public String location;
    public String name;
    public int questAnswered = 0;
    ArrayList<String> quests = new ArrayList<String>();
        
    public Character() {
    
    }
    
    /**
     * location, dead, questAnswered, 
     * setLocation, getLocation
     * setQuest, getQuest
     * 
     */
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getLocation() {
        return this.location;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void questAnswered() {
        this.questAnswered += 1;
    }
    
    public int getQuestAnswered() {
        return this.questAnswered;
    }
    
    public void setQuest(String quest) {
        this.quests.add(quest);
    }
    
    public String getQuest(int i) {
        return this.quests.get(i);
    }
}
