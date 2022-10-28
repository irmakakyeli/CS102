package shapes;
/**
 * an interface for shapes for making them selectable
 * @author: Irmak_Akyeli
 * @version: 12/03/2019
 */
public interface Selectable 
{
   boolean getSelected(); 
   
   void setSelected(boolean bln);
   
   Shape contains(int x , int y);
}