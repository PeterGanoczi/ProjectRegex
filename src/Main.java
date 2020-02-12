import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sk.itsovy.data.DataIP;

public class Main {
    public static void main(String[] args) {
        DataIP data=new DataIP();


        System.out.println(data.get());
        regexIpAdress((ArrayList<String>) data.get());

    }

    public static void regexIpAdress(ArrayList<String> list){

        String pattern="^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
        Pattern pattern1=Pattern.compile(pattern);

        for (int i=0; list.size()>i;i++) {

            if (list.get(i) != null) {
                Matcher matcher = pattern1.matcher(list.get(i));
                while (matcher.find()) {
                    System.out.println("Found match: " + matcher.group());
                }
            }
        }


    }
}
