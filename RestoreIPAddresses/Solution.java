package RestoreIPAddresses;

import java.util.*;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

    For example:
    Given "25525511135",

    return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 * Created by aoshen on 4/30/16.
 */
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        String item = new String();
        if (s.length()<4||s.length()>12)
            return res;

        dfs(s, 0, item, res);
        return res;
    }

    public void dfs(String s, int start, String item, ArrayList<String> res){
        if (start == 3 && isValid(s)) {
            res.add(item + s);
            return;
        }
        for(int i=0; i<3 && i<s.length()-1; i++){
            String substr = s.substring(0,i+1);
            if (isValid(substr))
                dfs(s.substring(i+1, s.length()), start+1, item + substr + '.', res);
        }
    }

    public boolean isValid(String s){
        if (s.charAt(0)=='0')
            return s.equals("0");
        int num = Integer.parseInt(s);

        if(num <= 255 && num > 0)
            return true;
        else
            return false;
    }
}
