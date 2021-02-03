package com.example.restservice;

public class Info {
    private VideoInfo video;
	private AudioInfo audio;

    public Info(VideoInfo videoInfo, AudioInfo audioInfo) {
        this.video = videoInfo;
        this.audio = audioInfo;
    }

    public Info() {
        this(null, null);
    }

    public void setVideo(VideoInfo videoInfo) {
        this.video = videoInfo;
    }

    public void setAudio(AudioInfo audioInfo) {
        this.audio = audioInfo;
    }

    public VideoInfo getVideo() {
        return video;
    }

    public AudioInfo getAudio() {
        return audio;
    }
}
