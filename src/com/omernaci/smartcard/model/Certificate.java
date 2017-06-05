package com.omernaci.smartcard.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Certificate {
	
	private StringProperty certificateName
			= new SimpleStringProperty(this, "certificateName");
	
	private StringProperty certificateCreatedDate
			= new SimpleStringProperty(this, "certificateCreatedDate");
	
	public Certificate(String certificateName, String certificateCreatedDate) {
		setCertificateName(certificateName);
		setCertificateCreatedDate(certificateCreatedDate);
	}
	
	public StringProperty certificateNameProperty() {
		return certificateName;
	}
	
	public final void setCertificateName(String certificateName) {
		certificateNameProperty().set(certificateName);
	}
	
	public final String getCertificateName() {
		return certificateNameProperty().get();
	}
	
	public StringProperty certificateCreatedDateProperty() {
		return certificateCreatedDate;
	}
	
	public final void setCertificateCreatedDate(String certificateCreatedDate) {
		certificateCreatedDateProperty().set(certificateCreatedDate);
	}
	
	public final String getCertificateCreatedDate() {
		return certificateCreatedDateProperty().get();
	}
	
}
