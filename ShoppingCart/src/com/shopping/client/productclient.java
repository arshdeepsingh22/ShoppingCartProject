package com.shopping.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import com.shopping.domain.user;
import com.shopping.services.productservicesimpl;
import com.shopping.domain.*;
/**
 * Created by 22arsh on 2/4/17.
 */
public class productclient {
    productservicesimpl imp = new productservicesimpl();


    File fil;

    public productclient(File file)
    {
        fil = file;
    }

    public void enterproductsbytxt() {

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
                product h = new product(1, str2[0], str2[1], Double.parseDouble(str2[2]), Integer.parseInt(str2[3]));
                //imp.createuser(h);
                try {
                    imp.createproduct(h);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
        }
    }
}
