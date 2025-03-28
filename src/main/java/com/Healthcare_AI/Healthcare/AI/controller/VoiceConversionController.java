package com.Healthcare_AI.Healthcare.AI.controller;

import com.Healthcare_AI.Healthcare.AI.service.VoiceConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VoiceConversionController {

    @Autowired
    private VoiceConversionService voiceConversionService;

    @CrossOrigin
    @PostMapping("/convert")
    public ResponseEntity<String> convertVoice(@RequestParam("voiceFile") MultipartFile file) {
        try {
            File convFile = new File(file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();

            String text = voiceConversionService.convertVoiceToText(convFile);
            return ResponseEntity.ok(text);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing voice file.");
        }
    }

//    @PostMapping("/voice/convert")
//    public ResponseEntity<String> convertVoice(@RequestBody byte[] audioData) {
//        String text = speechToTextService.convert(audioData);
//        return ResponseEntity.ok(text);
//    }
}
