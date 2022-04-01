//package ru.sfedu.utils;
//
//import com.opencsv.exceptions.CsvDataTypeMismatchException;
//import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import ru.sfedu.api.DataProviderCSV;
//import ru.sfedu.api.DataProviderJDBC;
//import ru.sfedu.api.DataProviderXML;
//import ru.sfedu.model.Product;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class GenerateBean {
//
//   private static final Logger log = LogManager.getLogger(GenerateBean.class);
//   DataProviderCSV csvDp = new DataProviderCSV();
//   DataProviderJDBC jdbcDp = new DataProviderJDBC();
//   DataProviderXML  xmlDp = new DataProviderXML();
//
//   public GenerateBean() throws IOException {
//        }
//
//
//    public Product generateWorkspace ()
//            throws CsvRequiredFieldEmptyException,
//            SQLException,
//            CsvDataTypeMismatchException,
//            IOException {
//        Product product = new Product();
//        product.setId(1L);
//        product.setName("Coaster");
//        product.setPrice(50);
//        product.setUseTime(2);
//        product.setDescription("ok");
//
//        return product;
//    }
//    public Product generateMaterial ()
//            throws CsvRequiredFieldEmptyException,
//            SQLException,
//            CsvDataTypeMismatchException,
//            IOException {
//        Product product = new Product();
//        product.setId(1L);
//        product.setName("");
//        product.setPrice(50);
//        product.setUseTime(2);
//        product.setDescription("ok");
//
//        return product;
//    }public Product generateUser ()
//            throws CsvRequiredFieldEmptyException,
//            SQLException,
//            CsvDataTypeMismatchException,
//            IOException {
//        Product product = new Product();
//        product.setId(1L);
//        product.setName("");
//        product.setPrice(150);
//        product.setUseTime(2);
//        product.setDescription("ok");
//
//        return product;
//    }
//}
