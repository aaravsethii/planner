import java.util.Scanner;
import java.io.IOException;

/** This class represents appointments with specific tasks, locations and times.
*/
public class Appointment extends Task {

   private String location;
   private String date;
   private Time start;
   private Time due;

   /** Prompt for and read a Appointment description, start time,
       deadline, and location
       from user input, handling invalid Time inputs gracefully.
       @param in the input source
       @throws IOException if other input errors
   */
   
   @Override
   public void read(Scanner in) throws IOException {
      super.read(in);
      System.out.print("enter date: ");
      this.date = in.nextLine();
      try {
         System.out.print("enter when [hh:mm a/p]: ");
         start = new Time(in.nextLine());
      }
      catch (BadTimeException e) {
         start = new Time("0:00");
      }
      try {
         System.out.print("enter end time [hh:mm a/p]: ");
         due = new Time(in.nextLine());
      }
      catch (BadTimeException e) {
         due = new Time("0:00");
      }
      System.out.print("enter where: ");
      this.location = in.nextLine();
   }

   /** Get all the inherited data (formatted like a Task) as
       well as the date, location, start time, & end time, separated by commas.
       @return the full description
   */
   @Override
   public String toString() {
      return super.toString() + ", " + date + ", " + start + 
         " - " + due + ", " + location;
   }
}
