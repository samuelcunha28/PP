import Exceptions.FullMemoryException;
import Exceptions.NonSupportedException;
import Pod.File;
import Pod.PPod;

public class PPodDemo {

    public static void main(String[] args) {
        System.out.println("Hello!");

        PPod pod1 = new PPod(100);

        File f1 = new File("aa","mp3", 1.0, 120);
        File f2 = new File("bb","mp3", 1.0, 120);
        File f3 = new File("cc","mp3", 1.0, 120);
        File f4 = new File("dd","mp3", 1.0, 120);
        File f5 = new File("ee","mp3", 1.0, 120);
        File f6 = new File("ff","mp4", 1.0, 120);

        try {
            pod1.addFile(f1);
            pod1.addFile(f2);
            pod1.addFile(f6);
            pod1.addFile(f4);
            pod1.addFile(f5);
            pod1.addFile(f3);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (FullMemoryException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        /**
        try{
            pod1.delete(0);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
         **/

        try{
           pod1.playTrack(0);
        } catch (NonSupportedException e){
            System.out.println(e.getMessage());
        }

        pod1.nextTrack();

    }
}
