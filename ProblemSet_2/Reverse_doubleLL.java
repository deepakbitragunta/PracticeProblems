
/*
 * 
 *  struct node *temp = NULL;  
     struct node *current = *head_ref;
      
     // swap next and prev for all nodes of 
     //  doubly linked list /
     while (current !=  NULL)
     {
       temp = current->prev;
       current->prev = current->next;
       current->next = temp;              
       current = current->prev;
     }      
      
     // Before changing head, check for the cases like empty 
    //    list and list with only one node /
     if(temp != NULL )
        *head_ref = temp->prev;
 * 
 */


/*
ListNode *reverse(ListNode* head)
	{
		if(head == NULL || head->next == NULL)
			return head;
		ListNode *p = head;
		while(p->next != NULL)
		{
			p->next = p->next ^ p->pre;
			p->pre = p->next ^ p->pre;
			p->next = p->next ^ p->pre;
			p = p->pre;
			if(p->prev ==
 null) {
				*head =p->next; 
			}
		}
		p->next = p->prev;
		p->prev = NULL;
		return p;
	} 
	



public void ReverseLinkedList (LinkedList linkedList)
{
LinkedListNode start = linkedList.Head;
LinkedListNode temp = null;

// ------------------------------------------------------------
// Loop through until null node (next node of the latest node) is found
// ------------------------------------------------------------

while (start != null)
{
// ------------------------------------------------------------
// Swap the â€œNextâ€� and â€œPreviousâ€� node properties
// ------------------------------------------------------------

temp = start.Next;
start.Next = start.Previous;
start.Previous = temp;

// ------------------------------------------------------------
// Head property needs to point to the latest node
// ------------------------------------------------------------

if (start.Previous == null)
{
linkedList.Head = start;
}

// ------------------------------------------------------------
// Move on to the next node (since we just swapped 
// â€œNextâ€� and â€œPreviousâ€�
// â€œNextâ€� is actually the â€œPreviousâ€�
// ------------------------------------------------------------

start = start.Previous;
}

// ------------------------------------------------------------
// That's it!
// ------------------------------------------------------------
}*/