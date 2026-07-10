import org.mockito.InOrder;

import static org.mockito.Mockito.*;

class Exercise6Test {

    interface BankService {
        void login();
        void checkBalance();
        void logout();
    }

    @Test
    void testInteractionOrder() {

        BankService service = mock(BankService.class);

        service.login();
        service.checkBalance();
        service.logout();

        InOrder order = inOrder(service);

        order.verify(service).login();
        order.verify(service).checkBalance();
        order.verify(service).logout();

        System.out.println("Method call order verified.");
    }
} 
