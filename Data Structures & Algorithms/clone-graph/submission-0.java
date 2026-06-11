/*
Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if (node == null) return node; 
        HashMap<Node, Node> vis = new HashMap<>();
        return rec(node, vis);
    }

    Node rec(Node node, HashMap<Node, Node> vis) {
        if (vis.containsKey(node)) return vis.get(node);

        vis.put(node, new Node(node.val));

        for(Node neighbor : node.neighbors) {
            vis.get(node).neighbors.add(rec(neighbor, vis));
        }

        return vis.get(node);
    } 
}