package code;
import java.util.*;
public class leet_code_77 {
    private List<List<Integer>> res = new ArrayList<>();
	private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
    	return res;
    }
	
	private void backtracking(int n,int k,int startIndex) 
    {
    	//当当前的路径长度等于需要的路径长度，加入结果集，然后结束递归
    	if(path.size() == k) 
    	{
    		res.add(new ArrayList<>(path));
    		return;
    	}
    	
    	//枝减操作，当剩下的未遍历到的个数小于了还需要的个数，就没有必要再进行遍历了
    	for(int i = startIndex; i <= n - (k - path.size()) + 1 ; i++) 
    	{
    		path.add(i);//添加路径
    		backtracking(n,k,i + 1);//继续向下递归
    		path.removeLast();//递归结束后，移除最后一位已经使用过的元素，进入下一轮遍历
    	}
    }
	
}
