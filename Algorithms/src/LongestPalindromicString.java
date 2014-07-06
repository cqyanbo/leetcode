import java.util.HashMap;

/*********
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * 
 * @author Bo
 *
 */
public class LongestPalindromicString {
	
	public String longestPalindrome(String s) {
		if(s==null || s.length() <= 1){
			return s;
		}

		HashMap<String, Boolean> hm = new HashMap();
		String maxString = "";
		for(int i = 0; i < s.length(); i++){
			for(int j = s.length()-1; j > i; j--){
				String substring = s.substring(i, j+1);
				if(!hm.containsKey(substring)){
					hm.put(substring, isPalindrome(substring));
				}
				if(hm.get(substring)){
					if(substring.length() > maxString.length()){
						maxString = substring;
					}
				}
			}
		}
		
		return maxString;
    }
	
	private boolean isPalindrome(String s){
		if(s==null || s.length() <= 0){
			return false;
		}
		
		for(int i = 0, j = s.length()-1; i<j; i++, j--){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
		}
		
		return true;
	}
	
	public String betterLongestPalindrome(String s){
		if(s == null || s.length() <= 1){
			return s;
		}
		
		int[][] table = new int[s.length()][s.length()];
		
		for(int i = 0; i < s.length(); i++){
			table[i][i] = 1;
			
			if(i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){
				table[i][i+1] = 1;
			}
		}
		
		for(int i = s.length()-1; i >= 0; i--){
			for(int j = i; j < s.length(); j++){
				if(i+1 < s.length() && j -1 >= 0 && table[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j)){
					table[i][j] = 1;
				}
			}
		}
		
		
		
		String maxString = "";
		for(int i = 0; i < s.length(); i++){
			for(int j = s.length()-1; j > i; j--){
				if(j-i+1 > maxString.length() && table[i][j] == 1){
					maxString = s.substring(i, j+1);
				}
			}
		}
		
		return maxString;
	}
	
	public static void main(String[] args){
		LongestPalindromicString lps = new LongestPalindromicString();
		String s = "aaaaa";
		System.out.println(lps.longestPalindrome(s));
		System.out.println(lps.betterLongestPalindrome(s));
	}
}
