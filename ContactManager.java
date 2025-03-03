import java.util.*;

public class ContactManager {
    private List<Contact> contacts;
    private Scanner sc;

    public ContactManager() {
        this.contacts = FileHandler4.loadContacts();
        this.sc = new Scanner(System.in);
    }

    public void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phoneNumber, email));
        FileHandler4.saveContacts(contacts);
        System.out.println("✅ Contact Added Successfully!");
    }

    public void viewAllContacts() {
        System.out.println("\n📌 Contact List:");
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void searchContact() {
        System.out.print("Enter name to search: ");
        String query = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(query)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No matching contacts found.");
        }
    }

    public void editContact() {
        System.out.print("Enter name of the contact to edit: ");
        String query = sc.nextLine().toLowerCase();

        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().equals(query)) {
                System.out.print("Enter new name: ");
                contact.setName(sc.nextLine());
                System.out.print("Enter new phone number: ");
                contact.setPhoneNumber(sc.nextLine());
                System.out.print("Enter new email: ");
                contact.setEmail(sc.nextLine());

                FileHandler4.saveContacts(contacts);
                System.out.println("✅ Contact Updated Successfully!");
                return;
            }
        }
        System.out.println("❌ Contact not found.");
    }

    public void deleteContact() {
        System.out.print("Enter name of the contact to delete: ");
        String query = sc.nextLine().toLowerCase();

        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().toLowerCase().equals(query)) {
                iterator.remove();
                FileHandler4.saveContacts(contacts);
                System.out.println("✅ Contact Deleted Successfully!");
                return;
            }
        }
        System.out.println("❌ Contact not found.");
    }
}
