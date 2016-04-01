package keepapp.logic;

import keepapp.API.IPerson;
import keepapp.API.implPerson;

public class ObjectRepository {
	public static IPerson getIPerson(){
		return new implPerson();
	}
}
