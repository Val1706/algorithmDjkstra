import java.util.Scanner;

public class View {

    public static String getCountry() {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        return s;
    }

    public static void getFirtsCountry(){
        System.out.println("Type first country: ");
    }

    public static void getNextCountry(){
        System.out.println("Type next country: ");
    }

    public static Integer getFirstDistance(){
        Scanner scan = new Scanner(System.in);
        Integer dist = scan.nextInt();
        return dist;
    }

    public static void showDistanceMsg(String country1, String country2){
        System.out.println("Type distance between " + country1 + "and" + country2);
    }
}
