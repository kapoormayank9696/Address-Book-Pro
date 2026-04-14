package Contact_Management_System.service;

import Contact_Management_System.DAO.ContactDAO;
import Contact_Management_System.model.Contact;

import java.sql.SQLException;
import java.util.List;

public class ContactService {
    private ContactDAO dao = new ContactDAO();

    // Add new contact
    public void add(Contact c) throws SQLException {
        if (dao.addContact(c)) {
            System.out.println("✅ Contact added successfully");
        } else {
            System.out.println("❌ Failed to add contact");
        }
    }

    // Show all contacts
    public void showAll() {
        List<Contact> list = dao.getALL();
        if (list.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        for (Contact c : list) {
            System.out.println(c);
        }
    }

    // Search contact by name
    public void search(String name) {
        Contact c = dao.getSearch(name);
        System.out.println(c == null ? "❌ Not found" : c);
    }

    // Update contact
    public void update(Contact c) {
        if (dao.update(c)) {
            System.out.println("✅ Contact updated");
        } else {
            System.out.println("❌ Update failed");
        }
    }

    // Delete contact by name (matching your DAO)
    public void delete(String name) throws SQLException {
        if (dao.deleteContact(name)) {
            System.out.println("✅ Contact deleted");
        } else {
            System.out.println("❌ Contact not found");
        }
    }
}