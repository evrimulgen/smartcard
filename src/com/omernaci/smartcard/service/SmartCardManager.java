package com.omernaci.smartcard.service;

import java.util.List;

import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CardTerminals;

import com.omernaci.smartcard.model.CardReader;

public interface SmartCardManager {
	
	public List<CardReader> getCardReaderList() throws CardException;
	
	public CardTerminals getCardTerminals();
	
	public List<CardTerminal> getCardTerminalList() throws CardException;
	
	public int getCardCount() throws CardException;

}
