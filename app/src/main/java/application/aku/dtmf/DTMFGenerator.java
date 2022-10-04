package application.aku.dtmf;

import android.media.AudioManager;
import android.media.ToneGenerator;

public class DTMFGenerator {
	final static int DTMF_LENGTH = 300; //lama suara
	final static int DTMF_PAUSE_LENGTH = 350; //lama berhennti
	
	ToneGenerator toneGenerator = new ToneGenerator(AudioManager.STREAM_DTMF, ToneGenerator.MAX_VOLUME);
	
    public boolean playDtmfSequence(String sequence, int lama) throws InterruptedException {
    	char aChar[] = sequence.toCharArray();

    	for(char cTone: aChar) {
    		if(cTone == '0') {
    			toneGenerator.startTone(ToneGenerator.TONE_DTMF_0, lama);
    		}
    		else if(cTone == '1') {
    			toneGenerator.startTone(ToneGenerator.TONE_DTMF_1, lama);
    		}
    		else if(cTone == '2') {
    			toneGenerator.startTone(ToneGenerator.TONE_DTMF_2, lama);
    		}
    		else if(cTone == '3') {
    			toneGenerator.startTone(ToneGenerator.TONE_DTMF_3, lama);
    		}
    		else if(cTone == '4') {
    			toneGenerator.startTone(ToneGenerator.TONE_DTMF_4, lama);
    		}
    		else if(cTone == '5') {
    			toneGenerator.startTone(ToneGenerator.TONE_DTMF_5, lama);
    		}
    		else if(cTone == '6') {
    			toneGenerator.startTone(ToneGenerator.TONE_DTMF_6, lama);
    		}
    		else if(cTone == '7') {
    			toneGenerator.startTone(ToneGenerator.TONE_DTMF_7, lama);
    		}
    		else if(cTone == '8') {
    			toneGenerator.startTone(ToneGenerator.TONE_DTMF_8, lama);
    		}
    		else if(cTone == '9') {
    			toneGenerator.startTone(ToneGenerator.TONE_DTMF_9, lama);
    		}
    		else if(cTone == 'a') {
    			toneGenerator.startTone(ToneGenerator.TONE_DTMF_A, lama);
    		}
			else if(cTone == 'b') {
				toneGenerator.startTone(ToneGenerator.TONE_DTMF_B, lama);
			}
			else if(cTone == 'c') {
				toneGenerator.startTone(ToneGenerator.TONE_DTMF_C, lama);
			}
			else if(cTone == 'd') {
				toneGenerator.startTone(ToneGenerator.TONE_DTMF_D, lama);
			}
			else if(cTone == '+') {
				toneGenerator.startTone(ToneGenerator.TONE_DTMF_0, lama);
			}
			else if(cTone == '*') {
				toneGenerator.startTone(ToneGenerator.TONE_DTMF_S, lama);
			}
			else if(cTone == '#') {
				toneGenerator.startTone(ToneGenerator.TONE_DTMF_P, lama);
			}
    		
    		Thread.sleep(DTMF_PAUSE_LENGTH);
    	}
    	return true;
    }
}