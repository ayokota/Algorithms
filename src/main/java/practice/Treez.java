package practice;

/**
 * Created by ayokota on 8/10/20.
 */
public class Treez {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode insert(TreeNode root,int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        } else if(val < root.val) {
            root.left = insert(root.left, val);
            return root;
        } else {
            root.right = insert(root.right, val);
            return root;
        }
    }

    public void DFS(TreeNode root) {
        if(root == null)
            return;
        System.out.print(root.val + " ");
        DFS(root.left);
        DFS(root.right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(q < p)
            return lowestCommonAncestor(root, q, p);

        if(root.val >= p && root.val <= q)
            return root;
        else {
            if(root.val > p && root.val > q) {
                return lowestCommonAncestor(root.left, q, p);
            } else {
                return lowestCommonAncestor(root.right, q, p);
            }
        }
    }

    public int distanceBetweenNodes(TreeNode root, int a, int b) {
        TreeNode lca = lowestCommonAncestor(root, a, b);
        return getDistance(lca, a) + getDistance(lca, b);
    }

    public int getDistance(TreeNode root, int val) {
        if(root == null)
            return 0;
        else if(root.val == val)
            return 0;
        else if(root.val > val)
            return 1 + getDistance(root.left, val);
        else
            return 1 + getDistance(root.right, val);
    }

    public static void main(String [] args) {
        Treez treez = new Treez();
        TreeNode root = treez.insert(null, 5);
        treez.insert(root, 2);
        treez.insert(root, 1);
        treez.insert(root, 3);
        treez.insert(root, 12);
        treez.insert(root, 9);
        treez.insert(root, 21);
        treez.insert(root, 25);
        treez.DFS(root);
        System.out.println();
        System.out.println(treez.distanceBetweenNodes(root, 3, 9));
        System.out.println(treez.distanceBetweenNodes(root, 9, 25));


        TreeNode root2 = treez.insert(null, 20);
        treez.insert(root2, 10);
        treez.insert(root2, 5);
        treez.insert(root2, 15);
        treez.insert(root2, 30);
        treez.insert(root2, 25);
        treez.insert(root2, 35);
        System.out.println(treez.distanceBetweenNodes(root, 5, 35));

    }
}
