public class Domino {
    private int top;
    private int bottom;

    public Domino(){
        top = 0;
        bottom = 0;
    }

    public Domino(int top, int bottom){
        this.top = top;
        this.bottom = bottom;
    }

    public int getTop(){
        return top;
    }

    public int getBottom(){
        return bottom;
    }

    public void setTop(int t){
        this.top = t;
    }

    public void setBottom(int b){
        this.bottom = b;
    }

    public String toString(){
        return top + "/" + bottom;
    }

    public void flip(){
        int t = top;
        int b = bottom;
        top = b;
        bottom = t;
    }

    public void settle(){
        if (top > bottom){
            flip();
        }
    }

    public int compareTo(Domino other){
        int result = 0;

        int thisSmaller = 0;
        int thisLarger = 0;
        int otherSmaller = 0;
        int otherLarger = 0;

        if (this.top < this.bottom){
            thisSmaller = top;
            thisLarger = bottom;
        }
        else {
            thisSmaller = bottom;
            thisLarger = top;
        }

        if (other.top > other.bottom){
            otherSmaller = other.bottom;
            otherLarger = other.top;
        }
        else {
            otherLarger = other.bottom;
            otherSmaller = other.top;
        }

        if (thisSmaller < otherSmaller){
            result = -1;
        }
        else if (thisSmaller > otherSmaller){
            result = 1;
        }
        else {
            if (thisLarger < otherLarger){
                result = -1;
            }
            else if (thisLarger > otherLarger){
                result = 1;
            }
            else {
                result = 0;
            }
        }
        return result;
    }

    public int compareToWeight(Domino other){
        int result = 0;
        int thisTotal = this.bottom + this.top;
        if (thisTotal < other.top + other.bottom){
            result = -1;
        }
        else if (thisTotal > other.top + other.bottom){
            result = 1;
        }
        else if (thisTotal == other.top + other.bottom){
            result = 0;
        }

        return result;
    }

    public boolean canConnect(Domino other){
        return (this.top == other.top || this.top == other.bottom || this.bottom == other.bottom || this.bottom == other.top);
    }
}