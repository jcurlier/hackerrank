// Calculate the number of edge... not node

  	static int getHeight(Node root)
    {
      if (root == null) return 0;
      return Math.Max(getDepth(root.left), getDepth(root.right));
    }

  	static int getDepth(Node node)
    {
      if (node == null) return 0;

        int left = getDepth(node.left);
        int right = getDepth(node.right);
        
        return Math.Max(left, right) + 1;
     }