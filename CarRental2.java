import java.util.*;




public class CarRental2 {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the car rental system!");

            // Initialize a hashmap of available cars
            HashMap<String,Integer> cars = new HashMap<>();
            cars.put("honda",100);
            cars.put("toyota",200);
            cars.put("ford",300);
            cars.put("chevy",400);
            cars.put("dodge",500);
            
            // a hashmap for rented cars
            HashMap<String,Integer> rentedcars = new HashMap<>();
            while (true) {
                System.out.println("Please select an option:");
                System.out.println("1. Rent a car");
                System.out.println("2. Return a car");
                System.out.println("3. View available cars");
                System.out.println("4. View rented cars");
                System.out.println("5. Add a car");
                System.out.println("6. Exit");

                int choice = scanner.nextInt();

                if (choice == 1) {
                    // Rent a car
                    scanner.nextLine();
                    System.out.println("Which car would you like to rent? write the name of the car.");
                    int i =0;
                    for (Map.Entry m : cars.entrySet()) {
                        System.out.println((i + 1) + ". " + m.getKey() + "   price-  " + m.getValue());
                        i++;
                    }
                    int total =0;
                    while(true){
                        String carChoice = scanner.nextLine();
                        // Mark the selected car as rented
                        if(cars.containsKey(carChoice)){
                            int value = cars.get(carChoice);
                            total = total + cars.get(carChoice);
                            System.out.println("You have rented a " + carChoice + " for $" + value + "  \ntotal = $" + total);
                            System.out.println("anything else?(if no ,press 'n' )");
                            rentedcars.put(carChoice,value) ; 
                            cars.remove(carChoice, value) ;
                        } 
                        
                        
                        else if(carChoice.equalsIgnoreCase("n")){ 
                            System.out.println("your total price is $" + total +  " + $" + total*0.18 + " (18% tax) = $" + (total+total*0.18)  );
                            System.out.println("Thank you for Shopping!!");
                            break;
                        }
                        else {
                            System.out.println("Invalid car choice. Please try again ");
                        }
                    }
                }
                else  if (choice == 2) {
                    // Return a car
                    scanner.nextLine(); // add this line to clear scanner's buffer
                    System.out.println("Which car are you returning? write the name of the car");
                    int i=0;
                    for (Map.Entry m : rentedcars.entrySet()) {
                        System.out.println((i + 1) + ". " + m.getKey() + "    price-   " + m.getValue());                
                        i++;
                    }
                    String returnedcar = scanner.nextLine();
                    
                    // Find the index of the returned car in the array
                    if(rentedcars.containsKey(returnedcar)) {
                        int value = rentedcars.get(returnedcar);
                        cars.put(returnedcar , value);
                        rentedcars.remove(returnedcar);
                        System.out.println("Thank you for returning the " + returnedcar);
                        
                    }
                     
                    else {
                        System.out.println("Invalid car choice." + returnedcar + "  not found ");
                    }
                }
                else if (choice == 3) {
                    // View available cars
                    System.out.println("Available cars:");
                    int i =0;
                    for (Map.Entry m : cars.entrySet()) {
                        System.out.println((i + 1) + ". " + m.getKey() + "    price-    " + m.getValue());
                        i++;
                    }
                }
                else if (choice == 4) {
                    // View available cars
                    System.out.println("Rented cars:");
                    int i=0;
                    for (Map.Entry m : rentedcars.entrySet()) {
                        System.out.println((i + 1) + ". " + m.getKey() + "    price-   " + m.getValue());                
                        i++;
                    }
                }     
                else if (choice == 5) {
                    scanner.nextLine();
                    System.out.println("Name of the car to be added: ");
                    String newcar = scanner.nextLine();
                    System.out.println("what is the price of the car: ");
                    int value = scanner.nextInt();
                    cars.put(newcar,value);
                    System.out.println("car added successfully");

                }    
                else if (choice == 6) {
                    // Exit
                    System.out.println("Thank you for using my car rental system. Goodbye!!");
                    break;
                } 
                else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
