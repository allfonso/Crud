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

import net.yustinus.crud.backend.dto.GolonganDto;
import net.yustinus.crud.backend.dto.JabatanDto;
import net.yustinus.crud.backend.dto.PendidikanDto;
import net.yustinus.crud.backend.dto.UnorDto;

/**
 * @author Yustinus Nugroho
 *
 */
public class MemberMutasiBean {

	private int skMutasiId;
	private String nama;
	private String nip;
	private Date tmtGolongan;
	private GolonganDto golongan;
	private String tempatLahir;
	private Date tglLahir;
	private JabatanDto jabatanLama;
	private UnorDto unorLama;
	private JabatanDto jabatanBaru;
	private UnorDto unorBaru;	
	private PendidikanDto pendidikanLama;
	private PendidikanDto pendidikanBaru;
	
	public MemberMutasiBean() {
		
	}

	public int getSkMutasiId() {
		return skMutasiId;
	}

	public void setSkMutasiId(int skMutasiId) {
		this.skMutasiId = skMutasiId;
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

	public GolonganDto getGolongan() {
		return golongan;
	}

	public void setGolongan(GolonganDto golongan) {
		this.golongan = golongan;
	}

	public Date getTglLahir() {
		return tglLahir;
	}

	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}

	public JabatanDto getJabatanLama() {
		return jabatanLama;
	}

	public void setJabatanLama(JabatanDto jabatanLama) {
		this.jabatanLama = jabatanLama;
	}	

	public JabatanDto getJabatanBaru() {
		return jabatanBaru;
	}

	public void setJabatanBaru(JabatanDto jabatanBaru) {
		this.jabatanBaru = jabatanBaru;
	}

	public UnorDto getUnorLama() {
		return unorLama;
	}

	public void setUnorLama(UnorDto unorLama) {
		this.unorLama = unorLama;
	}

	public UnorDto getUnorBaru() {
		return unorBaru;
	}

	public void setUnorBaru(UnorDto unorBaru) {
		this.unorBaru = unorBaru;
	}

	public Date getTmtGolongan() {
		return tmtGolongan;
	}

	public void setTmtGolongan(Date tmtGolongan) {
		this.tmtGolongan = tmtGolongan;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public PendidikanDto getPendidikanLama() {
		return pendidikanLama;
	}

	public void setPendidikanLama(PendidikanDto pendidikanLama) {
		this.pendidikanLama = pendidikanLama;
	}

	public PendidikanDto getPendidikanBaru() {
		return pendidikanBaru;
	}

	public void setPendidikanBaru(PendidikanDto pendidikanBaru) {
		this.pendidikanBaru = pendidikanBaru;
	}
}
