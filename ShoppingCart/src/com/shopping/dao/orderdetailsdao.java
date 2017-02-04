package com.shopping.dao;

import java.util.List;

import com.shopping.domain.orderDetail;

/**
 * Created by 22arsh on 2/2/17.
 */
public interface orderdetailsdao {

    public List<orderDetail> getallorderdetails();
    public void createorderdetail(orderDetail o);
    public void deleteorderdetail(int id);
    public void updateorderdetail(orderDetail o);
    public  List<orderDetail> getallorderdetailsbyid(int id);
}
