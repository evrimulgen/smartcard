package com.omernaci.smartcard.service.impl;

import java.util.List;

import javax.smartcardio.CardException;

import com.omernaci.smartcard.model.CardReader;

public class SmartCardTest {
	
	public static void main(String[] args) {

		SmartCardManagerImpl cardManagerImpl = new SmartCardManagerImpl();
		try {
			List<CardReader> cardReaders = cardManagerImpl.getCardReaderList();
			System.out.println(cardReaders.size());
		} catch (CardException e) {
			e.printStackTrace();
		}
		
	}

}
