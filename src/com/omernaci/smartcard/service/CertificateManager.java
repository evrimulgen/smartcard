package com.omernaci.smartcard.service;

import java.io.IOException;
import java.util.List;

import com.omernaci.smartcard.model.Certificate;

import sun.security.pkcs11.wrapper.PKCS11Exception;
import tr.gov.tubitak.uekae.esya.api.asn.x509.ECertificate;
import tr.gov.tubitak.uekae.esya.api.common.ESYAException;

public interface CertificateManager {
	
	public void loadEsyaApiLicence();
	
	public List<ECertificate> getCertificateList(String terminal) throws PKCS11Exception, IOException, ESYAException;
	
	public List<ECertificate> getCertificateListFromByte(List<byte[]> certificates) throws ESYAException;
	
	public List<Certificate> getSignatureCertificates(String terminal) throws PKCS11Exception, IOException, ESYAException;
	

}
