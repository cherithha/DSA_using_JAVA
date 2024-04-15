

public class Link {
   public int key;
   public int data;
   public Link next;

   public Link(int key, int data){
      this.key = key;
      this.data = data;
   }

   public void display(){
      System.out.print("{"+key+","+data+"}");
   }
}
