package com.hypnotriod.comparebinary;

/**
 *
 * @author Ilya Pikin
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            Comparator comparator = new Comparator();
            comparator.compare(args[0], args[1]);
        } else {
            System.out.println("Usage: java -jar compare-binary <path_to_bin_file_1> <path_to_bin_file_2>");
        }

    }

}
