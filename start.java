package dsassxj;

import java.util.*;

public class start {
    
    public static Map goMap = new Map();
    public static String currentLocation = "Town Hall";   //initialize day 1 location
    public static int dayNum = 1;  //initialize day 1
    public static String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static Stack<String> history = new Stack<>();
    public static Stack<String> forward = new Stack<>();
    public static Scanner sc = new Scanner(System.in);
    
    //method to choose the map (path) for the game
    public static void startGame(){
        
        System.out.println("Welcome, to the fantastical realm of JOJOLands.");
        System.out.println("[1] Start Game");
        System.out.println("[2] Load Game");
        System.out.println("[3] Exit\n");
        
        int start = input();
        System.out.println("======================================================================");
        
        switch(start){
            case 1 -> {
                System.out.println("Select a map: ");
                System.out.println("[1] Default Map");
                System.out.println("[2] Parallel Map");
                System.out.println("[3] Alternate Map\n");
                System.out.print("Select: ");
                int num = sc.nextInt();
                System.out.println("======================================================================");
                goMap.chooseMap(num);
                System.out.printf("It's Day %d (%s) of our journey in JOJOLands!\n", dayNum, DAYS_OF_WEEK[dayNum - 1]);
                mission();
            }
                
            case 2 -> {
                System.out.print("Enter the path of your save file: ");
                String savedPath = sc.nextLine();
                System.out.println("======================================================================");
                //jump to load method
            }
                
            case 3 -> end();
                
            default -> {
                System.out.println("Invalid input. Please choose again.");
                input();
            }
        }
    }
    
    //method to request input from the user to choose the flow of the game
    public static int input(){
        System.out.print("Select: ");
        int input = sc.nextInt();
        return input;
    }
    
    //method for mission in each location
    public static void mission(){
        while(true){
            System.out.println("Current Location: " + currentLocation);
            switch(currentLocation){
                case "Town Hall":
                    System.out.println("[1] Move to: ");
                    choices();
                    System.out.println("[2] Advance to Next Day");
                    System.out.println("[3] Save Game");
                    System.out.println("[4] Exit\n");
                    switch(input()){
                        case 1:                            
                            move();
                            break;
                        case 2:
                            advance();
                            break;
                        case 3: 
                            saveGame();
                            break;
                        case 4:
                            end();
                            break;
                        default:
                            break;
                    }
                    break;

                case "Morioh Grand Hotel":
                    System.out.println("[1] Move to: ");
                    choices();
                    System.out.println("[2] View Resident Information");
                    System.out.println("[3] The Hand");
                    System.out.println("[4] Back (" + history.peek() + ")"); 
                    System.out.println("[5] Back to Town Hall\n");
                    switch(input()){
                        case 1:
                            move();
                            break;
                        case 2:
                            //jump to Heaven's Door (basic feature 2)
                            break;
                        case 3: 
                            //jump to Super Fly (basic feature 7);
                            break;
                        case 4:
                            backtrack();
                            break;
                        case 5:
                            TownHall();
                            break;
                        default:
                            break;
                    }
                    break;
                
                case "Trattoria Trussardi", "Jade Garden", "Cafe Deux Magots", "Libeccio", "Savage Garden":
                    System.out.println("[1] Move to: ");
                    choices();
                    System.out.println("[2] View Waiting List and Order Processing List");
                    System.out.println("[3] View Menu");
                    System.out.println("[4] View Sales Information");
                    System.out.println("[5] Milagro Man");
                    System.out.println("[6] Back (" + history.peek() + ")");   
                    System.out.println("[7] Back to Town Hall\n");
                    
                    // Create an instance of the PearlJam class with the selected restaurant name
                    PearlJam pearlJam = new PearlJam(currentLocation);
                    
                    switch(input()){
                        case 1:
                            move();
                            break;
                        case 2:
                            //jump to Pearl Jam (basic feature 3)
                            Customer[] customers = new Customer[6];
                            customers[0] = new Customer(1, "Jonathan Joestar", 20, "Male", 10, currentLocation, "Braised Chicken in Black Bean Sauce");
                            customers[1] = new Customer(2, "Joseph Joestar", 18, "Male", 15, currentLocation, "Scrambled Egg White with Milk");
                            customers[2] = new Customer(3, "Jotaro Kujo", 17, "Male", 12, currentLocation, "Braised Goose Web with Vermicelli");
                            customers[3] = new Customer(4, "Josuke Higashikata", 16, "Male", 18, currentLocation, "Poached Tofu with Dried Shrimps");
                            customers[4] = new Customer(5, "Giorno Giovanna", 15, "Male", 18, currentLocation, "Deep-fried Hiroshima Oysters");
                            customers[5] = new Customer(6, "Jolyne Cujoh", 19, "Female", 18, currentLocation, "Braised Goose Web with Vermicelli");
                            System.out.println("======================================================================");
                            pearlJam.serveCustomers(customers);
                            pearlJam.addToWaitingList(customers);
                            pearlJam.sortWaitingList();
                            pearlJam.setProcessOrders();
                            pearlJam.displayWaitingList();
                            pearlJam.displayOrderProcessingList();
                            break;
                        case 3: 
                            //jump to Pearl Jam (basic feature 3)
                            System.out.println("======================================================================");
                            pearlJam.displayMenu(currentLocation);
                            break;
                        case 4:
                            //jump to Moody Blue (basic feature 5)
                            break;
                        case 5:
                            //jump to Milagro Man (basic feature 6)
                            break;
                        case 6:
                            backtrack();
                            break;
                        case 7:
                            TownHall();
                            break;
                        default:
                            break;
                    }
                    break;
                    
                case "Polnareff Land":
                    System.out.println("[1] Move to: ");
                    choices();
                    System.out.println("[2] View Resident Information");
                    System.out.println("[3] Back (" + history.peek() + ")");  
                    System.out.println("[4] Back to Town Hall\n");
                    switch(input()){
                        case 1:
                            move();
                            break;
                        case 2:
                            //jump to Heaven's Door (basic feature 2)
                            break;
                        case 3:
                            backtrack();
                            break;
                        case 4:
                            TownHall();
                            break;
                        default:
                            break;
                    }
                    break;
                    
                case "Joestar Mansion":
                    System.out.println("[1] Move to: ");
                    choices();
                    System.out.println("[2] View Resident Information");
                    System.out.println("[3] Back (" + history.peek() + ")");  
                    System.out.println("[4] Back to Town Hall\n");
                    switch(input()){
                        case 1:
                            move();
                            break;
                        case 2:
                            //jump to basic feature 4
                            break;
                        case 3:
                            backtrack();
                            break;
                        case 4:
                            TownHall();
                            break;
                        default:
                            break;
                    }
                    break;
                    
                default:
                    System.out.println("Sorry, no mission available at " + currentLocation);
                    System.out.println("[1] Move");
                    System.out.println("[2] Back (" + history.peek() + ")");
                    System.out.println("[3] Back to Town Hall\n");
                    switch(input()){
                        case 1:
                            move();
                            break;
                        case 2:
                            backtrack();
                            break;
                        case 3:
                            TownHall();
                            break;
                    }
                    System.out.println("======================================================================");
                    break;
            }
        }
    }
    
    //display the neighbour vertex
    public static void choices(){
        goMap.choices();
    }
    
    //method move to adjacent location
    public static void move(){
        goMap.move();
    }
    
    //method to backtrack
    public static void backtrack(){
        String goback = history.peek();
        forward.add(currentLocation);
        history.add(currentLocation);
        currentLocation = goback;
    }
    
    //method to go back to Town Hall
    public static void TownHall(){
        currentLocation = "Town Hall";
        mission();
    }
    
    //method to advance to next day
    public static void advance(){
        history.clear();
        forward.clear();
        dayNum++;
        currentLocation = "Town Hall";
        System.out.printf("It's Day %d (%s) of our journey in JOJOLands!\n", dayNum, DAYS_OF_WEEK[dayNum- 1]);
        mission();
    }
    
    //method to end the game at Town Hall
    public static void end(){
        System.out.println("THE END");
        System.out.println("Thank you for playing!");
        System.out.println("======================================================================");
        System.exit(0);
    }
    
    //method for loading the game state
    public static void loadGame(){
    }
    
    //method for saving the current game state
    public static void saveGame(){
    }
}