import java.util.*;

public class BalanceArray{
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        if (args.length > 0) {
            for (String s : args) a.add(Integer.parseInt(s));
        } else {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextInt()) a.add(sc.nextInt());
        }
        if (a.isEmpty()) return;

        balanceArray(a,0,a.size()-1);
        
    }

    // skriver rekkefølgen som gir balansert BST ved vanlig innsetting
    private static void balanceArray(ArrayList<Integer> a, int low, int high) {
        if (low > high) return;
        int mid = low + (high - low + 1) / 2; // venstre median
        System.out.println(a.get(mid));
        balanceArray(a, mid + 1, high);
        balanceArray(a, low, mid - 1);  
    }
}

