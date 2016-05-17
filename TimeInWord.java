/**
 * Created by Tanvir Irfan Fahim on 11-May-16.
 * https://www.hackerrank.com/challenges/the-time-in-words
 * Given the time in numerals we may convert it into words, as shown below:

 5:00→ five o' clock
 5:01→ one minute past five
 5:10→ ten minutes past five
 5:30→ half past five
 5:40→ twenty minutes to six
 5:45→ quarter to six
 5:47→ thirteen minutes to six
 5:28→ twenty eight minutes past five
 */
import java.util.*;
public class TimeInWord {
    static HashMap<Integer,String> numbers;
    static String[] min;
    public static void main(String [] s) {
        populateData();

        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();

        String res = "";
        if(m == 0) {
            res = numbers.get(h) + " " + min[2];
        } else{
            switch (m) {
                case 1:
                    res = numbers.get(m) + " " + min[0] + " " + min[4] + " " + numbers.get(h);
                    break;
                case 15:
                    res = numbers.get(m) + " " + min[4] + " " + numbers.get(h);
                    break;
                case 30:
                    res = numbers.get(m) + " " + min[4] + " " + numbers.get(h);
                    break;
                case 45:
                    res = numbers.get(m) + " " + min[3] + " " + numbers.get(h+1);
                    break;
                case 59:
                    res = numbers.get(m) + " " + min[1] + " " + min[3] + " " + numbers.get(h);
                    break;
                default:
                    if(m < 30) {
                        res = numbers.get(m) + " " + min[1] + " " + min[4] + " " + numbers.get(h);
                    } else {
                        res = numbers.get(60-m) + " " + min[1] + " " + min[3] + " " + numbers.get(h+1);
                    }
            }
        }

        System.out.println(res);
    }

    public static HashMap<Integer,String> populateData() {
        numbers = new HashMap<Integer,String>();
        numbers.put(1,"one");numbers.put(2,"two");numbers.put(3,"three");numbers.put(4,"four");numbers.put(5,"five");numbers.put(6,"six");
        numbers.put(7,"seven");numbers.put(8,"eight");numbers.put(9,"nine");numbers.put(10,"ten");numbers.put(11,"eleven");numbers.put(12,"twelve");
        numbers.put(13,"thirteen");numbers.put(14,"fourteen");numbers.put(15,"quarter");numbers.put(16,"sixteen");numbers.put(17,"seventeen");numbers.put(18,"eighteen");
        numbers.put(19,"nineteen");numbers.put(20,"twenty");numbers.put(21,"twentyone");numbers.put(22,"twentytwo");numbers.put(23,"twentythree");numbers.put(24,"twentyfour");
        numbers.put(25,"twentyfive");numbers.put(26,"twentysix");numbers.put(27,"twentyseven");numbers.put(28,"twentyeight");numbers.put(29,"twentynine");numbers.put(30,"half");
        numbers.put(31,"thirtyone");numbers.put(32,"thirtytwo");numbers.put(33,"thirtythree");numbers.put(34,"thirtyfour");numbers.put(35,"thirtyfive");numbers.put(36,"thirtysix");
        numbers.put(37,"thirtyseven");numbers.put(38,"thirtyeight");numbers.put(39,"thirtynine");numbers.put(40,"forty");numbers.put(41,"fortyone");numbers.put(42,"fortytwo");
        numbers.put(43,"fortythree");numbers.put(44,"fortyfour");numbers.put(45,"quarter");numbers.put(46,"fortysix");numbers.put(47,"fortyseven");numbers.put(48,"fortyeight");
        numbers.put(49,"fortynine");numbers.put(50,"fifty");numbers.put(51,"fiftyone");numbers.put(52,"fiftytwo");numbers.put(53,"fiftythree");numbers.put(54,"fiftyfour");
        numbers.put(55,"fiftyfive");numbers.put(56,"fiftysix");numbers.put(57,"fiftyseven");numbers.put(58,"fiftyeight");numbers.put(59,"fiftynine");numbers.put(60,"sixty");

        min = new String[5];
        min[0] = "minute";
        min[1] = "minutes";

        min[2] = "o\' clock";
        min[3] = "to";
        min[4] = "past";
        return numbers;
    }
}
