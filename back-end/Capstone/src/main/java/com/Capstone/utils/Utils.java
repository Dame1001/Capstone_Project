package com.Capstone.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.Capstone.entity.Maglia;
import com.Capstone.entity.User;

public class Utils {
	
	public static boolean validateUtente(User u) {
		if(u.getName()==null || u.getName().equalsIgnoreCase("")) {
			return false;
		}else if(u.getSurname()==null || u.getSurname().equalsIgnoreCase("")) {
			return false;
		}else if(u.getUsername()==null || u.getUsername().equalsIgnoreCase("")) {
			return false;
		}else if(u.getPassword()==null || u.getPassword().equalsIgnoreCase("")) {
			return false;
		}else if(u.getAddress()==null || u.getAddress().equalsIgnoreCase("")) {
			return false;
		}else if(u.getEmail()==null || u.getEmail().equalsIgnoreCase("") || !validateEmail(u.getEmail())) {
			
			System.out.println("controllo email non  superato");
			return false;
		}
		System.out.println("controllo superato");
		return true;
	}
	
	private static boolean validateEmail(String email) {
		String[] arrayEmail = email.split("@");
		if(arrayEmail.length != 2) {
			return false;
		}
		String[] arrayPunto = arrayEmail[1].split("[.]",0);
		if(arrayPunto.length != 2) {
			return false;
		}
		
		return true;
		
	}
	
	public static boolean validateMaglia(Maglia maglia) {
		if(maglia.getNome()== null || maglia.getNome().equalsIgnoreCase("")) {
			return false;
		}else if(maglia.getColore()== null || maglia.getColore().equalsIgnoreCase("")) {
			return false;
		}else if(maglia.getPrezzo()== null) {
			return false;
		}else if(maglia.getImmagine()== null || maglia.getImmagine().equalsIgnoreCase("")) {
			return false;
		}
		
		return true;
		
	}
	
	public static boolean validateLogin(User u) {
		if(u.getEmail()==null || u.getEmail().equalsIgnoreCase("") || !validateEmail(u.getEmail())) {
			return false;	
		}else if(u.getPassword()==null || u.getPassword().equalsIgnoreCase("")) {
			return false;
	    }
		return true;
	}
	
	public static String hashPassword(String password) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {			
			e.printStackTrace();
		}
		byte[] encodedhash = digest.digest(
		  password.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(encodedhash);
		  
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}

}
