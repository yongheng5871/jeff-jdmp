import org.jdmp.core.dataset.DataSet;
import org.jdmp.core.sample.Sample;

public class TutorialUtil {

	public static String removeCarriage(String str) {
		if (str.length() == 0) {
			return str;
		} else {

			// remove all the characters('\r' '\n') from the end to begin
			int i = str.length() - 1;
			for (; i >= 0; i--) {
				char c = str.charAt(i);
				if (c == '\r' || c == '\n') {
					i--;
				} else {
					break;
				}
			}

			if (i >= 0) {
				return str.substring(0, i + 1);
			} else {
				return "";
			}
		}
	}

	public static void printDataSet(DataSet ds) {
		for (Sample sample : ds.getSamples()) {
			printSample(sample);
		}
	}

	public static void printSample(Sample sample){
		String featureString = TutorialUtil.removeCarriage(sample
				.getMatrix(Sample.INPUT).stringValue());
		String targetString = TutorialUtil.removeCarriage(sample.getMatrix(
				Sample.TARGET).stringValue());
		System.out.println(featureString + "\t" + targetString);
	}
	
	public static void main(String[] args) {
		System.out.println(removeCarriage("zjf\r\n"));
		System.out.println("end");
	}
}
