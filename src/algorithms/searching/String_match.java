package algorithms.searching;

public class String_match {

	public static Boolean matchString(String sourceString, String subString){
		int subStringIndex = 0;
		Boolean match = false;
		for(int i =0; i<sourceString.length(); i++){
			if(subStringIndex>=subString.length()) {
				System.out.println(i + 1  - subString.length() + " - " + i);
				match = true;
				break;
			}
			else if(sourceString.charAt(i) == subString.charAt(subStringIndex)) {
//				System.out.println(sourceString.charAt(i)+""+subStringIndex);
				subStringIndex += 1;
			}
			else
				subStringIndex = 0;
		}
		if(subStringIndex >= subString.length()) {
			match = true;
		}
		return match;
		
	}
	
	public static void main(String[] args) {
		String source = "AppuAjith";
		String subString = "ajith";
		Boolean match = matchString(source.toLowerCase(),subString.toLowerCase());
		System.out.println("Match = " + match);
	}
}
