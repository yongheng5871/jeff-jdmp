import java.io.IOException;
import java.util.List;

import org.jdmp.core.dataset.DataSet;
import org.ujmp.core.exceptions.MatrixException;

public class SplitDataSet {

	static List<DataSet> split(DataSet ds) {
		List<DataSet> parts = ds.splitByPercent(true, 0.2, 0.8);
		return parts;
	}

	public static void main(String[] args) throws MatrixException, IOException {
		DataSet ds = CreateDataSet.createDataSet();
		List<DataSet> parts = split(ds);
		
		for (DataSet part : parts) {
			System.out.println(part.getSamples().getSize());
			TutorialUtil.printDataSet(part);
		}
	}

}
