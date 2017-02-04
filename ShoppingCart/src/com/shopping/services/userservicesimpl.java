package com.shopping.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shopping.dao.*;
import com.shopping.domain.*;

/**
 * Created by 22arsh on 2/1/17.
 */
public class userservicesimpl implements userservices {


    @Override
    public void deleteuser(int u)
    {
        usersdaoimpl ui = null;
        try {
            ui = new usersdaoimpl();
            ui.deleteuser(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public user getuserbyid(int id) {
        usersdaoimpl ui = null;
        try {
            ui = new usersdaoimpl();
            user p =  ui.getuserbyid(id);
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<user> getallusers() throws SQLException {
        List<user> list = new ArrayList<>();
        usersdaoimpl u = new usersdaoimpl();
        list = u.getallusers();

        return list;
    }

    public void createuser(user u)
    {
        try {
           usersdaoimpl ui = new usersdaoimpl();
            // ui = new usersdaoimpl();
            ui.createuser(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void updateuser(user u)
    {
        usersdaoimpl ui = null;
        try {
            ui = new usersdaoimpl();
            ui.updateuser(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
