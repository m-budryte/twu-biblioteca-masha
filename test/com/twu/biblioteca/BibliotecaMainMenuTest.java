package com.twu.biblioteca;

        import org.junit.After;
        import org.junit.Before;
        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.rules.TestName;

        import java.io.ByteArrayInputStream;
        import java.io.ByteArrayOutputStream;
        import java.io.InputStream;
        import java.io.PrintStream;

        import static org.junit.Assert.assertEquals;

public class BibliotecaMainMenuTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    BibliotecaMainMenu bibliotecaMainMenu = new BibliotecaMainMenu();

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Rule
    public TestName name = new TestName();

    @Test
    public void showMenuTest() {
        bibliotecaMainMenu.showMenu();
        assertEquals("Returns menu", "1. View list of books\n9.Exit\n", getOutput());
    }

    @Test
    public void chooseOption1Test() {
        bibliotecaMainMenu.chooseOption("1");
        assertEquals("Choose option 1", "Valid option.\n0. Go back\n", getOutput());
    }

    @Test
    public void chooseOption9Test() {
        bibliotecaMainMenu.chooseOption("9");
        assertEquals("Choose option 9", "EXIT\n", getOutput());
    }

    @Test
    public void chooseInvalidOptionTest() {
        bibliotecaMainMenu.chooseOption("10000000000000");
        assertEquals("Choose invalid", "Invalid option. Please try again.\n", getOutput());
    }
}

