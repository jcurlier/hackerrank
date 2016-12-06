	public static  Node insert(Node head, int data)
	{
      Node node = new Node(data);
      
      if (head == null)
      {
          head = node;
      }
      else
      {
        Node current = head;
        while (current.next != null)
        {
            current = current.next;
        }
        current.next = node;
      }
        
      return head;
    }