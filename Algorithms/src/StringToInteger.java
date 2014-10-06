import java.util.ArrayList;


public class StringToInteger {
	public int atoi(String str) {
        if(str == null || str.length() == 0){
        	return 0;
        }
        str = str.trim();
        char[] charInteger = str.toCharArray();
        ArrayList<Integer> number = new ArrayList<Integer>();
        // check if the number is negative
        boolean isNeg = (charInteger[0]=='-')?true:false;
        boolean isPos = (charInteger[0] == '+')?true:false;
        if(charInteger[0] != '-' && charInteger[0] != '+' && !Character.isDigit(charInteger[0])){
        	return 0;
        }
        
        // skip the first 0s
        int startPoint = 0;
        for(int i = (isNeg||isPos)?1:0; i < str.length(); i++){
        	char c = str.charAt(i);
        	if(!Character.isDigit(c)){
        		startPoint = i;
        		break;
        	}
        	
        	if(c == '0'){
        		continue;
        	}else{
        		startPoint = i;
        		break;
        	}
        }
        
        // figure out the usable part
        for(; startPoint < str.length(); startPoint++){
        	if(Character.isDigit(str.charAt(startPoint))){
        		number.add(str.charAt(startPoint)-'0');
        	}else{
        		break;
        	}
        }
        
        int result = 0;
        for(int i = 0; i < number.size(); i++){
        	result += number.get(i) * Math.pow(10, (number.size()-i-1)) * ((isNeg)?-1:1);
        }
        
        return result;
    }
	
	public static void main(String[] args){
		StringToInteger sti = new  StringToInteger();
		System.out.println(sti.atoi("-1"));
	}
}
