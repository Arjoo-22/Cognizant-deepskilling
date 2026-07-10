
import static org.mockito.Mockito.*;

class HandlingVoid{

    interface Printer {
        void printMessage();
    }

    @Test
    void testVoidMethod() {

        Printer printer = mock(Printer.class);

        doNothing().when(printer).printMessage();

        printer.printMessage();

        verify(printer).printMessage();

        System.out.println("Void method verified successfully.");
    }
} {
    
}
