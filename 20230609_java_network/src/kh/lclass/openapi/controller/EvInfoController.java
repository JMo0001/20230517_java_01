package kh.lclass.openapi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import kh.lclass.openapi.model.service.EvInfoService;

public class EvInfoController {

	  public void getEvInfoAll() {
	        EvInfoService service = new EvInfoService();
	        service.start();
	        
	    }
}
