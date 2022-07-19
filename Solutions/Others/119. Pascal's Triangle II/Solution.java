/* 这是一个比较巧妙的算法，把杨辉三角变成这样比较容易看出
*  [1]
	 [1,1]
	 [1,2,1]
	 [1,3,3,1]
	 [1,4,6,4,1]
*
*/


class Solution {
    public List<Integer> getRow(int rowIndex) {
	        List<Integer> list = new ArrayList<>();
	        for(int i=0;i<rowIndex+1;i++){
	            if(i==0)
	                list.add(1);
	            else
	                list.add(0);
	        }
	        for(int i=1;i<rowIndex+1;i++){
	            for(int j=i;j>=1;j--){
	                list.set(j,list.get(j-1)+list.get(j));
	            }
	        }
	        return list;
	    }
}