package com.omernaci.smartcard.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.smartcardio.CardException;

import com.omernaci.smartcard.concurency.CertificateThread;
import com.omernaci.smartcard.model.CardReader;
import com.omernaci.smartcard.service.impl.CertificateManagerImpl;
import com.omernaci.smartcard.service.impl.SmartCardManagerImpl;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class MainController implements Initializable {
	
	@FXML
    private ListView<String> listCardReader;
	
	private SmartCardManagerImpl cardManagerImpl;
	
	private CertificateManagerImpl managerImpl; 
	
	public static String data = "";
		
	private ObservableList<String> observableList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cardManagerImpl = new SmartCardManagerImpl();
		
		managerImpl = new CertificateManagerImpl();
		
		managerImpl.loadEsyaApiLicence();
		
		
		fillListViewContent();
		
		listCardReader.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println(oldValue + " - " + newValue);	
				checkItem(newValue);
				data = newValue;
				CertificateThread certificateThread = new CertificateThread();
				certificateThread.start();
			}
		});		
	}
	
	private void checkItem(String item) {

		for (String string : observableList) {
			if (!(string.contains(item))) {
				System.out.println("nacii");
			} else {
				System.out.println("soydemir");
			}
		}

		
	}

	private void fillListViewContent() {
		try {
			List<CardReader> cardReaders = cardManagerImpl.getCardReaderList();
			observableList = FXCollections.observableArrayList();
			for (int i = 0; i < cardReaders.size(); i++) {
				observableList.add(cardReaders.get(i).getCardReaderName());		
			}
			listCardReader.setItems(observableList);

		} catch (CardException e) {
			listCardReader.getItems().add("Takili kart okuyucu yok.");
		}		
	}

}
