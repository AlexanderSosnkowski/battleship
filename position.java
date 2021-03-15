public class position{
  private boolean ship;
  private boolean hit;
  private boolean miss;
  private ship yoho;
  public position(){ 
      this.ship = false;
      this.hit = false;
      this.miss = false;
      this.yoho = null;

 }
 
 public boolean getShip(){
   return this.ship;
 }
  public boolean getHit(){
   return this.hit;
 }

 public void setShip(boolean z){
   this.ship = z;
 }
 
 public boolean getMiss(){
   return this.miss;
 }

 public void setMiss(boolean z){
   this.miss = z;
 }

 public void setHit(boolean t){
   this.hit = t;
 }
  public void setYoho(ship j){
   this.yoho = j;
 }
  public String toString(boolean cheat){
   if(this.hit == true)
      System.out.print("[H]");
   else if(this.miss == true)
      System.out.print("[M]");
   else if(this.ship == true && cheat == true)
      System.out.print("[" + this.yoho.getName().substring(0,1) +  "]"); //only have this part for testing
   else
      System.out.print("[W]");   
   return("");
 }








}