package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestCallAPIService {

    private final WebClient webClient;

    @Autowired
    public TestCallAPIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://emplinfo.appplay.co.kr/gw/ApiGate").build();
    }
    public static class Params {
        public Params() {
        }

        public String getPTL_STS() {
            return PTL_STS;
        }

        public void setPTL_STS(String PTL_STS) {
            this.PTL_STS = PTL_STS;
        }

        String PTL_STS;

        public TestCallAPIService.REQ_DATA getREQ_DATA() {
            return REQ_DATA;
        }

        public void setREQ_DATA(TestCallAPIService.REQ_DATA REQ_DATA) {
            this.REQ_DATA = REQ_DATA;
        }

        public String getSECR_KEY() {
            return SECR_KEY;
        }

        public void setSECR_KEY(String SECR_KEY) {
            this.SECR_KEY = SECR_KEY;
        }

        public String getUSE_INTT_ID() {
            return USE_INTT_ID;
        }

        public void setUSE_INTT_ID(String USE_INTT_ID) {
            this.USE_INTT_ID = USE_INTT_ID;
        }

        public String getCHNL_ID() {
            return CHNL_ID;
        }

        public void setCHNL_ID(String CHNL_ID) {
            this.CHNL_ID = CHNL_ID;
        }

        public String getSVC_CD() {
            return SVC_CD;
        }

        public void setSVC_CD(String SVC_CD) {
            this.SVC_CD = SVC_CD;
        }

        public String getPTL_ID() {
            return PTL_ID;
        }

        public void setPTL_ID(String PTL_ID) {
            this.PTL_ID = PTL_ID;
        }

        REQ_DATA REQ_DATA;
        String SECR_KEY;
        String USE_INTT_ID;
        String CHNL_ID;
        String SVC_CD;
        String PTL_ID;
    }
    public static class REQ_DATA {
        String USER_DSNC;
        String PAGE_PER_REQ_CNT;
        String PAGE_NO;
        String SRCH_WD;
        String SRCH_GB;
        String STTS;

        public REQ_DATA() {
        }

        public String getUSER_DSNC() {
            return USER_DSNC;
        }

        public void setUSER_DSNC(String USER_DSNC) {
            this.USER_DSNC = USER_DSNC;
        }

        public String getPAGE_PER_REQ_CNT() {
            return PAGE_PER_REQ_CNT;
        }

        public void setPAGE_PER_REQ_CNT(String PAGE_PER_REQ_CNT) {
            this.PAGE_PER_REQ_CNT = PAGE_PER_REQ_CNT;
        }

        public String getPAGE_NO() {
            return PAGE_NO;
        }

        public void setPAGE_NO(String PAGE_NO) {
            this.PAGE_NO = PAGE_NO;
        }

        public String getSRCH_WD() {
            return SRCH_WD;
        }

        public void setSRCH_WD(String SRCH_WD) {
            this.SRCH_WD = SRCH_WD;
        }

        public String getSRCH_GB() {
            return SRCH_GB;
        }

        public void setSRCH_GB(String SRCH_GB) {
            this.SRCH_GB = SRCH_GB;
        }

        public String getSTTS() {
            return STTS;
        }

        public void setSTTS(String STTS) {
            this.STTS = STTS;
        }
    }

    public Mono<String> postDataToExternalApi() {

        Params requestParam = new Params();
        REQ_DATA REQ_DATA = new REQ_DATA();
        REQ_DATA.setPAGE_NO("1");
        REQ_DATA.setPAGE_PER_REQ_CNT("5000");
        REQ_DATA.setSTTS("Y");
        REQ_DATA.setSRCH_GB("");
        REQ_DATA.setSRCH_WD("");
        REQ_DATA.setUSER_DSNC("");

        requestParam.setREQ_DATA(REQ_DATA);
        requestParam.setCHNL_ID("CHNL_1");
        requestParam.setPTL_STS("C");
        requestParam.setPTL_ID("PTL_3");
        requestParam.setSECR_KEY("e63fb8dd-8889-465c-e6e4-9904d3ffa067");
        requestParam.setSVC_CD("emplinfo27");
        requestParam.setUSE_INTT_ID("UTLZ_590");


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(requestParam);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("JSONData", json);
//        requestBody.add("formData", formDataMap);

        return webClient.post()
                .uri("https://emplinfo.appplay.co.kr/gw/ApiGate")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED) // Use multipart/form-data for mixed content types
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class);
    }
    public static class RequestObj{
        String KEY;

        public REQ_DATA1 getREQ_DATA() {
            return REQ_DATA;
        }

        public void setREQ_DATA(REQ_DATA1 REQ_DATA) {
            this.REQ_DATA = REQ_DATA;
        }

        public String getKEY() {
            return KEY;
        }

        public void setKEY(String KEY) {
            this.KEY = KEY;
        }

        REQ_DATA1 REQ_DATA;


    }
    public static class REQ_DATA1 {
        String SMS_MSG;
        String DEST_NUM;
        String SUBJECT;

        public String getSMS_MSG() {
            return SMS_MSG;
        }

        public void setSMS_MSG(String SMS_MSG) {
            this.SMS_MSG = SMS_MSG;
        }

        public String getDEST_NUM() {
            return DEST_NUM;
        }

        public void setDEST_NUM(String DEST_NUM) {
            this.DEST_NUM = DEST_NUM;
        }

        public String getSUBJECT() {
            return SUBJECT;
        }

        public void setSUBJECT(String SUBJECT) {
            this.SUBJECT = SUBJECT;
        }

        public String getSEND_NUM() {
            return SEND_NUM;
        }

        public void setSEND_NUM(String SEND_NUM) {
            this.SEND_NUM = SEND_NUM;
        }

        public String getSMS_CRTC_KEY() {
            return SMS_CRTC_KEY;
        }

        public void setSMS_CRTC_KEY(String SMS_CRTC_KEY) {
            this.SMS_CRTC_KEY = SMS_CRTC_KEY;
        }

        public String getUSE_DSNC() {
            return USE_DSNC;
        }

        public void setUSE_DSNC(String USE_DSNC) {
            this.USE_DSNC = USE_DSNC;
        }

        public String getNTNL_CODE() {
            return NTNL_CODE;
        }

        public void setNTNL_CODE(String NTNL_CODE) {
            this.NTNL_CODE = NTNL_CODE;
        }

        String SEND_NUM;
        String SMS_CRTC_KEY;
        String USE_DSNC;
        String NTNL_CODE;
    }
    public Mono<String> sendSMS() {

        RequestObj requestObj = new RequestObj();
        REQ_DATA1 REQ_DATA = new REQ_DATA1();
        REQ_DATA.setDEST_NUM("0969625300");
        REQ_DATA.setSEND_NUM("087694261");
        REQ_DATA.setNTNL_CODE("855");
        REQ_DATA.setSUBJECT("Test Sending SMS");
        REQ_DATA.setSMS_MSG("Hello from KOSIGN");
        REQ_DATA.setSMS_CRTC_KEY("98bbf106-242f-ce18-9f76-2167ccea88ee");
        REQ_DATA.setUSE_DSNC("SMS");

        requestObj.setREQ_DATA(REQ_DATA);
        requestObj.setKEY("sms_trn_0001_01_c002");



        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(requestObj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("JSONData", json);

        return webClient.post()
                .uri("https://www.weplatform.co.kr/GauusGate")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED) // Use multipart/form-data for mixed content types
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class);
    }


}
