package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopping.domain.orderDetail;
import com.shopping.domain.product;
import com.shopping.utils.*;


/**
 * Created by 22arsh on 2/2/17.
 */
public class orderdetailsdaoimpl implements orderdetailsdao {
    Connection c;
    Statement s;
    String sql;
    public orderdetailsdaoimpl() {
        c = DBConnection.getConnection();
        try {
            s=  c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<orderDetail> getallorderdetails() {
        List<orderDetail> ods = new ArrayList<>();
        sql = "SELECT * FROM order_details";
        ResultSet rs;
        try {
            rs = s.executeQuery(sql);
            while(rs.next())
            {
             //   product p = new product(rs.getInt("id"),rs.getString("name"),rs.getString("code"),rs.getDouble("price"),rs.getInt("stock"));

                orderDetail d = new orderDetail();
                d.setId(rs.getInt("id"));
                d.setOrderId(rs.getInt("order_id"));
                d.setProductId(rs.getInt("product_id"));
                d.setQuantity(rs.getInt("quantity"));
                d.setPrice(rs.getDouble("price"));
                d.setAmount(rs.getDouble("amount"));
               ods.add(d);
            }
            return ods;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ods;

    }

    @Override
    public List<orderDetail> getallorderdetailsbyid(int id) {
        List<orderDetail> ods = new ArrayList<>();
        sql = "SELECT * FROM order_details WHERE order_id = ?";
        ResultSet rs;
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,id);

            rs = ps.executeQuery();

            while(rs.next())
            {
                //   product p = new product(rs.getInt("id"),rs.getString("name"),rs.getString("code"),rs.getDouble("price"),rs.getInt("stock"));

                orderDetail d = new orderDetail();
                d.setId(rs.getInt("id"));
                d.setOrderId(rs.getInt("order_id"));
                d.setProductId(rs.getInt("product_id"));
                d.setQuantity(rs.getInt("quantity"));
                d.setPrice(rs.getDouble("price"));
                d.setAmount(rs.getDouble("amount"));
                ods.add(d);

            }
            return ods;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ods;
    }

    @Override
    public void createorderdetail(orderDetail o) {
        sql = "INSERT INTO order_details (order_id,product_id,quantity,price,amount )" + "VALUES (?,?,?,?,?) ";
        try {

            PreparedStatement ps = c.prepareStatement(sql);

            // ps.setInt(1, s0);
            ps.setInt(1,o.getOrderId());
            //System.out.println(o.getOrderId());
            ps.setInt(2, o.getProductId());
            ps.setInt(3, o.getQuantity());
            ps.setDouble(4, o.getPrice());
            //System.out.println(o.getPrice());
            ps.setDouble(5, o.getAmount());
            ps.executeUpdate();

        }
        catch(SQLException e)
        {

        }

    }

    @Override
    public void deleteorderdetail(int id) {
        sql = "DELETE FROM order_details WHERE id = ? ";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateorderdetail(orderDetail o) {
        sql = "UPDATE order_details SET order_id = ?, product_id = ?, quantity = ?, price = ?, amount =? WHERE id = ?" ;
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = c.prepareStatement(sql);
            preparedStmt.setInt(2, o.getOrderId());
            preparedStmt.setInt (3, o.getProductId());
            preparedStmt.setInt  (4, o.getQuantity());
            preparedStmt.setDouble(5, o.getPrice());
            preparedStmt.setDouble(6, o.getAmount());

            preparedStmt.setInt(1, o.getId());
            preparedStmt .executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
