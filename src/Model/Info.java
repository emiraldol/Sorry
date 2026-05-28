package Model;
import java.util.ArrayList;
import View.Welcome;
/**
 * Helper interface having some methods we work with in WelcomeModel
 */
public interface  Info {
	int GetPlayers(Welcome field);
	ArrayList<String> GetNames(Welcome field,int numofplayers);
	

}
