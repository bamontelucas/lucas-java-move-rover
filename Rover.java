public class Rover {
    private int x;
    private int y;
    private Cardinal c;

    private int plateauWidth;
    private int plateauHeight;

    public Rover(int width, int height) {
        setPlateau(width, height);
    }

    public Rover(int x, int y, Cardinal c) {
        setState(x, y, c);
    }

    public Rover(int width, int height, int x, int y, Cardinal c) {
        setPlateau(width, height);
        setState(x, y, c);
    }

    public void setPlateau(int width, int height) {
        plateauWidth = width;
        plateauHeight = height;
    }
    
    public void setState(int x, int y, Cardinal c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public void turn(char s) {
        c = (('L' == s) ? c.prior() : c.next());
    }

    public void move() throws MoveRoverException{
        switch(c) {
            case N:
                if(y == plateauHeight) {
                    throw new MoveRoverException("Rover already is at the northern edge of the plateau");
                }
                y++;
                break;
            case E:
                if(x == plateauWidth) {
                    throw new MoveRoverException("Rover already is at the eastern edge of the plateau");
                }
                x++;
                break;
            case S:
                if(y == 0) {
                    throw new MoveRoverException("Rover already is at the southern edge of the plateau");
                }
                y--;
                break;
            case W:
                if(x == 0) {
                    throw new MoveRoverException("Rover already is at the eastern edge of the plateau");
                }
                x--;
                break;
        }
    }

    public void move(char c)  throws MoveRoverException{
        if(c == 'M') {
            move();
        } else {
            turn(c);
        }
    }

    public String getStateString() {
        return String.format("%d %d %s", x, y, c.name());
    }    
}