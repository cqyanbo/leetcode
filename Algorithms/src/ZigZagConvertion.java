
public class ZigZagConvertion {
	public String convert(String s, int nRows) {
		if(nRows <= 1) return s;
        StringBuilder[] list = new StringBuilder[nRows];
        for(int i = 0; i < nRows; i++) list[i] = new StringBuilder();
        int row = 0;
        int i = 0;
        boolean down = true;
        while(i < s.length()){
            list[row].append(s.charAt(i));
            if(row == 0) down = true;
            if(row == nRows-1) down = false;
            if(down) row++;
            else row --;
            i++;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list) res.append(sb.toString());
        return res.toString();
    }
}
