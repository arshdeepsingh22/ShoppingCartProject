package com.shopping.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopping.domain.*;
import com.shopping.services.orderservicesimpl;

/**
 * Created by 22arsh on 2/4/17.
 */
public class orderclient {
    orderservicesimpl imp = new orderservicesimpl();


    File fil;

    public orderclient(File file)
    {
        fil = file;
    }

    public void enterordersbytxt() {

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
                order h = new order();
                h.setId(1);
                java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
                h.setOrderDate(date);
                h.setAmount(Double.parseDouble(str2[0]));
                h.setUserId(Integer.parseInt(str2[1]));
                    List<orderDetail> od = new ArrayList<>();
                    od = null;
                    h.setOrderDetails(od);
                imp.createorder(h);
            }
        } catch (IOException e) {
        }
    }

}
