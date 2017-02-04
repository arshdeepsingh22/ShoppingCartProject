package com.shopping.client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.domain.*;
import com.shopping.services.*;

/**
 * Created by 22arsh on 2/4/17.
 */
public class mainly {
    public static void main(String[] args) {



        File fil = new File("/Users/22arsh/assignments/ShoppingCartProject/user.txt");
        File fil2 = new File("/Users/22arsh/assignments/ShoppingCartProject/product.txt");
        File fil3 = new File("/Users/22arsh/assignments/ShoppingCartProject/orderdetails.txt");
        File fil4 = new File("/Users/22arsh/assignments/ShoppingCartProject/order.txt");
        try {
            fil.createNewFile();
            fil2.createNewFile();
            fil3.createNewFile();
            fil4.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userclient u = new userclient(fil);
        // u.enterusersbytxt();
        productclient p = new productclient(fil2);
        //p.enterproductsbytxt();
        orderclient oc = new orderclient(fil4);
        // oc.enterordersbytxt();
        orderdetailsclient odc = new orderdetailsclient(fil3);
        //odc.enterorderdetailsbytxt();;

        /////////////////// ///////////// creating csv file for a choosen order id

        orderdetailsservicesimpl od = new orderdetailsservicesimpl();
        orderservicesimpl ok = new orderservicesimpl();
        userservicesimpl imp = new userservicesimpl();
        File dir = new File("/Users/22arsh/assignments/ShoppingCartProject/");
        File f1 = new File(dir,"Bill.csv");
        final String cs = ",";
        final String nls = "\n";
        final String fh= "OrderId,UserId,UserName";
        final String fh2 ="ProductId,Quantity,PriceofProduct,Amount";
        try {
            f1.createNewFile();
            FileWriter fw = new FileWriter(f1);
            fw.append(fh.toString());

            List<order> oo = new ArrayList<>();
            oo = ok.getallorders();
            int chooseorderid = 2;
            order o = new order();
            o = ok.getorderbyorderid(1);
            fw.append(nls);
            fw.append(Integer.toString(chooseorderid));
            fw.append(cs);
            fw.append(Integer.toString(o.getUserId()));
            fw.append(cs);
            int y = o.getUserId();
            user v = imp.getuserbyid(y);
            fw.append((v.getUserName())) ;
            List<orderDetail> od1 = new ArrayList<>();
            od1 = od.getallorderdetailsbyid(chooseorderid);
            fw.append(nls);
            fw.append(nls);
            fw.append(fh2);
            double sum = 0;
            for(orderDetail ur : od1)
            {
                fw.append(nls);
                fw.append(Integer.toString(ur.getProductId()));
                fw.append(cs);
                fw.append(Integer.toString(ur.getQuantity()));
                fw.append(cs);

                double x = (ur.getPrice());

                int q = ur.getQuantity();
                fw.append(Double.toString(x));
                fw.append(cs);
                sum = sum + (q*x);
                fw.append(Double.toString((q*x)));
            }

            fw.append(nls);
            fw.append(nls);
            fw.append(cs);
            fw.append(cs);
            fw.append("TOTAL");
            fw.append(cs);
            fw.append(Double.toString(sum));

            fw.flush();
            fw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }






    }
}
