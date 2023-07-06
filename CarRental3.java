import java.util.*;


class CarRental3{
    public static void main(String [] args){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("welcome to car rental system!");
            HashMap<String,Integer> cars = new HashMap<String,Integer>();
            cars.put("honda", 600);
            cars.put("mazda", 500);
            cars.put("suzuki", 100);
            cars.put("ford", 300);
            cars.put("audi", 200);
            cars.put("mercedezz", 400);
            HashMap<String,Integer> rentedcars = new HashMap<>();
            while(true){ 
                System.out.println("Please select an option:");
                System.out.println("1. Rent a car");
                System.out.println("2. Return a car");
                System.out.println("3. View available cars");
                System.out.println("4. View rented cars");
                System.out.println("5. Add a car");
                System.out.println("6. Exit");
                
                CarRental3 obj = new CarRental3();
                int ch = scanner.nextInt();
                switch(ch){
                    case(1): 
                        obj.rent(cars,rentedcars);
                        break;

                    case(2):
                        System.out.println("which cars would you like to return");
                        obj.returncar(cars,rentedcars);
                        break;
                    case(3):
                        obj.viewcar(cars);
                        break;
                
                    case(4):
                        obj.rentedcar(rentedcars);
                        break;

                    case(5):
                        System.out.println("Name of the car to be added: ");
                        String newcar = scanner.nextLine();
                        scanner.nextLine();
                        System.out.println("what is the price of the car: ");
                        int value = scanner.nextInt();   
                        int i = obj.addcar(cars,newcar,value);
                        if(i == 1){
                            System.out.println("car added successfully!!");
                        }
                        else{
                            System.out.println("the car cant be added");
                        }
                        break;

                    case(6):
                        System.out.println("Thank you for using my car rental system. Goodbye!!");
                        break;
                }
            }
        }
    }    

    void rent (HashMap<String,Integer> cars , HashMap<String,Integer> rentedcars){
        Scanner scanner = new Scanner(System.in);
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
    void returncar(HashMap<String,Integer> cars , HashMap<String,Integer> rentedcars){
         try (// Return a car
        Scanner scanner = new Scanner(System.in)) {
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
    }
    void viewcar(HashMap<String,Integer> cars){
        System.out.println("Available cars:");
                    int i =0;
                    for (Map.Entry m : cars.entrySet()) {
                        System.out.println((i + 1) + ". " + m.getKey() + "    price-    " + m.getValue());
                        i++;
                    }
    }
    void rentedcar(HashMap<String,Integer> rentedcars){
        int i = 0;
        for(Map.Entry m : rentedcars.entrySet()){
            System.out.println((i + 1) + ". " + m.getKey() + "    price-    " + m.getValue());
                        i++;
        }
    }
    int addcar(HashMap<String,Integer> cars,String newcar,int value){
        cars.put(newcar,value);
        return 1;
    }

}