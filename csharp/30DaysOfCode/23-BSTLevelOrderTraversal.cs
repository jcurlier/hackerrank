//breadth-first search, visits each level of a tree's nodes from left to right, top to bottom.
//30-binary-trees
using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Node
{
    public Node left,right;
    public int data;
    public Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution
{
    static void levelOrder(Node root)
    {
        string result = "";
        
        Queue<Node> queue = new Queue<Node>();  
        Node node = root;
            
        while (node != null)
        {
            if (result.Length > 0) result += " ";    
            result += node.data.ToString();
            
            if (node.left != null) queue.Enqueue(node.left);
            if (node.right != null) queue.Enqueue(node.right);
            
            node = (queue.Count > 0) ? queue.Dequeue() : null;
        }
        
        Console.WriteLine(result);
    }


    	static Node insert(Node root, int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    static void Main(String[] args){
        Node root=null;
        int T=Int32.Parse(Console.ReadLine());
        while(T-->0){
            int data=Int32.Parse(Console.ReadLine());
            root=insert(root,data);            
        }
        levelOrder(root);
        
    }
}