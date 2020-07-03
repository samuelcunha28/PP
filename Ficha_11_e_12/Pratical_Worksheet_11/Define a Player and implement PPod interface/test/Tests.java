import org.junit.Assert;
import org.junit.Test;
import player.File;
import player.IFile;
import player.PPlayer;
import player.exceptions.InvalidFileException;
import player.exceptions.InvalidPlayerStateException;

public class Tests {
    @Test
    public void testSolutionFile1() {
        File f1 = new File("Legendary Tiger Man - Big Black Boat", "mp3", 3072, 5);

        Assert.assertEquals("Name is not set properly", "Legendary Tiger Man - Big Black Boat", f1.getName());
        Assert.assertEquals("Extension is not set properly", "mp3", f1.getExtension());
        Assert.assertEquals("Duration is not set properly", 5, f1.getDurationSecs());
        Assert.assertEquals("Size is not set properly", 3072, f1.getSizeKB());
        Assert.assertTrue("toString is not including file name", f1.toString().contains(f1.getName()));
        Assert.assertTrue("toString is not including file extension", f1.toString().contains(f1.getExtension()));
        Assert.assertTrue("toString is not including file duration", f1.toString().contains(String.valueOf(f1.getDurationSecs())));
        Assert.assertTrue("toString is not including file size", f1.toString().contains(String.valueOf(f1.getSizeKB())));


    }

    @Test
    public void testSolutionFile2() {
        File f1 = new File("Legendary Tiger Man - Big Black Boat", "mp4", 5120, 15);

        Assert.assertEquals("Name is not set properly", "Legendary Tiger Man - Big Black Boat", f1.getName());
        Assert.assertEquals("Extension is not set properly", "mp4", f1.getExtension());
        Assert.assertEquals("Duration is not set properly", 15, f1.getDurationSecs());
        Assert.assertEquals("Size is not set properly", 5120, f1.getSizeKB());
        Assert.assertTrue("toString is not including file name", f1.toString().contains(f1.getName()));
        Assert.assertTrue("toString is not including file extension", f1.toString().contains(f1.getExtension()));
        Assert.assertTrue("toString is not including file duration", f1.toString().contains(String.valueOf(f1.getDurationSecs())));
        Assert.assertTrue("toString is not including file size", f1.toString().contains(String.valueOf(f1.getSizeKB())));

    }

    @Test
    public void testSolutionEqualsTrue() {
        File f1 = new File("Legendary Tiger Man - Big Black Boat", "mp3", 3072, 5);
        File f2 = new File("Legendary Tiger Man - Big Black Boat", "mp3", 3072, 5);
        Assert.assertEquals("Comparison between two files with all equal attributes must return true", f1, f2);
        Assert.assertEquals("Comparing with the same object must return true", f1, f1);
        Assert.assertEquals("Comparing with the same object must return true", f2, f2);
    }

    @Test
    public void testSolutionEqualsFalse() {
        File f1 = new File("Legendary Tiger Man - Big Black Boat", "mp3", 3072, 5);
        File f2 = new File("Legendary Tiger Man - Big Black Boat", "mp4", 5120, 15);
        Assert.assertNotEquals("Comparison between two files with different attributes must return false", f1, f2);
        Assert.assertNotEquals("Comparing with null must return false", null, f1);
        Assert.assertNotEquals("Comparing with different type of object must return false", f1, new Object());
    }

    @Test
    public void addFileNull() {

        PPlayer pp = new PPlayer();
        try {
            pp.addFile(null);
        } catch (InvalidPlayerStateException e) {
            Assert.fail("Adding a null file should create a InvalidFileException");
        } catch (InvalidFileException ignored) {

        }

    }

    @Test
    public void addFileOverMemoryLimit() {
        PPlayer pp = new PPlayer();
        try {
            pp.addFile(new File("Legendary Tiger Man - Big Black Boat", "mp3", 200000, 5));
        } catch (InvalidPlayerStateException ignored) {

        } catch (InvalidFileException e) {
            Assert.fail("Surpassing the available memory should return InvalidPlayerStateException");
        }
    }

    @Test
    public void addFileOverPlayerCapacity() {
        PPlayer pp = new PPlayer();
        try {
            for (int i = 0; i < 21; i++) pp.addFile(new File("Legendary Tiger Man - Big Black Boat", "mp3", 1024, 30));
        } catch (InvalidPlayerStateException ignored) {

        } catch (InvalidFileException e) {
            Assert.fail("Adding more than 20 files should return InvalidPlayerStateException");
        }

    }




}