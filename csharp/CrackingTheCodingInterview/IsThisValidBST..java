    boolean checkBST(Node root) {
        return isValidBSTNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isValidBSTNode(Node node, int min, int max)
    {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
    
        return isValidBSTNode(node.left, min, node.data) && isValidBSTNode(node.right, node.data, max);
    }