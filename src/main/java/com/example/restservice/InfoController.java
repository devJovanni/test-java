package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.kokorin.jaffree.ffprobe.FFprobe;
import com.github.kokorin.jaffree.ffprobe.FFprobeResult;
import com.github.kokorin.jaffree.ffprobe.Stream;
import java.nio.file.Path;

import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.restservice.service.FileStorageService;

@RestController
public class InfoController {
    @Autowired
    private FileStorageService fileStorageService;

	@PostMapping("/info")
	public Info info(@RequestParam("file") MultipartFile file) {
        FFprobe ffprobe;
        ffprobe = FFprobe.atPath();
        Info result = new Info();

        String fileName = fileStorageService.storeFile(file);

        Path filePath = fileStorageService.getFilePath(fileName);

        FFprobeResult probeResult = ffprobe
                .setShowStreams(true)
                .setInput(filePath)
                .execute();

        for (Stream stream : probeResult.getStreams()) {
            if (stream.getCodecType().code().equals("v")) {
                result.setVideo(new VideoInfo(stream.getIndex(), stream.getWidth(), stream.getHeight(), stream.getRFrameRate().longValue(), stream.getDuration(), "VIDEO", stream.getCodecLongName()));
            }
            else if (stream.getCodecType().code().equals("a")) {
                result.setAudio(new AudioInfo(stream.getIndex(), "AUDIO", stream.getCodecLongName()));
            }
        }

        return result;
		//return new Info();
	}
}
