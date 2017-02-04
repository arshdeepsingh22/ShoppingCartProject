package com.shopping.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import com.shopping.domain.product;
import com.shopping.services.orderdetailsservicesimpl;
import com.shopping.domain.*;
/**
 * Created by 22arsh on 2/4/17.
 */
public class orderdetailsclient {
    orderdetailsservicesimpl imp = new orderdetailsservicesimpl();


    File fil;

    public orderdetailsclient(File file)
    {
        fil = file;
    }

    public void enterorderdetailsbytxt() {

        try

        {

            FileReader fr = null;

            fr = new FileReader(fil);

            BufferedReader br = new BufferedReader(fr);
            String s;
            int count = 0;
            String[] str, str2;
            StringBuilder sb = new StringBuilder();

            while ((s = br.readLine()) != null) {
                sb.append(s).append("\n");
                //  System.out.println(sb);
            }

            s = sb.toString();
            str = s.split("\n");
            for (String ts : str) {
                str2 = ts.split(",");
                orderDetail h = new orderDetail();
                h.setId(1);
                h.setOrderId(Integer.parseInt(str2[0]));
                h.setProductId(Integer.parseInt(str2[1]));
                h.setQuantity(Integer.parseInt(str2[2]));
                h.setPrice(Double.parseDouble(str2[3]));
                h.setAmount(Double.parseDouble(str2[4]));
                imp.createorderdetail(h);
            }
        } catch (IOException e) {
        }
    }


}

