package tpRMI;
import java.rmi.*;


public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
public interface interfaceRMI extends Remote{
	
	void receiveMsg(String x) ;
	int calcul(int x , int y );
	
}
