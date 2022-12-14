package preProcess;

import java.io.*;

//make arff file from Mnist
public class MnistPreProcess3 {
    public static void createArffFromDataset(String pathName) throws IOException {
        File file = new File(pathName);
        file.delete();
        file.createNewFile();
        FileWriter writer = new FileWriter(pathName);
        writer.append("@RELATION MnistDataset\n");

        for (int r = 1; r <= 28; r++) {
            for (int c = 1; c <= 28; c++) {
                writer.append("\n@ATTRIBUTE r").append(String.valueOf(r)).append("c").append(String.valueOf(c)).append(" NUMERIC");
            }
        }
        writer.append("\n@ATTRIBUTE class {0,1,2,3,4,5,6,7,8,9}\n\n@DATA");

        BufferedReader br = new BufferedReader(new FileReader("mnistVector.txt"));
        String line = br.readLine();
        writer.append("\n");
        while (line != null)
        {

            line = br.readLine();
            writer.append(line);
            writer.append("\n");

        }
        br.close();

        writer.close();
    }

    public static void main(String[] args) throws IOException {
        createArffFromDataset("data.arff");

    }
}

