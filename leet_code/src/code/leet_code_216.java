package code;
import java.util.*;
public class leet_code_216 {
	private List<List<Integer>> res = new ArrayList<>();//结果集
	private LinkedList<Integer> path = new LinkedList<>();//路径集
	
	public List<List<Integer>> combinationSum3(int k ,int n)
	{
		backtracking(n,k,0,1);
		return res;
	}
	
	private void backtracking(int targetSum,int k,int sum,int startIndex) 
	{
		//剪枝
		if(sum > targetSum) 
		{
			return;
		}
		if(path.size() == k) 
		{
			//如果path.size() == k，但是sum != targetSum 就直接返回
			if(sum == targetSum) 
			{
				res.add(new ArrayList<>(path));
			}
			return;
		}
		//剪枝操作，遍历到后面还剩的数的数量小于了需要的数量的时候，就不用再遍历了
		for(int i = startIndex;i <= 9 - (k - path.size()) + 1; i++) 
		{
			//添加路径
			path.add(i);
			//总和
			sum += i;
			//开始递归
			backtracking(targetSum,k,sum,i + 1);
			//递归结束，回溯
			path.removeLast();
			sum -= i;
		}
	}
	
	
	
}
