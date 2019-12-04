package com.alswn.pay.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alswn.pay.entity.History;
import com.alswn.pay.repository.HistoryRepository;
import com.alswn.pay.util.DataUtil;

@RestController
@RequestMapping(value="/history")
public class HistoryController {
	
	@Autowired
	private HistoryRepository historyRepository;
	
	@PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException {
		historyRepository.saveAll(DataUtil.read(History.class, file.getInputStream(), file.getName()));
    }

}
