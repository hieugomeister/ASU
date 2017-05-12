import java.util.*; 

public class Pascal
{ 
    public static final int ROW = 9;
    private static int max = 0;

    public static void main(String[] args)
    { 
    	int len = 0;
    	int[][] pascal  = new int[ROW +1][];
        pascal[1] = new int[3];
        pascal[1][1] = 1;
        System.out.println(pascal[1][1]);
        for (int i = 2; i <= ROW; i++)
        {        	
            pascal[i] = new int[i + 2]; 
            
            for (int j = 1; j < pascal[i].length - 1; j++)
            {
            	System.out.println("Inner loop i, j = " + i + ", " + j);
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                System.out.println(pascal[i][j]);
                String str = Integer.toString(pascal[i][j]);
                len = str.length();
                if (len > max)
                    max = len;
            }
        }


        for (int i = 1; i <= ROW; i++) {                
            for (int k = ROW; k > i; k--)
                System.out.format("%-" + max + "s", " ");
            for (int j = 1; j < pascal[i].length - 1; j++)                      
                System.out.format("%-" + (max + max) + "s",  pascal[i][j]);
            System.out.println();
        }
    }
}

/*

public class Pascal
{ 
    public static void main(String[] args)
    { 
        int N = 9;
        int[][] pascal  = new int[N+1][];

        // initialize first row
        pascal[1] = new int[3];
        pascal[1][1] = 1;

        // fill in Pascal's triangle
        for (int i = 2; i <= N; i++)
        {
            pascal[i] = new int[i + 2];
            for (int j = 1; j < pascal[i].length - 1; j++)
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
        }

        // print results
        for (int i = 1; i <= N; i++)
        {
        	System.out.println("size = " + (pascal[i].length));
            for (int j = 1; j < pascal[i].length - 1; j++)
            {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
        }
    }
}
*/