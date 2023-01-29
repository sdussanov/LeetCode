import java.util.*;

class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 1, 2, 2, 3};
        int[] nums2 = new int[]{1, 3, 3};
        int[] nums3 = new int[]{1, 1, 1, 2, 3, 3, 3, 7, 7, 7, 7};

        System.out.println(Arrays.toString(topKFrequent2(nums1, 2)));
        System.out.println(Arrays.toString(topKFrequent2(nums2, 1)));
        System.out.println(Arrays.toString(topKFrequent2(nums3, 2)));
    }

    public static int[] topKFrequent1(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            result[--k] = pq.poll().getKey();
        }
        return result;
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int head = 0;
        int[] result = new int[k];
        for (int i = nums.length; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int val : bucket[i]) {
                    result[head++] = val;
                    if (head == k)
                        return result;
                }
            }
        }
        return result;
    }
}