package hzxtestmybatis.demo.controller;

import hzxtestmybatis.demo.config.SaxSheetContentsHandler;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author:HeZhengXing
 * @Descripton: excel解析处理类
 * @Date: Created in 16:30 2018/7/11
 * @Modify By:
 */
public class SaxExcelController {
    public static void main(String[] args) {
        int startRow = 0;
        int startCol = 0;
        List<Map<String,String>> dataListMap=new ArrayList<>();
        InputStream inputStream = null;
        InputStream inputStream1 = null;
        byte[] ba = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\test.xlsx");
            int size = fileInputStream.available();
            ba = new byte[size];
            fileInputStream.read(ba);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputStream = new ByteArrayInputStream(ba);
        try {
            OPCPackage opcPackage = OPCPackage.open(inputStream);
            XSSFReader xssfReader = new XSSFReader(opcPackage);

            StylesTable stylesTable = xssfReader.getStylesTable();
            ReadOnlySharedStringsTable readOnlySharedStringsTable = new ReadOnlySharedStringsTable(opcPackage);
            inputStream1 = xssfReader.getSheetsData().next();

            XMLReader xmlReader = SAXHelper.newXMLReader();
            xmlReader.setContentHandler(new XSSFSheetXMLHandler(stylesTable,readOnlySharedStringsTable,new SaxSheetContentsHandler(dataListMap,startRow,startCol),false));
            xmlReader.parse(new InputSource(inputStream1));
            System.out.println(xmlReader.getEntityResolver());
            for (Map<String,String> map:dataListMap) {
                System.out.println(map.entrySet());
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OpenXML4JException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
