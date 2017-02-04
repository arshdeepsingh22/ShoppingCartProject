package com.shopping.client;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.domain.order;
import com.shopping.domain.orderDetail;
import com.shopping.domain.user;
import com.shopping.services.orderdetailsservicesimpl;
import com.shopping.services.orderservicesimpl;
import com.shopping.services.productservicesimpl;
import com.shopping.services.userservicesimpl;

/**
 * Created by 22arsh on 2/1/17.
 */
public class OperationsOnServices {


  /*  public static void main(String[] args) {
        userservicesimpl imp = new userservicesimpl();

     *//*   File fil = new File("/Users/22arsh/assignments/ShoppingCartProject/abc.txt");
        try {
            fil.createNewFile();
            FileReader fr = new FileReader(fil);
            BufferedReader br = new BufferedReader(fr);
            String s;
            int count =0;
            String[] str,str2;
            StringBuilder sb = new StringBuilder();
            while((s=br.readLine())!=null)
            {
                sb.append(s).append("\n");
                //  System.out.println(sb);
            }
            s=sb.toString();
            str = s.split("\n");
            for(String ts : str )
            {
                str2 = ts.split(",");
                user h = new user(1,str2[0],str2[1],str2[2],str2[3]);
                //imp.createuser(h);
                imp.createuser(h);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

*//*

        /////////////// user

        //  user u1 = new user(3,"arsh12","arshdeep","singh","chandigarh" );

        /////   updated user identity from list getallusers
*//*        user u1 = new user(3,"arsh12","arshdeep","singh","chandigarh" );

           userservicesimpl imp = new userservicesimpl();
          // imp.createuser(u1);
          imp.updateuser(u1);
          List<user> l = new ArrayList<>();
       try{
           l=imp.getallusers();
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }


       for(user u : l)
       {
           System.out.println(u.getFirstName() + "\t\t"  + u.getAddress());
       }

*//*

        // imp.deleteuser(1);


        /////////////// product

        productservicesimpl pl = new productservicesimpl();
        *//*
        product p = new product(1, "tv", "a1b1", 12000, 12);

        try {
            pl.createproduct(p);
        } catch (SQLException e) {
        }
        *//*

   *//*     List<product> p = new ArrayList<>();
        try {
            p =  pl.getallproducts();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(product u : p)
        {
            System.out.println(u.getId() + "\t\t"  + u.getName());
        }

        *//*

       // product p1 = new product(1, "tv", "a1b1", 12000, 12);
      *//*  try {
            pl.deleteproduct(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ///   updated product identity from list getallusers
        product p2 = new product(2, "blower", "a2", 3100, 12);
        pl.updateproduct(p2);
*//*
        orderdetailsservicesimpl od = new orderdetailsservicesimpl();

      //  od.deleteorderdetail(3);



        // List<orderDetail> od1 = new ArrayList<>();
       // od1 = od.getallorderdetails();

      *//*  for(orderDetail d : od1)
        {
            System.out.println(d.getId() + "\t\t" + d.getOrderId() + "\t\t" + d.getQuantity());
        }

        *//*
     *//*   orderDetail od1 = new orderDetail();
      od1.setId(1);
      od1.setOrderId(1);
      od1.setProductId(1);
      od1.setPrice(12000);
      od1.setQuantity(2);
      od1.setAmount(((od1.getPrice())*(od1.getQuantity())));

      od.updateorderdetail(od1);
      *//*
      //  od.createorderdetail(od1);

      //try {
          //  product p = pl.getproduct(1);
           // System.out.println(p.getId());
          //  od1.setPrice(p.getPrice());
          //  od1.setQuantity(p.getStock());
          //  od1.setAmount(od1.getPrice()*od1.getQuantity());
        //    od.createorderdetail(od1);

      //  }
*//*
        orderDetail od2 = new orderDetail();
        od2.setId(2);
        od2.setOrderId(1);
        od2.setProductId(2);
        try {
            product p = pl.getproduct(2);
            od1.setPrice(p.getPrice());
            od1.setQuantity(p.getStock());
            od1.setAmount(od1.getPrice()*od1.getQuantity());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        *//*
            orderservicesimpl ok = new orderservicesimpl();

    *//*        order o = new order();
            o.setId(5);
        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());

            o.setOrderDate(date);
            o.setUserId(5);
            o.setAmount(58000);
            ok.updateorder(o);





            List<order> oo = new ArrayList<>();
            oo = ok.getallorders();
        for(order d : oo)
        {
            System.out.println(d.getId() + "\t\t" + d.getOrderDate() + "\t\t");
        }

*//*
          //  ok.deleteorder(2);


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
        *//*for(order d : oo)
        {
            System.out.println(d.getId() + "\t\t" + d.getOrderDate() + "\t\t");
        }
        *//*
            //choose a order id




            int chooseorderid = 1;
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
            for(orderDetail u : od1)
            {
                fw.append(nls);
                fw.append(Integer.toString(u.getProductId()));
                fw.append(cs);
                fw.append(Integer.toString(u.getQuantity()));
                fw.append(cs);

                double x = (u.getPrice());

                int q = u.getQuantity();
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

       *//*
        final String fh= "UserId,OrderId,UserName,ProductId,Quantity,PriceofProduct,Amount";
        try {
            f1.createNewFile();
            FileWriter fw = new FileWriter(f1);
            fw.append(fh.toString());
            List<order> oo = new ArrayList<>();
            oo = ok.getallorders();
            for(order d : oo)
            {
                System.out.println(d.getId() + "\t\t" + d.getOrderDate() + "\t\t");
            }
            //choose a order id

            int chooseorderid = 1;
            ok.getorderbyorderid(chooseorderid);
            od.getallorderdetailsbyid(1);
            double sum = 0;
            List<orderDetail> od1 = new ArrayList<>();
            od1 = od.getallorderdetails();
            order o = new order();

            o = ok.getorderbyorderid(1);
            fw.append(nls);
            fw.append(Integer.toString(o.getUserId()));
            fw.append(cs);

            fw.append(Integer.toString(chooseorderid));
            fw.append(cs);
            int y = o.getUserId();
            user v = imp.getuserbyid(y);
            fw.append((v.getUserName())) ;


            for(orderDetail u : od1)
            {

                fw.append(nls);
                fw.append(cs);
                fw.append(cs);
                fw.append(cs);
                fw.append(Integer.toString(u.getProductId()));
                fw.append(cs);
                fw.append(Integer.toString(u.getQuantity()));
                fw.append(cs);
                Double x = u.getPrice();
                int q = u.getQuantity();
                fw.append(Double.toString(u.getPrice()));
                fw.append(cs);
                sum = sum + (q*x);
                fw.append(Double.toString((q*x)));
            }
            fw.append(nls);

            fw.append(nls);
            fw.append(nls);
            fw.append(nls);
            fw.append("TOTAL");
            fw.append(cs);
            fw.append(cs);
            fw.append(cs);
            fw.append(cs);
            fw.append(cs);
            fw.append(cs);

            fw.append(Double.toString(sum));
            fw.flush();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

            *//*







    }
*/


}