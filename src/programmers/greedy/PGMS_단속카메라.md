###문제
https://programmers.co.kr/learn/courses/30/lessons/42884

### 접근법
같은 시점에 달리고 있는 차량은 하나의 단속 카메라로 커버가 가능하다.   
진입 지점과 진출 지점이 교차하는 경우에 두 차량은 같은 시점에 달리고 있다고 판단하였다.   
일단 진출 지점을 기준으로 오름차순으로 나열하였다.   
max라는 값에 진출 지점을 갱신하면서 진입 지점과 교차하지 않는 경우를 찾아 answer에 카운트 해주었다. 


### 코드
```
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        int max = Integer.MIN_VALUE;

        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        for(int i=0;i<routes.length;i++) {
            if(max < routes[i][0]) {
                max = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}
```