import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String parentMember = scanner.nextLine();

        if((parentMember).getClass().getSimpleName()=="String"){
        char hasChildMembers = scanner.next().charAt(0);

        scanner.nextLine(); 

        String[] childMembers = {};
        if (hasChildMembers == 'Y' || hasChildMembers == 'y') {
        
            String childMembersString = scanner.nextLine();
            childMembers = childMembersString.split(",");
        }

        scanner.close();

        int schemeAmount = 5000;

        int totalMembers = 1 + childMembers.length;
        System.out.println(totalMembers);

        Map<String, Integer> commissionMap = calculateCommission(parentMember, childMembers, schemeAmount);

        
        for (Map.Entry<String, Integer> entry : commissionMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        }
        else{
            System.out.println("INVALID INPUT");
        }
    }

    public static Map<String, Integer> calculateCommission(String parentMember, String[] childMembers, int schemeAmount) {
        Map<String, Integer> commissionMap = new HashMap<>();

        int parentCommission = (int) (0.1 * schemeAmount);
        commissionMap.put(parentMember, parentCommission);

        if (childMembers.length > 0) {
            int childCommission = (int) (0.05 * schemeAmount);
            for (String childMember : childMembers) {
                commissionMap.put(childMember, childCommission);
            }
        } else {
            commissionMap.put(parentMember, parentCommission + (int) (0.05 * schemeAmount));
        }

        return commissionMap;
    }
}
