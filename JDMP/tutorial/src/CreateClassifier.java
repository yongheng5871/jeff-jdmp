import org.jdmp.core.algorithm.classification.Classifier;
import org.jdmp.core.dataset.ClassificationDataSet;
import org.jdmp.core.dataset.DataSetFactory;
import org.jdmp.core.sample.ClassificationSample;
import org.jdmp.core.sample.Sample;
import org.jdmp.libsvm.SVMClassifier;
import org.ujmp.core.Matrix;
import org.ujmp.core.MatrixFactory;
import org.ujmp.core.calculation.Calculation.Ret;
import org.ujmp.core.enums.FileFormat;
import org.ujmp.core.enums.ValueType;

public class CreateClassifier {

	static void classify() throws Exception {

		Matrix data = MatrixFactory.importFromFile(FileFormat.CSV,
				"data/iris.data");

		Matrix features = data.selectColumns(Ret.NEW, 0, 1, 2, 3);
		Matrix targets = data.selectColumns(Ret.NEW, 4).discretizeToColumns(0);

		ClassificationDataSet ds = DataSetFactory.copyFromMatrix(features
				.convert(ValueType.DOUBLE), targets.convert(ValueType.DOUBLE));
		Classifier classifier = new SVMClassifier();
		classifier.train(ds);
		classifier.predict(ds);
		System.out.println("Accuracy:" + ds.getAccuracy());

		/////////////////// print the samples that can not be predicted correctly ////////////////// 
		System.out.println("Samples that can not be predicted corretly:");
		for (Sample sample : ds.getSamples()) {
			ClassificationSample cSample = (ClassificationSample) sample;
			if (!cSample.isCorrect()) {
				TutorialUtil.printSample(cSample);
			}
		}

		
		
		
		//////////////////////////// Compute the precision and recall /////////////////
		int[] totalCorrect = new int[3];
		int[] totalTarget = new int[3];
		int[] totalPredict = new int[3];

		for (Sample sample : ds.getSamples()) {
			ClassificationSample cSample = (ClassificationSample) sample;
			int targetIndex=cSample.getTargetClass();
			int predictIndex=cSample.getRecognizedClass();
			if (targetIndex==predictIndex){
				totalCorrect[targetIndex]++;
			}
			totalPredict[predictIndex]++;
			totalTarget[targetIndex]++;
		}

		for (int i=0;i<3;++i){
			System.out.println("Class "+i+":");
			System.out.print("Precision:"+totalCorrect[i]/(totalPredict[i]+0.0));
			System.out.println("\tRecall:"+totalCorrect[i]/(totalTarget[i]+0.0));
		}
	}

	public static void main(String[] args) throws Exception {
		classify();
	}
}
