import java.io.*;
public class Ch1_OneEditProblem {
	/*package whatever //do not write package name here */

		public boolean oneAway(String s1, String s2){
		    if(s1.length() == s2.length())
		        return canReplaceChar(s1,s2);
		    if(s1.length() > s2.length())
		        return canInsertChar(s1,s2);
		   else
		        return canInsertChar(s1,s2);
		}
		
		public boolean canReplaceChar(String s1, String s2){
		    boolean isFirst = true;
		    for(int i=0; i<s1.length();i++){
		        if(s1.charAt(i) != s2.charAt(i)){
		            if(isFirst)
		                isFirst = false;
		           else
		                return false;
		        }
		    }
		    return true;
		}
		
		public boolean canInsertChar(String s1, String s2){
		    for(int index1=0,index2=0; index1 < s1.length() && index2 < s2.length();index1++,index2++){
		        if(s1.charAt(index1) != s2.charAt(index2)){
		            if(index1 != index2)
		                return false;
		           else
		                index1++;
		        }
		    }
		    return true;
		}
		
		public static void main (String[] args) {
			Ch1_OneEditProblem c = new Ch1_OneEditProblem();
			String s1 = "pale";
			String s2 = "bake";
			System.out.println(c.oneAway(s1,s2));
		}
	
}
