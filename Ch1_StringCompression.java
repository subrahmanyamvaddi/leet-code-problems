import java.io.*;
import java.util.ArrayList;

public class Ch1_StringCompression {
	
	public String compressString(String s) {
		ArrayList<Character> str = new ArrayList<>();
		
		int count = 1;
		for(int i=1; i<s.length();i++) {
			if(s.charAt(i) != s.charAt(i-1)) {
				str.add(s.charAt(i-1));
				str.add((char)(count + '0'));
				count = 1;
			}
			else
				count++;
		}
		str.add(s.charAt(s.length()-1));
		str.add((char)(count + '0'));
		String s2 = str.toString();
		if(s2.length() < s.length())
			return s;
		
		return str.toString();
	}
	
	public static void main(String[] args) {
		String s = "aabcccccaaa";
		
		Ch1_StringCompression sc = new Ch1_StringCompression();
		System.out.println(sc.compressString(s));
	}
}
