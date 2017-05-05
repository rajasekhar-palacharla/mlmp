/******************************************************************************* 
 **  COPYRIGHT (C) 2008 Automotive Robotics. ALL RIGHTS RESERVED. 
 **  This work contains  Automotive Robotics  proprietary information, which 
 **  may constitute a trade secret and/or be confidential. Copyright 
 **  notice is precautionary only and does not imply publication. 

 **  FILE NAME : CommonUtils.java
 **  Description : information of the file
 **  Author: Automotive Robotics [Kavitha ]
 **  Creation Date : May 23,2008
 **  Revision History :
 **  Date	 : 
 **  Comments:
 *****************************************************************************/
/****************************************************************************
 **                 Package Declaration
 *****************************************************************************/

package com.mlm.commonutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.http.HttpSession;


/******************************************************************************
 **                 Import Declaration
 ******************************************************************************/

/******************************************************************************
 ** Class
 ******************************************************************************/
public class CommonUtils {
	/* private variable declarations */
	private final String CODES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
	private String errorStr;
	/*****************************************************************************
	 ** Method Name: base64Decode() Description: This routine used to decode
	 * encrypted data and gets original data. Parameters Descriptions:String
	 * input Return Value:byte[] original data
	 *****************************************************************************/
	public byte[] base64Decode(String input) {
		byte decoded[] = null;
		try{
		/*
		 * if (input.length() % 4 != 0) { throw new
		 * IllegalArgumentException("Invalid base64 input"); }
		 */
		decoded = new byte[((input.length() * 3) / 4)
				- (input.indexOf('=') > 0 ? (input.length() - input
						.indexOf('=')) : 0)];
		char[] inChars = input.toCharArray();
		int j = 0;
		int b[] = new int[4];
		for (int i = 0; i < inChars.length; i += 4) {
			// This could be made faster (but more complicated) by precomputing
			// these index locations.
			b[0] = CODES.indexOf(inChars[i]);
			b[1] = CODES.indexOf(inChars[i + 1]);
			b[2] = CODES.indexOf(inChars[i + 2]);
			b[3] = CODES.indexOf(inChars[i + 3]);
			decoded[j++] = (byte) ((b[0] << 2) | (b[1] >> 4));
			if (b[2] < 64) {
				decoded[j++] = (byte) ((b[1] << 4) | (b[2] >> 2));
				if (b[3] < 64) {
					decoded[j++] = (byte) ((b[2] << 6) | b[3]);
				}
			}
		}
		}catch(Exception e){
			
		}
		return decoded;
	}

	/*****************************************************************************
	 ** Method Name: base64Encode() Description: This routine used to encode
	 * input data and gets encrypted data. Parameters Descriptions:byte[] input
	 * Return Value:String encryptedData
	 *****************************************************************************/
	public String base64Encode(byte[] input) {
		StringBuilder out = null;
		try{
		 out= new StringBuilder((input.length * 4) / 3);
		int b;
		for (int i = 0; i < input.length; i += 3) {
			b = (input[i] & 0xFC) >> 2;
			out.append(CODES.charAt(b));
			b = (input[i] & 0x03) << 4;
			if (i + 1 < input.length) {
				b |= (input[i + 1] & 0xF0) >> 4;
				out.append(CODES.charAt(b));
				b = (input[i + 1] & 0x0F) << 2;
				if (i + 2 < input.length) {
					b |= (input[i + 2] & 0xC0) >> 6;
					out.append(CODES.charAt(b));
					b = input[i + 2] & 0x3F;
					out.append(CODES.charAt(b));
				} else {
					out.append(CODES.charAt(b));
					out.append('=');
				}
			} else {
				out.append(CODES.charAt(b));
				out.append("==");
			}
		}
		}catch(Exception e){
			
		}
		return out.toString();
	}


	public String decodeEmailUid(String encodeData) {
		String decodedData=null;
		try{
		byte[] decodedEmailUid = base64Decode(encodeData);
		char[] ch = new char[decodedEmailUid.length];
		for (int i = 0; i < decodedEmailUid.length; i++) {
			ch[i] = (char) decodedEmailUid[i];
		}
		decodedData = String.valueOf(ch);
		System.out.println("Decoded value is :" + decodedData);
		}catch(Exception e){
			
		}
		return decodedData;
	}

	public static String byteArrToString(byte decodedMsg[]) {
		String decodedData = "";
		try{
		char[] ch = new char[decodedMsg.length];
		for (int i = 0; i < decodedMsg.length; i++) {
			ch[i] = (char) decodedMsg[i];
		}
		decodedData = String.valueOf(ch);
		}catch(Exception e){
			
		}
		return decodedData;
	}
	public String getRole(HttpSession session){
		String role=null;
		try{
			role=(String)session.getAttribute("userrole");
		}catch(Exception e){
			
		}
		return role;
	}
}