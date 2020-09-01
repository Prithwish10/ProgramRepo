import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Most_Frequent_Subarray_Sum {

	Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int count = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        
        if(root == null)
            return new int[]{};
        
        findDriver(root);
        
        int ar[] = new int[count];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            
            if(entry.getValue() == max)
                ar[index ++] = entry.getKey();
            //     list.add(entry.getKey());
            
        }
//        int ar[] = new int[list.size()];
//        int index = 0;
//        
//        for(int i : list)
//            ar[index ++] = i;
        
        return ar;
    }
    private void findDriver(TreeNode root){
        
        if(root == null)
            return;
        
        int sum = helper(root);
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        if(map.get(sum) == max){
            count ++;
        }
        else if(map.get(sum) > max){
            count = 1;
            max = map.get(sum);
        }
        //max = Math.max(max, map.get(sum));
        
        findDriver(root.left);
        findDriver(root.right);
    }
    
    private int helper(TreeNode root){
        
        if(root == null)
            return 0;
        
        return root.val + helper(root.left) + helper(root.right);
    }
}
