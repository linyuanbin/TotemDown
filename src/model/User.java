package model;

import java.util.Date;

import com.mysql.jdbc.Blob;

public class User {

	private String UserID; //id
	private String UserName; //�û���
	private String UserTel; //�绰
	private String UserEmail; //����
	private String UserPassword; //����
	private String UserNickName; //�ǳ�
	private String UserSex; //�Ա�
	private Date UserBirthday; //����
	private String UserMajor; //ְҵ
	private int UserIntegral; //����
	private String UserUnderWrite;//ǩ��
	private String UserHobby; //����
	private String UserHeadPortr;//�û�ͷ��
	//private String User_WeChat; //΢�ź�

	
	
	public String getUserID() {
		return UserID;
	}
	
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserTel() {
		return UserTel;
	}
	public void setUserTel(String userTel) {
		UserTel = userTel;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserNickName() {
		return UserNickName;
	}
	public void setUserNickName(String userNickName) {
		UserNickName = userNickName;
	}
	public String getUserSex() {
		return UserSex;
	}
	public void setUserSex(String userSex) {
		UserSex = userSex;
	}
	public Date getUserBirthday() {
		return UserBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		UserBirthday = userBirthday;
	}
	public String getUserMajor() {
		return UserMajor;
	}
	public void setUserMajor(String userMajor) {
		UserMajor = userMajor;
	}
	public int getUserIntegral() {
		return UserIntegral;
	}
	public void setUserIntegral(int userIntegral) {
		UserIntegral = userIntegral;
	}
	public String getUserUnderWrite() {
		return UserUnderWrite;
	}
	public void setUserUnderWrite(String userUnderWrite) {
		UserUnderWrite = userUnderWrite;
	}
	public String getUserHobby() {
		return UserHobby;
	}
	public void setUserHobby(String userHobby) {
		UserHobby = userHobby;
	}
	public String getUserHeadPortr() {
		return UserHeadPortr;
	}
	public void setUserHeadPortr(String userHeadPortr) {
		UserHeadPortr = userHeadPortr;
	}

	@Override
	public String toString() {
		return "User [UserID=" + UserID + ", UserName=" + UserName + ", UserTel=" + UserTel + ", UserEmail=" + UserEmail
				+ ", UserPassword=" + UserPassword + ", UserNickName=" + UserNickName + ", UserSex=" + UserSex
				+ ", UserBirthday=" + UserBirthday + ", UserMajor=" + UserMajor + ", UserIntegral=" + UserIntegral
				+ ", UserUnderWrite=" + UserUnderWrite + ", UserHobby=" + UserHobby + ", UserHeadPortr=" + UserHeadPortr
				+ "]";
	}
	
	

	
	
}
