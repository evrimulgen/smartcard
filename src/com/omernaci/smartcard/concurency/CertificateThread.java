package com.omernaci.smartcard.concurency;

import java.io.IOException;
import java.util.List;

import com.omernaci.smartcard.controller.MainController;
import com.omernaci.smartcard.model.Certificate;
import com.omernaci.smartcard.service.impl.CertificateManagerImpl;

import sun.security.pkcs11.wrapper.PKCS11Exception;
import tr.gov.tubitak.uekae.esya.api.common.ESYAException;

public class CertificateThread extends Thread {
		
	private CertificateManagerImpl managerImpl;
	
	public CertificateThread() {
		managerImpl = new CertificateManagerImpl();
	}
	
	@Override
	public void run() {
		
		managerImpl.loadEsyaApiLicence();
		
		long startTime = System.nanoTime();
		try {
			synchronized (managerImpl) {
				//managerImpl.getCertificateList(MainController.data);
				//managerImpl.getSignatureCertificates(MainController.data);
				List<Certificate> certificates = managerImpl.getSignatureCertificates(MainController.data);
				System.out.println(certificates.get(0).getCertificateName());
				System.out.println(certificates.get(0).getCertificateCreatedDate());
			}
		} catch (PKCS11Exception e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ESYAException e) {
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
		
		long duration = (endTime - startTime) / 1000000; // millisecond
		
		System.out.println(duration + "ms in thread");
		
	}
}
