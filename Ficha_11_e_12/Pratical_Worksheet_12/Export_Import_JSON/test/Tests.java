import org.junit.Assert;
import org.junit.Test;
import player.File;
import player.IFile;
import player.PPlayer;
import player.comparators.AscendingDurationComparator;
import player.comparators.AscendingNameComparator;
import player.comparators.DescendingFilesizeComparator;
import player.exceptions.InvalidFileException;
import player.exceptions.InvalidPlayerStateException;

import java.io.IOException;

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

    @Test
    public void addFilePlayFileDeleteFile() {
        File f = new File("Legendary Tiger Man - Big Black Boat", "mp3", 1024, 1);
        PPlayer pp = new PPlayer();
        try {
            pp.addFile(f);
            pp.playTrack(0);
            IFile resp = pp.deleteFile(0);
            Assert.assertEquals("Removing an element is not working properly", f, resp);
        } catch (InvalidPlayerStateException | InvalidFileException e) {
            Assert.fail("Throwing exception when adding and removing file correctly");
        }

    }

    @Test
    public void addFilePlayFiles() {
        File f = new File("Legendary Tiger Man - Big Black Boat", "mp3", 1024, 1);
        File f1 = new File("Legendary Tiger Man - Big Black Boat2", "mp3", 1024, 1);
        File f2 = new File("Legendary Tiger Man - Big Black Boat", "mp3", 1024, 1);
        File f3 = new File("Legendary Tiger Man - Big Black Boat", "mp3", 1024, 1);
        PPlayer pp = new PPlayer();
        try {
            pp.addFile(f);
            pp.addFile(f1);
            pp.addFile(f2);
            pp.addFile(f3);
            pp.playTrack(0);
            Assert.assertTrue(true);
            IFile resp = pp.deleteFile(0);
            Assert.assertEquals("Removing an element is not working properly", f, resp);
        } catch (InvalidPlayerStateException | InvalidFileException e) {
            Assert.fail("Throwing exception when adding and removing file correctly");
        }

    }

    @Test
    public void addFilePlayFiles2() {
        File f = new File("Legendary Tiger Man - Big Black Boat", "mp3", 1024, 1);
        File f1 = new File("Legendary Tiger Man - Big Black Boat2", "mp3", 1024, 1);
        File f2 = new File("Legendary Tiger Man - Big Black Boat", "mp3", 1024, 1);
        File f3 = new File("Legendary Tiger Man - Big Black Boat", "mp3", 1024, 1);
        PPlayer pp = new PPlayer();
        try {
            pp.addFile(f);
            pp.addFile(f1);
            pp.addFile(f2);
            pp.addFile(f3);
            pp.playTrack(0);
            int i = 1;
            while (i < 5) {
                int nextTrack = pp.nextTrack();
                if (i == 4) {
                    Assert.assertEquals("When there is no next track the return value must be 0", 0, nextTrack);
                } else {
                    Assert.assertEquals("Next track from " + (i - 1) + " should be " + i, i, nextTrack);
                }
                i++;
            }

            i = 2;
            pp.playTrack(3);
            while (i >= 0) {
                int previousTrack = pp.previousTrack();
                if (i == 0) {
                    Assert.assertEquals("When there is no previous track the return must be 0", 0, previousTrack);
                } else {
                    Assert.assertEquals("Previous track from " + (i + 1) + " should be " + i, i, previousTrack);
                }
                i--;
            }
        } catch (InvalidPlayerStateException | InvalidFileException e) {
            Assert.fail("Throwing exception when adding and removing file correctly");
        }

    }

    @Test
    public void addPlayFileInvalid() {
        PPlayer pp = new PPlayer();
        try {
            pp.addFile(new File("Legendary Tiger Man - Big Black Boat", "mp3", 200, -5));
        } catch (InvalidPlayerStateException e) {
            Assert.fail("Adding a file with negative duration must throw InvalidPlayerStateException");
        } catch (InvalidFileException ignored) {

        }

    }

    @Test
    public void addFileSizeInvalid() {
        PPlayer pp = new PPlayer();
        try {
            pp.addFile(new File("Legendary Tiger Man - Big Black Boat", "mp3", -2, 5));
        } catch (InvalidPlayerStateException e) {
            Assert.fail("Adding a file with negative size must throw InvalidPlayerStateException");
        } catch (InvalidFileException ignored) {

        }
    }

    @Test
    public void listFiles() {
        PPlayer pp = new PPlayer();
        try {
            pp.addFile(new File("Legendary Tiger Man - Big Black Boat1", "mp4", 20, 1));
        } catch (InvalidPlayerStateException | InvalidFileException ignored) {

        }
        try {
            pp.addFile(new File("Legendary Tiger Man - Big Black Boat2", "mp3", 20, 1));
        } catch (InvalidPlayerStateException | InvalidFileException ignored) {
        }
        String value = pp.list();
        Assert.assertTrue("List all files is not considering all valid files", value.contains("Legendary Tiger Man - Big Black Boat2"));
        Assert.assertFalse("List all files is including an invalid file", value.contains("Legendary Tiger Man - Big Black Boat1"));
    }

    @Test
    public void globalFailures() {
        Assert.assertEquals("Not all failures are considered as global failures", 3, PPlayer.globalFailures);
    }

    @Test
    public void shuffleNameAscending() {
        File f1 = new File("B", "mp3", 2, 1);
        File f2 = new File("AA", "mp3", 2, 1);
        File f3 = new File("A", "mp3", 2, 1);
        PPlayer p = new PPlayer(new AscendingNameComparator());
        try {
            p.addFile(f1);

            p.addFile(f2);
            p.addFile(f3);

            p.shufflePlay();
        } catch (NullPointerException e) {
            Assert.fail("Null pointer in AscendingNameComparator");
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.fail("Out of bounds in AscendingNameComparator");
        } catch (InvalidPlayerStateException | InvalidFileException e) {
            Assert.fail("Error when adding valid file");
        }
        Assert.assertEquals("Shuffle Ascending Name is not working properly", p.deleteFile(2), f1);
        Assert.assertEquals("Shuffle Ascending Name is not working properly", p.deleteFile(1), f2);
        Assert.assertEquals("Shuffle Ascending Name is not working properly", p.deleteFile(0), f3);
    }

    @Test
    public void shuffleDurationAscending() {
        File f1 = new File("B", "mp3", 2, 100);
        File f2 = new File("AA", "mp3", 2, 10);
        File f3 = new File("A", "mp3", 2, 1);
        PPlayer p = new PPlayer(new AscendingDurationComparator());

        try {
            p.addFile(f1);
            p.addFile(f2);
            p.addFile(f3);
            p.shufflePlay();
        } catch (NullPointerException e) {
            Assert.fail("Null pointer in AscendingNameComparator");
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.fail("Out of bounds in AscendingNameComparator");
        } catch (InvalidPlayerStateException | InvalidFileException e) {
            Assert.fail("Error when adding valid file");
        }
        System.out.println(p.list());
        Assert.assertEquals("Shuffle Duration Ascending is not working properly", p.deleteFile(2), f1);
        Assert.assertEquals("Shuffle Duration Ascending is not working properly", p.deleteFile(1), f2);
        Assert.assertEquals("Shuffle Duration Ascending is not working properly", p.deleteFile(0), f3);
    }

    @Test
    public void shuffleFileSizeDescending() {
        File f1 = new File("B", "mp3", 10, 100);
        File f2 = new File("AA", "mp3", 20, 10);
        File f3 = new File("A", "mp3", 2, 1);
        PPlayer p = new PPlayer(new DescendingFilesizeComparator());

        try {
            p.addFile(f1);
            p.addFile(f2);
            p.addFile(f3);
            p.shufflePlay();
        } catch (NullPointerException e) {
            Assert.fail("Null pointer in AscendingNameComparator");
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.fail("Out of bounds in AscendingNameComparator");
        } catch (InvalidPlayerStateException | InvalidFileException e) {
            Assert.fail("Error when adding valid file");
        }

        System.out.println(p.list());

        Assert.assertEquals("Shuffle File Size Descending is not working properly", p.deleteFile(2), f3);
        Assert.assertEquals("Shuffle File Size Descending is not working properly", p.deleteFile(1), f1);
        Assert.assertEquals("Shuffle File Size Descending is not working properly", p.deleteFile(0), f2);
    }


    @Test
    public void testSerializeBackup() {
        PPlayer p = new PPlayer();
        File f1 = new File("B", "mp3", 10, 100);
        File f2 = new File("AA", "mp3", 20, 10);
        File f3 = new File("A", "mp3", 2, 1);
        try {
            p.addFile(f1);
            p.addFile(f2);
            p.addFile(f3);
            p.backup("temp.bak");
        } catch (InvalidPlayerStateException | InvalidFileException | IOException e) {
            Assert.fail("Generating exception when backup file correctly");
        }

        java.io.File tmp = new java.io.File("temp.bak");
        Assert.assertTrue("File was not created during backup", tmp.exists());
    }

    @Test
    public void testSerializeRestore() {
        PPlayer p = new PPlayer();
        File f1 = new File("B", "mp3", 10, 100);
        File f2 = new File("AA", "mp3", 20, 10);
        File f3 = new File("A", "mp3", 2, 1);
        try {
            p.addFile(f1);
            p.addFile(f2);
            p.addFile(f3);
            p.backup("temp.bak");
        } catch (InvalidPlayerStateException | InvalidFileException | IOException e) {
            Assert.fail("Generating exception when backup file correctly");
        }
        java.io.File tmp = new java.io.File("temp.bak");
        Assert.assertTrue(tmp.exists());
        try {
            p.recover("temp.bak");
        } catch (IOException | ClassNotFoundException e) {
            Assert.fail("Generating exception when recover file correctly");
        }
    }

    @Test
    public void testSerializeAll() {
        PPlayer p = new PPlayer();
        File f1 = new File("B", "mp3", 10, 100);
        File f2 = new File("AA", "mp3", 20, 10);
        File f3 = new File("A", "mp3", 2, 1);
        try {
            p.addFile(f1);
            p.addFile(f2);
            p.addFile(f3);
            p.backup("temp.bak");
        } catch (InvalidPlayerStateException | IOException | InvalidFileException e) {
            Assert.fail("Generating exception when backup file correctly");
        }

        java.io.File tmp = new java.io.File("temp.bak");
        Assert.assertTrue(tmp.exists());
        PPlayer pp = new PPlayer();
        try {
            pp.recover("temp.bak");
        } catch (IOException | ClassNotFoundException e) {
            Assert.fail("Generating exception when recover file correctly");
        }
        int i = 0;
        while (i < 3) {
            try {
                Assert.assertEquals(p.deleteFile(0), pp.deleteFile(0));
            } catch (ArrayIndexOutOfBoundsException ex) {
                Assert.fail("Reading the file is not working properly.");
            }
            i++;
        }
    }

    @Test
    public void testJSONBackup() {
        PPlayer p = new PPlayer();
        File f1 = new File("B", "mp3", 10, 100);
        File f2 = new File("AA", "mp3", 20, 10);
        File f3 = new File("A", "mp3", 2, 1);
        try {
            p.addFile(f1);
            p.addFile(f2);
            p.addFile(f3);
            p.backupJSON("temp.bak");
        } catch (InvalidPlayerStateException | IOException | InvalidFileException e) {
            Assert.fail("Generating exception when backup JSON file correctly");
        }
        java.io.File tmp = new java.io.File("temp.bak");
        Assert.assertTrue(tmp.exists());
    }

    @Test
    public void testJSONRestore() {
        PPlayer p = new PPlayer();
        File f1 = new File("B", "mp3", 10, 100);
        File f2 = new File("AA", "mp3", 20, 10);
        File f3 = new File("A", "mp3", 2, 1);
        try {
            p.addFile(f1);
            p.addFile(f2);
            p.addFile(f3);
            p.backupJSON("temp.bak");
        } catch (InvalidPlayerStateException | IOException | InvalidFileException e) {
            Assert.fail("Generating exception when backup JSON file correctly");
        }
        java.io.File tmp = new java.io.File("temp.bak");
        Assert.assertTrue(tmp.exists());
        try {
            p.recoverJSON("temp.bak");
        } catch (IOException | ClassNotFoundException e) {
            Assert.fail("Generating exception when recover JSON file correctly");
        }
    }

    @Test
    public void testJSONAll() {
        PPlayer p = new PPlayer();
        File f1 = new File("B", "mp3", 10, 100);
        File f2 = new File("AA", "mp3", 20, 10);
        File f3 = new File("A", "mp3", 2, 1);
        try {
            p.addFile(f1);
            p.addFile(f2);
            p.addFile(f3);
            p.backupJSON("temp.bak");
        } catch (InvalidPlayerStateException | IOException | InvalidFileException e) {
            Assert.fail("Generating exception when backup JSON file correctly");
        }
        java.io.File tmp = new java.io.File("temp.bak");
        Assert.assertTrue(tmp.exists());
        PPlayer pp = new PPlayer();
        try {
            pp.recoverJSON("temp.bak");
        } catch (IOException | ClassNotFoundException e) {
            Assert.fail("Generating exception when recover JSON file correctly");
        }
        int i = 0;
        while (i < 3) {
            try {
                Assert.assertEquals(p.deleteFile(0), pp.deleteFile(0));
            }catch(ArrayIndexOutOfBoundsException e){
                Assert.fail("Reading the JSON file is not working properly.");
            }
            i++;
        }
    }
}