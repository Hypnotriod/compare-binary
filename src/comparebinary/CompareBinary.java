package comparebinary;

/**
 *
 * @author Ilya Pikin
 */
public class CompareBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            Comparator comparator = new Comparator();
            comparator.compare(args[0], args[1]);
        } else {
            System.out.println("Please provides 2 files co compare.");
        }

    }

}
