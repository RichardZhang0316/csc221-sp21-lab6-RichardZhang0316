//LBA 6
//Richard Zhang
//2 May 2021
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
    /*
    * First, the constructor inherits the constructor of the superclass of SortedArralyList, which is ArrayList. Then, the
    * constructor sets the probe, which is the number of steps that rfind() method takes to find the object the user
    * wants to find in a SortedArrayList, to be 0.
     */
    public SortedArrayList(){
        super();
        probe = 0;
    }

    //This is the getter method of probe
    public int getProbe(){return probe;}
    //this method reset the probe to be zero
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

        if(position==-1){
            super.add(0,X);
        }
        else if(position==size()){
            super.add(X);
        }
        else {
            super.add(position, X);
        }
        return true;
    }

    // The (non-recursive) rsearch() method searches for X in the SortedArrayList.
    // If found, rsearch() returns the index to X in the SortedArrayList.
    // If not found, rsearch() returns the index where X should be added, or
    //   -1 if X should be added at the front of the list, or this.size() if
    //   X should be inserted at the rear of the list.
    // TODO -- complete rsearch()
    public int rsearch(T X){

        this.probe = 0;
        int position = rfind(X,0, this.size()-1);
        return position;
    }

    // The recursive rfind() method searches for X in the SortedArrayList
    //    between indices first and last (inclusive).
    //  rfind() returns the index where X is located, or the index where X
    //  should be added.
    // TODO -- complete rfind()
    public int rfind(T X, int first, int last){
        //First consider the situation when the X is not in the ArrayList
        //Consider when there is only one object in this SortedArrayList
        if(last-first<1){
            //X precedes the object in this list
            if(X.compareTo(this.get(first))<0){
                probe++;
                return first;
            }
            //X is equal the object in this list
            else if(X.compareTo(this.get(first))==0){
                probe++;
                return first;
            }
            //X follows the object in this list
            else {
                probe++;
                return last+1;
            }
        }

        //get the middle object in the list
        int middle = (first + last)/2;
        int compare = X.compareTo(this.get(middle)); //what is "this"???
        if(compare<0){
            //this situation happens when X lies in the first half of a list
            probe++;
            return rfind(X,first,middle-1);
        }
        else if(compare==0){
            //this situation happens when X is in the middle of a list
            probe++;
            return middle;
        }
        else{
            //this situation happens when X lies in the second half of a list
            probe++;
            return rfind(X,middle+1,last);
        }
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
