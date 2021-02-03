package com.example.restservice;

public class VideoInfo {
	private static final String template = "Index: %d, Width: %d, Height: %d, FPS: %.3f, Duration: %.3f, CodecType: %s, Codec: %s";    
    private final long index;
	private final long width;
	private final long height;
	private final float fps;
	private final float duration;
	private final String codecType;
	private final String codec;

	public VideoInfo(long index, long width, long height, float fps, float duration, String codecType, String codec) {
		this.index = index;
		this.width = width;
		this.height = height;
		this.fps = fps;
		this.duration = duration;
		this.codecType = codecType;
		this.codec = codec;
	}

    public long getIndex() {
        return index;
    }

    public long getWidth() {
        return width;
    }

    public long getHeight() {
        return height;
    }

    public float getFps() {
        return fps;
    }

    public float getDuration() {
        return duration;
    }


    public String getCodecType() {
        return codecType;
    }

    public String getCodec() {
        return codec;
    }

    @Override
    public String toString() { 
        return String.format(template, index, width, height, fps, duration, codecType, codec); 
    }
}
