package outlaw;
import java.util.Scanner;
import Character.*;

public class main {
    
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //System.out.print("Please enter the Sheriff's name: ");
        //username = input.nextLine();
        
        Player user = new Player();
        //user.setName(username);
        //Parser parser = new Parser();
        //Vice vice = new Vice();
        Story storyline = new Story(user);
    }
    
}
