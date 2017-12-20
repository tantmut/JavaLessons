package homeworks.HW.fileManager;



import java.io.File;
import java.io.IOException;

public class FileManager {

    public static final String   start = "D:\\";
    public static final String   currentFolder = "D:\\";

    public void createDirectory(String name){
        File folder = new File (start +"//"+ name);
        folder.mkdir();
    }

    public void createFile(String name) throws IOException {
        File file = new File(currentFolder +"//"+ name);
        file.createNewFile( );
    }
    public void copyFileFromOneDirToAnotherDir(String nameFile, String nameDirectory) throws IOException {

        /*
        File file = new File("D:\\2.txt");
        String path = "D:\\sgfdsdfg";

        Files.copy(file.toPath(),
                    (new File(path + file.getName())).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        */

        File source =   new File(start + nameFile) ;
        File dest = new File(start + nameDirectory);
       /* try {
            FileUtils.copyFileToDirectory(source, dest, true);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
     }

     public void convertFromTxtToPdf(){

     }
    public void removeEmptyDir(String name){
        File file = new File( start + name);
        file.delete();
    }

    public  void removeNonEmptyDir(File dir) {

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                for (File aFile : files) {
                    removeNonEmptyDir(aFile);
                }
            }
            dir.delete();
        } else {
            dir.delete();
        }
    }

    public void removeFile(String name){
        File file = new File (start + name);
        file.delete();
    }

    public void renameDir(String name, String newName){
        File file = new File(start +name);
        File newFile = new File(file.getParent() + newName);
        file.renameTo(newFile);
    }

    public void renameFile(String name, String newName){
        File file = new File(start + name);
        File newFile = new File(file.getParent() + newName);
        file.renameTo(newFile);
    }


    public void DisplayTheContentsOfADirectory(String name){
        File file = new File(start + name);

        File[] contentsOfDirectory = file.listFiles();
        for (File object: contentsOfDirectory){
            if(object.isFile()){
                System.out.format("File name: %s%n", object.getName());
            }
            else if (object.isDirectory()){
                System.out.format("Directory name: %s%n", object.getName());
            }
        }
    }
    //new File(start + "Directory").mkdir();
    public static void main(String[] args) throws IOException {
        File file1 = new File( start + "first");
        FileManager fm = new FileManager();
     }
}

