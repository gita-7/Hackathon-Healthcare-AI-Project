package com.Healthcare_AI.Healthcare.AI.service;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.concurrent.Future;

public class VoiceConversionService {


    @Value("${azure.speech.key}")
    private String speechApiKey;

    @Value("${azure.speech.region}")
    private String speechRegion;

    public String convertVoiceToText(File voiceFile) {
        try {
            SpeechConfig speechConfig = SpeechConfig.fromSubscription(speechApiKey, speechRegion);
            AudioConfig audioConfig = AudioConfig.fromWavFileInput(voiceFile.getAbsolutePath());
            SpeechRecognizer recognizer = new SpeechRecognizer(speechConfig, audioConfig);

            Future<SpeechRecognitionResult> task = recognizer.recognizeOnceAsync();
            SpeechRecognitionResult result = task.get();

            return result.getText();
        } catch (Exception e) {
            return "Error converting voice to text.";
        }
    }
}
