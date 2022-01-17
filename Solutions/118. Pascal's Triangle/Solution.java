class Solution {
   public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> anslist = new ArrayList<>();
		for(int i=0;i<numRows;i++) {
			List<Integer> tmplist = new ArrayList<>();
			for(int j=0;j<=i;j++) {
				if(j==0||j==i) {
					tmplist.add(1);
				}else {
					tmplist.add(anslist.get(i-1).get(j-1)+anslist.get(i-1).get(j));
				}
			}
			anslist.add(tmplist);
		}
		return anslist;
	}
}