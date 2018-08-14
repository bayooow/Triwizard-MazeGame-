
/**
 *
 * @author Bayu Aji Firmansyah
 */

import java.util.Arrays;
import java.util.Scanner;

public class Triwizard{
    
    static Arena listArena[];
    static Player[] player;
    
    public static void main(String[] args) throws CloneNotSupportedException, StackEmpty {
        Scanner s = new Scanner (System.in);        
        Scanner ss;
        int width = s.nextInt();              
        s.nextLine();        
        
        Arena main = new Arena(width);        
        
        String way =s.nextLine();        
        
        s= new Scanner(way);
        s.useDelimiter(" ");
        int count=0;
        
        while(s.hasNext()){
            
            ss=new Scanner(s.next());
            ss.useDelimiter(",");
            
            int idx=0;
            int kor[]=new int[2];
            while(ss.hasNext()){
                int temp = Integer.parseInt(ss.next());
                kor[idx] = temp;
                idx++;
            }
            if(count==0){main.addPosStart(kor[0], kor[1]);}
            if(!s.hasNext()){main.addPosFinish(kor[0], kor[1]);}
            main.addWay(kor[0],kor[1]);
            count++;
        }                
        s=new Scanner(System.in);
        int pemain =s.nextInt();
        s.nextLine();
        int idx_Player=0;
        player = new Player[pemain];
        //create pemain        
        for(int h =0; h<pemain;h++){
            s= new Scanner(System.in);            
            String nameSugest=s.nextLine();
            s=new Scanner(nameSugest);
            s.useDelimiter(" ");            
            String []sugest=new String[5];
            int idx=0;
            while(s.hasNext()){
                sugest[idx]=s.next();
                idx++;            }            
            player[idx_Player]=new Player(sugest, main.clone());
            player[idx_Player].setPosNow(main.start.x, main.start.y);
            idx_Player++;            
        }
       
        int idx_main=0;

       for(int i =0; i < player.length;i++){    
           player[i].plotSugest();           
           player[i].play();           
    }
       
       for(int i = 0 ; i < player.length;i++){
           for(int x = 0 ; x < player.length-1;x++){
               if(player[x+i].getStep()<player[x].getStep()){
                   Player temp= player[x];
                   player[x]=player[x+1];
                   player[x+1]=temp;
               }
           }
           
       }
       
       
       for(int i = 0 ;i < player.length;i++){
           System.out.println(player[i].getName());
           player[i].getArena().print();
           
       }
       
        
    }
    
}
