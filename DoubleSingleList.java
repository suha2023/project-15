
package doublesinglelist;
class Node 
  { 
   int data; 
   Node next;  // Next is by default initialized  as null
   Node prev; 
   Node (int d) {data = d; next = null; prev = null; }  // Constructor to create a new node         
  } 


class DoubleSingleList
{
Node head;

// This function inserts a new Node at front of the list.
public void push(int newdata) 
{ 
Node NewNode = new Node(newdata); // Allocate the Node & store  the data*/
NewNode.next = head;   // Make next of new Node as head  
NewNode.prev = null;  //,and previous as NULL 

//change prev of head node to new node
if (head != null) head.prev = NewNode; 

head = NewNode;  // Move the head to point to new Node 
} 
         ////////////////////////////////////////////////////

// Insert a node after a given node
public void insertAfter(Node PrevNode, int newdata) 
{ 
if (PrevNode == null)  //Check if the given Node is null
  { 
   System.out.println("The given previous node cannot be null"); 
   return; 
  } 
Node NewNode = new Node(newdata); //Allocate the Node &  3. Put in the data
NewNode.next = PrevNode.next; //Make next of new Node as next of prev_node 
PrevNode.next = NewNode;  //make next of prev_node as new_node 
NewNode.prev = PrevNode; 

// Change previous of new_node's next node 
 if (NewNode.next != null) 
   NewNode.next.prev = NewNode;
} 

            ////////////////////////////////////////////////////

// Add a new data to the end of the List
public void append(int newdata)
{ 

Node NewNode = new Node(newdata); // Allocate the Node and store the data in it
Node last = head;
NewNode.next = null; 
 
if (head == null) //If the Linked List is empty
   { 
   NewNode.prev = null; //,then make the new node as head
   head = NewNode; 
   return; 
   }


while (last.next != null) last = last.next; //Else traverse till the last node
  
last.next = NewNode;  //Change the next of last node
NewNode.prev = last; //Make last node as previous of the new node

return; 
} 

    //////////////////////////////////////////////////
// Insert a node before a given node
void insertBefore(Node NextNode, int newdata)
{
	// check if the given new_node is NULL 
if  (NextNode == null)
   {
   	System.out.println("the given next node cannot be NULL");
    return;
   }

Node NewNode = new Node(newdata); // Allocates the new node
NewNode.data = newdata; // store the data in it
NewNode.prev = NextNode.prev;  // Make prev of new node as prev of NewNode
NextNode.prev = NewNode;  //Make the prev of next_node as NewNode
NewNode.next = NextNode;  // Make next_node as next of NewNode

if (NewNode.prev != null)
    NewNode.prev.next = NewNode;// Change next of new_node's previous node

else head = NewNode; // If the prev of new_node is NULL, it will be the new head node

}

// delete a given node
void deleteNode( Node del)
{
// Base case
if (head == null || del == null) return;

// If node to be deleted is the head node
if (head == del) head = head.next;

// Change next only if node to be deleted is NOT the last node 
if (del.next != null) del.next.prev = del.prev;

// Change prev only if node to be deleted is NOT the first node
if (del.prev != null) del.prev.next = del.next;

return;
}


            ////////////////////////////////////////////////////
//This function prints contents of a double linked list starting from head 
void printList() 
{
Node n = head;
while (n != null) 
  { 
   System.out.print(n.data+" "); 
   n = n.next; 
  }
  System.out.print(" \n ") ;
} 

            ////////////////////////////////////////////////////

}// end of the class doublyLinkedList

class DoubleSingleListmain
{
public static void main(String[] args)
{
DoubleSingleList dll = new DoubleSingleList(); // Start with the empty list
dll.append(6); // Insert 6. So linked list becomes 6->NULL 
dll.push(7);   // Insert 7 at the beginning. So linked list becomes 7->6->NULL
dll.append(4); // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL 
dll.insertAfter(dll.head.next,8); //Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL 
dll.push(7);
dll.insertBefore(dll.head.next,1111);
System.out.println("Created DLL is: "); 
dll.printList(); 


//System.out.println("After delete of head is: "); 
//dll.deleteNode(dll.head);
//dll.printList(); 

//dll.deleteNode(dll.head.next);
//System.out.println(" DLL after delete of the second node in the New Listis: "); 
//dll.printList(); 

}
}
