package aiModel;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;

public class mnistWithNaiveBayes {
    public static void main(String[] args) throws Exception {
        //region File Reading
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data.arff"));
        Instances train = new Instances(bufferedReader);
        train.setClassIndex(train.numAttributes() - 1);
        bufferedReader.close();
        System.out.println("loading data...........................................");

        NaiveBayes naiveBayes=new NaiveBayes();
        naiveBayes.buildClassifier(train);
        System.out.println("training model...........................................");

        // serialize model
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("MNISTnaiveBayes.model"));
        oos.writeObject(naiveBayes);
        oos.flush();
        oos.close();
        System.out.println("saving model..............................................");
        Evaluation eval = new Evaluation(train);

        eval.evaluateModel(naiveBayes, train);
        //System.out.println(eval.toSummaryString());
        System.out.println("______________________________________________");
        // *100  is because we need % from 100%
        System.out.println("eval.precision() = " + eval.precision(0) * 100);// we have 3 option in this datasource : (0)tested_positive,(1)tested_negative and (2)none, if result of eval.precision is down -> others grouped in the positve group, and machine learning is false
        System.out.println("eval.recall() = " + eval.recall(0)* 100);  // we have 3 option in this datasource : (0)tested_positive,(1)tested_positive and (2)none, if result of eval.recall is down -> none grouped in the other group, and machine learning is false
        System.out.println("eval.fMeasure0() = " + eval.fMeasure(0) * 100);  //we have 3 option in this datasource : (0)tested_positive,(1)tested_positive and (2)none, if result of eval.fMeasure() is down -> eval.precision+eval.recall = is down, and machine learning is false
        System.out.println("eval.fMeasure1() = " + eval.fMeasure(1) * 100);  //we have 3 option in this datasource : (0)tested_positive,(1)tested_positive and (2)none, if result of eval.fMeasure() is down -> eval.precision+eval.recall = is down, and machine learning is false
        System.out.println("eval.fMeasure2() = " + eval.fMeasure(2) * 100);  //we have 3 option in this datasource : (0)tested_positive,(1)tested_positive and (2)none, if result of eval.fMeasure() is down -> eval.precision+eval.recall = is down, and machine learning is false
        System.out.println("eval.fMeasure3() = " + eval.fMeasure(3) * 100);  //we have 3 option in this datasource : (0)tested_positive,(1)tested_positive and (2)none, if result of eval.fMeasure() is down -> eval.precision+eval.recall = is down, and machine learning is false
        System.out.println("eval.fMeasure4() = " + eval.fMeasure(4) * 100);  //we have 3 option in this datasource : (0)tested_positive,(1)tested_positive and (2)none, if result of eval.fMeasure() is down -> eval.precision+eval.recall = is down, and machine learning is false
        System.out.println("eval.fMeasure5() = " + eval.fMeasure(5) * 100);  //we have 3 option in this datasource : (0)tested_positive,(1)tested_positive and (2)none, if result of eval.fMeasure() is down -> eval.precision+eval.recall = is down, and machine learning is false
        System.out.println("eval.fMeasure6() = " + eval.fMeasure(6) * 100);  //we have 3 option in this datasource : (0)tested_positive,(1)tested_positive and (2)none, if result of eval.fMeasure() is down -> eval.precision+eval.recall = is down, and machine learning is false
        System.out.println("eval.fMeasure7() = " + eval.fMeasure(7) * 100);  //we have 3 option in this datasource : (0)tested_positive,(1)tested_positive and (2)none, if result of eval.fMeasure() is down -> eval.precision+eval.recall = is down, and machine learning is false
        System.out.println("eval.fMeasure8() = " + eval.fMeasure(8) * 100);  //we have 3 option in this datasource : (0)tested_positive,(1)tested_positive and (2)none, if result of eval.fMeasure() is down -> eval.precision+eval.recall = is down, and machine learning is false
        System.out.println("eval.fMeasure9() = " + eval.fMeasure(9) * 100);  //we have 3 option in this datasource : (0)tested_positive,(1)tested_positive and (2)none, if result of eval.fMeasure() is down -> eval.precision+eval.recall = is down, and machine learning is false
        System.out.println("______________________________________________");


    }


}
