package com.shopping.services;


import java.sql.SQLException;
import java.util.List;
import com.shopping.domain.user;


/**
 * Created by 22arsh on 1/27/17.
 */
public interface userservices {

    public List <user> getallusers() throws SQLException;
    public void createuser(user u);
    public void updateuser(user u);
    public void deleteuser(int u);
    public user getuserbyid(int id);


}
