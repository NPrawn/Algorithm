import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] array = new int[31];
        
        for(int i = 1; i <= 28; i++)
        {
            int n = Integer.parseInt(br.readLine());
            array[n]++;
        }
        for(int i = 1; i <= 30; i++)
        {
            if(array[i] == 0)
                bw.write(i + "\n");
        }
        
        
        br.close();
        bw.close();
    }
}