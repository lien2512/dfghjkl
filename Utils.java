import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.io.*;
public class Utils {
    private static final String FileIn = "C:\\Lab9";
    public static String readContentFromFile(String path)
    {
        String s = "";
        try {
            File file = new File(path);
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line = in.readLine();
            //s = s + line;
            while(line != in.readLine())
            {
                s = s + line +"\n";
                line = in.readLine();

            }
            in.close();
        }
        catch (Exception e) {
        }
        return s;
    }
//    public static void  writeContentToFile(String path) throws IOException
//    {
//
//        BufferedWriter file = null;
//        try {
//            file = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"));
//            String s = "noi dung can viet vao file\n";
//            file.write(s + "\n");
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        file.close();
//
//    }
    public static void add(String path)
    {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            String content = "Nội dung mình muốn viết vào file\n";
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static File findFileByName(String folderPath, String fileName) {



        File file = new File(folderPath);
        File[] matchingFiles = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.equals(fileName);
            }
        });
        return matchingFiles.length != 0 ? matchingFiles[0] : null;


    }



    public static void main(String[] args) throws IOException {

        System.out.println(readContentFromFile("C:\\Lab9\\test.txt"));
        //writeContentToFile("C:\\Lab9\\test.txt");
        add("C:\\Lab9\\test.txt");
        File find = findFileByName("C:\\Lab9","test.txt");
        System.out.println(find.getAbsoluteFile());

    }
}