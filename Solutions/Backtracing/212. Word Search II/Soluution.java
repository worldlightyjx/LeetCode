class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String s;

        TrieNode() {

        }
    }

    TrieNode root = new TrieNode();
    boolean[][] visited;
    int m, n;
    char[][] bd;

    public List<String> findWords(char[][] board, String[] words) {
        bd = board;
        Set<String> res = new HashSet<>();
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (String word : words) {
            buildTrie(word);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, root, res);
            }
        }

        return new ArrayList<>(res);

    }

    private void dfs(int x, int y, TrieNode root, Set<String> res) {
        if (x >= m || y >= n || x < 0 || y < 0 || visited[x][y])
            return;
        if (root.child[bd[x][y] - 'a'] == null)
            return;

        visited[x][y] = true;
        root = root.child[bd[x][y] - 'a'];
        if (root.s != null) {
            res.add(root.s);
        }
        dfs(x + 1, y, root, res);
        dfs(x - 1, y, root, res);
        dfs(x, y + 1, root, res);
        dfs(x, y - 1, root, res);

        visited[x][y] = false;
    }

    private void buildTrie(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.child[ch - 'a'] == null) {
                node.child[ch - 'a'] = new TrieNode();
            }
            node = node.child[ch - 'a'];
        }
        node.s = word;
    }
}