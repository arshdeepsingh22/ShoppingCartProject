package com.shopping.services;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.*;
import com.shopping.domain.*;
import oracle.jvm.hotspot.jfr.Producer;

/**
 * Created by 22arsh on 2/2/17.
 */

public class productservicesimpl implements productservices {


    @Override
    public List<product> getallproducts() throws SQLException {
        productsdaoimpl pd = new productsdaoimpl();
        List<product> ps = new ArrayList<>();
        ps = pd.getallproducts();
        return ps;
    }

    @Override
    public product getproduct(int id) throws SQLException {
        productsdaoimpl pd = new productsdaoimpl();
        product p =  pd.getproduct(id);
        return p;
    }

    @Override
    public void createproduct(product p) throws SQLException {
        productsdaoimpl pd = new productsdaoimpl();
        pd.createproduct(p);
    }

    @Override
    public void updateproduct(product p) {
        productsdaoimpl pd = null;
        try {
            pd = new productsdaoimpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pd.updateproduct(p);

    }
    @Override
    public void deleteproduct(int u) throws SQLException {
        productsdaoimpl pd = new productsdaoimpl();
        pd.deleteproduct(u);
    }

}
