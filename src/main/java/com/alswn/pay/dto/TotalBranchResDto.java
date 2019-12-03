package com.alswn.pay.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_EMPTY)
public class TotalBranchResDto {
//	[
//	{“year”: 2018, 
//	“dataList”:[
//	    {
//	“brName”: “관리점명”,
//	“brCode”: “관리점코드”,
//	“sumAmt”: 0000 },
//	…
//	  ]
//	},
//	{“year”: 2019, 
//	“dataList”:[
//	{
//	“brName”: “관리점명”,
//	“brCode”: “관리점코드”,
//	“sumAmt”: 0000 },
//	…
//	]
//	}
//	]
	
	private long year;
	private List<BranchResDto> dataList;
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public List<BranchResDto> getDataList() {
		return dataList;
	}
	public void setDataList(List<BranchResDto> dataList) {
		this.dataList = dataList;
	}

}
