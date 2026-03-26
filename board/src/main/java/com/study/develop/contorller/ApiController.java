package com.study.develop.contorller;

import com.study.develop.entity.City;
import com.study.develop.entity.Country;
import com.study.develop.entity.Qualifications;
import com.study.develop.repository.QualificationsRepository;
import com.study.develop.service.CityService;
import com.study.develop.service.CountryService;
import com.study.develop.service.QualificationsService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Controller
public class ApiController {  //localhost:8080/board/cityView

    @Autowired
    private QualificationsService qualificationsService;

    @GetMapping("/api/qualificationsView")
    public String cityView(Model model) throws Exception{

        log.info("======>>>>> qualificationsView");

        List<Qualifications> qList =  qualificationsService.getQualificationsList();
        if(qList != null && !qList.isEmpty()){
            model.addAttribute("lstMap", qList);
            return "qualificationsView";
        }

        Map<String, String> hmap = new HashMap<>();
        List<Map<String, String>> lstMap = new ArrayList<>();
        JSONArray jsonArray = null;
        try {
            jsonArray = certificate();
        } catch (JSONException je) {
            jsonArray = certificate();
        }
        for(Object o : jsonArray){
            if(o instanceof JSONObject){
                hmap.clear();       //리스트에 담은내용이 다 같이 삭제
                JSONObject js = (JSONObject)o;
                for(String key : js.keySet()){
                    hmap.put(key, js.get(key).toString());
                }
                Map<String, String> tmpMp = new HashMap<>();
                tmpMp.putAll(hmap);
                lstMap.add(tmpMp);
            }
        }
        for(Map<String, String> m : lstMap){
            Qualifications q =  Qualifications
                    .builder()
                    .obligfldcd(Integer.parseInt("".equals(m.get("obligfldcd"))?"0":m.get("obligfldcd")))
                    .seriescd(m.get("seriescd"))
                    .jmcd(m.get("jmcd"))
                    .mdobligfldnm(m.get("mdobligfldnm"))
                    .seriesnm(m.get("seriesnm"))
                    .mdobligfldcd(Integer.parseInt("".equals(m.get("mdobligfldcd"))?"0":m.get("mdobligfldcd")))
                    .obligfldnm(m.get("obligfldnm"))
                    .qualgbcd(m.get("qualgbcd"))
                    .jmfldnm(m.get("jmfldnm"))
                    .qualgbnm(m.get("qualgbnm"))
                    .build();
            qualificationsService.write(q);
            log.info("==========> {}", q);
        }
        model.addAttribute("lstMap", lstMap);
        return "qualificationsView";
    }

    public JSONArray certificate() throws IOException {

        log.info("======>>>>> api 호출");
        URL url = new URL(/*URL*/"http://openapi.q-net.or.kr/api/service/rest/InquiryListNationalQualifcationSVC/getList" + "?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + "0344d6c477e09fd262269790d011a16fb268079a1cc1695f912548341ce191cb" /*Service Key*/);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        String xml = sb.toString();

        JSONObject jsonObject = XML.toJSONObject(xml);

        return jsonObject.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items")
                .getJSONArray("item");
    }


}
