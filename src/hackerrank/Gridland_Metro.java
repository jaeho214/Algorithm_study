package hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

/*
 * 구간의 중복을 찾아냈어야 했는데 정렬을 할 생각을 못했당.
 * 구현실력 모자람
 */
public class Gridland_Metro {
    static class Pair{
        int row, start, end;

        public Pair(int row, int start, int end) {
            this.row = row;
            this.start = start;
            this.end = end;
        }

        public int getRow() {
            return row;
        }

        public int getStart() {
            return start;
        }
    }

    static String gridlandMetro(int n, int m, int k, int[][] track) {
        BigInteger total = BigInteger.valueOf(n).multiply(BigInteger.valueOf(m));
        if(k == 0){
            return total.toString();
        }

        List<Pair> trackList = new ArrayList<>();

        for(int[] t : track)
            trackList.add(new Pair(t[0], t[1], t[2]));

        trackList.sort(Comparator.comparingInt(Pair::getRow).thenComparing(Pair::getStart));

        List<Pair> list = new ArrayList<>();
        int idx = 1;
        int row = trackList.get(0).row;
        int start = trackList.get(0).start;
        int end = trackList.get(0).end;

        while(idx < trackList.size()){

            if(trackList.get(idx).row != row){
                list.add(new Pair(row, start, end));
                row = trackList.get(idx).row;
                start = trackList.get(idx).start;
                end = trackList.get(idx).end;
                idx ++;
                continue;
            }
            if(trackList.get(idx).start <= end){
                end = Math.max(end, trackList.get(idx).end);
            }else{
                list.add(new Pair(row, start, end));
                start = trackList.get(idx).start;
                end = trackList.get(idx).end;
            }
            idx ++;
        }
        list.add(new Pair(row, start, end));

        for(Pair pair : list){
            total = total.subtract(BigInteger.valueOf(pair.end - pair.start + 1));
        }

        return total.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmk[0]);

        int m = Integer.parseInt(nmk[1]);

        int k = Integer.parseInt(nmk[2]);

        int[][] track = new int[k][3];

        for (int i = 0; i < k; i++) {
            String[] trackRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int trackItem = Integer.parseInt(trackRowItems[j]);
                track[i][j] = trackItem;
            }
        }

        String result = gridlandMetro(n, m, k, track);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }


}
