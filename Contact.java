public class Contact {
    // Private fields
    private String name1;
    private String phone1;

    // Constructor
    public Contact(String name1, String phone1) {
        this.name1 = name1;
        this.phone1 = phone1;
    }

    // Getter for Name
    public String getName() {
        return name1;
    }

    // Getter for Phone
    public String getPhone() {
        return phone1;
    }

    // Override toString method
    @Override
    public String toString() {
        return name1 + " | " + phone1;
    }
}