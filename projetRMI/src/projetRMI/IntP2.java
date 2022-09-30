package projetRMI;

import java.rmi.Remote;

public interface IntP2 extends Remote{
	public void receiveMessage(String t) throws Exception;
	public int Calculer(int a, int b) throws Exception;	
}
