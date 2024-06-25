package algo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SearchInFile {
    public static void main(String[] args) {
        int[] ar = new int[]{3, 6, 1, 8, 4, 2};
        ArrayList<File> fileList = new ArrayList<>();
        File f = new File("/Users/albertabih/Documents/hystory/Pictures/");
      /*  searchFiles(f, fileList);
        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }*/
    }

    private static void searchFiles(File rooFile, List<File> fileList) {
        if (rooFile.isDirectory()) {
            System.out.println("searching at: " + rooFile.getAbsolutePath());
            File[] directoryFiles = rooFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".jpg"))
                            fileList.add(file);
                    }
                }
            }
        }
    }
}
