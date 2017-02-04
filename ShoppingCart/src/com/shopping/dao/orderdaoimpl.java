package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopping.domain.order;
import com.shopping.domain.orderDetail;
import com.shopping.utils.DBConnection;
import com.shopping.services.*;
/**
 * Created by 22arsh on 2/2/17.
 */
public class orderdaoimpl implements orderdao {
    Connection c;
    Statement s;
    String sql;
    public orderdaoimpl() {
        c = DBConnection.getConnection();
        try {
            s =  c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createorder(order o) {
        sql = "INSERT INTO orders(orderdate,amount,user_id)" + "VALUES (?,?,?) ";
        try {

            PreparedStatement ps = c.prepareStatement(sql);

            // ps.setInt(1, s0);
            ps.setDate(1, (Date) o.getOrderDate());
            ps.setDouble(2, o.getAmount());
            ps.setInt(3, o.getUserId());
            ps.executeUpdate();
        }
        catch(SQLException e)
        {

        }


    }

    @Override
    public void deleteorder(int id) {
        sql = "DELETE FROM orders WHERE id = ? ";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    @Override
    public List<order> getallorders() {
        List<order> ods = new ArrayList<>();
        sql = "SELECT * FROM orders";
        ResultSet rs;
        try {
            rs = s.executeQuery(sql);
            while(rs.next())
            {
                order d = new order();
                d.setId(rs.getInt("id"));
                d.setOrderDate(rs.getDate("orderdate"));
                d.setAmount(rs.getDouble("amount"));
                d.setUserId(rs.getInt("user_id"));
                orderdetailsservicesimpl i = new orderdetailsservicesimpl();
              d.setOrderDetails(i.getallorderdetailsbyid(rs.getInt("id")));
                ods.add(d);
            }
            return ods;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ods;

    }

    @Override
    public order getorderbyorderid(int i) {
        sql = "SELECT * FROM orders WHERE id = ?";
        order d1 = new order();
        ResultSet rs1;
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,i);
            rs1 = ps.executeQuery();
               rs1.next();
                d1.setOrderDate(rs1.getDate("orderdate"));
                 d1.setAmount(rs1.getDouble("amount"));
                d1.setUserId(rs1.getInt("user_id"));
                d1.setId(rs1.getInt("id"));
                orderdetailsservicesimpl o = new orderdetailsservicesimpl();
                List<orderDetail> od =  o.getallorderdetailsbyid(rs1.getInt("id"));
                d1.setOrderDetails(od);


            return d1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return d1;
    }

    @Override
    public void updateorder(order o) {
        sql = "UPDATE orders SET orderdate = ?, amount = ?, user_id =? WHERE id = ?" ;
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = c.prepareStatement(sql);
            preparedStmt.setDate(1, (Date) o.getOrderDate());
            preparedStmt.setDouble (2, o.getAmount());
            preparedStmt.setInt  (3, o.getUserId());
            preparedStmt.setInt(4, o.getId());
            preparedStmt .executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }
