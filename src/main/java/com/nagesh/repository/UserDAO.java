package com.nagesh.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nagesh.entity.User;

public class UserDAO {

    private final String URL = "jdbc:mysql://localhost:3306/ride";
    private final String USERNAME = "root"; 
    private final String PASSWORD = "Nagesh@45"; 

    // ✅ Get User by Email
    public User getUserByEmail(String email) {
        User user = null;

        try {
            // 1. Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Get DB Connection
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 3. SQL Query
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);

            // 4. Execute Query
            ResultSet rs = ps.executeQuery();

            // 5. If record exists, map it to User object
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password")); 
            }

     
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
