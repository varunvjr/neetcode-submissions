class CountSquares {
    HashMap<List<Integer>,Integer>map;
    List<List<Integer>>ptsCount;
    public CountSquares() {
        map = new HashMap<>();
        ptsCount = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        List<Integer>temp = new ArrayList<>();
        temp.add(x);
        temp.add(y);
        map.put(temp,map.getOrDefault(temp,0)+1);
        ptsCount.add(temp);
    }
    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int res = 0;
        for(List<Integer>pts:ptsCount){
            int x = pts.get(0);
            int y = pts.get(1);
            if(Math.abs(py-y)!=Math.abs(px-x)||(px==x||py==y))
                continue;
            res+=map.getOrDefault(Arrays.asList(x,py),0)*map.getOrDefault(Arrays.asList(px,y),0);
        }
        return res;
    }
}
