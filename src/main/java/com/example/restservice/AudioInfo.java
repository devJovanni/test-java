package com.example.restservice;

public class AudioInfo {
	private static final String template = "Index: %d, CodecType: %s, Codec: %s";    
    private final long index;
	private final String codecType;
	private final String codec;

	public AudioInfo(long index, String codecType, String codec) {
		this.index = index;
		this.codecType = codecType;
		this.codec = codec;
	}

    public long getIndex() {
        return index;
    }

    public String getCodecType() {
        return codecType;
    }

    public String getCodec() {
        return codec;
    }

    @Override
    public String toString() { 
        return String.format(template, index, codecType, codec); 
    }
}
