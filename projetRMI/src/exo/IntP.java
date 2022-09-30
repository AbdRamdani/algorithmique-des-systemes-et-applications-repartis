package exo;

import java.rmi.Remote;

public interface IntP extends Remote{
	public void receiveMessage(int n) throws Exception;
	public int Calculer(int a) throws Exception;	
	//public void receiveInt(int n) throws Exception;
	
}
