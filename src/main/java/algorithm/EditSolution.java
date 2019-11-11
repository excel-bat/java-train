package algorithm;

/**
 * @author shanyb@uxsino.com
 * @title: EditSolution
 * @ticketNO: #
 * @description: 编辑距离DP
 * @create: 2019-10-28 15:53
 */
public class EditSolution {


    public static int editDistance(int x,int y,char[] xchar,char[] ychar){

        if(x ==0 ){
            return y;
        }
        if(y == 0){
            return  x;
        }
        if(xchar[x]==ychar[y]){ return editDistance(x-1,y-1,xchar,ychar);}

        return Math.min(Math.min(editDistance(x-1,y,xchar,ychar)+1,editDistance(x,y-1,xchar,ychar)+1),editDistance(x-1,y-1,xchar,ychar)+1);

    }

    public static void main(String[] args) {


        char[] xchar = "25433adf".toCharArray();
        char[] ychar = "25436ad3".toCharArray();
        int[] result = new int[xchar.length+ychar.length];
        for (int i = 0; i < result.length-1; i++) {

            result[i] = -1;
        }
        System.out.println(editDistance(xchar.length-1,ychar.length-1,xchar,ychar));
    }
}
