class Solution {
    class Node {
        int num;
        int freq;

        Node(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        int[] ans = new int[k];

        for (int i = 0; i < nums.length; i++) {
            Node cur = map.getOrDefault(nums[i], new Node(nums[i], 0));
            cur.freq += 1;
            map.put(nums[i], cur);
        }

        for (var entry : map.entrySet()) {
            pq.add(entry.getValue());
        }

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().num;
        }
        return ans;

    }
}