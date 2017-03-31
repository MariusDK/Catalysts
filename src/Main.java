import java.util.ArrayList;

/**
 * Created by MariusDK on 30.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        CitireFisier c=new CitireFisier();
        String input;
        input=c.citireFiser();
        System.out.println(input);
        ArrayList<Double> a = new ArrayList<Double>();
        String[] Stinput=input.split(" ");
        for (int i = 0 ; i < Stinput.length; i++) {
            a.add(Double.parseDouble(Stinput[i]));
        }
        Prob1 p1=new Prob1();
        p1.setCurrentBank(14.30 ,48.24, 1200, 1680, 1500);
        p1.fillList(a);
        p1.validare();
        p1.sort();
        p1.determinareAngajat();
        p1.printListAngajati();
        p1.printListClienti();
        System.out.println(" ");
        //p1.printList();
    }

}
