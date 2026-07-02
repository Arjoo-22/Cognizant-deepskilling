class Decorator {

    public static void main(String[] args) {

        Notifier notifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        notifier.send("Server Down Alert");
    }
}

interface Notifier{
    void send(String message);
}

class EmailNotifier implements Notifier{

    @Override
    public void send(String message){
        System.out.println("Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier{

    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier){
        this.notifier = notifier;
    }

    @Override
    public void send(String message){
        notifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator{

    public SMSNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        super.send(message);
        System.out.println("SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator{

    public SlackNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        super.send(message);
        System.out.println("Slack: " + message);
    }
}