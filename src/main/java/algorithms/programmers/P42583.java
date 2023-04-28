package algorithms.programmers;

import java.util.*;

public class P42583 {

    int bridgeLength;
    int maxWeight;
    int curWeight = 0;
    int availNum = bridgeLength;
    Queue<Truck> crossing = new LinkedList<>();
    Queue<Truck> trucks = new LinkedList<>();

    class Truck {
      int remains;
      int truckWeight;

      Truck(int truckWeight) {
        this.truckWeight = truckWeight;
        this.remains = bridgeLength;
      }

      int getRemains() {
        return this.remains;
      }

      void setRemains(int remains) {
        this.remains = remains;
      }

      int getWeight() {
        return this.truckWeight;
      }
    }

    public void move() {
      for (Truck t : crossing) {
        t.setRemains(t.getRemains() - 1);
      }
    }

    public void finished() {
      if (!crossing.isEmpty()) {
        if (crossing.peek().getRemains() == 0) {
          curWeight -= crossing.peek().getWeight();
          crossing.poll();
        }
      }
    }

    public void initiate() {
      if (!trucks.isEmpty()) {
        if (curWeight + trucks.peek().getWeight() <= maxWeight) {
          curWeight += trucks.peek().getWeight();
          crossing.add(trucks.poll());
        }
      }
    }

    boolean allArrived() {
      return trucks.isEmpty() && crossing.isEmpty();
    }

    public int pro() {
      int counter = 0;
      while (!allArrived()) {
        counter++;
        finished();

        initiate();
        move();
      }

      return counter;
    }


    public int solution(int bridge_length, int weight, int[] truck_weights) {
      int answer = 0;
      bridgeLength = bridge_length;
      maxWeight = weight;



      for (int single : truck_weights) {
        Truck t = new Truck(single);
        trucks.add(t);
      }

      answer = pro();

      return answer;
    }

}
