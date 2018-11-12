import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import java.util.List;
public class test {

    public  List<String> getAllFunctions(File path)
    {
        List<String> list = new ArrayList<String>();

        try {
            File file = path;
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line ;

            while((line = in.readLine()) != null)
            {

                if((line.contains("public static") ||(line.contains("//")&&line.contains("public static")) ||(line.contains("/*") &&line.contains("public static")))&& !line.contains(";"))
                {
                    list.add(line);
                }
                //line = in.readLine();
            }
            in.close();
        }
        catch (Exception e) {
        }
        return list;
    }
    public static void in(List<String> l)
    {
        for(int i = 0;i< l.size();i++)
        {
            System.out.println(l.get(i));
        }
    }
    public String findFunctionByName(String name)
    {
        System.out.println("câu b : ");
        String s ="";
        int count1 = 0;
        int count2 = 0;
        int n = name.indexOf(",");
        String st = name.substring(0,n);
        int i = 0;
        int j  = 0;
        try {
            File file = new File("C:\\Lab9\\src\\Utils.java");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line ;

            while(( line = in.readLine()) != null)
            {

                if(line.contains(st)) {

                    //s = s + line + "\n";
                    i++;
                }
                if(i>0 )
                {
                    s = s+ line + "\n";
                    if(line.contains("{"))
                    {
                        count1 ++;
                    }
                    else if(line.contains("}"))
                    {
                        count2 ++;
                    }
                    if(count1 == count2 && count1 != 0)
                    {
                        break;
                    }

                }


            }


            in.close();
        }
        catch (Exception e) {
        }
        return s;
    }
    public static void main(String[] args) {
        test so = new test();
        File test = new File("C:\\Lab9\\src\\Utils.java");
        in(so.getAllFunctions(test));
        System.out.println();
        System.out.println(so.findFunctionByName("findFileByName(String,String)"));

    }
}
