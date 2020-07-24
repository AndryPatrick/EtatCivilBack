package com.person.service;

import java.io.IOException;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.stereotype.Service;

import com.person.service.bean.Naissance;

import fr.opensagres.xdocreport.core.XDocReportException;

public interface ServiceNaissance {

	String addNaissance(Naissance naissance);

	Naissance genererCopie(long identity) throws IOException, XDocReportException, Docx4JException;
	
}
