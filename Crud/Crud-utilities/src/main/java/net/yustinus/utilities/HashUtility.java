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
package net.yustinus.utilities;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.prng.DigestRandomGenerator;
import org.bouncycastle.util.encoders.Base64;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;

/**
 * @author Yustinus Nugroho
 *
 */
public class HashUtility {
private static final DigestRandomGenerator drg = new DigestRandomGenerator(new SHA3Digest(512));
	
	/**
	 * 
	 */
	public HashUtility() {
	}
	
	public static String hash(String plainPassword) {
        return hash(plainPassword, salt(128), 512, 1024);
    }
	
	public static String hash(String plainPassword, byte[] salt) {
        return hash(plainPassword, salt, 512, 1024);
    }
	
	public static String hash(String plainPassword, byte[] salt, int keyLength, int iterations) {
		Preconditions.checkArgument(!isNullOrEmpty(plainPassword), "password can not be empty or null");
		Preconditions.checkArgument(keyLength > 0, "the key length must be greater than 0");
		Preconditions.checkArgument(iterations >= 0, "the number of iterations must be positive");
        
        PKCS5S2ParametersGenerator generator = new PKCS5S2ParametersGenerator();
        generator.init(plainPassword.getBytes(Charsets.UTF_8),
                salt,
                iterations);
        //System.out.println("salt hash :"+encode(salt));
        //System.out.println("salt hash :"+salt.length);
        return format("%s|%s",
                encode(salt),
                encode(((KeyParameter) generator.generateDerivedParameters(keyLength)).getKey()));        
	}
	
	public static boolean verify(String plainPassword, String hash) {
        Preconditions.checkArgument(!isNullOrEmpty(plainPassword));
        Preconditions.checkArgument(!isNullOrEmpty(hash));
        String ecyPlain = hash(plainPassword, decode(extractSalt(hash)));
        if (ecyPlain.equals(hash)) {
        	return true;
        } else {
    		//System.out.println("ency plain : "+ecyPlain);
    		//System.out.println("plain hash : "+hash);
        	return false;
        }
    }
	
	private static byte[] salt(int count) {
        byte[] salt = new byte[count];
        drg.nextBytes(salt);
        return salt;
    }
	
	private static String encode(byte[] input) {
        return Base64.toBase64String(input);
    }

    private static byte[] decode(String input) {
        return Base64.decode(input);
    }

    private static String extractSalt(String input) {
        return input.substring(0, input.indexOf("|"));
    }


}
