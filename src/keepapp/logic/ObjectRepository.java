package keepapp.logic;

import keepapp.API.IKeePass;
import keepapp.API.IPerson;
import keepapp.API.implKeePass;
import keepapp.API.implPerson;

public class ObjectRepository {
	public static IPerson getIPerson(){
		return new implPerson();
	}
	public static IKeePass getIKeePass(){
		return new implKeePass();
	}
}
