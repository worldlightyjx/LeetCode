class Solution {
    public int numJewelsInStones(String J, String S) {
		char[] j = J.toCharArray();
		char[] s = S.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<s.length;i++) {
			if(map.containsKey(s[i])) {
				int cnt = map.get(s[i]);
				map.put(s[i], ++cnt);
				
			}else {
				map.put(s[i],1);
			}
		}
		int sum = 0;
		for(int i=0;i<j.length;i++) {
        if(map.containsKey(j[i]))
			    sum+=map.get(j[i]);
		}
		return sum;
		
	}
}