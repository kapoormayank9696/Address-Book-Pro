package Contact_Management_System.model;

public class Contact {
    // Private Access Modifier And Data Members
    private int id;
    private String name;
    private String phone;
    private String email;

    // Default Constructor
    public Contact() {}

    // Parameterized Constructor
    public Contact(int id,String name,String phone,String email) {
        this.id=id;                  // id usually from DB
        setName(name);              // use setter for validation
        setPhone(phone);            // use setter for validation
        setEmail(email);            // use setter for validation
    }

    // Setters
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!!!");
        }
        this.name=name;
    }
    public void setPhone(String phone) {
        if(phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid phone number!!!");
        }
        this.phone=phone;
    }
    public void setEmail(String email) {
        if(email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty!!!");
        }
        this.email=email;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }

    // Display
    @Override
    public String toString() {
        return id + " | " + name + " | " + phone + " | " + email;
    }
}
