package Contact_Management_System;


import Contact_Management_System.model.Contact;
import Contact_Management_System.service.ContactService;

import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    // Main function
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        ContactService service=new ContactService();

        while (true) {
            System.out.println("=========CONTACT MANAGEMENT SYSTEM==========");
            System.out.println("1. Add New Contact");
            System.out.println("2. View All");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choices;
            try {
                choices = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                continue;
            }

            switch (choices) {
                case 1:
                    System.out.print("Name: ");
                    String name=sc.nextLine();
                    System.out.print("Phone: ");
                    String phone=sc.nextLine();
                    System.out.print("Email: ");
                    String email= sc.nextLine();

                    service.add(new Contact(0,name,phone,email));
                    break;
                case 2:
                    service.showAll();
                    break;
                case 3:
                    System.out.print("Name: ");
                    service.search(sc.nextLine());
                    break;
                case 4:
                    System.out.print("ID of contact to update: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Name: ");
                    String n=sc.nextLine();
                    System.out.print("Phone: ");
                    String p= sc.nextLine();
                    System.out.print("Email: ");
                    String e= sc.nextLine();

                    service.update(new Contact(id,n, p, e));
                    break;
                case 5:
                    System.out.print("Name: ");
                    service.delete(sc.nextLine());
                    break;
                case 6:
                    System.out.println("Thank you for using the Contact Management System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please choose 1-6.");
            }
        }
    }
}
