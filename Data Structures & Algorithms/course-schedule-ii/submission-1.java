class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj = new ArrayList<>();
        int count = 0;
        int res[] = new int[numCourses];
        int idx = 0;
        int indegree[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(i,new ArrayList<>());
        }
        for(int course[]:prerequisites){
            int src = course[1];
            int dest = course[0];
            adj.get(src).add(dest);
            indegree[dest]++;
        }
        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int node = queue.remove();
            count++;
            res[idx++] = node;
            for(int ele:adj.get(node)){
                indegree[ele]--;
                if(indegree[ele]==0){
                    queue.add(ele);
                }
            }
        }
        return count==numCourses?res:new int[0];
    }
}
