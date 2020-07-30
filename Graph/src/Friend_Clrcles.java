//There are N students in a class. Some of them are friends, while some are not. Their friendship is 
//transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, 
//then A is an indirect friend of C. And we defined a friend circle is a group of students who are 
//direct or indirect friends.

//Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, 
//then the ith and jth students are direct friends with each other, otherwise not. And you have to output 
//the total number of friend circles among all the students.

//Example 1:
//Input: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//Output: 2
//Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
//The 2nd student himself is in a friend circle. So return 2.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Friend_Clrcles {
    public int findCircleNum(int[][] M) {
        if(M == null)
            return 0;
        
        Set<Integer> set = new HashSet<Integer>();
        
        int count = 0;
        
        for(int i = 0; i < M.length; i++){
            
            if(!set.contains(i)){
                
                bfs(M, set, i);
                count ++;
            }
        }
        return count;
    }
    public void bfs(int M[][], Set<Integer> set, int src){
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.add(src);
        set.add(src);
        
        while(!queue.isEmpty()){
            
            int temp = queue.poll();
            
            for(int i = 0; i < M.length; i++){
                
                if(M[temp][i] == 1 && !set.contains(i)){
                    
                    set.add(i);
                    queue.add(i);
                }
            }
        }
    }
}