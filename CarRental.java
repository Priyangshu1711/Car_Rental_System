import java.util.Scanner;
import java.util.Arrays;
public class CarRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the car rental system!");

        // Initialize an array of available cars
        String[] cars = {"honda civic", "toyota camry", "ford mustang", "chevy impala"};
        String[] rentedcars = {};
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
                System.out.println("Which car would you like to rent?");
                for (int i = 0; i < cars.length; i++) {
                    System.out.println((i + 1) + ". " + cars[i]);
                }
                int carChoice = scanner.nextInt();

                if (carChoice > 0 && carChoice <= cars.length) {
                    // Mark the selected car as rented
                    System.out.println("You have rented a " + cars[ carChoice - 1  ]);
                    rentedcars = Arrays.copyOf(rentedcars,rentedcars.length +1);
                    rentedcars[rentedcars.length -1] = cars[carChoice - 1]; 
                    cars[carChoice - 1] = "";
                } else {
                    System.out.println("Invalid car choice. Please try again ");
                }
            }else  if (choice == 2) {
                // Return a car
                scanner.nextLine(); // add this line to clear scanner's buffer
                System.out.println("Which car are you returning?");
                for (int i = 0; i < rentedcars.length; i++) {
                    System.out.println((i + 1) + ". " + rentedcars[i]);
                }
                
                
                String returnedCar = scanner.nextLine();
                
                // Find the index of the returned car in the array
                int index = -1;
                for (int i = 0; i < rentedcars.length; i++) {
                    if (rentedcars[i].equalsIgnoreCase(returnedCar)) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    // Mark the returned car as available
                    for (int i =0 ; i< cars.length;i++){
                        if (cars[i] == ""){
                            cars[i] = returnedCar;
                            break;
                        }
                    }
                    rentedcars[index] = "";
                    System.out.println("Thank you for returning the " + returnedCar);
                } else {
                    System.out.println("Invalid car choice." + returnedCar + "  not found ");
                }
            }

                
             else if (choice == 3) {
                // View available cars
                System.out.println("Available cars:");
                for (String car : cars) {
                    if (!car.equals("")) {
                        System.out.println(car);
                    }
                }
            }
            else if (choice == 4) {
                // View available cars
                System.out.println("Rented cars:");
                for (String car : rentedcars) {
                    if (!car.equals("")) {
                        System.out.println(car);
                    }
                }
            } 
            else if (choice == 5) {
                scanner.nextLine();
                System.out.println("Name of the car to be added:");
                String newcar = scanner.nextLine();
                cars = Arrays.copyOf(cars,cars.length+1);
                cars[cars.length -1] = newcar;
                System.out.println("car added successfully");

            }    
            else if (choice == 6) {
                // Exit
                System.out.println("Thank you for using the car rental system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
