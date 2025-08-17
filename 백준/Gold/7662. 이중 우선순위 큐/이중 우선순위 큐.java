import java.io.*;
import java.util.*;

public class Main {
    static class DualPriorityQueue {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>();

        public void insert(int n) {
            minHeap.offer(n);
            maxHeap.offer(n);
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        public void delete(int type) {
            if (countMap.isEmpty()) return;

            if (type == 1) {
                remove(maxHeap);
            } else {
                remove(minHeap);
            }
        }

        private void remove(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int val = heap.poll();
                if (countMap.containsKey(val)) {
                    int cnt = countMap.get(val);
                    if (cnt == 1) countMap.remove(val);
                    else countMap.put(val, cnt - 1);
                    break;
                }
            }
        }

        public String getResult() {
            clean(minHeap);
            clean(maxHeap);

            if (countMap.isEmpty()) return "EMPTY";
            int max = getValid(maxHeap);
            int min = getValid(minHeap);
            return max + " " + min;
        }

        private void clean(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty() && !countMap.containsKey(heap.peek())) {
                heap.poll();
            }
        }

        private int getValid(PriorityQueue<Integer> heap) {
            clean(heap);
            return heap.peek();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            DualPriorityQueue dpq = new DualPriorityQueue();

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                String op = input[0];
                int n = Integer.parseInt(input[1]);

                if (op.equals("I")) {
                    dpq.insert(n);
                } else {
                    dpq.delete(n);
                }
            }
            sb.append(dpq.getResult()).append("\n");
        }
        System.out.print(sb);
    }
}
