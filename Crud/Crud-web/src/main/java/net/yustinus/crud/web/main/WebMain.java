package net.yustinus.crud.web.main;

import java.util.ArrayList;
import java.util.List;

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
import net.yustinus.crud.backend.services.MenimbangService;

public class WebMain {

	@Autowired
	private MenimbangService menimbangService;
	private MenimbangDto menimbang;

	public WebMain() {

	}

	public void init() {
		this.menimbang = menimbangService.getMenimbangById(1);
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MenimbangService menimbangService = (MenimbangService) ctx.getBean("menimbangService");

		

		SkMutasiBean skMutasiBean = new SkMutasiBean();
		/*
		 * MenimbangDto menimbang = new MenimbangDto(); List<MenimbangItemDto>
		 * menimbangItems = new ArrayList<MenimbangItemDto>(); for (int i=0;
		 * i<5;i++) { MenimbangItemDto a = new MenimbangItemDto();
		 * a.setMenimbangItem("Menimbang "+(i+1)); menimbangItems.add(a); }
		 * 
		 * menimbang.setMenimbangItems(menimbangItems);
		 * menimbang.setMenimbangName("yustinus");
		 */		
		skMutasiBean.setMenimbang(menimbangService.getMenimbangById(1));

		List<SkMutasiBean> skMutasiBeans = new ArrayList<SkMutasiBean>();
		skMutasiBeans.add(skMutasiBean);
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(skMutasiBeans);
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport("D:/skMutasi.jasper", null,
					beanCollectionDataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "D:/aaa.pdf");
			// JasperExportManager.exportReportToPdfFile(jasperPrint,
			// "D:/aaa.pdf");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MenimbangDto getMenimbang() {
		return menimbang;
	}

	public void setMenimbang(MenimbangDto menimbang) {
		this.menimbang = menimbang;
	}

	public MenimbangService getMenimbangService() {
		return menimbangService;
	}

	public void setMenimbangService(MenimbangService menimbangService) {
		this.menimbangService = menimbangService;
	}

}
