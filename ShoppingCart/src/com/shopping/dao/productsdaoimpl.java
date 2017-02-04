package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopping.domain.*;
import javax.swing.plaf.nimbus.State;

import com.shopping.utils.DBConnection;

/**
 * Created by 22arsh on 2/2/17.
 */

public class productsdaoimpl implements productsdao {

    Connection cd ;
    Statement stmt1;
    String sql;

    public productsdaoimpl() throws SQLException
    {

            cd = DBConnection.getConnection();
            stmt1 = cd.createStatement();

    }


    @Override
    public List<product> getallproducts() {
       List<product> products = new ArrayList<>();
       sql = "SELECT * FROM products";
        ResultSet rs;
        try {
            rs = stmt1.executeQuery(sql);
            while(rs.next())
            {
                product p = new product(rs.getInt("id"),rs.getString("name"),rs.getString("code"),rs.getDouble("price"),rs.getInt("stock"));
                products.add(p);

            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;

    }

    @Override
    public product getproduct(int id) throws SQLException {
        sql = "SELECT * FROM products WHERE id = ?";

        PreparedStatement ps = cd.prepareStatement(sql);
        ps.setInt(1,id);

        ResultSet rs = ps.executeQuery(sql);
        product p = new product(rs.getInt("id"),rs.getString("name"),rs.getString("code"),rs.getDouble("price"),rs.getInt("stock"));
        return p;
    }

    @Override
    public void createproduct(product p)
    {
        sql = "INSERT INTO products(name,code,price,stock)" + "VALUES (?,?,?,?) ";
        try {

            //int s0 = p.getId();
       /* String s1=  p.getName();
            String s2 = p.getCode();
            Double s3 = p.getPrice();
            int s4 = p.getStock();*/

            PreparedStatement ps = cd.prepareStatement(sql);

           // ps.setInt(1, s0);
            ps.setString(1,p.getName());
            ps.setString(2, p.getCode());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getStock());
            ps.executeUpdate();

        }
        catch(SQLException e)
        {

        }


    }

    @Override
    public void updateproduct(product p) {
        sql = "UPDATE products SET name = ?, code = ?, price = ?, stock = ? WHERE id = ?" ;
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = cd.prepareStatement(sql);
            preparedStmt.setString(1, p.getName());
            preparedStmt.setString (2, p.getCode());
            preparedStmt.setDouble  (3, p.getPrice());
            preparedStmt.setInt(4, p.getStock());
            preparedStmt.setInt(5, p.getId());
            preparedStmt .executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteproduct(int u) throws SQLException {
    sql = "DELETE FROM products WHERE id = ? ";
    PreparedStatement ps = cd.prepareStatement(sql);
        ps.setInt(1,u);
        ps.executeUpdate();
    }


}
