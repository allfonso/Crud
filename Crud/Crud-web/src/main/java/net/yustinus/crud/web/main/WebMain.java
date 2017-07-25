package net.yustinus.crud.web.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.samples.AbstractSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.yustinus.crud.backend.beans.SkMutasiBean;
import net.yustinus.crud.backend.dto.MenimbangDto;
import net.yustinus.crud.backend.dto.MenimbangItemDto;
import net.yustinus.crud.backend.dto.RoleDto;
import net.yustinus.crud.backend.services.MemperhatikanService;
import net.yustinus.crud.backend.services.MengingatService;
import net.yustinus.crud.backend.services.MenimbangService;

public class WebMain{
	
	private MenimbangDto menimbang;

	public WebMain() {

	}

	public void init() {		
	}

	public static void main(String[] args) throws Docx4JException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MenimbangService menimbangService = (MenimbangService) ctx.getBean("menimbangService");
		MemperhatikanService memperhatikanService = (MemperhatikanService) ctx.getBean("memperhatikanService");
		MengingatService mengingatService = (MengingatService) ctx.getBean("mengingatService");
		
		/*	SkMutasiBean skMutasiBean = new SkMutasiBean();		
		skMutasiBean.setMenimbang(menimbangService.getMenimbangById(1));
		skMutasiBean.setMemperhatikan(memperhatikanService.getMemperhatikanById(1));
		skMutasiBean.setMengingat(mengingatService.getMengingatById(1));

		List<SkMutasiBean> skMutasiBeans = new ArrayList<SkMutasiBean>();
		skMutasiBeans.add(skMutasiBean);
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(skMutasiBeans);
		//JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(menimbangService.getMenimbangById(1).getMenimbangItems());
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport("D:/skMutasi.jasper", null,
					beanCollectionDataSource);
			//JasperPrint jasperPrint = JasperFillManager.fillReport("D:/menimbangItems.jasper", null,
			//		beanCollectionDataSource);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, "D:/bbb.pdf");
			// JasperExportManager.exportReportToPdfFile(jasperPrint,
			// "D:/aaa.pdf");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ctx.close();*/
		
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
		MainDocumentPart mdp = wordMLPackage.getMainDocumentPart();
		
		mdp.addParagraphOfText("hello world");
		
//		ProtectDocument protection = new ProtectDocument(wordMLPackage);
//		protection.restrictEditing(STDocProtect.READ_ONLY, "foobaa");
		
		
		String filename = "D:\\bbb.docx";
		Docx4J.save(wordMLPackage, new java.io.File(filename), Docx4J.FLAG_SAVE_ZIP_FILE); 
		System.out.println("Saved " + filename);
	}

	public MenimbangDto getMenimbang() {
		return menimbang;
	}

	public void setMenimbang(MenimbangDto menimbang) {
		this.menimbang = menimbang;
	}

}
