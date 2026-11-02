package 算法与综合;
import java.io.*;
import java.util.*;
//堆
public class DynamicMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 大根堆：存前半部分（较小一半），堆顶是中位数
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 小根堆：存后半部分（较大一半）
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (maxHeap.isEmpty() || x <= maxHeap.peek()) {
                maxHeap.add(x);
            } else {
                minHeap.add(x);
            }

            // 平衡：保证 maxHeap.size() >= minHeap.size()，最多差1
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
            while (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            System.out.println(maxHeap.peek());
        }
    }
}
