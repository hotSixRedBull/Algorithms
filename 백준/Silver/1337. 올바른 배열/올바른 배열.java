import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = bf.readLine();
        int siz = Integer.parseInt(line);
        int[] arr = new int[siz];
        for (int i=0; i<siz; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);

        int minNeed = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) {
            Set<Integer> findSet = new HashSet<>();
            Set<Integer> haveSet = new HashSet<>();
            for (int j=0; j<5; j++) {
                findSet.add(arr[i]-j);
                if (i - j >= 0) {
                    haveSet.add(arr[i - j]);
                }
            }
            findSet.removeAll(haveSet);
            minNeed = Math.min(minNeed, findSet.size());
        }

        bufferedWriter.write(minNeed+"\n");
        bufferedWriter.flush();
    }
}
