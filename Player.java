
/**
 *
 * @author Bayu Aji Firmansyah
 */
public class Player {

    private String name;
    private Arena arena;
    private String sugest[];

    private position now;

    Player(String[] sugest, Arena arena) {
        this.name = sugest[0];
        this.sugest = new String[4];
        for (int i = 0; i < 4; i++) {
            this.sugest[i] = sugest[i + 1];
        }
        this.arena = arena;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return arena.getStep();
    }

    public void setPosNow(int x, int y) {
        now = new position(x, y);
    }

    public String getSugest(int index) {
        return sugest[index];
    }

    public Arena getArena() {
        return arena;
    }
    private Stack<String> sugestStack = new Stack<String>();

    public void play() throws StackEmpty {
        //kerjain duulu yang ini        
        if (this.arena.finish.x == this.now.x && this.arena.finish.y == this.now.y) {

        } else {
            if (!sugestStack.isEmpty()) {
                if (sugestStack.getTop().equalsIgnoreCase("Up")) {
                    if (arena.moveBool(sugestStack.getPos().getX(), sugestStack.getPos().getY() + 1)) {
                        moveUp(sugestStack.getPos().getX(), sugestStack.getPos().getY());
                        sugestStack.pop();
                        plotSugest();
                        play();
                    } else {
                        sugestStack.pop();
                        play();
                    }
                } else if (sugestStack.getTop().equalsIgnoreCase("Down")) {
                    if (arena.moveBool(sugestStack.getPos().getX(), sugestStack.getPos().getY() - 1)) {
                        moveDown(sugestStack.getPos().getX(), sugestStack.getPos().getY());
                        sugestStack.pop();
                        plotSugest();
                        play();
                    } else {
                        sugestStack.pop();
                        play();
                    }
                } else if (sugestStack.getTop().equalsIgnoreCase("Left")) {
                    if (arena.moveBool(sugestStack.getPos().getX() - 1, sugestStack.getPos().getY())) {
                        moveLeft(sugestStack.getPos().getX(), sugestStack.getPos().getY());
                        sugestStack.pop();
                        plotSugest();
                        play();
                    } else {
                        sugestStack.pop();
                        play();
                    }
                } else if (sugestStack.getTop().equalsIgnoreCase("Right")) {
                    if (arena.moveBool(sugestStack.getPos().getX() + 1, sugestStack.getPos().getY())) {
                        moveRight(sugestStack.getPos().getX(), sugestStack.getPos().getY());
                        sugestStack.pop();
                        plotSugest();
                        play();
                    } else {
                        sugestStack.pop();
                        play();
                    }
                }
            }
        }

    }

    public void plotSugest() {
        for (int i = 3; i >= 0; i--) {
            this.sugestStack.push(this.sugest[i], now);
        }
    }

    private void moveUp(int x, int y) {
        arena.move(x, y + 1);
        setPosNow(x, y + 1);
    }

    private void moveDown(int x, int y) {
        arena.move(x, y - 1);
        setPosNow(x, y - 1);
    }

    private void moveLeft(int x, int y) {
        arena.move(x - 1, y);
        setPosNow(x - 1, y);
    }

    private void moveRight(int x, int y) {
        arena.move(x + 1, y);
        setPosNow(x + 1, y);
    }

    public static Player compareTo(Player a, Player b) {
        if (a.getArena().getStep() < b.getArena().getStep()) {
            return a;
        } else if (a.getArena().getStep() < b.getArena().getStep()) {
            return b;

        } else {
            if ((int) a.getName().charAt(0) > (int) b.getName().charAt(0)) {
                return b;
            } else {
                return a;
            }
        }

    }
}
