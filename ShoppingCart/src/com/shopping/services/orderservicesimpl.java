package com.shopping.services;

import java.util.ArrayList;
import java.util.List;

import com.shopping.domain.order;
import com.shopping.dao.*;

/**
 * Created by 22arsh on 2/2/17.
 */
public class orderservicesimpl implements orderservices {
    orderdaoimpl oi = new orderdaoimpl();

    @Override
    public void createorder(order o) {
        oi.createorder(o);
    }

    @Override
    public void deleteorder(int id) {
        oi.deleteorder(id);
    }

    @Override
    public order getorderbyorderid(int i) {
        order o = new order();
        o = oi.getorderbyorderid(i);
        return o;
    }

    @Override
    public List<order> getallorders() {
        List<order> o = new ArrayList<>();
        o = oi.getallorders();
        return o;
    }

    @Override
    public void updateorder(order o) {
        oi.updateorder(o);
    }
}
