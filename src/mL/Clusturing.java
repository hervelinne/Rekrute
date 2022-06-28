package mL;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFrame;
import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.trees.J48;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
import weka.core.Debug.Random;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

public class Clusturing {

	public static void main(String args[]) throws Exception{
		// TODO Auto-generated method stub
		//load data
				Instances data = new Instances(new BufferedReader(new FileReader("data/offre3.arff")));
				String[] opts = new String[] { "-R", "1" };
				Remove remove = new Remove();
				remove.setOptions(opts);
				remove.setInputFormat(data);
				data = Filter.useFilter(data, remove);
				// new instance of clusterer
				EM model = new EM();
				// build the clusterer
				model.buildClusterer(data);
				System.out.println(model);
				
				double logLikelihood = ClusterEvaluation.crossValidateModel(model, data, 10, new Random(1));
				System.out.println(logLikelihood);
	}

}
