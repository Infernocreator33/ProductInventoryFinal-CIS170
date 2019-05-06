package Manager;
import java.util.*;
import Item.Items;

public class ItemManager 
{
    public List<Items> listOfItems;
    Scanner input = new Scanner(System.in);
    public ItemManager()
    {
        this.listOfItems = new ArrayList<>();
    }
    public int addItem(Items item)
    {
        this.listOfItems.add(item);
        return this.listOfItems.size();
    }
    
    public int count()
    {
        return this.listOfItems.size();
    }
    public Items getItem(int index)
    {
        if(index < 0 || index >= count())
        {
            return null;
        }
        return this.listOfItems.get(index);
        
    }
    public boolean removeItem(int id)
    {
        int index = -1;
        for(int i = 0, n = count(); i < n; i++)
        {
            if(this.listOfItems.get(i).getId() == id)
            {
                index = i;
                break;
            }
        }
        if(index != -1)
        {
            this.listOfItems.remove(index);
            return true;
        }
        return false;
    }

    public boolean editItem(int id)
    {
        int index = -1;
        for(int i = 0, n = count(); i < n; i++)
        {
            if(this.listOfItems.get(i).getId() == id)
            {
                index = i;
                break;
            }
        }
        if(index != -1)
        {
            Items newItem = new Items(this.listOfItems.get(index).getId(),this.listOfItems.get(index).getName(),this.listOfItems.get(index).getQuantity());
            System.out.println(this.listOfItems.get(index));
            removeItem(index);
            this.listOfItems.add(index, newItem);
            System.out.println(this.listOfItems.get(index));
            return true;
        }  
       return false;
    }
}