import java.io.*;
import java.util.Arrays;


public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = bf.readLine();
        String[] numbers = line.split(" ");
        int N = Integer.parseInt(numbers[0]);
        int goal = Integer.parseInt(numbers[1]);
        int broken = Integer.parseInt(numbers[2]);

        int[] arr = new int[broken];
        for (int i=0; i<broken; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);

        int[] inside = new int[broken+1];
        inside[0] = arr[0]-1;
        for (int i=0; i<arr.length-1; i++) {
            inside[i+1] = arr[i+1]-arr[i]-1;
        }
        inside[broken] = N - arr[broken - 1];

        int ans = -1;
        for (int i=0; i<inside.length; i++) {
            if (inside[i] >= goal) {
                ans = 0;
                break;
            }
        }
        if (ans == -1) {
            for (int fixed = 1; fixed <= broken; fixed++) {
                int consecutive = 0;
                int left = 0;
                for (int i = 0; i <= fixed; i++) {
                    consecutive += inside[i];
                }
                if (consecutive + fixed >= goal) {
                    ans = fixed;
                    break;
                }
                for (int right = left + fixed + 1; right < inside.length; right++, left++) {
                    consecutive -= inside[left];
                    consecutive += inside[right];
                    if (consecutive + fixed >= goal) {
                        ans = fixed;
                        break;
                    }
                }
                if (ans != -1) {
                    break;
                }
            }
        }
        bufferedWriter.write(ans+"\n");
        bufferedWriter.flush();
    }
}
