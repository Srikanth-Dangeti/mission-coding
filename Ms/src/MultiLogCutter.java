
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class MultiLogCutter {
    public MultiLogCutter() {
        super();
    }
    public static void main(String[] args) throws Exception {
        String inputFolderPath = "C:\\Users\\rkdikshi\\Downloads\\New folder\\New folder\\";
        listAllFiles(new File(inputFolderPath));
    }
    // Uses listFiles method
    public static void listAllFiles(File folder) {
        System.out.println("In listAllfiles(File) method");
        File[] fileNames = folder.listFiles();
        for (File file : fileNames) {
            // if directory call the same method again
            if (file.isDirectory()) {
                listAllFiles(file);
            } else {
                try {
                    readandFiletrContent(file);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    private static void readandFiletrContent(File file) {
        String outPutFolderPath = "C:\\Users\\rkdikshi\\Downloads\\New folder\\";
        String searchString = "Configuration Owner Tax Option";
        FileInputStream fis = null;
        BufferedReader reader = null;
        FileOutputStream fos = null;
        PrintWriter out = null;
        try {
            if (!file.canRead())
                file.setReadable(true);
            if (file.exists() && !file.canWrite()) {
                file.setWritable(true);
            }
            fis = new FileInputStream(file); //TODO replace file name
            //fis = new FileInputStream("D:\\GE Issue\\ess_serverHA\\logs\\apps\\ess_serverHA-diagnostic-58.log"); //TODO replace file name
            reader = new BufferedReader(new InputStreamReader(fis));
            String line = reader.readLine();
            while (line != null) {
                int index = line.lastIndexOf(searchString);
                //   int index= line.lastIndexOf("InterfaceLoaderController");
                if (index != -1) {
                    String remainingString = line; 
                   // System.out.println("Search String Found in file " + file.getName());
                  System.out.println(line);
                  System.out.println("in "+outPutFolderPath + file.getName());
                    out = new PrintWriter(outPutFolderPath + file.getName()); //TODO tweak filename
                    out.println(remainingString);
                }
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                fis.close();
              if(out!=null)
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}