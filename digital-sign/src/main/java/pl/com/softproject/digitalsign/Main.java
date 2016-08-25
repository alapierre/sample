/**
 * Copyright 2016-06-02 the original author or authors.
 */
package pl.com.softproject.digitalsign;


import eu.europa.esig.dss.DSSDocument;
import eu.europa.esig.dss.FileDocument;
import eu.europa.esig.dss.client.crl.OnlineCRLSource;
import eu.europa.esig.dss.client.http.commons.OCSPDataLoader;
import eu.europa.esig.dss.client.ocsp.OnlineOCSPSource;
import eu.europa.esig.dss.tsl.TrustedListsCertificateSource;
import eu.europa.esig.dss.validation.CommonCertificateVerifier;
import eu.europa.esig.dss.validation.SignedDocumentValidator;
import eu.europa.esig.dss.validation.report.Reports;
import eu.europa.esig.dss.x509.KeyStoreCertificateSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class Main {

    public static void main(String[] args) {


        File certsFile = new File("D:\\realizacje\\SoftProject\\commons\\sample-projects\\sample\\digital-sign\\src\\main\\resources\\keystore.p12");
        System.out.println(certsFile.exists());
        KeyStoreCertificateSource dssKeyStore = new KeyStoreCertificateSource(certsFile, "PKCS12", "dss-password");

        DSSDocument signature = new FileDocument(new File("sample/digital-sign/src/main/resources/3-5-2016.pdf.xades"));
        DSSDocument orygilnalDocument = new FileDocument(new File("sample/digital-sign/src/main/resources/3-5-2016.pdf"));

        OCSPDataLoader ocspDataLoader = new OCSPDataLoader();

        OnlineOCSPSource ocspSource = new OnlineOCSPSource();
        ocspSource.setDataLoader(ocspDataLoader);

        OnlineCRLSource crlSource = new OnlineCRLSource();
        crlSource.setDataLoader(ocspDataLoader);

        TrustedListsCertificateSource trustedCertSource = new TrustedListsCertificateSource();
        trustedCertSource.setDssKeyStore(dssKeyStore);

        CommonCertificateVerifier certificateVerifier = new CommonCertificateVerifier();
        certificateVerifier.setTrustedCertSource(trustedCertSource);
        certificateVerifier.setOcspSource(ocspSource);
        certificateVerifier.setCrlSource(crlSource);
        certificateVerifier.setDataLoader(ocspDataLoader);

        SignedDocumentValidator documentValidator = SignedDocumentValidator.fromDocument(signature);
        documentValidator.setCertificateVerifier(certificateVerifier);

        List<DSSDocument> detachedContents = new ArrayList<DSSDocument>();
        detachedContents.add(orygilnalDocument);
        documentValidator.setDetachedContents(detachedContents);

        Reports reports = documentValidator.validateDocument();

        reports.getSimpleReport().isSignatureValid("");

        //reports.print();

    }


}
