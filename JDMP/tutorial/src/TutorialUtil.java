public class TutorialUtil {

	public static String removeCarriage(String str) {
		if (str.length() == 0) {
			return str;
		} else {

			// remove all the characters('\r' '\n') from the end to begin 
			int i=str.length()-1;
			for (; i >= 0; i--) {
				char c = str.charAt(i);
				if (c == '\r' || c == '\n') {
					i--;
				}else{
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
	
	public static void main(String[] args) {
		System.out.println(removeCarriage("zjf\r\n"));
		System.out.println("end");
	}
}
