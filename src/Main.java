import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sk.itsovy.data.DataIP;
import sk.itsovy.data.PersonalID;

public class Main {
    private static final String IPPATTERN="^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
    private static final String IDPATTERN="^[0-9]{2}[0156][0-9]{3}\\/?[0-9]{3,4}$";

    public static void main(String[] args) {
        DataIP data=new DataIP();
        PersonalID personalId=new PersonalID();

        System.out.println(data.get());
        System.out.println("------Correct IP adresses------");
        regex((ArrayList<String>) data.get(),IPPATTERN);

        System.out.println(personalId.get());
        System.out.println("------Correct personal ID------");
        regex((ArrayList<String>) personalId.get(),IDPATTERN);
    }

    public static void regex(ArrayList<String> list, String pattern){
        Pattern pattern1=Pattern.compile(pattern);

        for (int i=0; list.size()>i;i++) {

            if (list.get(i) != null) {
                Matcher matcher = pattern1.matcher(list.get(i));
                while (matcher.find()) {
                    System.out.println("Found match: " + matcher.group());
                }
            }
        }
        System.out.println();
    }
}
