import java.util.*;

public class df {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String pm = scanner.nextLine();

        if((pm).getClass().getSimpleName()=="String"){
        char hascmes = scanner.next().charAt(0);

        scanner.nextLine(); 

        String[] cmes = {};
        if (hascmes == 'Y' || hascmes == 'y') {
        
            String cmesString = scanner.nextLine();
            cmes = cmesString.split(",");
        }

        scanner.close();

        int sa = 5000;

        int totalMembers = 1 + cmes.length;
        System.out.println(totalMembers);

        Map<String, Integer> cm = cac(pm, cmes, sa);

        
        for (Map.Entry<String, Integer> entry : cm.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        }
        else{
            System.out.println("INVALID INPUT");
        }
    }

    public static Map<String, Integer> cac(String pm, String[] cmes, int sa) {
        Map<String, Integer> cm = new HashMap<>();

        int pc = (int) (0.1 * sa);
        cm.put(pm, pc);

        if (cmes.length > 0) {
            int cc = (int) (0.05 * sa);
            for (String cme : cmes) {
                cm.put(cme, cc);
            }
        } else {
            cm.put(pm, pc + (int) (0.05 * sa));
        }

        return cm;
    }
}
