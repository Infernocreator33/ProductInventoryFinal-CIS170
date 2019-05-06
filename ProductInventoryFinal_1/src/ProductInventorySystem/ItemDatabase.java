
package ProductInventorySystem;
import ItemUserInterface.UserInterface;
import java.io.FileNotFoundException;
import java.io.IOException;
public class ItemDatabase 
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        UserInterface ui = new UserInterface();
        ui.start();
    }
}