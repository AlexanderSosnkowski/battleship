import java.util.ArrayList;
public class ship{
   private int length;
   private String name;
   private boolean sunk;
   private ArrayList<position> loc = new ArrayList<position>();

public ship(int length, String name){
   this.length = length;
   this.name = name;
   this.sunk = false;
   for(int i = 0; i < this.getLength(); i ++){
      this.loc.add(new position());
   }
   

}
public boolean update(){
   int temp = 0;
   for(int i = 0; i < this.getLength(); i ++){
      if(loc.get(i).getHit() == true){
        temp ++;
      }
    }
    if(temp == this.length){return true;}
    return false;
}

 public boolean getSunk(){
   return this.sunk;
 }
  public String getName(){
   return this.name;
 }
 public int getLength(){
   return this.length;
 }
 public void setLoc(int x, position z){
   this.loc.set(x, z);
 }
 public ArrayList<position> getLoc(){
   return this.loc;
 }









}