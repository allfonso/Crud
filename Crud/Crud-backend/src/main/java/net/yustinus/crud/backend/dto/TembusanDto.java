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
public class TembusanDto {
	
	private int tembusanId;
	private String tembusanName;
	private String tembusanDescription;
	private List<TembusanItemDto> tembusanItems;
	private boolean tembusanDisable;
	
	public TembusanDto() {
	
	}

	public int getTembusanId() {
		return tembusanId;
	}

	public void setTembusanId(int tembusanId) {
		this.tembusanId = tembusanId;
	}

	public String getTembusanName() {
		return tembusanName;
	}

	public void setTembusanName(String tembusanName) {
		this.tembusanName = tembusanName;
	}

	public String getTembusanDescription() {
		return tembusanDescription;
	}

	public void setTembusanDescription(String tembusanDescription) {
		this.tembusanDescription = tembusanDescription;
	}

	public List<TembusanItemDto> getTembusanItems() {
		return tembusanItems;
	}

	public void setTembusanItems(List<TembusanItemDto> tembusanItems) {
		this.tembusanItems = tembusanItems;
	}

	public boolean isTembusanDisable() {
		return tembusanDisable;
	}

	public void setTembusanDisable(boolean tembusanDisable) {
		this.tembusanDisable = tembusanDisable;
	}

}
