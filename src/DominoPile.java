import java.util.*;
public class DominoPile {
    ArrayList<Domino> pile;

    public DominoPile(){
        pile = new ArrayList<>();
    }

    public void newStack6(){
        for (int i = 0; i <= 6; i++){
            for (int j = i; j <= 6; j++){
                Domino temp = new Domino(i,j);
                pile.add(temp);
            }
        }
    }

    public void shuffle(){
        Random r1 = new Random();
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Domino> temp = new ArrayList<>();

        int ind = -1;
        for (int i=0; i<pile.size(); i++){
            while (ind == -1 || index.contains(ind)){
                ind = r1.nextInt(pile.size());
            }
            temp.add(pile.get(ind)); // add corresponding index domino to the pile
            index.add(ind); // add ind to index to prevent it from being selected again
        }

        pile.clear(); // clear original pile
        for (Domino domino : temp){
            pile.add(domino);
        }
    }

    public void shuffleTwo() {
        Random r1 = new Random();
        for (int i = 0; i <= pile.size()-1; i--) {
            Collections.swap(pile, i, r1.nextInt(pile.size()));
        }
    }

    public ArrayList<Domino> getPile(){
        return pile;
    }
}