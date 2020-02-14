import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sk.itsovy.data.DataIP;
import sk.itsovy.data.PersonalID;
import sk.itsovy.data.Date;
import sk.itsovy.data.MacAddress;

public class Main {
    private static final String IPPATTERN="^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
    private static final String IDPATTERN="^[0-9]{2}[0156][0-9]{3}\\/?[0-9]{3,4}$";
    private static final String MACADRESS="^([0-9 A-F a-f]{2}\\:){5}([0-9 A-F a-f]{2})$";
    private static final String DATEPATTERN="^((([1-9]|[12][0-9]|3[0-1])\\.(1|3|5|7|8|10|12))|(([1-9]|[12][0-9]|30)\\." +
            "(4|6|9|11))|(([1-9]|[12][0-9])\\.2))\\.(19|20)[0-9]{2}$";

    public static void main(String[] args) {
        DataIP data=new DataIP();
        PersonalID personalId=new PersonalID();
        Date date=new Date();
        MacAddress macAddress=new MacAddress();


        System.out.println(data.get());
        System.out.println("------Correct IP adresses------");
        regex((ArrayList<String>) data.get(),IPPATTERN);

        System.out.println(personalId.get());
        System.out.println("------Correct personal ID------");
        regex((ArrayList<String>) personalId.get(),IDPATTERN);

        System.out.println(date.get());
        System.out.println("------Correct date format------");
        regex((ArrayList<String>) date.get(),DATEPATTERN);

        System.out.println(macAddress.get());
        System.out.println("------Correct MAC Address------");
        regex((ArrayList<String>) macAddress.get(),MACADRESS);
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
