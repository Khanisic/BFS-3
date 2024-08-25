// Time Complexity : 0(v+e)
// Space Complexity : O(v)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//BFS


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copyNode = clone(node);
        q.add(node);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            List<Node> neighbours = curr.neighbors;
            for (Node neighbour : neighbours) {
                if (!map.containsKey(neighbour)) {
                    q.add(neighbour);
                }
                Node clonedNeighbour = clone(neighbour);
                map.get(curr).neighbors.add(clonedNeighbour);
            }
        }
        return copyNode;
    }

    private Node clone(Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node newnode = new Node(node.val);
        map.put(node, newnode);
        return newnode;
    }
}

// dfs

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node) {
        // base
        if (map.containsKey(node)) {
            return;
        }
        // logic
        clone(node);
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            dfs(neighbor);
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }

    private Node clone(Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newnode = new Node(node.val);
        map.put(node, newnode);
        return newnode;
    }
}