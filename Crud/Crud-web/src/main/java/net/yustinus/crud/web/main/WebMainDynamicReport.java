package net.yustinus.crud.web.main;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.icu.text.SimpleDateFormat;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.Units;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.builder.expression.JasperExpression;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.yustinus.crud.backend.beans.MemberMutasiBean;
import net.yustinus.crud.backend.beans.SkMutasiBean;
import net.yustinus.crud.backend.dto.MemperhatikanDto;
import net.yustinus.crud.backend.dto.MengingatDto;
import net.yustinus.crud.backend.dto.MenimbangDto;
import net.yustinus.crud.backend.dto.TembusanDto;
import net.yustinus.crud.backend.services.MemperhatikanService;
import net.yustinus.crud.backend.services.MengingatService;
import net.yustinus.crud.backend.services.MenimbangService;
import net.yustinus.crud.backend.services.TembusanService;
import net.yustinus.crud.web.report.ArialTemplate;
import net.yustinus.utilities.CrudUtility;

public class WebMainDynamicReport {

	public WebMainDynamicReport() {
	}

	public WebMainDynamicReport(SkMutasiBean skMutasi) {
		// TODO Auto-generated constructor stub
		build(skMutasi);
	}

	private void build(SkMutasiBean skMutasi) {
		JasperReportBuilder report = report();

		SubreportBuilder subreportTitle = cmp.subreport(createSubreportTitle());
		Map<String, Object> a = new HashMap<String, Object>();
		subreportTitle.setParameters(a);
		SubreportBuilder subreportMenimbang = cmp.subreport(createSubreport("menimbangItem"))
				.setDataSource(new subReportDataSource(1));
		SubreportBuilder subreportMemperhatikan = cmp.subreport(createSubreport("memperhatikanItem"))
				.setDataSource(new subReportDataSource(2));
		SubreportBuilder subreportMengingat = cmp.subreport(createSubreport("mengingatItem"))
				.setDataSource(new subReportDataSource(3));
		SubreportBuilder subreportMetapkan = cmp.subreport(createSubreportMenetapkan())
				.setDataSource(new subReportMenetapkanDatasource());
		SubreportBuilder subreportTembusan = cmp.subreport(createSubreportTembusan())
				.setDataSource(new subReportDataSource(4));
		SubreportBuilder subreportSpeciment = cmp.subreport(createSubreportSpeciment());

		// cmp.subreport(subreportTitle);

		report.setTemplate(ArialTemplate.reportTemplate);
		report.setPageFormat(Units.inch(8.5), Units.inch(13), PageOrientation.PORTRAIT);
		report.setPageMargin(DynamicReports.margin(20));
		report.setDataSource(createMainDataSource(skMutasi));
		report.addField("menimbang", MenimbangDto.class);
		report.addField("memperhatikan", MemperhatikanDto.class);
		report.addField("mengingat", MengingatDto.class);
		report.addField("tembusan", TembusanDto.class);
		report.addField("noSkMutasi", String.class);

		report.title(subreportTitle);
		report.detail(cmp.verticalGap(10));
		report.detail(subreportMenimbang);
		report.detail(cmp.verticalGap(10));
		report.detail(subreportMemperhatikan);
		report.detail(cmp.verticalGap(10));
		report.detail(subreportMengingat);
		report.detail(cmp.verticalGap(10));
		report.detail(subreportMetapkan);
		report.detail(cmp.verticalGap(10));
		report.detail(subreportTembusan);
		report.detail(cmp.verticalGap(10));
		report.summary(subreportSpeciment);

		try {
			report.show();
			FileOutputStream outputStream = new FileOutputStream(new File("d:\\ggg.pdf"));
			report.toPdf(outputStream);
			outputStream.close();
		} catch (DRException | IOException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createMainDataSource(SkMutasiBean skMutasi) {
		List<SkMutasiBean> d = new ArrayList<SkMutasiBean>();
		d.add(skMutasi);
		return new JRBeanCollectionDataSource(d);
	}

	private JRDataSource createMainDataSource(List<SkMutasiBean> skMutasiBeans) {
		return new JRBeanCollectionDataSource(skMutasiBeans);
	}

	// subreport Title
	private JasperReportBuilder createSubreportTitle() {
		JasperReportBuilder report = DynamicReports.report();
		report.setTemplate(ArialTemplate.reportTemplate);
		report.setPageMargin(DynamicReports.margin().setBottom(20));
		report.setTemplate(ArialTemplate.reportTemplate);
		report.addTitle(cmp.image("D:\\image002.gif").setHorizontalImageAlignment(HorizontalImageAlignment.CENTER),
				cmp.text("GUBERNUR DAERAH ISTIMEWA YOGYAKARTA").setStyle(ArialTemplate.titleStyle),				
				cmp.text("KEPUTUSAN GUBERNUR DAERAH ISTIMEWA YOGYAKARTA").setStyle(ArialTemplate.titleStyle),
				cmp.text(new ExpNomorSk()).setStyle(ArialTemplate.titleStyle),
				cmp.text("GUBERNUR DAERAH ISTIMEWA YOGYAKARTA").setStyle(ArialTemplate.titleStyle));

		return report;
	}

	// subreport menimbang memperhatikan mengingat
	private JasperReportBuilder createSubreport(String item) {
		JasperReportBuilder report = DynamicReports.report();
		String cap = item.substring(0, item.length() - 4);
		cap = cap.substring(0, 1).toUpperCase() + cap.substring(1);
		JasperExpression<?> jasperSyntax = exp.jasperSyntax("($V{REPORT_COUNT}==1?\"" + cap + "\":\"\")");
		JasperExpression<?> jasperSyntax2 = exp.jasperSyntax("($V{REPORT_COUNT}==1?\":\":\"\")");
		report.columns(col.column(jasperSyntax).setFixedWidth(90), col.column(jasperSyntax2).setFixedWidth(10),
				col.column(new ExpressionColumn(item)).setFixedWidth(20),
				col.column(item, type.stringType()).setHorizontalTextAlignment(HorizontalTextAlignment.JUSTIFIED));
		return report;
	}

	private JasperReportBuilder createSubreportMenetapkan() {
		JasperReportBuilder report = DynamicReports.report();
		report.addTitle(cmp.text("MEMUTUSKAN").setHorizontalTextAlignment(HorizontalTextAlignment.CENTER),
				cmp.horizontalList().add(cmp.text("Menetapkan").setFixedWidth(90), cmp.text(":").setFixedWidth(10)),
				cmp.horizontalList().add(cmp.text("KESATU").setFixedWidth(90), cmp.text(":").setFixedWidth(10),
						cmp.text("Pegawai Negeri Sipil tersebut di bawah ini :")),
				cmp.horizontalList().add(cmp.text("").setFixedWidth(100), cmp.text("Nama").setFixedWidth(160),
						cmp.text(":").setFixedWidth(10), cmp.text("MINARNI, S.Pd")),
				cmp.horizontalList().add(cmp.text("").setFixedWidth(100),
						cmp.text("Tempat/Tanggal Lahir").setFixedWidth(160), cmp.text(":").setFixedWidth(10),
						cmp.text("Bantul / 12-05-1968")),
				cmp.horizontalList().add(cmp.text("").setFixedWidth(100), cmp.text("NIP").setFixedWidth(160),
						cmp.text(":").setFixedWidth(10), cmp.text("19680512 201406 2 002")),
				cmp.horizontalList().add(cmp.text("").setFixedWidth(100), cmp.text("Pendidikan").setFixedWidth(160),
						cmp.text(":").setFixedWidth(10), cmp.text("S.1 Pendidikan")),
				cmp.horizontalList().add(cmp.text("").setFixedWidth(100),
						cmp.text("Pangkat/Golongan/TMT").setFixedWidth(160), cmp.text(":").setFixedWidth(10),
						cmp.text("Penata Muda / III/a /  01-06-2014")),
				cmp.horizontalList().add(cmp.text("").setFixedWidth(100),
						cmp.text("Jabatan dan Unit Kerja Lama").setFixedWidth(160), cmp.text(":").setFixedWidth(10),
						cmp.text(
								"Penyusun Rencana Kerjasama Kelembagaan pada Subbidang Kemitraan Bidang Pengembangan dan Kemitraan Badan Pendidikan dan Pelatihan DIY ")),
				cmp.horizontalList().add(cmp.text("").setFixedWidth(100),
						cmp.text(
								"terhitung mulai tanggal 01-09-2016 dipindahkan pada jabatan dan unit kerja baru sebagai Analis Perencanaan Program dan Anggaran pada Subbagian Program, Data dan Teknologi Informasi Sekretariat Badan Pendidikan dan Pelatihan DIY")),
				cmp.horizontalList().add(cmp.text("KEDUA").setFixedWidth(90), cmp.text(":").setFixedWidth(10),
						cmp.text(
								"Apabila dikemudian hari ternyata terdapat kekeliruan dalam keputusan ini, akan diadakan perbaikan sebagaimana mestinya.")),
				cmp.horizontalList().add(cmp.text(
						"ASLI Keputusan ini diberikan kepada Pegawai Negeri Sipil yang bersangkutan untuk diketahui dan dipergunakan sebagaimana mestinya.")));

		return report;
	}

	private JasperReportBuilder createSubreportTembusan() {
		JasperReportBuilder report = DynamicReports.report();
		report.addTitle(
				cmp.text("Salinan Keputusan ini disampaikan kepada Yth. :").setStyle(stl.style().setUnderline(true)));
		JasperExpression<?> jasperSyntax = exp.jasperSyntax("String.valueOf($V{REPORT_COUNT})+\".\"");
		report.columns(col.column(jasperSyntax).setFixedWidth(20),
				col.column(DynamicReports.field("tembusanItem", type.stringType())));
		return report;
	}

	private JasperReportBuilder createSubreportSpeciment() {
		JasperReportBuilder report = DynamicReports.report();
		report.addTitle(
				cmp.horizontalList().add(cmp.text("").setWidth(70),
						cmp.horizontalList().add(cmp.text("").setFixedWidth(200),
								cmp.text("Ditetapkan di Yogyakarta"))),
				cmp.horizontalList().add(cmp.text("").setWidth(70),
						cmp.horizontalList().add(cmp.text("").setFixedWidth(200),
								cmp.text("pada tanggal  26-08-2016"))),
				cmp.verticalGap(15),
				cmp.horizontalList().add(cmp.text("").setWidth(50),
						cmp.text("a.n. GUBERNUR").setHorizontalTextAlignment(HorizontalTextAlignment.CENTER)),
				cmp.horizontalList().add(cmp.text("").setWidth(50),
						cmp.text("DAERAH ISTIMEWA YOGYAKARTA")
								.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER)),
				cmp.horizontalList().add(cmp.text("").setWidth(50),
						cmp.text("KEPALA BADAN KEPEGAWAIAN DAERAH")
								.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER)),
				cmp.verticalGap(50),
				cmp.horizontalList().add(cmp.text("").setWidth(50),
						cmp.text("R. AGUS SUPRIYANTO, S.H., M.Hum")
								.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER)
								.setStyle(stl.style().setUnderline(true))),
				cmp.horizontalList().add(cmp.text("").setWidth(50), cmp.text("NIP. 19600318 198603 1 012")
						.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER)));
		return report;
	}

	private class subReportDataSource extends AbstractSimpleExpression<JRDataSource> {

		protected int param;

		public subReportDataSource(int param) {
			this.param = param;
		}

		private static final long serialVersionUID = 7382030511380420635L;

		@Override
		public JRDataSource evaluate(ReportParameters parameters) {
			if (this.param == 1) {
				MenimbangDto menimbang = parameters.getValue("menimbang");
				return new JRBeanCollectionDataSource(menimbang.getMenimbangItems());
			} else if (this.param == 2) {
				MemperhatikanDto memperhatikan = parameters.getValue("memperhatikan");
				return new JRBeanCollectionDataSource(memperhatikan.getMemperhatikanItems());
			} else if (this.param == 3) {
				MengingatDto mengingat = parameters.getValue("mengingat");
				return new JRBeanCollectionDataSource(mengingat.getMengingatItems());
			} else {
				TembusanDto tembusan = parameters.getValue("tembusan");
				return new JRBeanCollectionDataSource(tembusan.getTembusanItems());
			}
		}
	}

	private class subReportMenetapkanDatasource extends AbstractSimpleExpression<JRDataSource> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1985118807914472511L;

		@Override
		public JRDataSource evaluate(ReportParameters parameters) {
			
			List<Menetapkan> menetapkan = new ArrayList<Menetapkan>();
			
			Date tmtSk = parameters.getMasterParameters().getValue("tmtSkMutasi");
			String tmtSkMutasi = CrudUtility.sortDateFormat(tmtSk);
			List<MemberMutasiBean> member =  parameters.getMasterParameters().getValue("memberMutasi");
			for (MemberMutasiBean emp : member) {
				Menetapkan memberMutasi = new Menetapkan();
				memberMutasi.setNama(emp.getNama());
				memberMutasi.setNip(emp.getNip());
				memberMutasi.setTempatLahir(emp.getTempatLahir());
				memberMutasi.setTglLahir(CrudUtility.sortDateFormat(emp.getTglLahir()));
				memberMutasi.setPendidikan(emp.getPendidikan().getPendidikan());
				memberMutasi.setGolongan(emp.getGolongan().getGolongan());
				memberMutasi.setPangkat(emp.getGolongan().getPangkat());
				memberMutasi.setTmtGolongan(CrudUtility.sortDateFormat(emp.getTmtGolongan()));
				if (emp.getJenisJabatanLama().getJenisJabatanId() == 1 )					
					memberMutasi.setJabatanLama(emp.getUnorLama().getNamaJabatanStruktural());
				else 
					memberMutasi.setJabatanLama(emp.getJabatanLama().getJabatanName());
				memberMutasi.setUnorLama(emp.getUnorLama().getFullyQualifiedUnorName());
				
				if (emp.getJenisJabatanBaru().getJenisJabatanId() == 1 )					
					memberMutasi.setJabatanBaru(emp.getUnorBaru().getNamaJabatanStruktural());
				else 
					memberMutasi.setJabatanBaru(emp.getJabatanBaru().getJabatanName());
				memberMutasi.setUnorBaru(emp.getUnorBaru().getFullyQualifiedUnorName());
				
				memberMutasi.setTmtSkMutasi(tmtSkMutasi);
				
				menetapkan.add(memberMutasi);
			}
			return new JRBeanCollectionDataSource(menetapkan);
		}

	}

	private class ExpressionColumn extends AbstractSimpleExpression<String> {

		protected String capItem;

		public ExpressionColumn(String capItem) {
			this.capItem = capItem;
		}

		private static final long serialVersionUID = 1L;

		@Override
		public String evaluate(ReportParameters parameters) {
			if (capItem.equalsIgnoreCase("menimbangItem")) {
				MenimbangDto menimbang = parameters.getMasterParameters().getValue("menimbang");
				if (menimbang.getMenimbangItems().size() > 1)
					return parameters.getReportRowNumber() + ".";
				else
					return null;
			} else if (capItem.equalsIgnoreCase("memperhatikanItem")) {
				MemperhatikanDto memperhatikan = parameters.getMasterParameters().getValue("memperhatikan");
				if (memperhatikan.getMemperhatikanItems().size() > 1)
					return parameters.getReportRowNumber() + ".";
				else
					return null;
			} else if (capItem.equalsIgnoreCase("mengingatItem")) {
				MengingatDto mengingat = parameters.getMasterParameters().getValue("mengingat");
				if (mengingat.getMengingatItems().size() > 1)
					return parameters.getReportRowNumber() + ".";
				else
					return null;
			} else
				return null;
		}

	}

	private class ExpNomorSk extends AbstractSimpleExpression<String> {

		private static final long serialVersionUID = -1446136393080044959L;

		@Override
		public String evaluate(ReportParameters parameters) {
			String a = parameters.getMasterParameters().getFieldValue("noSkMutasi");
			return "NOMOR : " + a;
		}

	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MenimbangService menimbangService = (MenimbangService) ctx.getBean("menimbangService");
		MemperhatikanService memperhatikanService = (MemperhatikanService) ctx.getBean("memperhatikanService");
		MengingatService mengingatService = (MengingatService) ctx.getBean("mengingatService");
		TembusanService tembusanService = (TembusanService) ctx.getBean("tembusanService");

		SkMutasiBean skMutasiBean = new SkMutasiBean();
		skMutasiBean.setMenimbang(menimbangService.getMenimbangById(1));
		skMutasiBean.setMemperhatikan(memperhatikanService.getMemperhatikanById(1));
		skMutasiBean.setMengingat(mengingatService.getMengingatById(0));
		skMutasiBean.setTembusan(tembusanService.getTembusanById(1));
		skMutasiBean.setNoSkMutasi("177/asdf/23423/923");
		new WebMainDynamicReport(skMutasiBean);
		ctx.close();
	}

	public class Menetapkan {

		private String nama;
		private String nip;
		private String tempatLahir;
		private String tglLahir;
		private String pendidikan;
		private String golongan;
		private String pangkat;
		private String tmtGolongan;
		private String jabatanLama;
		private String unorLama;
		private String jabatanBaru;
		private String unorBaru;
		private String tmtSkMutasi;

		public Menetapkan() {

		}

		public String getNama() {
			return nama;
		}

		public void setNama(String nama) {
			this.nama = nama;
		}

		public String getNip() {
			return nip;
		}

		public void setNip(String nip) {
			this.nip = nip;
		}

		public String getTempatLahir() {
			return tempatLahir;
		}

		public void setTempatLahir(String tempatLahir) {
			this.tempatLahir = tempatLahir;
		}

		public String getTglLahir() {
			return tglLahir;
		}

		public void setTglLahir(String tglLahir) {
			this.tglLahir = tglLahir;
		}

		public String getPendidikan() {
			return pendidikan;
		}

		public void setPendidikan(String pendidikan) {
			this.pendidikan = pendidikan;
		}

		public String getGolongan() {
			return golongan;
		}

		public void setGolongan(String golongan) {
			this.golongan = golongan;
		}

		public String getPangkat() {
			return pangkat;
		}

		public void setPangkat(String pangkat) {
			this.pangkat = pangkat;
		}

		public String getTmtGolongan() {
			return tmtGolongan;
		}

		public void setTmtGolongan(String tmtGolongan) {
			this.tmtGolongan = tmtGolongan;
		}

		public String getJabatanLama() {
			return jabatanLama;
		}

		public void setJabatanLama(String jabatanLama) {
			this.jabatanLama = jabatanLama;
		}

		public String getUnorLama() {
			return unorLama;
		}

		public void setUnorLama(String unorLama) {
			this.unorLama = unorLama;
		}

		public String getJabatanBaru() {
			return jabatanBaru;
		}

		public void setJabatanBaru(String jabatanBaru) {
			this.jabatanBaru = jabatanBaru;
		}

		public String getUnorBaru() {
			return unorBaru;
		}

		public void setUnorBaru(String unorBaru) {
			this.unorBaru = unorBaru;
		}

		public String getTmtSkMutasi() {
			return tmtSkMutasi;
		}

		public void setTmtSkMutasi(String tmtSkMutasi) {
			this.tmtSkMutasi = tmtSkMutasi;
		}
	}

}
