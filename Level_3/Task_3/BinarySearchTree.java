package Level_3.Task_3;

public class BinarySearchTree{
    TreeNode root;


    public void insert(int value) {
        root = insertRec(root, value);
    }
    private TreeNode insertRec(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);

        if (value <node.value){
            node.left = insertRec(node.left, value);
        } else if (value > node.value){
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }
    private boolean searchRec(TreeNode node, int value) {
        if (node == null) return false;

        if (node.value == value) return true;

        if (value < node.value){
            return searchRec(node.left, value);
        } else{
            return searchRec(node.right, value);
        }
    }

    public void inorder() {
        inorderRec(root);
    }
    private void inorderRec(TreeNode node) {
        if (node!= null) {
            inorderRec(node.left);
            System.out.print(node.value + " ");
            inorderRec(node.right);
        }
    }

    public void preorder() {
        preorderRec(root);
    }
    private void preorderRec(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    public void postorder() {
        postorderRec(root);
    }
    private void postorderRec(TreeNode node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.value + " ");
        }
    }

    public void delete(int value) {
        root = deleteRec(root, value);
    }
    private TreeNode deleteRec(TreeNode node, int value) {
        if (node ==null) return null;

        if (value <node.value) {
            node.left = deleteRec(node.left, value);
        } else if(value > node.value) {
            node.right = deleteRec(node.right, value);
        } else{
            //no child
            if (node.left == null && node.right == null) {
                return null;
            }
            //one child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            //two children
            int min = findMin(node.right);
            node.value = min;
            node.right = deleteRec(node.right, min);
        }

        return node;
    }
    private int findMin(TreeNode node) {
        while(node.left !=null) {
            node =node.left;
        }
        return node.value;
    }


    public void printTree() {
        printTreeRec(root, 0);
    }
    private void printTreeRec(TreeNode node, int level) {
        if (node == null) return;

        printTreeRec(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.value);

        printTreeRec(node.left, level + 1);
    }

}
