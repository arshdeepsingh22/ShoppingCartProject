package com.shopping.services;
import java.util.List;

import com.shopping.domain.*;
/**
 * Created by 22arsh on 2/2/17.
 */
public interface orderservices {
    public void createorder(order o);
    public void deleteorder(int id);
    public List<order> getallorders();
    public void updateorder(order o);
    public order getorderbyorderid(int i);
}
