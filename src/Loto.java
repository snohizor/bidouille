import javax.sound.midi.Soundbank;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class Loto {


    int tirage[] = {0,0,0,0,0,0};

    long tests = 0;
    int totalTests = 0;

    int myNumbers[] = {4,8,15,21,25,5};
    int myNumbersez[] = {8,41,12,29,17,6};

    boolean stop = false;



    public Loto(){


        while(!stop) {

            tests++;

            tirage[0] = getRng();
            tirage[1] = getRng();
            tirage[2] = getRng();
            tirage[3] = getRng();
            tirage[4] = getRng();
            tirage[5] = getRngOverTen();

            if(tests%1000000 == 0)
            System.out.println( NumberFormat.getNumberInstance(Locale.US).format(tests).toString());

            /*try{
            Thread.sleep(250);
            }catch(Exception e){

            }*/

            /*System.out.println(Arrays.toString(tirage));*/


            if(Arrays.equals(myNumbers, tirage)){
                System.out.println("gg test : " + NumberFormat.getNumberInstance(Locale.US).format(tests).toString());
                stop = true;
            }


        }

    }

    private int getRng(){

        int rng =  (int)(Math.random() * (49 - 1)) + 1;

        boolean duplicate = tableContains(rng);


        while(duplicate){

            rng = (int)(Math.random() * (49 - 1)) + 1;

            duplicate = tableContains(rng);
        }

        return rng;

    }

    private int getRngOverTen(){
        int rng = (int)(Math.random() * (9 - 1)) + 1;
        return rng;
    }

    boolean tableContains(int toCheck){

        for(int i : tirage){
            if(i == toCheck)
                return true;
        }


        return false;

    }

    private boolean isbBoolean(int d, int e, int f, int myD, int myE, int myF) {
        return d == myD && e == myE && f == myF;
    }

    private boolean isaBoolean(int a, int b, int c, int myA, int myB, int myC) {
        return a == myA && b == myB && c == myC;
    }


}
