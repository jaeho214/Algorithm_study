## 저울

### 문제
https://programmers.co.kr/learn/courses/30/lessons/42886

### 접근법
답을 찾기 못해서 결국엔 다른 코드를 참고했다.   
오름차순으로 정렬하고, 구할 수 있는 무게에 +1을 하면 될 것이라고 생각한 접근은 맞았지만 구현하지 못했다.   
무게 1짜리 추로는 무게 1밖에 표현할 수 없다.   
무게 1짜리 두 개의 추로는 1과 2를 표현할 수 있다.   
무게 1짜리 두 개와 2짜리 한 개로는 1, 2, 3, 4 를 표현할 수 있다.   
그러나 5는 표현할 수가 없다.   
이미 사용할 수 있는 추들을 모두 사용하여 만든 최대의 무게에 +1을 하게 된다면 그 무게는 구할 수 없게 되는 것이다.   
결국은 추들의 무게의 합 + 1 = 추들이 측정할 수 없는 무게 라는 식이 성립된다.   
이 문제를 적용시켜보겠다.   
입력으로 주어진 무게들을 오름차순으로 정렬하면 [1, 1, 2, 3, 6, 7, 30] 이 된다.
무게 7까지의 추들을 모두 더하면 20이 되는데 이는 무게 20까지 표현이 가능하다는 뜻이다.   
그런데 다음 추는 30이기 때문에 다음으로 표현할 수 있는 무게는 30이 되어버린다.   
따라서 21부터 29까지의 무게를 주어진 추로는 표현할 수 없게 된다.



### 코드
```
import java.util.Arrays;   

class Solution {   
    public int solution(int[] weight) {   
        Arrays.sort(weight);   

        int num = 1;   

        for(int i=0;i<weight.length;i++){   
            if(num < weight[i])   
                break;   
            num += weight[i];   
        }   
        return num;   
    }   
}
```


