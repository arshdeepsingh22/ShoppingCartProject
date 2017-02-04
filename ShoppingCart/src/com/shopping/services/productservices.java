package com.shopping.services;

import java.sql.SQLException;
import java.util.List;

import com.shopping.domain.product;

/**
 * Created by 22arsh on 2/2/17.
 */
public interface productservices {
    public List<product> getallproducts() throws SQLException;
    public product getproduct(int id) throws SQLException;
    public void createproduct(product p) throws SQLException;
    public void updateproduct(product p);
    public void deleteproduct(int u) throws SQLException;


}
