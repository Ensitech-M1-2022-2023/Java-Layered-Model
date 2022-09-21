package Service;

public class Service {
    public ServiceGame game;

    public Service(String confName){
        game = new ServiceGame(confName);
    }
}
