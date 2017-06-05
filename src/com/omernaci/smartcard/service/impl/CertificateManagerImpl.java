package com.omernaci.smartcard.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.omernaci.smartcard.model.Certificate;
import com.omernaci.smartcard.service.CertificateManager;

import sun.security.pkcs11.wrapper.PKCS11Exception;
import tr.gov.tubitak.uekae.esya.api.asn.x509.ECertificate;
import tr.gov.tubitak.uekae.esya.api.common.ESYAException;
import tr.gov.tubitak.uekae.esya.api.common.util.LicenseUtil;
import tr.gov.tubitak.uekae.esya.api.common.util.bag.Pair;
import tr.gov.tubitak.uekae.esya.api.smartcard.pkcs11.BaseSmartCard;
import tr.gov.tubitak.uekae.esya.api.smartcard.pkcs11.CardType;
import tr.gov.tubitak.uekae.esya.api.smartcard.pkcs11.P11SmartCard;
import tr.gov.tubitak.uekae.esya.api.smartcard.pkcs11.SmartOp;

public class CertificateManagerImpl implements CertificateManager {

	@Override
	public void loadEsyaApiLicence() {
		InputStream inputStream = null;
		
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream("lisans/lisans.xml");
			LicenseUtil.setLicenseXml(inputStream);
		} catch (ESYAException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public List<ECertificate> getCertificateList(String terminal) throws PKCS11Exception, IOException, ESYAException {
		
		Pair<Long, CardType> slotAndCardType = SmartOp.getSlotAndCardType(terminal);
		
		long session = ((Long) slotAndCardType.getObject1()).longValue();
		
		BaseSmartCard baseSmartCard = new P11SmartCard(slotAndCardType.getObject2());
		baseSmartCard.openSession(session);		
		
		return getCertificateListFromByte(baseSmartCard.getSignatureCertificates());
	}
	
	public List<ECertificate> getCertificateListFromByte(List<byte[]> certificates) throws ESYAException {
		
		List<ECertificate> eCertificates = new ArrayList<ECertificate>();
		
		if (!(certificates.isEmpty())) {
			for (byte[] bs : certificates) {
				ECertificate certificate = new ECertificate(bs);
				eCertificates.add(certificate);
			}
		}	
		
		return eCertificates;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Certificate> getSignatureCertificates(String terminal) throws PKCS11Exception, IOException, ESYAException {
		
		List<Certificate> signatureCertificates = new ArrayList<Certificate>();
		
		String certificateName = "";
		
		String certificateCreatedDate = "";
		
		for (ECertificate eCertificate : getCertificateList(terminal)) {
			
			if (eCertificate.isQualifiedCertificate()) {
				certificateName = eCertificate.getSubject().getCommonNameAttribute();
				certificateCreatedDate = eCertificate.getNotBefore().getTime().toLocaleString();
				
				signatureCertificates.add(new Certificate(certificateName, certificateCreatedDate));
			}
			
		}
		
		return signatureCertificates;
	}

}
