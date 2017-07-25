/**
 * 
 * Copyright (c) 2017, Yustinus Nugroho
 * 
 * This software is created to help SIMPEG division in Badan Kepegawaian Daerah
 * gathering and organizing data from other divisions.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *   1. Redistributions of source code must retain the above copyright notice, 
 *      this list of conditions and the following disclaimer.
 * 
 *   2. Let me know if you use this code by email yustinus.nugroho@gmail.com
 *  
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * Hope this make changes.
 */
package net.yustinus.crud.backend.beans;

import java.util.Date;
import java.util.List;

import net.yustinus.crud.backend.dto.AtasNamaDto;
import net.yustinus.crud.backend.dto.MemperhatikanDto;
import net.yustinus.crud.backend.dto.MengingatDto;
import net.yustinus.crud.backend.dto.MenimbangDto;
import net.yustinus.crud.backend.dto.SpecimentDto;
import net.yustinus.crud.backend.dto.TembusanDto;
import net.yustinus.crud.backend.dto.TemplateSkMutasiDto;

/**
 * @author Yustinus Nugroho
 *
 */
public class SkMutasiBean {
	
	private int skMutasiId;
	private Date tglSkMutasi;
	private Date tmtSkMutasi;
	private String noSkMutasi;
	private List<MemberMutasiBean> memberMutasi;
	private MemperhatikanDto memperhatikan;
	private MenimbangDto menimbang;
	private MengingatDto mengingat;
	private TembusanDto tembusan;
	private SpecimentDto speciment;
	private AtasNamaDto atasNama;
	private TemplateSkMutasiDto templateSkMutasi;
	private int spaceBeforeMenimbang;
	private int spaceBeforeMengingat;
	private int spaceBeforeMemperhatikan;
	private int spaceBeforeMenetapkan;
	private int spaceBeforePenutup;
	private int spaceBeforeTembusan;
	private int spaceBeforeSpeciment;
	
	public SkMutasiBean() {
		
	}	

	public Date getTglSkMutasi() {
		return tglSkMutasi;
	}

	public void setTglSkMutasi(Date tglSkMutasi) {
		this.tglSkMutasi = tglSkMutasi;
	}

	public Date getTmtSkMutasi() {
		return tmtSkMutasi;
	}

	public void setTmtSkMutasi(Date tmtSkMutasi) {
		this.tmtSkMutasi = tmtSkMutasi;
	}

	public List<MemberMutasiBean> getMemberMutasi() {
		return memberMutasi;
	}

	public void setMemberMutasi(List<MemberMutasiBean> memberMutasi) {
		this.memberMutasi = memberMutasi;
	}

	public MemperhatikanDto getMemperhatikan() {
		return memperhatikan;
	}

	public void setMemperhatikan(MemperhatikanDto memperhatikan) {
		this.memperhatikan = memperhatikan;
	}

	public MenimbangDto getMenimbang() {
		return menimbang;
	}

	public void setMenimbang(MenimbangDto menimbang) {
		this.menimbang = menimbang;
	}

	public MengingatDto getMengingat() {
		return mengingat;
	}

	public void setMengingat(MengingatDto mengingat) {
		this.mengingat = mengingat;
	}

	public TembusanDto getTembusan() {
		return tembusan;
	}

	public void setTembusan(TembusanDto tembusan) {
		this.tembusan = tembusan;
	}

	public SpecimentDto getSpeciment() {
		return speciment;
	}

	public void setSpeciment(SpecimentDto speciment) {
		this.speciment = speciment;
	}

	public AtasNamaDto getAtasNama() {
		return atasNama;
	}

	public void setAtasNama(AtasNamaDto atasNama) {
		this.atasNama = atasNama;
	}

	public TemplateSkMutasiDto getTemplateSkMutasi() {
		return templateSkMutasi;
	}

	public void setTemplateSkMutasi(TemplateSkMutasiDto templateSkMutasi) {
		this.templateSkMutasi = templateSkMutasi;
	}

	public String getNoSkMutasi() {
		return noSkMutasi;
	}

	public void setNoSkMutasi(String noSkMutasi) {
		this.noSkMutasi = noSkMutasi;
	}

	public int getSkMutasiId() {
		return skMutasiId;
	}

	public void setSkMutasiId(int skMutasiId) {
		this.skMutasiId = skMutasiId;
	}

	public int getSpaceBeforeMenimbang() {
		return spaceBeforeMenimbang;
	}

	public void setSpaceBeforeMenimbang(int spaceBeforeMenimbang) {
		this.spaceBeforeMenimbang = spaceBeforeMenimbang;
	}

	public int getSpaceBeforeMengingat() {
		return spaceBeforeMengingat;
	}

	public void setSpaceBeforeMengingat(int spaceBeforeMengingat) {
		this.spaceBeforeMengingat = spaceBeforeMengingat;
	}

	public int getSpaceBeforeMemperhatikan() {
		return spaceBeforeMemperhatikan;
	}

	public void setSpaceBeforeMemperhatikan(int spaceBeforeMemperhatikan) {
		this.spaceBeforeMemperhatikan = spaceBeforeMemperhatikan;
	}

	public int getSpaceBeforeMenetapkan() {
		return spaceBeforeMenetapkan;
	}

	public void setSpaceBeforeMenetapkan(int spaceBeforeMenetapkan) {
		this.spaceBeforeMenetapkan = spaceBeforeMenetapkan;
	}

	public int getSpaceBeforePenutup() {
		return spaceBeforePenutup;
	}

	public void setSpaceBeforePenutup(int spaceBeforePenutup) {
		this.spaceBeforePenutup = spaceBeforePenutup;
	}

	public int getSpaceBeforeTembusan() {
		return spaceBeforeTembusan;
	}

	public void setSpaceBeforeTembusan(int spaceBeforeTembusan) {
		this.spaceBeforeTembusan = spaceBeforeTembusan;
	}

	public int getSpaceBeforeSpeciment() {
		return spaceBeforeSpeciment;
	}

	public void setSpaceBeforeSpeciment(int spaceBeforeSpeciment) {
		this.spaceBeforeSpeciment = spaceBeforeSpeciment;
	}

}
