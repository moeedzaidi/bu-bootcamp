import java.util.*; 

public class ContactManager { 

    public static void main(String[] args) { 

        HashMap<String, Contact> contacts = new HashMap<>(); 

        // Step 4: Add contacts (Key = Name, Value = Contact object)
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Alan Turing", new Contact("Alan Turing", "+1 617 555 0102"));
        contacts.put("Grace Hopper", new Contact("Grace Hopper", "+1 617 555 0103"));
        contacts.put("Margaret Hamilton", new Contact("Margaret Hamilton", "+1 617 555 0104"));
        contacts.put("John von Neumann", new Contact("John von Neumann", "+1 617 555 0105"));

        // Step 5: Look up a contact by Name
        System.out.println("=== Contact Lookup Test ===");
        
        // Test 1: Existing contact
        String searchName1 = "Ada Lovelace";
        Contact found1 = contacts.get(searchName1);
        if (found1 == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(found1);
        }

        // Test 2: Non-existing contact
        String searchName2 = "Charles Babbage";
        Contact found2 = contacts.get(searchName2);
        if (found2 == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(found2);
        }

        System.out.println(); // Blank line for spacing

        // Step 6: Print the Sorted List
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        
        // Lambda expression to sort alphabetically by name
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");
        for (Contact c : sorted) {
            System.out.println(c);
        }
    } 
}