package com.cn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TableCreate {
	String tuser;
	String trole;
	String tright;
	String tfunction;
	String tcontract;
	String tcontractprocess;
	String tcontractstate;
	String tlog;
	String tcustomer;
	String tcontractattachment;

	public TableCreate() {
		tuser="create table userm(name varchar2(40),password varchar2(20))";
		trole="create table role(name varchar2(40),description varchar2(100),function varchar2(500))";
		tright="create table right(username varchar2(40),rolename varchar2(20),description varchar2(100))";
		tfunction="create table function(num varchar2(10),name varchar2(40),url varchar2(100),description varchar2(100))";
		tcontract="create table contract(num varchar2(20),name varchar2(40),customer varchar2(40),"
				+ "begintime date,endtime date,content varchar2(4000),username varchar2(40))";
		tcontractprocess="create table contract_process(comnum varchar2(20),type integer check(type between 1 and 4),"
				+ "state integer check(state between 0 and 2),username varchar2(40),content varchar2(4000),"
				+ "time date,if integer check(if between 0 and 1))";
		tcontractstate = "create table cotract_state(conname varchar2(40),"
				+ "type integer check(type between 1 and 5),time date)";
		tlog = "create table log(username varchar2(40),"
				+ "content varchar2(4000),time date)";
		tcustomer = "create table customer(num varchar2(20),"
				+ "name varchar2(40),address varchar2(100),tel varchar2(20),fax varchar2(20),"
				+ "code varchar2(10),bank varchar2(50),account varchar2(50))";
		tcontractattachment="create table contract_attachment(connum varchar2(20),"
				+ "filename varchar2(100),path varchar2(100),type varchar2(20),uploadtime date)";
		run();
		}
	public void run() {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet result = null;
		try {		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:"+"thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password ="scott";
		con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		System.out.println("连接成功！");
		stmt.executeUpdate(tuser);
		stmt.executeUpdate(trole);
		stmt.executeUpdate(tright);
		stmt.executeUpdate(tfunction);
		stmt.executeUpdate(tcontract);
		stmt.executeUpdate(tcontractprocess);
		stmt.executeUpdate(tcontractstate);
		stmt.executeUpdate(tlog);
		stmt.executeUpdate(tcustomer);
		stmt.executeUpdate(tcontractattachment);
		String sq2 = "insert into role(name,description,function) values('new','new_user','no_function')";
		String sq3 = "insert into role(name,description,function) values('operator','operator','operator')";
		String sq4 = "insert into role(name,description,function) values('manager','manager','manager')";
		stmt.executeUpdate(sq2);
		stmt.executeUpdate(sq3);
		stmt.executeUpdate(sq4);
		stmt.close();
		con.close();

		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) {
    	TableCreate fm = new TableCreate();
      	 
       }
}