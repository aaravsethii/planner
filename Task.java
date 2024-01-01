import java.io.IOException;
import java.util.Scanner;

/** Class to represent tasks - todo items.
*/
public class Task {
   
   private String what;
   private boolean active; 

   /** Default constructor.
   */
   public Task() {
      this.what = "";
      this.active = true; // new task has not been done
   }

   /** Change the task details.
      @param w what to do
   */
   public void setTask(String w) {
      this.what = w;
   }
   
   /** Set the task as completed if not done and vice versa.
   */
   public void toggleDone() {
      if (active) {
         active = false;
      }
      else {
         active = true;
      }
   }
     
   /** Find out if the task has been completed.
       @return true if done, false otherwise
   */
   public boolean isDone() {
      return !this.active;
   }

   /** Prompt for and read a task description from user input.
       @param in the input source
       @throws IOException if bad or no input
   */
   public void read(Scanner in) throws IOException {
      System.out.print("enter what to do: ");
      this.what = in.nextLine();
   }

   /** Get the task information using the format "[ ] what" for
       an active item and "[x] what" for a completed item.
       @return the task information
   */
   
   @Override
   public String toString() {
      String str = "";
      
      if (active) {
         str += "[ ] " + what;
      }
      else {
         str += "[x] " + what;
      }
      
      return str;
      
   }
   
}

