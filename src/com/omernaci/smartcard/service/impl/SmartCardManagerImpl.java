package com.omernaci.smartcard.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.smartcardio.Card;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CardTerminals;
import javax.smartcardio.TerminalFactory;

import com.omernaci.smartcard.model.CardReader;
import com.omernaci.smartcard.service.SmartCardManager;

public class SmartCardManagerImpl implements SmartCardManager {

	@Override
	public List<CardReader> getCardReaderList() throws CardException {
		
		System.setProperty("sun.security.smartcardio.library", "/lib/x86_64-linux-gnu/libpcsclite.so.1.0.0");
		
		List<CardReader> cardReaderList = new ArrayList<>();
		
		String cardReaderName = "";
		
		String cardReaderAtr = " - ";
		
		String cardReaderInfo = "Yok";
		
		String cardVersion = " - ";
		
		String cardChip = " - ";
		
		CardTerminals cardTerminals = getCardTerminals();
		
		String [] connections = { "T=1", "T=0", "T=*"};
		
		String connectionType = connections[0];
		
		if (cardTerminals != null || getCardCount() > 0) {
			
			Object [] obj = getCardTerminalList().toArray();
			
			for (int i = 0; i < obj.length; i++) {
				cardReaderName = obj[i].toString().substring(15);
				
				if (((CardTerminal) getCardTerminalList().get(i)).isCardPresent()) {
					cardReaderInfo = "Var";
					Card card = ((CardTerminal) getCardTerminalList().get(i)).connect(connectionType);
					cardReaderAtr = card.getATR().getBytes().toString();
				}
				
				cardReaderList.add(new CardReader(cardReaderName, cardReaderAtr, cardReaderInfo, cardVersion, cardChip));				
			}
			
		}
		
		return cardReaderList;
	}
	
	@Override
	public CardTerminals getCardTerminals() {
		return TerminalFactory.getDefault().terminals();
	}

	@Override
	public List<CardTerminal> getCardTerminalList() throws CardException {
		return TerminalFactory.getDefault().terminals().list();
	}

	@Override
	public int getCardCount() throws CardException {
		return getCardTerminalList().size();
	}

}
