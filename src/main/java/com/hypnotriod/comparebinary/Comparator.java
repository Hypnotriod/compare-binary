package com.hypnotriod.comparebinary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Ilya Pikin
 */
public class Comparator {

    public static final int BUFFER_SIZE_BYTES = 1024;

    public void compare(String file1Path, String file2Path) {
        byte[] buffer1 = new byte[BUFFER_SIZE_BYTES];
        byte[] buffer2 = new byte[BUFFER_SIZE_BYTES];
        FileInputStream inputStream1;
        FileInputStream inputStream2;
        int bytesRead1;
        int bytesRead2;
        long index = 0;
        long numberOfDifferentBytes = 0;

        try {
            inputStream1 = new FileInputStream(file1Path);
            inputStream2 = new FileInputStream(file2Path);

            while (true) {

                bytesRead1 = inputStream1.read(buffer1);
                bytesRead2 = inputStream2.read(buffer2);

                for (int i = 0; i < Math.min(bytesRead1, bytesRead2); i++) {
                    if (buffer1[i] != buffer2[i]) {
                        System.out.println(
                                String.format("#%010d:%08X %02Xh != %02Xh", index, index,
                                        buffer1[i], buffer2[i])
                        );
                        numberOfDifferentBytes++;
                    }
                    index++;
                }

                if (bytesRead1 == -1 || bytesRead2 == -1) {
                    if (bytesRead1 == -1) {
                        System.err.println("End of File 1 reached.");
                    }
                    if (bytesRead2 == -1) {
                        System.err.println("End of File 2 reached.");
                    }

                    if (bytesRead1 == -1 && bytesRead2 == -1) {
                        if (numberOfDifferentBytes == 0) {
                            System.out.println("Files are identical!");
                        } else {
                            System.out.println(
                                    String.format("%d bytes differ.", numberOfDifferentBytes)
                            );
                        }
                    } else {
                        if (numberOfDifferentBytes == 0) {
                            System.out.println("Files have different length.");
                        } else {
                            System.out.println(
                                    String.format("Files have different length and %d bytes are differ.", numberOfDifferentBytes)
                            );
                        }
                    }

                    break;
                }

            }

        } catch (FileNotFoundException ex) {
            System.err.println("File not foud: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Can't read file: " + ex.getMessage());
        }

    }
}
