import java.io.*;
import java.util.HashMap;


public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = bf.readLine();
        String[] numbers = line.split(" ");
        int tableSiz = Integer.parseInt(numbers[0]);
        int sushiKind = Integer.parseInt(numbers[1]);
        int consecutive = Integer.parseInt(numbers[2]);
        int coupon = Integer.parseInt(numbers[3]);
        int[] table = new int[tableSiz];
        for (int i=0; i<tableSiz; i++) {
           table[i] = Integer.parseInt(bf.readLine());
        }
        HashMap<Integer, Integer> belly = new HashMap<>();
        for (int i=0; i<consecutive; i++) {
            belly.put(table[i], belly.getOrDefault(table[i], 0)+1);
        }

        int max = 0;
        for (int i=consecutive; i<tableSiz; i++) {
            if (belly.get(table[i-consecutive]) == 1) {
                belly.remove(table[i-consecutive]);
            }
            else {
                belly.put(table[i - consecutive], belly.get(table[i-consecutive])-1);
            }
            belly.put(table[i], belly.getOrDefault(table[i], 0)+1);
            if (belly.keySet().contains(coupon)) {
                max = Math.max(max, belly.keySet().size());
            }
            else {
                max = Math.max(max, belly.keySet().size()+1);
            }
        }

        //one more round
        for (int i=0; i<consecutive; i++) {
            if (belly.get(table[tableSiz+i-consecutive]) == 1) {
                belly.remove(table[tableSiz+i-consecutive]);
            }
            else {
                belly.put(table[tableSiz+i-consecutive], belly.get(table[tableSiz+i-consecutive])-1);
            }
            belly.put(table[i], belly.getOrDefault(table[i], 0)+1);
            if (belly.keySet().contains(coupon)) {
                max = Math.max(max, belly.keySet().size());
            }
            else {
                max = Math.max(max, belly.keySet().size()+1);
            }
        }

        bufferedWriter.write(max+"\n");
        bufferedWriter.flush();
    }
}
