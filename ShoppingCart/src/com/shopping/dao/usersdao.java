package com.shopping.dao;

import com.shopping.domain.*;

import java.sql.SQLException;
import java.util.List;
/**
 * Created by 22arsh on 2/1/17.
 */
public interface usersdao {
    public List<user> getallusers();
    public void createuser(user u) throws SQLException;
    public void updateuser(user u);
    public void deleteuser(int u) throws SQLException;
    public user getuserbyid(int id);

}
