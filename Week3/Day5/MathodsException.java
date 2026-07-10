import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MethodsExceptionTest {

    interface PaymentService {
        void processPayment();
    }

    @Test
    void testVoidMethodThrowsException() {

        PaymentService service = mock(PaymentService.class);

        doThrow(new RuntimeException("Payment Failed"))
                .when(service)
                .processPayment();

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.processPayment()
        );

        assertEquals("Payment Failed", exception.getMessage());

        verify(service).processPayment();

        System.out.println("Exception handling verified.");
    }
}