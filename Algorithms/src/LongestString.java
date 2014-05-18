import java.util.Arrays;

/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestString {
	
	public static int lengthOfLongestSubstring(String s) {
	   if(s.length() == 0){
		   return 0;
	   }
       int[] counter = new int[256];
       Arrays.fill(counter, -1);
       int Max = 1;
       int start = 0;
       counter[s.charAt(0)] = 0;
       for(int i = 1; i < s.length(); i++){
    	   if(counter[s.charAt(i)] >= start){
    		   start = counter[s.charAt(i)] + 1;
    	   }
    	   Max = Math.max(Max, i - start + 1);
    	   counter[s.charAt(i)] = i;
       }
        
       return Max;
    }
	
	public static void main(String[] args){
		String test = "c";
		System.out.println(LongestString.lengthOfLongestSubstring(test));
	}

}
