public class Test{
    public static void main(String[] args){
        double[] array1 = {1.1, 22, 3.3, 4.4, 5.5, 0.5, 7.7, 8.8, 9.9, 11};
        double[] results = MMR.findMaxAndMin(array1);
        for(double d : results){
            System.out.println(d);
        }
    }
}
