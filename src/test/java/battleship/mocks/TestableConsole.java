package battleship.mocks;

import battleship.Console;

public class TestableConsole extends Console {
    private InjectedMock im;
    public TestableConsole(InjectedMock im) {
        this.im = im;
    }
    @Override
    public void printLine(String line) {
        im.printLine(line);
    }
}