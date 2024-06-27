class Solution {
  public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> tempCount = new HashMap<>();

    Arrays.stream(nums).forEach(n ->
        tempCount.put(n, tempCount.getOrDefault(n, 0) + 1));

    List<Integer> count = new ArrayList<>(tempCount.keySet());

    Collections.sort(count, (i,j) ->
        tempCount.get(j) - tempCount.get(i)
    );

    Queue<Integer> FIFO = new LinkedList<>();

    count.stream().forEach(e -> FIFO.add(e));

    int[] result = new int[k];

    for (int i = 0; i < k; i++) {
      result[i] = FIFO.poll();
    }

    return result;
  }
}
