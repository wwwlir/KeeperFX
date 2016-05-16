package keepapp.model.DAOFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import javax.sql.RowSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import keepapp.model.Link;

public class FirebirdLinkDAO implements LinkDAO {
	private final String DRIVER = "org.firebirdsql.jdbc.FBDriver";
	private final String DBURL = "jdbc:firebirdsql:embedded:C:\\FirebirdDatabase\\FDBT.FDB";
	Connection conn = null;
	
	private Connection createConnection(){
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DBURL, "SYSDBA", "masterkey");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	private void closeConnection(Statement statement){
		try {
			conn.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int insertLink(Link link) {
		String strSQL = "insert into links (NAME, GROUPNAME, LINK, NOTE, ISGROUP) values (?,?,?,?,?)";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, link.getName());
			stmt.setString(2, link.getGroup());
			stmt.setString(3, link.getLink());
			stmt.setString(4, link.getNote());
			stmt.setInt(5, link.getIsGroup());
			stmt.executeUpdate();
			closeConnection(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return 0;
	}

	@Override
	public boolean deleteLink(Link link) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLinkByID(int ID) {
		String strSQL = "delete from LINKS where id=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setInt(1, ID);
			stmt.executeUpdate();
			closeConnection(stmt);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Link getLinkByID(int ID) {
		String strSQL = "select ID, NAME, GROUPNAME, ISGROUP, LINK, NOTE from LINKS where ID=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setInt(1, ID);
			ResultSet res =  stmt.executeQuery();
			res.next();
			Link link = new Link(res.getInt("id"),res.getString("name"));
			link.setLink(res.getString("link"));
			link.setNote(res.getString("note"));
			link.setIsGroup(res.getInt("isgroup"));
			link.setGroup(res.getString("groupname"));
			closeConnection(stmt);
			return link;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
	}

	@Override
	public Link findLink(Link link) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateLink(Link link) {
		String strSQL = "update LINKS set name=?, groupname=?, link=?, note=? where id=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, link.getName());
			stmt.setString(2, link.getGroup());
			stmt.setString(3, link.getLink());
			stmt.setString(4, link.getNote());
			stmt.setInt(5, link.getID());
			stmt.executeUpdate();
			closeConnection(stmt);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ObservableList<Link> getLinkData() {
		ObservableList<Link> linkData = FXCollections.observableArrayList();
		String strSQL = "select id, name from links where isgroup=0";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {				
				linkData.add(new Link(res.getInt("id"), res.getString("name")));
			}
			closeConnection(stmt);
			return linkData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ObservableList<Link> getLinkGroup() {
		ObservableList<Link> linkGroup = FXCollections.observableArrayList();
		String strSQL = "select id, name, groupname from links where isgroup=1";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				Link tempLink = new Link(res.getInt("id"), res.getString("name"));
				tempLink.setGroup(res.getString("groupname"));
				linkGroup.add(tempLink);
			}
			closeConnection(stmt);
			return linkGroup;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ObservableList<Link> getShortLink(String groupName) {
		ObservableList<Link> linkData = FXCollections.observableArrayList();
//		String strTemp = "select id, name, login from accounts";
//		if(groupName.length() != 0){
//			strTemp.concat(" where isgroup=0 and groupname=?");
//		}
		String strSQL = "select id, name from links where isgroup=0 and groupname=?";
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(strSQL);
			stmt.setString(1, groupName);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {				
				linkData.add(new Link(res.getInt("id"), res.getString("name")));
			}
			closeConnection(stmt);
			return linkData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RowSet selectLinkRS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectLinkTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printLink() {
		// TODO Auto-generated method stub

	}

}
