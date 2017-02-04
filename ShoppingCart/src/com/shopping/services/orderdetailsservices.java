package com.shopping.services;
import com.shopping.domain.*;
import java.util.List;

/**
 * Created by 22arsh on 2/2/17.
 */
public interface orderdetailsservices {
    public List<orderDetail> getallorderdetails();
    public void createorderdetail(orderDetail o);
    public void deleteorderdetail(int id);
    public void updateorderdetail(orderDetail o);
    public  List<orderDetail> getallorderdetailsbyid(int id);
}
