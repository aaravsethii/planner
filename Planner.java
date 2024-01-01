/** This class creates objects that are personal planners.
*/
public class Planner implements Collection {

   /** Default maximum size of planner. */
   private static final int MAXSIZE = 1000;
   
   /** Collection of things that must be done. */
   private Task[] todo;
   /** Number of actual tasks in the planner. */
   private int numtasks;

   /** Create a Planner with the default Collection starting size.
   */
   public Planner() {
      todo = new Task[STARTSIZE];
   }

   @Override
   public int size() {
      return this.numtasks;
   }

   /** Add an item to the planner, doubling the size of the planner
      if not yet at the maximum size.
      @param o the item to add, must be some type of Task
      @return true if added, false otherwise
   */
   @Override
   public boolean add(Object o) {
      Task[] temp;
      
      if (! (o instanceof Task)) {
         return false;
      }
      
      if (todo.length * 2 <= MAXSIZE) {
         temp = new Task[todo.length * 2];
      }
      else {
         temp = new Task[MAXSIZE];
      }
      
      for (int i = 0; i < todo.length; i++) {
         temp[i] = todo[i];
      }
      
      todo = temp;
      
      todo[numtasks] = (Task) o;
      
      numtasks += 1;
      
      return true; 
   }

   @Override
   public void display() {
      for (int i = 0; i < this.numtasks; i++) {
         System.out.printf("(%3d) %s\n", i, this.todo[i]);
      }
   }

   /** Find all items in the Planner that contain the parameter as a substring.
       @param o the target string to find (case sensitive)
       @return a string with all items in the Planner containing o, one per line
               or an empty string if there are none
   */
  
   @Override
   public Object find(Object o) {
      String str = "";
      for (int i = 0; i < numtasks; i++) {
         if (todo[i].toString().contains(o.toString())) {
            str += todo[i].toString() + "\n";
         }
      }
      
      if (str.equals("")) {
         str = "Cannot find item";
      }
      
      return str;
      
   }

   @Override
   public Object get(int n) {
      if (n > size()) {
         throw new ArrayIndexOutOfBoundsException();
      }
      return this.todo[n - 1];  // adjust for nth numbering
   }

}
