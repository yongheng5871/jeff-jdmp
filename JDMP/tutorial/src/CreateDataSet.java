import java.io.IOException;

import org.jdmp.core.dataset.ClassificationDataSet;
import org.jdmp.core.dataset.DataSetFactory;
import org.jdmp.core.sample.Sample;
import org.ujmp.core.Matrix;
import org.ujmp.core.MatrixFactory;
import org.ujmp.core.calculation.Calculation.Ret;
import org.ujmp.core.enums.FileFormat;
import org.ujmp.core.exceptions.MatrixException;

public class CreateDataSet {

	public static void main(String[] args) throws MatrixException, IOException {

		Matrix data = MatrixFactory.importFromFile(FileFormat.CSV,
				"data/iris.data");

		Matrix features = data.subMatrix(Ret.NEW, 0, 0, data.getRowCount() - 1,
				data.getColumnCount() - 2);
		Matrix targets = data.subMatrix(Ret.NEW, 0, data.getColumnCount() - 1,
				data.getRowCount() - 1, data.getColumnCount() - 1);

		ClassificationDataSet ds = DataSetFactory.copyFromMatrix(features,
				targets);

		for (Sample sample : ds.getSamples()) {
			String featureString = TutorialUtil.removeCarriage(sample
					.getMatrix(Sample.INPUT).stringValue());
			String targetString = TutorialUtil.removeCarriage(sample.getMatrix(
					Sample.TARGET).stringValue());
			System.out.println(featureString + "\t" + targetString);
		}
	}
}
