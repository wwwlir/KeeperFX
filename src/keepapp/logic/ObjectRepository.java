package keepapp.logic;

import keepapp.services.implCommon;
import keepapp.services.implIKeeLink;
import keepapp.services.implINote;
import keepapp.services.implKeePass;
import keepapp.services.implPerson;
import keepapp.services.API.ICommon;
import keepapp.services.API.IKeeLink;
import keepapp.services.API.IKeePass;
import keepapp.services.API.INote;
import keepapp.services.API.IPerson;

public class ObjectRepository {
	public static IPerson getIPerson(){
		return new implPerson();
	}
	public static IKeePass getIKeePass(){
		return new implKeePass();
	}
	public static IKeeLink getIKeeLink(){
		return new implIKeeLink();
	}
	public static INote getINote(){
		return new implINote();
	}
	public static ICommon getImplCommon(){
		return new implCommon();
	}
}
