package shapes;
/**
 * an interface for shapes for making them locatable
 * @author: Irmak_Akyeli
 * @version: 12/03/2019
 */
public interface Locatable 
{
   int getX();
   
   int getY();
   
   void setLocation(int x , int y);
   
}