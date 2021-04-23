// SortedArrayList Class
//   This is a generic class that extends ArrayList.  The generic T must
//   extend Comparable as well.
//
//   SortedArrayList is a simple, perhaps naive, class that maintains
//   a sorted list when adding and removing.  The  rfind()  implements
//   a recursive binary search.
//
//   This has developed for an example, and no claims for complete correctness are
//   given.  USE AT OWN RISK
//
//   David John
//   April, 2021

import java.util.ArrayList;
import java.util.Comparator;

public class SortedArrayList<T extends Comparable<T> > extends ArrayList<T> {

    private int probe;

    // TODO -- comments to explain what happens here
    public SortedArrayList(){
        super();
        probe = 0;
    }

    public int getProbe(){return probe;}
    public void resetProbe(){probe = 0;}


    // TODO -- complete this code
    public boolean add(T X){

        // if this is empty, then add X as the
        // only element of this
        if (isEmpty()){
            super.add(X);
            return true;
        }

        // find where to insert X and then insert it
        int position = this.rsearch(X);

        return true;
    };

    // The (non-recursive) rsearch() method searches for X in the SortedArrayList.
    // If found, rsearch() returns the index to X in the SortedArrayList.
    // If not found, rsearch() returns the index where X should be added, or
    //   -1 if X should be added at the front of the list, or this.size() if
    //   X should be inserted at the rear of the list.
    // TODO -- complete rsearch()
    public int rsearch(T X){

        this.probe = 0;
        int position = rfind(X,0, this.size()-1);

        return 33;

    }

    // The recursive rfind() method searches for X in the SortedArrayList
    //    between indices first and last (inclusive).
    //  rfind() returns the index where X is located, or the index where X
    //  should be added.
    // TODO -- complete rfind()
    public int rfind(T X, int first, int last){

        return 77;

    }




    // utility method to dump the list (limited value)
    public  void dump(){
        for(int i=0;i<this.size();i++){
            System.out.println(this.get(i));
        }

    }

    // utility method to check to make sure the list is sorted
    public  boolean isSorted(){
        for(int i=0; i<this.size()-1;i++){
            if (this.get(i).compareTo(this.get(i+1))>0){return false;}
        }
        return true;
    }

    public String toString(){ return "size() = "+this.size()+" :  probes "+this.probe;}
}
