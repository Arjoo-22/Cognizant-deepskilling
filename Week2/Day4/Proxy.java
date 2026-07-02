class Proxy {

    public static void main(String[] args) {

        Image image = new ProxyImage("nature.jpg");

        System.out.println("First Call");
        image.display();

        System.out.println();

        System.out.println("Second Call");
        image.display();
    }
}

interface Image{
    void display();
}

class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromServer();
    }

    private void loadFromServer(){
        System.out.println("Loading " + fileName + " from server...");
    }

    @Override
    public void display(){
        System.out.println("Displaying " + fileName);
    }
}

class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display(){

        if(realImage == null){
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}