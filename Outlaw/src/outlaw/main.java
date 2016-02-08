package outlaw;
import java.util.Scanner;

public class main {
    
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username;
        
        System.out.print("Please enter the Sheriff's name: ");
        username = input.nextLine();
        
        Player user = new Player();
        user.setName(username);
        user.printAllStats(user);
        Map map1 = new Map();
    }
    
}
