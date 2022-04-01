package ru.sfedu.api;


import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.model.*;
import ru.sfedu.utils.ConfigurationUtil;
import ru.sfedu.utils.Result;
//import javax.xml.bind.JAXBException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDataProvider implements IDataProvider {
//    создаю методы из юзкейса тут и в мэйне их вызываю
private static final Logger log = LogManager.getLogger(ConfigurationUtil.class.getName());


    public Result<Order> addOrder(Order object){
        return null;
    }

    public Result<Offer> addOffer(Offer object) {
        return null;
    }

    public Optional <Product> getProductById(long id) {
        return null;
    }

    public Optional<Workspace> getWorkspaceById(long id) {
        return null;
    }

    public Optional <Material> getMaterialById(long id) {
        return null;
    }
}
