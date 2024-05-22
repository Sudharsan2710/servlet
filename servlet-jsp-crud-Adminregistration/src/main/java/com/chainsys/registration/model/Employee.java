package com.chainsys.registration.model;

public class Employee {
	private int id;
	private	String fullname;
	private	String email;
	private	String password;
	private	String contact;
		
		
		public Employee(String fullname, String email, String password, String contact) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}


		public Employee(int id, String fullname, String email, String password, String contact) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}


		public Employee(){
			
		}
		
		
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}


		

		



}
