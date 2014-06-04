package com.MusicDessert.Service;

import java.util.Date;

public interface IdentifyingCodeFactory {
	public static final int IDENTIFYING_CODE_LEFT_CYCLE = 10;//µ¥Î»ÎªÃë
	public static enum IdentifyingCodeState {Correct, LoseEfficacy, UnCreated, Wrong};
	
	public boolean sendAndSaveIdentifyingCode(String phoneNumber);
	public IdentifyingCodeState getIdentifyingCodeState(String identifyingCode);
	public boolean isIdentifyingCodeBeenSended();
	public boolean isIdentifyingCodeLoseEfficacy();
	public boolean isIdentifyingCodeCorrect(String identifyingCode);
	public String getIdentifyingCode();
	public Date getIdentifyingCodeCreateTime();
}
