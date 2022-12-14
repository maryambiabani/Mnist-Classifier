package preProcess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//merge all vector together
public class MnistPreProcess2 {

    public static void main(String[] args) throws IOException
    {

        List<String> results = new ArrayList<String>();

        File[] files = new File(".\\result").listFiles();
//If this pathname does not denote a directory, then listFiles() returns null.
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
        // PrintWriter object for file3.txt
        PrintWriter pw = new PrintWriter("mnistVector.txt");
        for (String f:results){
            // BufferedReader object for file1.txt
            BufferedReader br = new BufferedReader(new FileReader(".\\result\\"+f));
            String line = br.readLine();
            // loop to copy each line of
            // file1.txt to  file3.txt
            while (line != null)
            {
                pw.println(line);
                line = br.readLine();

            }
            br.close();
        }
        pw.flush();
        // closing resources
        pw.close();
    }
}
