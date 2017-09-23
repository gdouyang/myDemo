package json;


import java.io.*; 

import com.fasterxml.jackson.core.*; 
import com.fasterxml.jackson.core.io.CharacterEscapes; 
import com.fasterxml.jackson.core.io.SerializedString; 
 
    /*
    /******************************************************** 
    /* Helper types 
    /******************************************************** 
     */ 
 
    /**
     * Trivial simple custom escape definition set. 
     */ 
    @SuppressWarnings("serial") 
  public class MyEscapes extends CharacterEscapes 
    { 
    	final static int TWO_BYTE_ESCAPED = 0x111; 
        final static int THREE_BYTE_ESCAPED = 0x1111; 
     
        final static SerializedString TWO_BYTE_ESCAPED_STRING = new SerializedString("&111;"); 
        final static SerializedString THREE_BYTE_ESCAPED_STRING = new SerializedString("&1111;"); 
        private final int[] _asciiEscapes; 
 
        public MyEscapes() { 
            _asciiEscapes = standardAsciiEscapesForJSON(); 
//            _asciiEscapes['a'] = 'A'; // to basically give us "\A" 
            _asciiEscapes['>'] = CharacterEscapes.ESCAPE_CUSTOM; // too force "\u0062" 
            _asciiEscapes['<'] = CharacterEscapes.ESCAPE_CUSTOM; 
            _asciiEscapes['"'] = CharacterEscapes.ESCAPE_CUSTOM; 
            _asciiEscapes['\''] = CharacterEscapes.ESCAPE_CUSTOM; 
        } 
         
        @Override 
        public int[] getEscapeCodesForAscii() { 
            return _asciiEscapes; 
        } 
 
        @Override 
        public SerializableString getEscapeSequence(int ch) 
        { 
            if (ch == '<') { 
                return new SerializedString("&lt;"); 
            }
            if (ch == '>') { 
            	return new SerializedString("&gt;"); 
            }
            if (ch == '"') { 
            	return new SerializedString("&quot;"); 
            }
            if (ch == '\'') { 
            	return new SerializedString("&apos;"); 
            }
            if (ch == TWO_BYTE_ESCAPED) { 
                return TWO_BYTE_ESCAPED_STRING; 
            } 
            if (ch == THREE_BYTE_ESCAPED) { 
                return THREE_BYTE_ESCAPED_STRING; 
            } 
            return null; 
        } 
    } 
     
    
