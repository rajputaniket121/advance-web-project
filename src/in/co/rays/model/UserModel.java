package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {
	public void add(UserBean bean) throws Exception {
		UserBean exist = findByLogin(bean.getLoginId());
		if(exist!=null) {
			throw new Exception("User already Presant");
		}
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			pstmt.setLong(1, getNextPk());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLoginId());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(7, bean.getAddress());
			int i = pstmt.executeUpdate();
			pstmt.close();
			System.out.println("New User data Inserted " + i);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			System.out.println(e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public void update(UserBean bean) throws Exception {
		UserBean exist = findByLogin(bean.getLoginId());
		if(exist!=null && exist.getId() == bean.getId()) {
			throw new Exception("User Login id already Presant");
		}
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update user set first_name = ?,last_name = ?, login_id = ?, "
					+ "password  = ?, dob = ?, address = ? where id = ?");
			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLoginId());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(6, bean.getAddress());
			pstmt.setLong(7, bean.getId());
			int i = pstmt.executeUpdate();
			pstmt.close();
			System.out.println("User data Updated " + i);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			System.out.println(e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}
	
	public void delete(Long id) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from user where id = ?");
			pstmt.setLong(1, id);
			int i = pstmt.executeUpdate();
			pstmt.close();
			System.out.println("User data Deleted " + i);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			System.out.println(e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}
	
	public UserBean findByPk(Long id) throws Exception {
		Connection conn = null;
		UserBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from user where id = ?");
			pstmt.setLong(1, id);
			ResultSet rs  = pstmt.executeQuery();
			while(rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLoginId(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setAddress(rs.getString(7));
			}
			pstmt.close();
			rs.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}
	
	public UserBean findByLogin(String loginId) throws Exception {
		Connection conn = null;
		UserBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from user where login_id = ?");
			pstmt.setString(1, loginId);
			ResultSet rs  = pstmt.executeQuery();
			while(rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLoginId(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setAddress(rs.getString(7));
			}
			pstmt.close();
			rs.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}
	
	public UserBean authenticate(String loginId,String password) throws Exception {
		Connection conn = null;
		UserBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from user where login_id = ? and password = ?");
			pstmt.setString(1, loginId);
			pstmt.setString(2, password);
			ResultSet rs  = pstmt.executeQuery();
			while(rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLoginId(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setAddress(rs.getString(7));
			}
			pstmt.close();
			rs.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return bean;
	}
	
	public List<UserBean> search(UserBean bean,int pageNo,int pageSize) throws Exception {
		Connection conn = null;
		List<UserBean> list = null;
		try {
			conn = JDBCDataSource.getConnection();
			StringBuffer sql = new StringBuffer("select * from user where 1=1 ");
			if (bean != null) {
				if (bean.getId() != null) {
					sql.append("and id = "+bean.getId()+" ");
				}
				if (bean.getFirstName() != null && bean.getFirstName().length()>0) {
					sql.append("and first_name like '"+bean.getFirstName()+"%' ");
				}
				if (bean.getLastName() != null && bean.getLastName().length()>0) {
					sql.append("and last_name like '"+bean.getLastName()+"%' ");
				}
				if (bean.getLoginId() != null && bean.getLoginId().length()>0) {
					sql.append("and login_id like '"+bean.getLoginId()+"%' ");
				}
				if (bean.getPassword() != null && bean.getPassword().length()>0) {
					sql.append("and password like '"+bean.getPassword()+"%' ");
				}
				if(bean.getDob()!=null) {
					sql.append("and dob like '"+new java.sql.Date(bean.getDob().getTime())+"%' ");
				}
				if (bean.getAddress() != null && bean.getAddress().length()>0) {
					sql.append("and address like '"+bean.getAddress()+"%' ");
				}
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				sql.append("limit " + pageNo + "," + pageSize);
			}
			System.out.println(sql);
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs  = pstmt.executeQuery();
			list = new ArrayList<UserBean>();
			while(rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLoginId(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setAddress(rs.getString(7));
				list.add(bean);
			}
			pstmt.close();
			rs.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;
	}
	
	public void userTableMetadeta() throws Exception {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from user");
			ResultSet rs  = pstmt.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			System.out.println("Catelog Name : "+rsMetaData.getCatalogName(1));
			System.out.println("Table Name : "+rsMetaData.getTableName(1));
			System.out.println("Column Count  : "+rsMetaData.getColumnCount());
			System.out.println();
			for(int i = 1;i<=rsMetaData.getColumnCount();i++) {
				System.out.println("Column : "+ i);
				System.out.println("Label : "+ rsMetaData.getColumnLabel(i));
				System.out.println("Name : "+ rsMetaData.getColumnName(i));
				System.out.println("Type : "+ rsMetaData.getColumnTypeName(i));
				System.out.println("Size : "+ rsMetaData.getColumnDisplaySize(i));
				System.out.println("Precision : "+ rsMetaData.getPrecision(i));
				System.out.println();
			}
			pstmt.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public Long getNextPk() throws SQLException {
		Long pk = 0l;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from user");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getLong(1);
		}
		JDBCDataSource.closeConnection(conn, pstmt);
		return pk + 1;
	}

}
