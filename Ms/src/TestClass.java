import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input
 
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
 
        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
 
        */
 
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[40];
        arr[0]=1;
        arr[1]=2;
        for(int i=2;i<40;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        StringBuilder sb = new StringBuilder();
        while(T!=0){
            int N = sc.nextInt();
            int track=0;
            String s = "";
            
            for(int i=39;i>=0;i--)
            {
                if(arr[i]<=N){
                    track=1;
                    s=s+"1";
                    N=N-arr[i];
                    continue;
                }
                if(track==1){
                    s=s+"0";
                }
            }
            //System.out.println(s);
            sb.append(s).append("\n");
            T--;
        }
        System.out.println(sb.toString());
    }
}