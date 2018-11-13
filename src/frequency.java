import java.util.*;

public class frequency {
    public static void main(String args[]){
        String input = "YOU, ME, WE, SHE, HE, SOW, COW, DOG, PIG, RIG, GOLD, SEA, RUG, HAT, CAT, ROW, MOB, LOG, BOX, TAB, BAR, EAR, TAR, JAR, DIG, FAN, BIG, TEA, NOW, FOX, BOG, BAT, BIT, KIT, SIT, ZEN, RAN, FAN, QUIZ, VAN";

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        String s = input;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer val = map.get(c);
            if (val != null) {
                map.put(c, new Integer(val + 1));
            }
            else {
                map.put(c, 1);
            }
        }




        String[] chars = new String[28];
        int[] fre = new int[28];
        int i = 0;
        for (Character name: map.keySet()){
            String key =name.toString();
            int value = map.get(name);
            System.out.println(key + " " + value);
            chars[i] = key;
            fre[i] = value;
            i++;

        }
        int flag= 0;
        int inifre = 1;
        int si = 0;
        String[] sortedchars = new String[28];
        int[] sortedfre = new int[28];
        while (flag < 28){
            int count = 0;
            for (Character name: map.keySet()){
                String key =name.toString();
                int value = map.get(name);

               if (value == inifre){
                   sortedchars[si] = key;
                   sortedfre[si] = value;
                   map.remove(key);
                   si++;
                   flag++;
               }

            }
            inifre++;
        }

        for (int j =0;j<28;j++){
            System.out.print("'"+sortedchars[j]+"',");
        }
        for (int j =0;j<28;j++){
            System.out.print(sortedfre[j]+",");
        }

    }




}
