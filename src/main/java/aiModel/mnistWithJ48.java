package aiModel;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;

public class mnistWithJ48 {
    public static void main(String[] args) throws Exception {


    //region File Reading
    BufferedReader bufferedReader = new BufferedReader(new FileReader("data.arff"));
    Instances train = new Instances(bufferedReader);
    train.setClassIndex(train.numAttributes() - 1);
    bufferedReader.close();
    //end region File Reading

    //region Classifier Training
    J48 tree = new J48();
        tree.buildClassifier(train);
    //end region Classifier Training

    //Monitor, NOT Force
    Evaluation eval = new Evaluation(train);
        // serialize model
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("MNISTj48.model"));
        oos.writeObject(tree);
        oos.flush();
        oos.close();
//        weka.core.SerializationHelper.write("/some/where/j48.model", tree);  // can use instead of last paragraph


    eval.evaluateModel(tree, train);
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
    //System.out.println(tree.graph());//text graph
    //System.out.println(tree.toString());//graphic graph
    //end Monitor
}}
