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

public class Classification {
	
	public String Prediction(int p, int r, int c, int n, int a) {
        
	 try {
		 /*// Change data from CSV to Arff
	        CSVLoader loader = new CSVLoader();
	        loader.setSource(new File("/Users/mimi/Downloads/offre-1.csv"));
	        Instances data = loader.getDataSet();
	        ArffSaver save = new ArffSaver(); 
	        save.setInstances(data);
	        save.setFile(new File("/Users/mimi/Downloads/offre2.arff"));
	        save.writeBatch();*/
		 
         //Load data : 
    	ConverterUtils.DataSource source = new ConverterUtils.DataSource("data/offre1_arf.arff");
    	Instances data = source.getDataSet();
		System.out.println(data.numInstances() + " instances loaded.");
            //System.out.println(data);
            
            //remove id attribute : 
		
		String[] opts = new String[] { "-R", "1" };
		Remove remove = new Remove();
		remove.setOptions(opts);
		remove.setInputFormat(data);
		data = Filter.useFilter(data, remove);
            //System.out.println(data);

		
		
		
            
		  //set attribute of class index manually :
				data.setClassIndex(data.numAttributes()-4);
            
            /*
	 * Feature selection
	 */
	AttributeSelection attSelect = new AttributeSelection();
	InfoGainAttributeEval eval = new InfoGainAttributeEval();
	Ranker search = new Ranker();
	attSelect.setEvaluator(eval);
	attSelect.setSearch(search);
	attSelect.SelectAttributes(data);
	int[] indices = attSelect.selectedAttributes();
	//System.out.println("Selected attributes: "+Utils.arrayToString(indices));
            
            
        //build decision tree
        String[] options = new String[1];
		options[0] = "-U"; // choix parmis arbre de decisions pas qu'un seul cas
		J48 tree = new J48();
		tree.setOptions(options);
		tree.buildClassifier(data);
		System.out.println(tree);
            

            
        /*
		 * Classify new instance.
		 */
		double[] vals = new double[data.numAttributes()];
		vals[0] = p; //poste
		vals[1] = r; //region
		//vals[2] = 0.0; // Entreprise
		vals[3] = c; //typedecontrat
	    vals[4] = n; //niv d'etude
	    vals[5] = a;//annee d'experiences 
            
           // System.out.println(data.numAttributes());
	    
	
	 
	 // catsize {false, true}
	Instance myUnicorn = new DenseInstance(1.0, vals);
	//Assosiate your instance with Instance object in this case dataRaw
	myUnicorn.setDataset(data); 
            
            System.out.println("The instance: " + myUnicorn);
            
            double label = tree.classifyInstance(myUnicorn);
            String val = data.classAttribute().value((int) label); 
            System.out.println(val);
           
            
            /*
    		 * Visualize decision tree
    		 */
    		/*TreeVisualizer tv = new TreeVisualizer(null, tree.graph(),
    				new PlaceNode2());
    		JFrame frame = new javax.swing.JFrame("Tree Visualizer");
    		frame.setSize(800, 500);
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.getContentPane().add(tv);
    		frame.setVisible(true);
    		tv.fitToScreen();*/
     /*
	 * Evaluation
	 */

	weka.classifiers.Classifier cl = new J48();
	Evaluation eval_roc = new Evaluation(data);
	eval_roc.crossValidateModel(cl, data, 10, new Random(1), new Object[] {});
	System.out.println(eval_roc.toSummaryString());
	// Confusion matrix
	double[][] confusionMatrix = eval_roc.confusionMatrix();
	System.out.println(eval_roc.toMatrixString());
	
	 return val; 
        
    }catch(Exception e){
        System.out.println(e.getMessage());
        return null; 
    }
	}
public static void main(String[] args) {
		Classification  c = new Classification(); 
		c.Prediction(1, 1, 1,1, 1); 
    }
}

