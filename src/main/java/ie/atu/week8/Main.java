package ie.atu.week8;

import java.util.ArrayList;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Product> Inventory = new ArrayList<Product>();
        Scanner Keyboard = new Scanner(System.in);
        while(true){
            System.out.println("Inventory Management System");
            System.out.println("\t1: Add Product\n\t2: Update Product\n\t3: Display Product\n\t4: Exit");
            System.out.print("Enter Your Selection: ");

            String UserInput = Keyboard.next();

            switch (UserInput){
                case "1" -> {
                    Product Temp = new Product();
                    System.out.println("Adding New Product");

                    while(true){
                        System.out.print("Enter the ProductID: ");
                        Temp.setProductId(Keyboard.next());

                        if(get_index(Temp.getProductId(), Inventory) == -1){
                            break;
                        }

                        System.out.println("Product ID not unique");
                    }


                    System.out.print("Enter the Name: ");
                    Temp.setName(Keyboard.next());

                    while (true){
                        System.out.print("Enter the Price: ");
                        UserInput = Keyboard.next();
                        try {
                            Temp.setPrice(Double.parseDouble(UserInput));
                        } catch (Exception e){
                            System.out.println("Not a valid entry. Try Again");
                            continue;
                        }
                        break;
                    }

                    while (true){
                        System.out.print("Enter the quantity: ");
                        UserInput = Keyboard.next();
                        try {
                            Temp.setQuantity(Integer.parseInt(UserInput));
                        } catch (Exception e){
                            System.out.println("Not a valid entry. Try Again");
                            continue;
                        }
                        break;
                    }

                    Inventory.add(Temp);

                }

                case "2" -> {
                    System.out.println("Update Product\n");
                    System.out.print("Enter products id: ");
                    UserInput = Keyboard.next();
                    int productIndex = get_index(UserInput, Inventory);


                    if(productIndex == -1){
                        System.out.println("Product does not exist!");
                        break;
                    }

                    System.out.println("Updating product " + Inventory.get(productIndex).getName());
                    System.out.println("What would you like to change:");
                    System.out.println("\t1: Name\n\t2: Price\n\t3: Quantity");

                    UserInput = Keyboard.next();
                    switch (UserInput){
                        case "1" ->{
                            System.out.print("Enter the Name: ");
                            Inventory.get(productIndex).setName(Keyboard.next());
                        }
                        case "2" ->{
                            while (true){
                                System.out.print("Enter the Price: ");
                                UserInput = Keyboard.next();
                                try {
                                    Inventory.get(productIndex).setPrice(Double.parseDouble(UserInput));
                                } catch (Exception e){
                                    System.out.println("Not a valid entry. Try Again");
                                    continue;
                                }
                                break;
                            }
                        }
                        case "3" ->{
                            while (true){
                                System.out.print("Enter the quantity: ");
                                UserInput = Keyboard.next();
                                try {
                                    Inventory.get(productIndex).setQuantity(Integer.parseInt(UserInput));
                                } catch (Exception e){
                                    System.out.println("Not a valid entry. Try Again");
                                    continue;
                                }
                                break;
                            }
                        }
                        default -> {
                            System.out.println("Invalid Entry");
                        }


                    }




                }

                case "3" -> {
                    System.out.println("Printing Inventory");
                    for(int i = 0; i != Inventory.size(); i++){
                        System.out.println("\t" + Inventory.get(i));
                    }
                    System.out.println("End Of Inventory");
                }

                case "4" -> {
                    System.out.println("GoodBye");
                    return;
                }

                default -> {
                    System.out.println("Invalid Input. Try Again");
                }



            }

        }


    }


    static int get_index(String ProductID, ArrayList<Product> List){
        for(int i = 0; i != List.size(); i++){
            if(Objects.equals(List.get(i).getProductId(), ProductID)){
                return i;
            }
        }
        return -1;
    }

}
