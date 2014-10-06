import java.util.ArrayList;


public class ReverseInteger {
	public int reverse(int x){
        if(x < 10 && x > -10){
        	return x;
        }
        
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        int p = x;
        while(p != 0){
        	int tmp = p % 10;
        	p = p / 10;
        	integerList.add(tmp);
        }
        System.out.println(integerList);
        int size = integerList.size();
        
        int result = 0;
        
        for(int i = 0; i < size; i++){
    		result += integerList.get(i) * Math.pow(10, size-i-1);
        }
        

    	return result;
    }
	
	public static void main(String[] args){
		ReverseInteger ri = new ReverseInteger();
		
		System.out.println(ri.reverse(-123));
	}
}
