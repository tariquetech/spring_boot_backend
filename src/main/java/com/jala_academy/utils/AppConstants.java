package com.jala_academy.utils;

public class AppConstants {
	
    public static final String RESET_PASS_LINK_SENT = "Reset Pasword Link sent to your email";
    public static final String RECORD_NOT_AVAIL = "Record is not available: invalid Email ID";
    public static final String EMAIL = "email";
    public static final String TOKEN = "token";
    public static final String PASSWORD = "password";
    public static final String EMPLOYEE = "Employee";
    public static final String RESET_PASS_SUCC = "Password reset successful.";
    public static final String RESET_PASS = "Password Reset";
    public static final String INVALID_RESET_TOKEN = "Invalid reset token";
    public static final String STATE_ID = "stateId";
    public static final String COUNTRY_ID = "countryId";
    public static final String ID = "id";
    public static final String NOT_FOUND_WITH_PER = "%s not found with %s : '%s'";
    public static final String ALREADY_EXIST_WITH_PER = "%s Already Exist with %s : '%s'";
    public static final String QUERY_FIND_CITY_BY_ID = "SELECT c FROM City c WHERE c.stateId = :stateId";
    public static final String QUERY_FIND_COUNTRY_BY_ID = "SELECT s FROM State s WHERE s.countryId = :countryId";
    public static final String NOT_EXIST_WITH_USERNAME_EMAIL = "User not exists by Username or Email";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String INVALID_JWT_SIGNATURE = "Invalid JWT signature";
    public static final String INVALID_JWT_TOKEN = "Invalid JWT token";
    public static final String EXPIRED_JWT_TOKEN = "Expired JWT token";
    public static final String UNSUPPORTED_JWT_TOKEN = "Unsupported JWT token";
    public static final String JWT_STRING_EMPTY = "JWT claims string is empty.";
    public static final String USERNAME_ALREADY_EXIST = "Username already exists!";
    public static final String EMAIL_ALREADY_EXIST = "Email is already exists!.";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String USER_REGISTER_SUCC = "User Registered Successfully!.";
    public static final String DELETE_SUCC =  " Deleted Successfully";
    public static final String EMPLOYEE_SPACE = "Employee ";
    public static final String CLICK_LINK_TO_RESET_PASS = "Click the link below to reset your password:\n\n";
    public static final String RESET_PASS_LINK = "http://localhost:3000/reset/";
}
