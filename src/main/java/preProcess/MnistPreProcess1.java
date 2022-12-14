package preProcess;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;

// read image by opencv and convert to vector
public class MnistPreProcess1 {
    public static void main(String[] args) throws IOException {
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
        LinkedHashSet<String> results = new LinkedHashSet<String>();
        File[] files = new File("resource\\MNIST Dataset JPG format\\MNIST Dataset JPG format\\MNIST - JPG - training\\9").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
//        System.out.println(results);
        String result="result\\result9.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(result));
        for (String fName:results) {
            String input = ".\\resource\\MNIST Dataset JPG format\\MNIST Dataset JPG format\\MNIST - JPG - training\\9\\"+fName;
            Imgcodecs imageCodecs = new Imgcodecs();
            // Reading the image
//            System.out.println(input);
            Mat src = imageCodecs.imread(input, Imgcodecs.IMREAD_GRAYSCALE);
            byte[] data1 = new byte[src.rows() * src.cols() * (int) (src.elemSize())];
//            System.out.println(src.rows());
//            System.out.println(data1.length);
            src.get(0, 0, data1);
            for (int j = 0; j <src.rows()*src.cols() ; j++) {
//                System.out.println(String.valueOf(data1[i]));
            writer.write(String.valueOf(data1[j]));
            writer.write(",");
            }
            writer.write("9");
writer.newLine();
        }
        writer.close();

        }
    }

