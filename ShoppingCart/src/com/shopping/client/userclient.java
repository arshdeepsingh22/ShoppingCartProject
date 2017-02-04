package com.shopping.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.shopping.domain.*;
import com.shopping.services.userservicesimpl;

/**
 * Created by 22arsh on 2/4/17.
 */
public class userclient {
    userservicesimpl imp = new userservicesimpl();
        File fil;
    public userclient(File file)
    {
        fil = file;
    }
      public void enterusersbytxt() {
          File fil = new File("/Users/22arsh/assignments/ShoppingCartProject/user.txt");
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
                  user h = new user(1, str2[0], str2[1], str2[2], str2[3]);
                  //imp.createuser(h);
                  imp.createuser(h);
              }
          } catch (IOException e) {
          }
      }


}
