import java.io.IOException;

import org.jdmp.core.algorithm.classification.bayes.NaiveBayesClassifier;
import org.jdmp.core.algorithm.relationmining.MarketBasketAnalysis;
import org.jdmp.core.dataset.ClassificationDataSet;
import org.jdmp.core.dataset.DataSetFactory;
import org.jdmp.core.dataset.RelationalDataSet;
import org.jdmp.core.sample.ClassificationSample;
import org.jdmp.core.sample.RelationalSample;
import org.jdmp.core.sample.Sample;
import org.jdmp.libsvm.SVMClassifier;

public class TestJDMP {

	public static void main(String[] args) throws Exception {

		ClassificationDataSet ds = DataSetFactory.IRIS();

		NaiveBayesClassifier classifier = new NaiveBayesClassifier();
		classifier.train(ds);
		classifier.predict(ds);
		for (Sample sample : ds.getSamples()) {
			ClassificationSample cSample = (ClassificationSample) sample;
			if(cSample.isCorrect()){
				TutorialUtil.printSample(cSample);
			}
		}
		// testLibSVM();
	}

	private static void test() throws IOException, Exception {

	}

	static void testLibSVM() throws Exception {
		ClassificationDataSet dataSet = DataSetFactory.IRIS();

		SVMClassifier svm = new SVMClassifier();

		svm.train(dataSet);
		svm.predict(dataSet);

		System.out.println("Accuracy:" + dataSet.getAccuracy());
		// dataSet.showGUI();
	}

	static void testMarketAnlysis() throws Exception {
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
