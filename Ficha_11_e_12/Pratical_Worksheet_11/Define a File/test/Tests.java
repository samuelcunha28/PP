import org.junit.Assert;
import org.junit.Test;
import player.File;

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


}