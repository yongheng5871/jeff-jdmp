import org.jdmp.core.algorithm.classification.bayes.NaiveBayesClassifierTest;
import org.jdmp.core.algorithm.relationmining.MarketBasketAnalysis;
import org.jdmp.core.dataset.ClassificationDataSet;
import org.jdmp.core.dataset.DataSetFactory;
import org.jdmp.core.dataset.RelationalDataSet;
import org.jdmp.core.sample.RelationalSample;
import org.jdmp.libsvm.SVMClassifier;
import org.ujmp.core.Matrix;
import org.ujmp.core.MatrixFactory;
import org.ujmp.core.calculation.Calculation.Ret;
import org.ujmp.core.enums.FileFormat;

public class TestJDMP {

	public static void main(String[] args) throws Exception {

		 Matrix data = MatrixFactory.importFromFile(FileFormat.CSV,
		 "data/iris.data");
				
		 Matrix features=data.subMatrix(Ret.NEW, 0, 0, data.getRowCount()-1,
		 data.getColumnCount()-2);
		 Matrix targets=data.subMatrix(Ret.NEW, 0, data.getColumnCount()-1,
		 data.getRowCount()-1, data.getColumnCount()-1);

		 ClassificationDataSet ds=DataSetFactory.copyFromMatrix(features, targets);
		 NaiveBayesClassifierTest classifier = new NaiveBayesClassifierTest();
		 classifier.train(ds);
		 classifier.predict(ds);
		 System.out.println(ds.getAccuracy());
		 
		 testMarketAnlysis();
		//
		// Matrix test = MatrixFactory.importFromFile(FileFormat.CSV,
		// "data/test.csv");
		// Matrix output = classifier.predict(test);
		// System.out.println(output.toString());
		// ds.showGUI();

		// matrix.showGUI();
	}

	static void testLibSVM() throws Exception {
		ClassificationDataSet dataSet = DataSetFactory.IRIS();

		SVMClassifier svm = new SVMClassifier();

		svm.train(dataSet);
		svm.predict(dataSet);

		System.out.println(dataSet.getAccuracy());
//		 dataSet.showGUI();
	}
	
	static void testMarketAnlysis() throws Exception{
		RelationalDataSet dataSet = new RelationalDataSet();
		 
		RelationalSample s = new RelationalSample();
		s.addObject("Product 1");
		s.addObject("Product 2");
		s.addObject("Product 3");
		s.addObject("Product 4");
		dataSet.getSamples().add(s);
		 
		s = new RelationalSample();
		s.addObject("Product 1");
		s.addObject("Product 2");
		s.addObject("Product 3");
		dataSet.getSamples().add(s);
		 
		s = new RelationalSample();
		s.addObject("Product 1");
		s.addObject("Product 6");
		s.addObject("Product 7");
		dataSet.getSamples().add(s);
		 
		s = new RelationalSample();
		s.addObject("Product 7");
		s.addObject("Product 2");
		s.addObject("Product 3");
		s.addObject("Product 8");
		dataSet.getSamples().add(s);
		 
		s = new RelationalSample();
		s.addObject("Product 7");
		s.addObject("Product 4");
		s.addObject("Product 3");
		s.addObject("Product 8");
		dataSet.getSamples().add(s);
		
		MarketBasketAnalysis mba = new MarketBasketAnalysis();
		mba.setMinSupport(2);
		dataSet.showGUI();
		RelationalDataSet result = mba.calculate(dataSet);
		result.showGUI();
	}
}
