
package ItemUserInterface;
import java.util.*;
import Item.Items;
import Manager.ItemManager;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserInterface
{
    private ItemManager itemManager;
    private Scanner input;
    private ArrayList<Items> items;
    public UserInterface()
    {
        this.items = new ArrayList<>();
        this.input = new Scanner(System.in);
        this.itemManager = new ItemManager();
    }
    public int menu()
    {
        System.out.println("*********ITEM MENU********");
        System.out.println("1. Add Item");
        System.out.println("2. Show all items");
        System.out.println("3. Delete item");
        System.out.println("4. Edit ");
        System.out.println("0. Exit");
        System.out.println("Must exit program to save list to file");
        int choice = readInt(0, 4);
        return choice;
    }
    public void start() throws IOException, FileNotFoundException
    {
        while(true)
        {
            int choice = menu();
            switch(choice)
            {
                case 0: 
                    save(items);
                    System.exit(0);
                    break;
                case 1: 
                    addItem();
                    break;
                case 2: 
                    showAll();
                    break;
                case 3: 
                    removeItem();
                    break;
                case 4: 
                    editItem();
                    break;
                            
                default: 
                    throw new AssertionError();
            }
        }
    }
        public int readInt(int min, int max)
       { 
        int choice;
        while(true)
        {
            try
            {
                choice = Integer.parseInt(input.nextLine());
                if(choice >= min && choice <= max)
                {
                    break;
                }
            }
            catch(ArithmeticException e)
            {
                System.out.println("Number must be integer no decimal");
            } 
        }
        return choice;
       }
        private void addItem()
        {
            System.out.println("Enter item ID number: ");
            int id = readInt(0, Integer.MAX_VALUE);
            System.out.println("Enter item name: ");
            String name = input.nextLine();
            System.out.println("Enter item quantity: ");
            int quantity = readInt(0, Integer.MAX_VALUE);
            Items item = new Items(id, name, quantity);
            this.itemManager.addItem(item);   
        }
        private void showAll()
        {
            System.out.println("***All items***");
            System.out.println("ID\tName\tQuantity");
            for(int i = 0; i < this.itemManager.count(); i++)
            {
                Items item = this.itemManager.getItem(i);
                System.out.println(item.getId() + "\t" + item.getName() + "\t" + item.getQuantity());
                
            }
            
        }
        private void removeItem()
        {
            System.out.println("Enter ID of Item");
            int id = readInt(0,Integer.MAX_VALUE);
            boolean result = this.itemManager.removeItem(id);
            if(result)
            {
                System.out.println("Item was removed");
            }
            else
            {
                System.out.println("Item was not removed");
            }
        }
        private void editItem()
        {
              System.out.println("Enter ID of Item");
              int id = readInt(0,Integer.MAX_VALUE);
              Items item = this.itemManager.getItem(id);
              System.out.println(item);
              for(int i = 0; i < this.itemManager.count(); i++)
            {
                if(id == i)
                {
                    this.itemManager.editItem(i);
                }
                else
                {
                    System.out.println("Item does not exist");   
                }  
            }
        }


    public void save(ArrayList<Items> items) throws FileNotFoundException, IOException
    {
        File file = new File("G:\\School\\Java\\Java\\Code\\ProductInventoryFinal_1\\file.txt");
        if(file.exists())
        {                
          System.out.println("File already exists");
          System.out.println("Last modified on " + new java.util.Date(file.lastModified()));
        try(PrintWriter printWriter = new PrintWriter(file);)
        {
            for(int i = 0; i < this.itemManager.count();i++)
            {
                Items item = this.itemManager.getItem(i);
                printWriter.println(item.getId()+ "\t" + item.getName()+ "\t" + item.getQuantity());
            }
        }
        catch(IOException io)
        {
            System.out.println("Error");
        }
       }

    }
}
