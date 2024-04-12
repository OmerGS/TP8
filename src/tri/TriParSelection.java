package tri;
import pays.Pays;

public class TriParSelection implements Itri{
    private Pays[] tab;

    public TriParSelection(Pays[] tab){
        this.tab = tab;
    }

    private void swap(int i, int j){
        if(i >= 0 && i < this.tab.length && j >= 0 && j < this.tab.length){
            Pays temporaire = this.tab[i];
            this.tab[i] = this.tab[j];
            this.tab[j] = temporaire; 
        } else {
            System.out.println("I et J sont incorrect");
        }
    }

    private int minimumPosition(int debut) {
        int minPos = debut;
        for (int i = debut + 1; i < tab.length; i++) {
            if (tab[i].getSurface() > tab[minPos].getSurface()) {
                minPos = i;
            }
        }
        return minPos;
    }
    

    public void trier() {
        for (int i = 0; i < tab.length - 1; i++) {
            int minPos = minimumPosition(i);
            swap(i, minPos);
        }
    }
    
}
