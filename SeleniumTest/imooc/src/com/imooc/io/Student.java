package com.imooc.io;

import java.io.Serializable;

public class Student implements Serializable {
   
	private String stuNo;
	private String stuName;
	private int stuAge;
	
	public Student() {
		super();
	}
	public Student(String stuNo, String stuName, int stuAge) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", stuName=" + stuName + ", stuAge="
				+ stuAge + "]";
	}
	/**
	 * @return the stuNo
	 */
	public String getStuNo() {
		return stuNo;
	}
	/**
	 * @param stuNo the stuNo to set
	 */
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	/**
	 * @return the stuName
	 */
	public String getStuName() {
		return stuName;
	}
	/**
	 * @param stuName the stuName to set
	 */
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	/**
	 * @return the stuAge
	 */
	public int getStuAge() {
		return stuAge;
	}
	/**
	 * @param stuAge the stuAge to set
	 */
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

}
