package by.belstu.it.lyskov.lab13;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameList {
    public String[] fileNameList;

    protected static class ExtensionFilter implements FilenameFilter {
        String extension;

        public ExtensionFilter(String extension) {
            this.extension = "." + extension;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(extension);
        }
    }

    public FileNameList(String dirName, String xxx) {
        File dir = new File(dirName);
        if (dir.exists())
            fileNameList = dir.list(new ExtensionFilter(xxx));
    }
}
