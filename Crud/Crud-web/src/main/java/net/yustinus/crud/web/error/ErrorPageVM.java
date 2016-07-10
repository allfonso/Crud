/**
 * Copyright (c) 2016, Yustinus Nugroho
 * 
 * This software is created for education only.
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
package net.yustinus.crud.web.error;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

/**
 * @author Yustinus Nugroho
 *
 */
public class ErrorPageVM implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Window win;

	@WireVariable("requestScope")
	private Map<String, Object> _requestScope;

	private Integer errCode;
	private String errMessage;
	private String sorryMessage;
	private Exception exception;
	
	@Init
	public void initSetup(@ContextParam(ContextType.VIEW) Component view) {

		if (view instanceof Window) {
			this.win = (Window) view;
		}

		this.errCode = (Integer) _requestScope.get("javax.servlet.error.status_code");
		this.errMessage = (String) _requestScope.get("javax.servlet.error.message");
		this.exception = (Exception) _requestScope.get("javax.servlet.error.exception");
		this.sorryMessage = Labels.getLabel(
		                "Message_Error_SorryUnexpectedError",
		                "We're Sorry!/n/nAn unexpected error occured.");

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
	}
	
	@Command
	public void closeWin() {
		win.detach();
	}
	
	@Command
	public void showErrorDetail() {

		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("errCode", this.errCode);
		map.put("errMessage", this.errMessage);
		map.put("exception", this.exception);
		map.put("errFrom", "Un Handled Application Error");
		Sessions.getCurrent().setAttribute("errordetail", map);
		//Executions.getCurrent().sendRedirect("/pages/error/errordetail.zul", "_blank");
		//win.detach();
	}

	public String getSorryMessage() {
		return sorryMessage;
	}

	public void setSorryMessage(String sorryMessage) {
		this.sorryMessage = sorryMessage;
	}	
}
