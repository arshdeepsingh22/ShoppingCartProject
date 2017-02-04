package com.shopping.services;

import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.productsdaoimpl;
import com.shopping.domain.orderDetail;
import com.shopping.domain.product;
import com.shopping.dao.*;
/**
 * Created by 22arsh on 2/2/17.
 */
public class orderdetailsservicesimpl implements orderdetailsservices {
    orderdetailsdaoimpl pd = new orderdetailsdaoimpl();

    @Override
    public List<orderDetail> getallorderdetails() {
        List<orderDetail> ps = new ArrayList<>();
        ps = pd.getallorderdetails();
        return ps;
    }

    @Override
    public List<orderDetail> getallorderdetailsbyid(int id) {
        List<orderDetail> ps = new ArrayList<>();
        ps = pd.getallorderdetailsbyid(id);
        return ps;
    }

    @Override
    public void createorderdetail(orderDetail o) {

        pd.createorderdetail(o);

    }

    @Override
    public void deleteorderdetail(int id) {
        pd.deleteorderdetail(id);

    }

    @Override
    public void updateorderdetail(orderDetail o) {
        pd.updateorderdetail(o);
    }
}
