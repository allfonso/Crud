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
package net.yustinus.crud.backend.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.yustinus.crud.backend.dto.MengingatDto;
import net.yustinus.crud.backend.mappers.MengingatMapper;
import net.yustinus.crud.backend.services.MengingatService;

/**
 * @author Yustinus Nugroho
 *
 */

@Service("mengingatService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class MengingatServiceImpl implements MengingatService {

	/* (non-Javadoc)
	 * @see net.yustinus.crud.backend.services.mengingatService#getmengingatById(int)
	 */
	
	@Autowired
	private MengingatMapper mengingatMapper;
	
	@Override
	public MengingatDto getMengingatById(int mengingatId) {
		
		return mengingatMapper.selectMengingatById(mengingatId);
	}

}
