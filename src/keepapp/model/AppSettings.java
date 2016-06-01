package keepapp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AppSettings {
	private String pathDataBase;

	public String getPathDataBase() {
		return pathDataBase;
	}

	public void setPathDataBase(String pathDataBase) {
		this.pathDataBase = pathDataBase;
	}
	
}
