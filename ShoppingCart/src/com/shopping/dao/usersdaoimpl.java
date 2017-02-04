package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopping.utils.*;
import com.shopping.domain.*;
import com.shopping.utils.DBConnection;

/**
 * Created by 22arsh on 1/29/17.
 */
public class usersdaoimpl implements usersdao {

    Connection c ;
    Statement stmt;
    String sql;


    @Override
    public user getuserbyid(int id) {
        sql = "SELECT * FROM users WHERE id = ?";

        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int y =  rs.getInt("id");
            user p = new user(rs.getInt("id"),rs.getString("user_name"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("address"));
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
        }


  /*      try {
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
           int y =  rs.getInt("id");
            user p = new user(rs.getInt("id"),rs.getString("user_name"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("address"));
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

*/
        return null;
    }

    public usersdaoimpl() throws SQLException {
        c = DBConnection.getConnection();
        stmt = c.createStatement();
    }

    @Override
    public void updateuser(user u) {

        sql = "UPDATE users SET user_name = ?, first_name = ?, last_name = ?, address = ? WHERE id = ?" ;
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = c.prepareStatement(sql);
            preparedStmt.setString(1, u.getUserName());
            preparedStmt.setString (2, u.getFirstName());
            preparedStmt.setString   (3, u.getLastName());
            preparedStmt.setString(4, u.getAddress());
            preparedStmt.setInt(5, u.getId());
            preparedStmt .executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void createuser(user u) {

        String s1 = u.getUserName();
        String s2 = u.getFirstName();
        String s3 = u.getLastName();
        String s4 = u.getAddress();

        try {

      //      sql = "INSERT INTO users( user_name , first_name , last_name , address)" + "VALUES (s1,s2,s3,s4); ";
            sql = "INSERT INTO users( user_name , first_name , last_name , address)" + "VALUES (?,?,?,?); ";

            PreparedStatement preparedStmt = c.prepareStatement(sql);
            preparedStmt.setString(1, s1);
            preparedStmt.setString (2, s2);
            preparedStmt.setString   (3, s3);
            preparedStmt.setString(4, s4);

            //stmt.executeUpdate(sql);
            preparedStmt .executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    @Override
    public void deleteuser(int u) throws SQLException{
        // Integer i1 = i;
        sql = "DELETE FROM users WHERE id = ? ;";
        int j;
        //  stmt.executeUpdate(sql);
        PreparedStatement p = c.prepareStatement(sql);
        p.setInt(1,u);
        p.executeUpdate();
    }


    @Override
        public List<user> getallusers()
        {
            List<user> users=new ArrayList<>();
     ResultSet rs ;
        sql = "SELECT * FROM users; ";
        try {
             rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                user u = new user(rs.getInt("id"),rs.getString("user_name"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("address"));
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }






}
