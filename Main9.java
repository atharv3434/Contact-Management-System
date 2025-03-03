import java.util.Scanner;

public class Main9 {
    private static ContactManager contactManager = new ContactManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("📞 Welcome to Contact Management System 📞");

        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    contactManager.addContact();
                    break;
                case 2:
                    contactManager.viewAllContacts();
                    break;
                case 3:
                    contactManager.searchContact();
                    break;
                case 4:
                    contactManager.editContact();
                    break;
                case 5:
                    contactManager.deleteContact();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye! 📞");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
