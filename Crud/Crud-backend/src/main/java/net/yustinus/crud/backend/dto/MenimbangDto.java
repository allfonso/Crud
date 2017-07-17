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
package net.yustinus.crud.backend.dto;

import java.util.List;

/**
 * @author Yustinus Nugroho
 *
 */
public class MenimbangDto {
	
	private int menimbangId;
	private String menimbangName;
	private String menimbangDescription;
	private List<MenimbangItemDto> menimbangItems;
	private boolean menimbangDisable;
	
	public MenimbangDto() {
		
	}

	public int getMenimbangId() {
		return menimbangId;
	}

	public void setMenimbangId(int menimbangId) {
		this.menimbangId = menimbangId;
	}

	public String getMenimbangName() {
		return menimbangName;
	}

	public void setMenimbangName(String menimbangName) {
		this.menimbangName = menimbangName;
	}

	public String getMenimbangDescription() {
		return menimbangDescription;
	}

	public void setMenimbangDescription(String menimbangDescription) {
		this.menimbangDescription = menimbangDescription;
	}

	public boolean isMenimbangDisable() {
		return menimbangDisable;
	}

	public void setMenimbangDisable(boolean menimbangDisable) {
		this.menimbangDisable = menimbangDisable;
	}

	public List<MenimbangItemDto> getMenimbangItems() {
		return menimbangItems;
	}

	public void setMenimbangItems(List<MenimbangItemDto> menimbangItems) {
		this.menimbangItems = menimbangItems;
	}

}
