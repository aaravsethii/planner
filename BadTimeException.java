/** BadTimeException class.
*/

public class BadTimeException extends RuntimeException {
   
   /** Default constructor.
   */
   public BadTimeException() {
      super("invalid time of day");
   }
   
   /** Constructor that takes in a message.
   *  @param message  message output
   */
   public BadTimeException(String message) {
      super(message);
   }
   
}
