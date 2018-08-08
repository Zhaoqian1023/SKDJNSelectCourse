package com.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



public class ExcelUtil {
	
	@SuppressWarnings({ "deprecation", "unused" })
	public static boolean createExcel(List list, String URL){
		 //第一步创建workbook  
        HSSFWorkbook wb = new HSSFWorkbook();  
          
        //第二步创建sheet  
        HSSFSheet sheet = wb.createSheet("最新录入学生成绩库");  
          
        //第三步创建行row:添加表头0行  
        HSSFRow row = sheet.createRow(0);  
        HSSFCellStyle  style = wb.createCellStyle();      
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中  
          
          
        //第四步创建单元格  
        HSSFCell cell = row.createCell((short) 0); //第一个单元格 
     // 设置单元格内容为字符串型
        cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
        // 为了能在单元格中输入中文,设置字符集为UTF_16
        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
        /*cell.setCellValue("姓名");  */
        cell.setCellValue(new HSSFRichTextString("序号"));
        cell.setCellStyle(style);                   //内容居中  
          
        cell = row.createCell((short) 1);                   //第二个单元格     
        /*cell.setCellValue("身份证"); */
        cell.setCellValue(new HSSFRichTextString("学号"));
        cell.setCellStyle(style);  
          
        cell = row.createCell((short) 2);                   //第三个单元格    
        /*cell.setCellValue("错误状态");  */
        cell.setCellValue(new HSSFRichTextString("姓名"));
        cell.setCellStyle(style);  
          
        cell = row.createCell((short) 3);                   //第四个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("班号"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 4);                   //第五个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("班级"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 5);                   //第六个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("学期"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 6);                   //第七个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("课程类别"));
        cell.setCellStyle(style);  
          
        cell = row.createCell((short) 7);                   //第八个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("课程名"));
        cell.setCellStyle(style);
        
        cell = row.createCell((short) 8);                   //第九个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("课程ID"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 9);                   //第十个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("学分"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 10);                   //第十一个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("卷面成绩比例"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 11);                   //第十二个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("平时成绩比例"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 12);                   //第十三个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("卷面成绩"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 13);                   //第十四个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("平时成绩"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 14);                   //第十五个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("最终成绩"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 15);                   //第十六个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("重修1"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 16);                   //第十七个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("重修2"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 17);                   //第十八个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("重修3"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 18);                   //第十九个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("备注"));
        cell.setCellStyle(style);  
        
        cell = row.createCell((short) 19);                   //第二十个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("考试类型"));
        cell.setCellStyle(style); 
        
        cell = row.createCell((short) 20);                   //第二十一个单元格    
        /*cell.setCellValue("错误信息"); */ 
        cell.setCellValue(new HSSFRichTextString("任课教师"));
        cell.setCellStyle(style); 
        
        //第五步插入数据  
        
       /* List<ScoreManagement> scList = list; 
        for(ScoreManagement scm:scList){
        	int i = 1;
        	 //创建行  
        	row = sheet.createRow(i);
        	
        }
        
        for (int i = 0; i < list.size(); i++) {  
        	ScoreManagement scm = list.get(i);  
            //创建行  
            row = sheet.createRow(i+1);  
            //创建单元格并且添加数据  
            row.createCell((short) 0).setCellValue(scm.getSmid());  
            row.createCell((short) 1).setCellValue(scm.getStudentId());  
            row.createCell((short) 2).setCellValue(scm.getStudentName());  
            row.createCell((short) 3).setCellValue(scm.getClassId());  
            row.createCell((short) 4).setCellValue(scm.getClassName());  
            row.createCell((short) 5).setCellValue(scm.getYear());  
            row.createCell((short) 6).setCellValue(scm.getCategory());  
            row.createCell((short) 7).setCellValue(scm.getCourse());  
            row.createCell((short) 8).setCellValue(scm.getCourseId());  
            row.createCell((short) 9).setCellValue(scm.getCredits());  
            row.createCell((short) 10).setCellValue(scm.getPaperProportion());  
            row.createCell((short) 11).setCellValue(scm.getOrdinaryProportion());  
            row.createCell((short) 12).setCellValue(scm.getPaperGrade());
            row.createCell((short) 13).setCellValue(scm.getOrdinaryGrade());
            row.createCell((short) 14).setCellValue(scm.getFinalGrade());
            row.createCell((short) 15).setCellValue(scm.getResetGrade1());
            row.createCell((short) 16).setCellValue(scm.getResetGrade2());
            row.createCell((short) 17).setCellValue(scm.getResetGrade3());
            row.createCell((short) 18).setCellValue(scm.getBeizhu());
            row.createCell((short) 19).setCellValue(scm.getExamFlag());
            row.createCell((short) 20).setCellValue(scm.getTeacherName());
        }  */
        
        //第六步将生成excel文件保存到指定路径下  
        try {  
            FileOutputStream fout = new FileOutputStream(URL);  
            wb.write(fout);  
            fout.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
          
        /*System.out.println("Excel文件生成成功..."); */ 
		return true;
	}

}
