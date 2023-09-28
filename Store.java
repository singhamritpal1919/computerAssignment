package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Store {
	
	final static String store_Password = "password" ;
	private static int currentComputers;
	private static int maxCp;
	public static Computer[] inventory;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("WELCOME TO THE STORE !");
		
		int choice = 0 ;
		
        
        	do {
    			
    			System.out.println("What do you want : ");
    			System.out.println("1. Enter new computers (password required)");
    			System.out.println("2. Change information of a computer (password required)");
    			System.out.println("3. Display all computers by a specific brand");
    			System.out.println("4. Display all computers under a certain a price.");
    			System.out.println("5. Quit.");
    			
    			System.out.println("Please Enter Your choice :");
    			
  
    		try {
    			choice = kb.nextInt();
    		}catch(InputMismatchException e) {
    			System.out.println("Please Enter Valid choice :");
    			kb.nextLine();
    		}
    		
    		
    		
    		switch(choice) {
    		case 1 : 
    			one(kb);
    			break;
          	 
    		case 2:
    			two(kb);
    			break ;
    			
    		case 3:
    			three(kb);
    			break ;
    			
    		case 4:
    			fourth(kb);
    			break ;
    			
    		case 5:
    			System.out.println("Closing the Store.");
    			break ;
    			
    			default :
    				System.out.println("Invalid Choice");
    		}
    		}while(choice!=5);
       
	
		
	
	}	
	
	
	
	
	
	public static void one(Scanner ss) {
		
		String enter_Password = ss.nextLine();
		

		 if (!enter_Password.equals(store_Password)) {
	            System.out.println("You have 3 tries.");
		        for (int i = 0; i < 3; i++) {
                     System.out.print("Enter the password: ");  
                     enter_Password = ss.nextLine();
                     if (enter_Password.equals(store_Password)) {
                    	 break ;
                     }
                         System.out.println("Incorrect password. You have " + (2 - i) + " tries remaining.");
		        }
                     if (!enter_Password.equals(store_Password)) {
                         System.out.println("Returning to the main menu.");
                         return;
                     
	        } 
                     System.out.print("Enter the maximum number of computers your store can contain: ");
                     maxCp = ss.nextInt();
                     inventory = new Computer[maxCp];
                     
                     System.out.print("How many computers do you want to enter? ");
                     int numComputers = ss.nextInt();
                     

                     if (currentComputers + numComputers <= maxCp) {
                         for (int i = 0; i < numComputers; i++) {
                             System.out.println("Enter information for Computer #" + (currentComputers + 1));
                             System.out.println("Brand: ");
                             String br = ss.nextLine();
                             ss.nextLine();
                             
                             System.out.println("Model: ");
                             String md = ss.nextLine();
                             
                             
                             System.out.println("Serial Number: ");
                             long s = ss.nextLong();
                             
                             
                             
                             System.out.println("Price: $");
                             double pr = ss.nextDouble();
                   
                             Computer computer = new Computer(br, md, s , pr);
                             inventory[currentComputers] = computer;
                             currentComputers++;
                         }
                         System.out.println("Computer(s) added successfully.");
                     } else {
                         System.out.println("Not enough space in the inventory. You can only add " +
                                            (maxCp - currentComputers) + " more computer(s).");
                     }
                 }
	
        }
	
	
	
	
	public static void two(Scanner ss) {
		String enter_Password = ss.nextLine();
		

		 if (!enter_Password.equals(store_Password)) {
	            System.out.println("You have 3 tries.");
		        for (int i = 0; i < 3; i++) {
                    System.out.print("Enter the password: ");  
                    enter_Password = ss.nextLine();
                    if (enter_Password.equals(store_Password)) {
                   	 break ;
                    }
                        System.out.println("Incorrect password. You have " + (2 - i) + " tries remaining.");
		        }
                    if (!enter_Password.equals(store_Password)) {
                        System.out.println("Returning to the main menu.");
                        return;
                    
	        }   
                    System.out.println("Enter computer number you want to edit");
                    int computerNumber = ss.nextInt();
                    ss.nextLine();
                    
                    if (computerNumber >= 1 && computerNumber <= maxCp) {
                        int index = computerNumber - 1;
                        Computer computer = inventory[index];

                        System.out.println("Current information of computer #" + computerNumber);
                        System.out.println(computer);

                        int updateChoice;
                        do {
                        	
                        	System.out.println("\nComputer Update Menu (Computer #X)");
                            System.out.println("1. Update brand");
                            System.out.println("2. Update model");
                            System.out.println("3. Update SN");
                            System.out.println("4. Update price");
                            System.out.println("5. Quit");
                            
                            System.out.print("Enter your choice > ");
                            updateChoice = ss.nextInt();
                            ss.nextLine(); // Consume newline

                            switch (updateChoice) {
                                case 1:
                                    System.out.print("Enter new brand: ");
                                    String newBrand = ss.nextLine();
                                    computer.setBrand(newBrand);
                                    break;
                                case 2:
                                    System.out.print("Enter new model: ");
                                    String newModel = ss.nextLine();
                                    computer.setModel(newModel);
                                    break;
                                case 3:
                                    System.out.print("Enter new SN: ");
                                    long newSN = ss.nextLong();
                                    computer.setSN(newSN);
                                    break;
                                case 4:
                                    System.out.print("Enter new price: ");
                                    double newPrice = ss.nextDouble();
                                    computer.setPrice(newPrice);
                                    break;
                                case 5:
                                    System.out.println("Computer information updated successfully:");
                                    System.out.println(computer);
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                            }
                        } while (updateChoice != 5);
                    } else {
                        System.out.println("Invalid computer number. Returning to the main menu.");
                    }

                    
                    
	    } 
		
	}
	
	public static void three(Scanner ss) {
		System.out.print("Enter the brand name: ");
        String brandName = ss.nextLine();
        //System.out.println(ss.next());
        
        System.out.println("Computers with brand '" + brandName + "':");

        for (int i = 0; i < currentComputers; i++) {
            //if (inventory[i].getBrand().equalsIgnoreCase(brandName)) {
                System.out.println("Computer # " + (i + 1));
                System.out.println(inventory[i].getBrand());
            //}
        }
	}
	
	
	
    public static void fourth(Scanner ss) {
		
    	 System.out.print("Enter the maximum price: $");
         double maxPrice = ss.nextDouble();
         System.out.println("Computers under $" + maxPrice + ":");

         for (int i = 0; i < currentComputers; i++) {
             if (inventory[i].getPrice() < maxPrice) {
                 System.out.println("Computer #" + (i + 1));
                 System.out.println(inventory[i].toString());
             }
         }
	}
	
}


			
			
	
		
		
	




