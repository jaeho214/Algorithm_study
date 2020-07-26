package programmers.level3;

public class Level3_자물쇠와열쇠 {
    public static void main(String[] args) {
        int key[][] = {{0,0,0}, {1,0,0}, {0,1,1}};
        int lock[][] = {{1,1,1}, {1,1,0}, {1,0,1}};
        Level3_자물쇠와열쇠 level3_자물쇠와열쇠 = new Level3_자물쇠와열쇠();
        System.out.println(level3_자물쇠와열쇠.solution(key, lock));
    }
    public boolean solution(int[][] key, int[][] lock) {

        for(int i=0;i<4;i++){
            key = rotate(key);
            if(isPossible(key, lock))
                return true;
        }

        return false;
    }

    private boolean isPossible(int[][] key, int[][] lock) {
        int[][] copy = new int[lock.length + key.length * 2][lock.length + key.length * 2];

        for(int i=0; i<lock.length;i++){
            for(int j=0;j<lock.length; j++){
                copy[i+key.length][j+key.length] = lock[i][j];
            }
        }

        for(int i=0;i<copy.length-key.length;i++){
            for(int j=0;j<copy.length-key.length;j++){
                if(check(i, j, key, copy))
                    return true;
            }
        }

        return false;
    }

    private boolean check(int x, int y, int[][] key, int[][] copy) {
        int[][] arr = new int[copy.length][copy.length];

        for(int i=0;i<arr.length;i++){
            arr[i] = copy[i].clone();
        }

        for(int i=0;i<key.length;i++){
            for(int j=0;j<key.length;j++){
                if(key[i][j] == 1)
                    arr[i+x][j+y]++;
            }
        }

        for(int i=key.length;i<arr.length-key.length;i++){
            for(int j=key.length;j<arr.length-key.length;j++){
                if(arr[i][j] != 1)
                    return false;
            }
        }

        return true;
    }

    private int[][] rotate(int[][] key){
        int copy[][] = new int[key.length][key.length];

        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                copy[i][j] = key[key.length-1-j][i];
            }
        }
        return copy;
    }
}
