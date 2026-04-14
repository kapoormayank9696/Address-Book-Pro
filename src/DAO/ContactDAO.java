package Contact_Management_System.DAO;

import Contact_Management_System.util.DBConnection;
import Contact_Management_System.model.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    // Insert data In Contact Table
    public boolean addContact(Contact c) throws SQLException {
        String query="INSERT INTO contact(name,phone,email) VALUES(?,?,?)";
        try(Connection connection= DBConnection.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(query)){
            connection.setAutoCommit(false);
            preparedStatement.setString(1,c.getName());
            preparedStatement.setString(2,c.getPhone());
            preparedStatement.setString(3,c.getEmail());
            int rows=preparedStatement.executeUpdate();
            if(rows > 0) {
                connection.commit();
                return true;
            } else{
                connection.rollback();
                return false;
            }
        } catch(SQLException e) {
            System.err.println("❌ Add Error: " + e.getMessage());
        }
        return false;
    }

    // READ ALL
    public List<Contact> getALL() {
        List<Contact> list=new ArrayList<>();
        String query="SELECT * FROM contact";
        try(Connection connection=DBConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(query)) {
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) {
                list.add(new Contact(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")
                        )
                );
            }
        } catch (SQLException e) {
            System.err.println("❌ Fetch Error: " + e.getMessage());
        }
        return list;
    }

    // SEARCH BY NAME
    public Contact getSearch(String name) {
        String query="SELECT * FROM contact WHERE name=?";
        try(Connection connection=DBConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(query)) {
            preparedStatement.setString(1,name);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new Contact(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")
                );
            }
        }catch (SQLException e) {
            System.err.println("❌ Search Error: " + e.getMessage());
        }
        return null;
    }

    // Update Contact
    public boolean update(Contact c) {
        String query="UPDATE contact SET name=?,phone=?,email=? WHERE id=?";
        try (Connection connection=DBConnection.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(query)){
            connection.setAutoCommit(false);
            preparedStatement.setString(1,c.getName());
            preparedStatement.setString(2,c.getPhone());
            preparedStatement.setString(3,c.getEmail());
            preparedStatement.setInt(4, c.getId());
            int rows=preparedStatement.executeUpdate();
            if(rows > 0) {
                connection.commit();
                return true;
            }else {
                connection.rollback();
            }
        }catch (SQLException e) {
            System.err.println("❌ Update Error: " + e.getMessage());
        }
        return false;
    }

    // DELETE CONTACT
    public boolean deleteContact(String name) throws SQLException {
        String query="DELETE FROM contact WHERE name=?";
        try (Connection connection=DBConnection.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(query)){
            connection.setAutoCommit(false);
            preparedStatement.setString(1,name);
            int rows=preparedStatement.executeUpdate();
            if(rows > 0) {
                connection.commit();
                System.out.println("✅ Deleted successfully");
                return true;
            }else {
                connection.rollback();
            }
        } catch (SQLException e) {
            System.err.println("❌ Delete Error: " + e.getMessage());
        }
        return false;
    }

}
