package keepapp.logic;

import keepapp.API.ICommon;
import keepapp.API.IKeeLink;
import keepapp.API.IKeePass;
import keepapp.API.INote;
import keepapp.API.IPerson;
import keepapp.API.implCommon;
import keepapp.API.implIKeeLink;
import keepapp.API.implKeePass;
import keepapp.API.implINote;
import keepapp.API.implPerson;

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
