
/**
 *
 * @author Bayu Aji Firmansyah
 */

/*
    2 []  []  []      (x,y)
    1 [x] []  []      (0,1)
    0 []  []  [x]     (2,0)
       0  1    2
 */
class position {

    int x, y;

    position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Arena {

    private String[][] area;
    private int size;
    private int step = 2;
    position start;
    position finish;

    public Arena clone() {
        Arena main = new Arena(size);
        for(int i = 0 ; i < size;i++){
            for(int x = 0 ; x < size;x++){
                main.area[x][i]=area[x][i];
            }
        }
        main.size = size;
        main.step = 2;
        main.start = this.start;
        main.finish = this.finish;
        return main;

    }
public int getStep(){return step;}
    public Arena(int size) {

        this.size = size;

        area = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int x = 0; x < size; x++) {
                area[i][x] = "XX";
            }
        }
    }

    public void addPosStart(int x, int y) {
        start = new position(x, y);
    }

    public void addPosFinish(int x, int y) {
        finish = new position(x, y);
    }

    public void addWay(int x, int y) {   
        area[size - 1 - y][x] = "00";      
    }                                                   

    public void move(int x, int y) {              
        String temp = Integer.toString(step);
        if (temp.length() == 1) {
            temp = "0" + temp;
        }
        area[size - 1 - start.y][start.x] = "01";
        area[size - 1 - y][x] = temp;
        step++;
    }

    public boolean moveBool(int x, int y) {
try{
        if ((!area[size - 1 - y][x].equalsIgnoreCase("00"))) {
            return false;        
        } else {
            return true;
        }
}catch(IndexOutOfBoundsException a){
        return false;
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int x = 0; x < size; x++) {
                System.out.print("[" + area[i][x] + "] ");
            }
            System.out.println("");
        }
    }

    public int getSize() {
        return this.size;
    }

}
