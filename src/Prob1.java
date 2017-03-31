import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by MariusDK on 30.03.2017.
 */
public class Prob1 {
    public ArrayList<Persoane> list=new ArrayList<Persoane>();
    public ArrayList<Double> listRezultat=new ArrayList<Double>();
    public Bank c=new Bank();
    public ArrayList<Double> Angajanti=new ArrayList<>();
    public ArrayList<Double> Clienti=new ArrayList<>();

    public double distanceEuclidian(double x,double y)
    {
        double rez;
        rez=Math.sqrt(Math.pow((x-c.getxPosition()),2)+Math.pow((y-c.getyPosition()),2));
        return rez;
    }
    public int validare()
    {
        int count=0;
        for (Persoane a:list)
        {
            if ((distanceEuclidian(a.getxPosition(),a.getyPosition())<=0.0003)&&(a.getTime()==c.getTimeRobbery()))
            {
              count++;
              listRezultat.add(a.getDeviceId());
            }
        }
    return count;
    }
    public void sort()
    {
        Collections.sort(listRezultat);
    }
    public void fillList(ArrayList<Double> a)
    {
        int i=0;
        while(i<a.size())
        {
            Persoane p=new Persoane();
            p.setDeviceId(a.get(i));
            p.setTime(a.get(i+1));
            p.setxPosition(a.get(i+2));
            p.setyPosition(a.get(i+3));
            i=i+4;
            list.add(p);
        }

    }
    public void setCurrentBank(double x,double y,double timeopen,double timeclose,double time)
    {
        c.setBankClosingTime(timeclose);
        c.setBankOpeningTime(timeopen);
        c.setTimeRobbery(time);
        c.setxPosition(x);
        c.setyPosition(y);
    }
    public void printList()
    {
        for (int i=0;i<listRezultat.size();i++)
        {
            System.out.println(" "+listRezultat.get(i));
        }

    }
    public double TimeBank()
    {
        double time=c.getBankClosingTime()-c.getBankOpeningTime();

        return time;
    }
    public double CandAjunge(double deviceId)
    {
        double time=c.getTimeRobbery();
        for (Persoane p:list)
        {
            if ((distanceEuclidian(p.getxPosition(),p.getyPosition())<=0.0003)) {
                if ((p.getDeviceId() == deviceId) && (p.getTime() <= c.getTimeRobbery())) {
                    if (time > p.getTime()) {
                        time = p.getTime();
                    }
                }
            }
        }
        return time;
    }
    public double CandPleaca(double deviceId)
    {
        double time=c.getTimeRobbery();

            for (Persoane p:list)
        {
            if ((distanceEuclidian(p.getxPosition(),p.getyPosition())<=0.0003)) {
                if ((p.getDeviceId() == deviceId) && (p.getTime() >= c.getTimeRobbery())) {
                    if (time < p.getTime()) {
                        time = p.getTime();
                    }
                }
            }
        }
        return time;
    }
    public void determinareAngajat()
    {
        double timeBank=TimeBank();

        for (int i=0;i<listRezultat.size();i++)
        {
            if (((timeBank*7)/10)<(CandPleaca(listRezultat.get(i))-CandAjunge(listRezultat.get(i))))
            {

                Angajanti.add(listRezultat.get(i));
            }
            else
            {
                Clienti.add(listRezultat.get(i));
            }
        }

    }
    public void printListAngajati()
    {
        Collections.sort(Angajanti);
        System.out.print(Angajanti.size());
        for (int i=0;i<Angajanti.size();i++)
        {
            System.out.print(" "+Angajanti.get(i));
        }
    }
    public void printListClienti()
    {
        Collections.sort(Clienti);
        System.out.print(" "+Clienti.size());
        for (int i=0;i<Clienti.size();i++)
        {
            System.out.print(" "+Clienti.get(i));
        }
    }

}
