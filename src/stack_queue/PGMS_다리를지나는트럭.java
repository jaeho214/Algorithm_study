package stack_queue;

import java.util.LinkedList;
import java.util.Queue;
/*
 * https://stroot.tistory.com/123
 * 나는 규칙을 찾아서 해결하려고 했는데 모든 가능성을 카운트하는 방식으로 해결했다.
 */
public class PGMS_다리를지나는트럭 {
    public class Truck{
        private int weight;
        private int position;
        public Truck(int weight, int position) {
            this.weight = weight;
            this.position = position;
        }
    }

    public static void main(String[] args) {
        PGMS_다리를지나는트럭 pgms_다리를지나는트럭 = new PGMS_다리를지나는트럭();
        int[] truck_weights = {1,1,1,1};
        System.out.println(pgms_다리를지나는트럭.solution(4,2, truck_weights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //트럭들이 이동하는 모든 횟수를 카운트함
        int answer = 0;

        //대기 중인 트럭
        Queue<Truck> trucks = new LinkedList<>();
        //다리위를 이동 중인 트럭
        Queue<Truck> movingTrucks = new LinkedList<>();

        for(int i : truck_weights){
            trucks.add(new Truck(i, 0));
        }

        //대기 중인 트럭이 있거나 이동중인 트럭이 있는 동안에
        while(!trucks.isEmpty() || !movingTrucks.isEmpty()){
            answer ++;

            Truck finished = null;
            int sum = 0;

            //이동 중인 트럭들의 무게를 계산하고 각 트럭의 위치를 +1씩 이동
            for(Truck truck : movingTrucks){
                sum += truck.weight;
                truck.position ++;

                //트럭의 위치가 다리 길이를 넘어가게 되면 그 트럭은 finish했다고 할당
                if(truck.position > bridge_length)
                    finished = truck;
            }

            //이동이 끝난 트럭이 있다면
            if(finished != null){
                //이동 중인 트럭 큐에서 제거하고
                movingTrucks.remove(finished);
                //그 트럭의 무게만큼 총 무게에서 제거
                sum -= finished.weight;
            }

            //대기 중인 트럭이 있고, 이동중인 트럭의 개수가 다리 길이보다 적다면
            if(!trucks.isEmpty() && (movingTrucks.size() < bridge_length)){
                Truck truck = trucks.peek();

                //새로운 트럭을 출발시켰을 때 무게와 다리가 버틸 수 있는 무게를 비교해서
                if(truck.weight + sum <= weight){
                    //다리가 버틸 수 있는 무게라면
                    //대기 트럭 큐에서 제거하고
                    trucks.remove(truck);
                    //이동 중인 트럭 큐에 삽입
                    movingTrucks.add(truck);
                    //트럭의 위치 ++
                    truck.position++;
                }
            }
        }
        return answer;
    }

}
