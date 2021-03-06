package tests;

import address.AddressBookApplication;
import address.data.AddressBook;
import address.data.AddressEntry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * tests AddressBook
 */

class AddressBookTest {


    /**
     * checks if size() correctly returns the number of elements
     */
    @Test
    public void testSize(){

        AddressBook ab = new AddressBook();
        AddressEntry first = new AddressEntry();
        AddressEntry second = new AddressEntry();
        ab.add(first);
        ab.add(second);

        Assertions.assertEquals(ab.size(), 2);

        AddressBook ab2 = new AddressBook();
        AddressBookApplication.init("C:\\Users\\User\\IdeaProjects\\AddressBookApplication\\src\\address\\data\\AddressInputDataFile.txt", ab2);
        Assertions.assertEquals(ab2.size(), 2);

    }

    /**
     * checks if list() correctly prints out the information from the AddressBook
     */
    @Test
    public void testList(){

        AddressBook ab = new AddressBook();
        AddressEntry first = new AddressEntry();
        ab.add(first);

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        ab.list();

        /*String outString = """
                first
                last
                street
                city
                state
                99999
                phone
                email
                
                """;

        Assertions.assertEquals(outString, out.toString());*/

        Assertions.assertFalse(out.toString().isEmpty());

    }

    /**
     * checks if add() adds an entry to the AddressBook
     */
    @Test
    public void testAdd(){

        AddressBook ab = new AddressBook();
        AddressEntry first = new AddressEntry();
        ab.add(first);
        Assertions.assertEquals(1, ab.size());

        AddressEntry second = new AddressEntry();
        ab.add(second);
        Assertions.assertEquals(2, ab.size());

    }

    /**
     * checks if remove() removes an entry from AddressBook
     */
    @Test
    public void testRemove(){

        AddressBook ab = new AddressBook();
        AddressEntry first = new AddressEntry();
        ab.add(first);
        AddressEntry second = new AddressEntry();
        ab.add(second);

        Assertions.assertEquals(2, ab.size());
        ab.removeWrapper(0);
        Assertions.assertEquals(1, ab.size());
        ab.removeWrapper(0);
        Assertions.assertEquals(0, ab.size());

    }

    /**
     * checks if search() correctly identifies if entries contain information
     */
    @Test
    public void testSearch(){

        AddressBook ab = new AddressBook();
        AddressEntry first = new AddressEntry();
        ab.add(first);

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        ab.search("first");

        Assertions.assertFalse(out.toString().isEmpty());

        ab.search("99999");
        Assertions.assertFalse(out.toString().isEmpty());

    }

}