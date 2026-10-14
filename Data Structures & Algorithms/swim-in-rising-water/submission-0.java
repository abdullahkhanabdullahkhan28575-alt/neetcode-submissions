class DSU {
    private int[] Parent;
    private int[] Size;

    public DSU(int n) {
        Parent = new int[n + 1];
        Size = new int[n + 1];
        for (int i = 0; i <= n; i++) Parent[i] = i;
        Arrays.fill(Size, 1);
    }

    public int find(int node) {
        if (Parent[node] != node)
            Parent[node] = find(Parent[node]);
        return Parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;
        if (Size[pu] < Size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        Size[pu] += Size[pv];
        Parent[pv] = pu;
        return true;
    }

    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }
}

public class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        DSU dsu = new DSU(N * N);
        List<int[]> positions = new ArrayList<>();
        for (int r = 0; r < N; r++)
            for (int c = 0; c < N; c++)
                positions.add(new int[]{grid[r][c], r, c});
        positions.sort(Comparator.comparingInt(a -> a[0]));
        int[][] directions = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        for (int[] pos : positions) {
            int t = pos[0], r = pos[1], c = pos[2];
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < N && nc >= 0 &&
                    nc < N && grid[nr][nc] <= t) {
                    dsu.union(r * N + c, nr * N + nc);
                }
            }
            if (dsu.connected(0, N * N - 1)) return t;
        }
        return N * N;
    }
}