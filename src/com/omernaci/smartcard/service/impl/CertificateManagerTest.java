package com.omernaci.smartcard.service.impl;

import java.io.IOException;

import sun.security.pkcs11.wrapper.PKCS11Exception;
import tr.gov.tubitak.uekae.esya.api.common.ESYAException;

public class CertificateManagerTest {
	
	public static void main(String[] args) {
		
		CertificateManagerImpl managerImpl = new CertificateManagerImpl();
		managerImpl.loadEsyaApiLicence();
		try {
			System.out.println(managerImpl.getCertificateList("OMNIKEY AG CardMan 6121 00 00"));
		} catch (PKCS11Exception e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ESYAException e) {
			e.printStackTrace();
		}
		
		
	}

}
