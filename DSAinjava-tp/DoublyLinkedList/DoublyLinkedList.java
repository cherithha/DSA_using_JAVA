

public class DoublyLinkedList {
   
   //this link always point to first Link 
   private Link first;
   //this link always point to last Link 
   private Link last;

   // create an empty linked list 
   public DoublyLinkedList(){
      first = null;
      last = null;
   }

   //is list empty
   public boolean isEmpty(){
      return first == null;
   }

   //insert link at the first location
   public void insertFirst(int key, int data){
      //create a link
      Link link = new Link(key,data);

      if(isEmpty()){
         //make it the last link
         last = link;
      }else {
         //update first prev link
         first.prev = link;
      }

      //point it to old first link
      link.next = first;
      //point first to new first link
      first = link;
   }

   //insert link at the last location
   public void insertLast(int key, int data){
      //create a link
      Link link = new Link(key,data);

      if(isEmpty()){
         //make it the last link
         last = link;
      }else {
         //make link a new last link
         last.next = link;     
         //mark old last node as prev of new link
         link.prev = last;
      }

      //point last to new last node
      last = link;
   }

   //delete link at the first location
   public Link deleteFirst(){
      //save reference to first link
      Link tempLink = first;
      //if only one link
      if(first.next == null){
         last = null;
      }else {
         first.next.prev = null;
      }
      first = first.next;
      //return the deleted link
      return tempLink;
   }

   //delete link at the last location
   public Link deleteLast(){
      //save reference to last link
      Link tempLink = last;
      //if only one link
      if(first.next == null){
         first = null;
      }else {
         last.prev.next = null;
      }
      last = last.prev;
      //return the deleted link
      return tempLink;
   }

   //display the list in from first to last
   public void displayForward(){
      //start from the beginning
      Link current = first;
      //navigate till the end of the list
      System.out.print("[ ");
      while(current != null){
         //print data
         current.display();
         //move to next item
         current = current.next;
         System.out.print(" ");
      }      
      System.out.print(" ]");
   }

   //display the list from last to first
   public void displayBackward(){
      //start from the last
      Link current = last;
      //navigate till the start of the list
      System.out.print("[ ");
      while(current != null){
         //print data
         current.display();
         //move to next item
         current = current.prev;
         System.out.print(" ");
      }
      System.out.print(" ]");
   }

   //delete a link with given key
   public Link delete(int key){
      //start from the first link
      Link current = first;      
      //if list is empty
      if(first == null){
         return null;
      }

      //navigate through list
      while(current.key != key){
      //if it is last node
      if(current.next == null){
            return null;
         }else{           
            //move to next link
            current = current.next;             
         }
      }

      //found a match, update the link
      if(current == first) {
         //change first to point to next link
            first = current.next;
         }else {
            //bypass the current link
            current.prev.next = current.next;
         }    

         if(current == last){
            //change last to point to prev link
            last = current.prev;
         }else {
            current.next.prev = current.prev;
         }
         return current;
      }

   public boolean insertAfter(int key, int newKey, int data){
      //start from the first link
      Link current = first;      
      //if list is empty
      if(first == null){
         return false;
      }

      //navigate through list
      while(current.key != key){
         //if it is last node
         if(current.next == null){
            return false;
         }else{           
            //move to next link
            current = current.next;             
         }
      }

      Link newLink = new Link(newKey,data); 
      if(current==last) {
         newLink.next = null; 
         last = newLink; 
      }
      else {
         newLink.next = current.next;         
         current.next.prev = newLink;
      }
      newLink.prev = current; 
      current.next = newLink; 
      return true; 
   }
}