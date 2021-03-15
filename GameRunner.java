import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;
public class GameRunner{
   public static void make(position[][] board){
   
        for(int row = 0; row < board.length ; row ++){
        for(int col = 0; col < board[row].length; col ++){
            board[row][col] = new position();
           // System.out.print(board[row][col]);
            
         }
         //System.out.println("");
      }   

   
   
   }
   public static void display(position[][] board, boolean cheat){
        System.out.println("[ ][1][2][3][4][5][6][7][8][9][10]");
        for(int row = 0; row < board.length ; row ++){
        for(int col = 0; col < board[row].length; col ++){
            //board[row][col] = new position();
            //if(col == 0){   System.out.print("[" + (row + 1) + "]"); }
            
            if(col == 0){ System.out.print("[" + "ABCDEFGHIJ".substring(row, row + 1) + "]"); }
            
            System.out.print(board[row][col].toString(cheat));
            
         }
         System.out.println("");
      }   
   
   }
   public static void place(position[][] board, ship x){
        boolean noShip = false;
        int i = 0;
        boolean horiz = false;
        int row = 0; 
        int col = 0;
        while (noShip == false){ 
            row = (int)(Math.random()*(10 - x.getLength()) ); 
            col = (int)(Math.random()*(10 - x.getLength()) );        
            double ran = Math.random();
            i = row;
            horiz = false; //horizontal ship placement true or false
            if(ran > .5){horiz = true; i = col;} 
            for(int d = i; d < x.getLength() + i; d ++ ){ 
               if(horiz == true){
                  if(board[row][d].getShip() == true){
                     noShip = false;
                     break;
                  }
               }
               
               else{
                  if(board[d][col].getShip() == true){
                     noShip = false;
                     break;
                  }
               }
            if(d + 1 == x.getLength() + i){noShip = true; break;}
            
            }
            
         }
         
         
         //System.out.println(col + " " + row);       

         
         
         int count = 0;
         int temp = x.getLength() + i;
         for(i=i; i < temp - 0;  i ++){
          if(horiz == false){
            x.getLoc().set(count, board[i][col]);   
            board[i][col].setShip(true);
            board[i][col].setYoho(x);
            //System.out.print(board[i][col]);
         }else{
            x.getLoc().set(count, board[row][i]);    
            board[row][i].setShip(true); 
            board[row][i].setYoho(x);
            //System.out.print(board[row][i]);
         }
         count ++;

         }
         
      
   }
   
   public static void main(String[]args){
      position[][] board = new position[10][10];
      //ships
     ship air = new ship(5, "aircraft carier");
     ship battle = new ship(4, "battle ship");
     ship destroyer = new ship(3, "destroyer");
     ship sub = new ship(3, "submarine");
     ship pat = new ship(2, "patrol boat");
     make(board);
     // could be more efficent / nicer code with a better calling system using an array
     place(board, air);
     place(board, battle);
     place(board, destroyer);
     place(board, sub);
     place(board, pat);
     Scanner talk = new  Scanner(System.in);
     System.out.println("Welcome to battle ship, select difficulty (H)ard 20 shots, (N)ormal 50 shots, or (E)asy 100 shots and cheats");
     String yo = talk.nextLine();
     yo = yo.toUpperCase();
     int ammo;
     int startAmmo;
     boolean cheat = false;
     if(yo.equals("H") == true ){
      ammo = 20; 
      startAmmo = ammo;
     }else if(yo.equals("E") == true ){
      ammo = 100; 
      startAmmo = ammo;
      cheat = true;
     }else{
      ammo = 50; 
      startAmmo = ammo;
     }
     
     Scanner scan = new  Scanner(System.in);
     String input;
     int input2;
     ArrayList<ship> ships = new ArrayList<ship>();
     ships.add(air);
     ships.add(battle);
     ships.add(destroyer);
     ships.add(sub);
     ships.add(pat);
     
     display(board, cheat);
     
     while(ammo > 0){
     System.out.println("You have: " + ammo + " shots left. Please enter a cordinate to shoot: ");
     System.out.println("You have destroyed: " + (100 *( ( (double) 5 - ships.size() ) / 5) ) + "% of all ships");
     System.out.println("You have: " + (100 * ( (double) ammo / startAmmo) ) + "% of your ammo stores remaining");
     input = scan.nextLine();
     input = input.toLowerCase();
     input2 = Integer.parseInt(input.substring(1)) - 1;
     if(board["abcdefghij".indexOf(input.substring(0,1))][input2].getShip() == true){
       board["abcdefghij".indexOf(input.substring(0,1))][input2].setHit(true); // check for invalid inputs to alex
     }else{
      board["abcdefghij".indexOf(input.substring(0,1))][input2].setMiss(true);
     }
     
     display(board, cheat);
     
     for(ship z: ships){  
        if(z.update() == true){
         System.out.println("You sunk the " + z.getName() + " good job.");
         ships.remove(z);
         break;
        }
     }
       
     if(ships.size() == 0){
      System.out.println("You have destroyed the fleeing fleet of ships.\n GOOD JOB you have succeded in commiting a war crime. \n Your going to jail for breaking the geneva convention.");
      break;
     }
     
     
     ammo --;
     if(ammo == 0){
          System.out.println("Out of Ammo, the enemy fleet escapes. \n <===You Lose===>");
          break;
      }
     }
     
     
   
   }

}