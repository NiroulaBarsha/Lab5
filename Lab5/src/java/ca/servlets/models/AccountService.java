/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.servlets.models;

/**
 *
 * @author Barsha
 */
public class AccountService {
    public User login(String username, String password){
		if(username== null || password== null){
			return null;
		}
		if(username.equals("abe") && password.equals("password")){
			return	new User(username,password);
		}else if(username.equals("barb") && password.equals("password")){
			return	new User(username,password);
		}else{
			return null;
		}
	}
}
