package algorithm.normal;

/**
 * @author shanyb
 */
public class BigIntergerSimulation {
    
    public String add(String num1, String num2) {
        StringBuffer res = new StringBuffer("");
        
        //初始化
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        
        while (i >= 0 || j >= 0) {
            
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            
            int temp = a + b + carry;
            
            carry = temp / 10;
            
            res = res.append(temp % 10);
            i--;
            j--;
        }
        
        if (carry == 1) {
            res.append(1);
        }
        
        return res.reverse().toString();
    }
}
