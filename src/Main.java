// Testing program for SortedArrayList class
//
// David John
// April, 2021


import java.util.Random;

public class Main {

    public static SortedArrayList<Double> XXX;
    public static Random rand;

    public static void main(String[] args) {

        XXX = new SortedArrayList<Double>();
        rand = new Random();

        int count = rand.nextInt(10000);
        for(int i=0; i<count;i++){
            XXX.add(rand.nextDouble());

        }

        XXX.add(0.77);

        System.out.println(XXX);

        System.out.println(XXX.isSorted());
        // dump();

        System.out.println(XXX.rsearch(0.77));
        System.out.println(XXX);

        System.out.println(XXX.rsearch(.3457));
        System.out.println(XXX);

        return;

    }


}
