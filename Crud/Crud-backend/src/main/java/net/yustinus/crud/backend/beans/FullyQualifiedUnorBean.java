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

import net.yustinus.crud.backend.dto.UnorDto;

/**
 * @author Yustinus Nugroho
 *
 */
public class FullyQualifiedUnorBean {
	
	private UnorDto lvl1Unor;
	private UnorDto lvl2Unor;
	private UnorDto lvl3Unor;
	
	public FullyQualifiedUnorBean() {
		
	}
	
	public UnorDto getLvl1Unor() {
		return lvl1Unor;
	}
	public void setLvl1Unor(UnorDto lvl1Unor) {
		this.lvl1Unor = lvl1Unor;
	}
	public UnorDto getLvl2Unor() {
		return lvl2Unor;
	}
	public void setLvl2Unor(UnorDto lvl2Unor) {
		this.lvl2Unor = lvl2Unor;
	}
	public UnorDto getLvl3Unor() {
		return lvl3Unor;
	}
	public void setLvl3Unor(UnorDto lvl3Unor) {
		this.lvl3Unor = lvl3Unor;
	}

}
