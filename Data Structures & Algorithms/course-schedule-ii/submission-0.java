class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(i,new ArrayList<>());
        }
        int indegree[] = new int[numCourses];
        for(int course[]:prerequisites){
            int dest = course[0];
            int src = course[1];
            adj.get(src).add(dest);
            indegree[dest]++;
        }
        System.out.println(adj);
        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int count = 0;
        int idx = 0;
        int res[] = new int[numCourses];
        while(!queue.isEmpty()){
            int node = queue.remove();
            res[idx++] = node;
            System.out.println("Node :"+node);
            count++;
            for(int nei : adj.get(node)){
                System.out.println("Heelo");
                System.out.println(nei);
                indegree[nei]--;
                if(indegree[nei]==0){
                    queue.add(nei);
                }
            }
        }
        if(count<numCourses){
            return new int[]{};
        }
        return res;
    }
}
