package outlaw;

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class Map {

    private int[][] map = {{1, 0, 2, 0, 3}, {0, 0, 0, 0, 0}, {4, 0, 5, 0, 6}, {0, 0, 0, 0, 0}, {7, 0, 8, 0, 9}};
    private Scanner scan = new Scanner(System.in);
    private HashMap<Integer, String> location = new HashMap();
    private int[] playerLocation = new int[2];

    public Map() {
        playerLocation[0] = 4;
        playerLocation[1] = 1;
        setLocation();
    }

    private void setLocation() {
        location.put(1, "Grocery Store");
        location.put(2, "The Tavern");
        location.put(3, "The Church");
        location.put(4, "Motel");
        location.put(5, "Market Square");
        location.put(6, "Private Residence");
        location.put(7, "The abandoned old well");
        location.put(8, "Private Residence");
        location.put(9, "South Habour");
    }

    private String getLocation(int x, int y) {
        int n = 0;
        if (x == 0) {
            if (y == 0) {
                n = 1;
            } else if (y == 2) {
                n = 4;
            } else if (y == 4) {
                n = 7;
            } else {
                n = 0;
            }
        } else if (x == 2) {
            if (y == 0) {
                n = 2;
            } else if (y == 2) {
                n = 5;
            } else if (y == 4) {
                n = 8;
            } else {
                n = 0;
            }
        } else if (x == 4) {
            if (y == 0) {
                n = 3;
            } else if (y == 2) {
                n = 6;
            } else if (y == 4) {
                n = 9;
            } else {
                n = 0;
            }
        }

        if (n == 0) {
            return "street";
        } else {
            return location.get(n);
        }
    }

    private boolean verifyRoute(int x, int y, String route) {
        // x = playerLocation[0], y = playerLocation[1], route = left||right||up||down
        boolean is = true;
        switch (route) {
            case "left":
                if (x == 0) {
                    is = false;
                }
                break;
            case "right":
                if (x == 4) {
                    is = false;
                }
                break;
            case "up":
                if (y == 0) {
                    is = false;
                }
                break;
            case "down":
                if (y == 4) {
                    is = false;
                }
                break;
            default:
                is = true;
        }
        return is;
    }

    public String mapMenu() {
        String where;
        boolean endWhile = false;

        while (!endWhile) {
            System.out.println("\nWhich direction would you like to go? (Up, Down, Left, Right)");
            System.out.print("- ");
            String input = scan.nextLine();
            input = input.toLowerCase();

            switch (input) {
                case "left":
                    if (verifyRoute(playerLocation[0], playerLocation[1], "left")) {
                        playerLocation[0] -= 1;
                        endWhile = true;
                    } else {
                        System.out.println("\nYou cannot move left!");
                        System.out.println("Please re-enter your choice.");
                    }
                    break;
                case "right":
                    if (verifyRoute(playerLocation[0], playerLocation[1], "right")) {
                        playerLocation[0] += 1;
                        endWhile = true;
                    } else {
                        System.out.println("\nYou cannot move right!");
                        System.out.println("Please re-enter your choice.");
                    }
                    break;
                case "up":
                    if (verifyRoute(playerLocation[0], playerLocation[1], "up")) {
                        playerLocation[1] -= 1;
                        endWhile = true;
                    } else {
                        System.out.println("\nYou cannot move up!");
                        System.out.println("Please re-enter your choice.");
                    }
                    break;
                case "down":
                    if (verifyRoute(playerLocation[0], playerLocation[1], "down")) {
                        playerLocation[1] += 1;
                        endWhile = true;
                    } else {
                        System.out.println("\nYou cannot move down!");
                        System.out.println("Please re-enter your choice.");
                    }
                    break;
                default:
                    System.out.println("\nInvalid direction!!! \nPlease re-enter your choice.");
            }
        }

        where = getLocation(playerLocation[0], playerLocation[1]);

        return where;
    }

}
