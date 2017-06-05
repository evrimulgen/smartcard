package com.omernaci.smartcard.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CardReader {

	private StringProperty cardReaderName
			= new SimpleStringProperty(this, "cardReaderName");

	private StringProperty cardReaderAtr
			= new SimpleStringProperty(this, "cardReaderAtr");

	private StringProperty cardReaderInfo
			= new SimpleStringProperty(this, "cardReaderInfo");

	private StringProperty cardVersion
			= new SimpleStringProperty(this, "cardVersion");

	private StringProperty cardChip
			= new SimpleStringProperty(this, "cardChip");
	
	public CardReader(String cardReaderName, String cardReaderAtr,
			String cardReaderInfo, String cardVersion, String cardChip) {
		setCardReaderName(cardReaderName);
		setCardReaderAtr(cardReaderAtr);
		setCardReaderInfo(cardReaderInfo);
		setCardVersion(cardVersion);
		setCardChip(cardChip);
	}
	
	public StringProperty cardReaderNameProperty() {
		return cardReaderName;
	}
	
	public final String getCardReaderName() {
		return cardReaderNameProperty().get();
	}
	
	public final void setCardReaderName(String cardReaderName) {
		cardReaderNameProperty().set(cardReaderName);
	}
	
	public StringProperty cardReaderAtrProperty() {
		return cardReaderAtr;
	}
	
	public final String getCardReaderAtr() {
		return cardReaderAtrProperty().get();
	}
	
	public final void setCardReaderAtr(String cardReaderAtr) {
		cardReaderAtrProperty().set(cardReaderAtr);
	}
	
	public StringProperty cardReaderInfoProperty() {
		return cardReaderInfo;
	}
	
	public final String getCardReaderInfo() {
		return cardReaderInfoProperty().get();
	}
	
	public final void setCardReaderInfo(String cardReaderInfo) {
		cardReaderInfoProperty().set(cardReaderInfo);
	}
	
	public StringProperty cardVersionProperty() {
		return cardVersion;
	}
	
	public final String getCardVersion() {
		return cardVersionProperty().get();
	}
	
	public final void setCardVersion(String cardVersion) {
		cardVersionProperty().set(cardVersion);
	}
	
	public StringProperty cardChipProperty() {
		return cardChip;
	}
	
	public final String getCardChip() {
		return cardChipProperty().get();
	}
	
	public final void setCardChip(String cardChip) {
		cardChipProperty().set(cardChip);
	}

}
